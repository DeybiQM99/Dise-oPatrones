/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos;

import capadatos.Interface.ComprobanteInterface;
import capaentidades.Comprobante;
import conexion.conexion;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author carlo
 */
public class ComprobanteDAO implements ComprobanteInterface {

    private boolean confirmacion;
    private final conexion cnx;

    public ComprobanteDAO() {
        this.cnx = conexion.getInstancia();
    }

    @Override
    public int insertarID(Comprobante comp) {
        int idGenerado = -1;
        String sql = "INSERT INTO Comprobante(Tipo, Numero, Codigo, Fecha, Hora, Igv, Subtotal, Total, IdCliente, IdPago, IdPedido, IdEmpleado) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, comp.getTipo());
            ps.setString(2, comp.getNumero());
            ps.setString(3, comp.getCodigo());
            ps.setDate(4, new java.sql.Date(comp.getFecha().getTime()));
            ps.setTime(5, comp.getHora());
            ps.setDouble(6, comp.getIgv());
            ps.setDouble(7, comp.getSubtotal());
            ps.setDouble(8, comp.getTotal());
            ps.setInt(9, comp.getIdCliente());
            ps.setInt(10, comp.getIdPago());
            ps.setInt(11, comp.getIdpedido());
            ps.setInt(12, comp.getIdEmpleado());

            int filas = ps.executeUpdate();

            if (filas > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        idGenerado = rs.getInt(1);
                        comp.setIdComprobante(idGenerado);
                    }
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar Comprobante: " + e.getMessage());
        }

        return idGenerado;
    }

    @Override
    public boolean insertar(Comprobante c) {
        String sql = "INSERT INTO comprobante "
                + "(tipo, numero, codigo, fecha, hora, igv, subtotal, total, "
                + "idcliente, idpago, idpedido, idempleado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, c.getTipo());
            ps.setString(2, c.getNumero());
            ps.setString(3, c.getCodigo());
            ps.setDate(4, c.getFecha());
            ps.setTime(5, c.getHora());
            ps.setDouble(6, c.getIgv());
            ps.setDouble(7, c.getSubtotal());
            ps.setDouble(8, c.getTotal());
            ps.setInt(9, c.getIdCliente());
            ps.setInt(10, c.getIdPago());
            ps.setInt(11, c.getIdpedido());
            ps.setInt(12, c.getIdEmpleado());

            int fila = ps.executeUpdate();
            confirmacion = fila > 0;

        } catch (SQLException e) {
            confirmacion = false;
            JOptionPane.showMessageDialog(null,
                    "Error al insertar Comprobante: " + e.getMessage());
        }
        return confirmacion;
    }

    @Override
    public String generarNumero() {
        String numero = "B-000001"; // valor por defecto
        String sql = "SELECT COALESCE(MAX(IdComprobante), 0) + 1 AS siguiente FROM Comprobante";
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int siguiente = rs.getInt("siguiente");
                // Formato: B-000001, B-000002, etc.
                numero = String.format("B-%06d", siguiente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al generar número: " + e.getMessage());
        }
        return numero;
    }

    @Override
    public String generarCodigo() {
        String codigo = "000001"; // valor por defecto
        String sql = "SELECT COALESCE(MAX(IdComprobante), 0) + 1 AS siguiente FROM Comprobante";
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int siguiente = rs.getInt("siguiente");
                // Formato: C000001, C000002, etc.
                codigo = String.format("C%06d", siguiente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al generar código: " + e.getMessage());
        }
        return codigo;
    }

    @Override
    public int obtenerUltimoNumero(String tipo) {
        int ultimo = 0;
        String sql = "SELECT Numero FROM Comprobante WHERE Tipo=? ORDER BY IdComprobante DESC LIMIT 1";
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tipo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String numero = rs.getString("Numero");

                    if (numero != null && !numero.trim().isEmpty()) {
                        if (numero.contains("-")) {
                            // Ejemplo: B-000015 → obtiene "000015"
                            String[] partes = numero.split("-");
                            if (partes.length > 1) {
                                ultimo = Integer.parseInt(partes[1]);
                            } else {
                                System.err.println("Formato inesperado en Numero (falta parte después del guion): " + numero);
                            }
                        } else {
                            // Caso sin guion: "000015"
                            try {
                                ultimo = Integer.parseInt(numero);
                            } catch (NumberFormatException e) {
                                System.err.println("Formato inválido en Numero: " + numero);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ultimo;
    }

    @Override
    public int obtenerUltimoNumero1(String tipo) {
        int ultimo = 0;
        String sql = "SELECT Numero FROM Comprobante WHERE Tipo=? ORDER BY IdComprobante DESC LIMIT 1";
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tipo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String numero = rs.getString("Numero");
                    // Ejemplo: B-000015 → obtener 15
                    ultimo = Integer.parseInt(numero.split("-")[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ultimo;
    }

}
