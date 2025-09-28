/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos;

import capadatos.Interface.PagoInterface;
import capaentidades.Pago;
import conexion.conexion;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class PagoDAO implements PagoInterface{
     private boolean confirmacion;
    private final conexion cnx;

    public PagoDAO() {
        this.cnx = conexion.getInstancia();
    }

    @Override
    public List<Pago> listar(String texto) {
        List<Pago> lista = new ArrayList<>();
        String sql = """
                     SELECT IdPago, Metodo, Monto, Fecha, Hora
                     FROM Pago
                     WHERE Metodo ILIKE ?
                     ORDER BY IdPago ASC
                     """;
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + texto + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pago p = new Pago();
                p.setIdPago(rs.getInt("IdPago"));
                p.setMetodo(rs.getString("Metodo"));
                p.setMonto(rs.getDouble("Monto"));
                p.setFecha(rs.getDate("Fecha"));
                p.setHora(rs.getTime("Hora"));
                lista.add(p);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar Pago: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean insertar(Pago p) {
        String sql = "INSERT INTO Pago(Metodo, Monto, Fecha, Hora) VALUES (?,?,?,?)";
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getMetodo());
            ps.setDouble(2, p.getMonto());
            ps.setDate(3, new java.sql.Date(p.getFecha().getTime()));
            ps.setTime(4, p.getHora());
            int fila = ps.executeUpdate();
            confirmacion = fila > 0;
        } catch (SQLException e) {
            confirmacion = false;
            JOptionPane.showMessageDialog(null, "Error al insertar Pago: " + e.getMessage());
        }
        return confirmacion;
    }

    @Override
    public boolean actualizar(Pago p) {
        String sql = "UPDATE Pago SET Metodo=?, Monto=?, Fecha=?, Hora=? WHERE IdPago=?";
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getMetodo());
            ps.setDouble(2, p.getMonto());
            ps.setDate(3, new java.sql.Date(p.getFecha().getTime()));
            ps.setTime(4, p.getHora());
            ps.setInt(5, p.getIdPago());
            int fila = ps.executeUpdate();
            confirmacion = fila > 0;
        } catch (SQLException e) {
            confirmacion = false;
            JOptionPane.showMessageDialog(null, "Error al actualizar Pago: " + e.getMessage());
        }
        return confirmacion;
    }

    @Override
    public boolean eliminar(Pago p) {
        String sql = "DELETE FROM Pago WHERE IdPago=?";
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getIdPago());
            int fila = ps.executeUpdate();
            confirmacion = fila > 0;
        } catch (SQLException e) {
            confirmacion = false;
            JOptionPane.showMessageDialog(null, "Error al eliminar Pago: " + e.getMessage());
        }
        return confirmacion;
    }

    @Override
    public List<Pago> seleccionar() {
        List<Pago> lista = new ArrayList<>();
        String sql = "SELECT IdPago, Metodo FROM Pago ORDER BY IdPago ASC";
        try (Connection conn = cnx.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pago p = new Pago();
                p.setIdPago(rs.getInt("IdPago"));
                p.setMetodo(rs.getString("Metodo"));
                lista.add(p);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar pagos en combo: " + e.getMessage());
        }
        return lista;
    }
    
    @Override
    public int insertarID(Pago p) {
        int idGenerado = -1;
        String sql = "INSERT INTO Pago(Metodo, Monto, Fecha, Hora) VALUES (?,?,?,?)";

        try (Connection conn = cnx.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getMetodo());
            ps.setDouble(2, p.getMonto());
            ps.setDate(3, new java.sql.Date(p.getFecha().getTime()));
            ps.setTime(4, p.getHora());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                String sqlId = "SELECT MAX(IdPago) AS id FROM Pago";
                try (PreparedStatement ps2 = conn.prepareStatement(sqlId);
                     ResultSet rs = ps2.executeQuery()) {
                    if (rs.next()) {
                        idGenerado = rs.getInt("id");
                        p.setIdPago(idGenerado);
                    }
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar Pago: " + e.getMessage());
        }

        return idGenerado;
    }
    
    
    
  
}
