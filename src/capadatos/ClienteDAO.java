/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos;

import capadatos.Interface.ClienteInterface;
import capaentidades.Cliente;
import conexion.conexion;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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

public class ClienteDAO implements ClienteInterface {

    private boolean confirmacion;
    private final conexion cnx;

    public ClienteDAO() {
        this.cnx = conexion.getInstancia();
    }

    @Override
    public boolean insertar(Cliente cli) {
        String sql = "INSERT INTO Cliente(Nombre,Apellido,DNI,Telefono,Direccion,Raz_social,RUC) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getApellido());
            ps.setString(3, cli.getDni());
            ps.setString(4, cli.getTelefono());
            ps.setString(5, cli.getDireccion());
            ps.setString(6, cli.getRazonSocial());
            ps.setString(7, cli.getRuc());
            int fila = ps.executeUpdate();
            confirmacion = fila > 0;
        } catch (SQLException e) {
            confirmacion = false;
            JOptionPane.showMessageDialog(null, "Error al insertar Cliente: " + e.getMessage());
        }
        return confirmacion;
    }

    @Override
    public List<Cliente> listar(String texto) {
        List<Cliente> lista = new ArrayList<>();
        String sql = """
                     SELECT IdCliente,
                            Nombre,
                            Apellido,
                            DNI,
                            Telefono,
                            Direccion,
                            Raz_social,
                            RUC
                     FROM Cliente
                     WHERE Nombre ILIKE ? OR Apellido ILIKE ?
                     ORDER BY IdCliente ASC;
                     """;
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + texto + "%");
            ps.setString(2, "%" + texto + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setIdCliente(rs.getInt("IdCliente"));
                cli.setNombre(rs.getString("Nombre"));
                cli.setApellido(rs.getString("Apellido"));
                cli.setDni(rs.getString("DNI"));
                cli.setTelefono(rs.getString("Telefono"));
                cli.setDireccion(rs.getString("Direccion"));
                cli.setRazonSocial(rs.getString("Raz_social"));
                cli.setRuc(rs.getString("RUC"));
                lista.add(cli);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar Clientes " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean actualizar(Cliente cli) {
        boolean confirmacion = false;
        String sql = "UPDATE Cliente SET Nombre=?, Apellido=?, DNI=?, Telefono=?, Direccion=?, Raz_social=?, RUC=? WHERE IdCliente=?";
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getApellido());
            ps.setString(3, cli.getDni());
            ps.setString(4, cli.getTelefono());
            ps.setString(5, cli.getDireccion());
            ps.setString(6, cli.getRazonSocial());
            ps.setString(7, cli.getRuc());
            ps.setInt(8, cli.getIdCliente());

            int fila = ps.executeUpdate();
            confirmacion = fila > 0;
        } catch (SQLException e) {
            confirmacion = false;
            JOptionPane.showMessageDialog(null, "Error al actualizar Cliente: " + e.getMessage());
        }
        return confirmacion;
    }

    @Override
    public boolean eliminar(Cliente cli) {
        String sql = "DELETE FROM Cliente WHERE IdCliente=?";
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cli.getIdCliente());
            int fila = ps.executeUpdate();
            confirmacion = fila > 0;
        } catch (SQLException e) {
            confirmacion = false;
            JOptionPane.showMessageDialog(null, "Error al eliminar Cliente: " + e.getMessage());
        }
        return confirmacion;
    }


    @Override
    public List<Cliente> seleccionar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT IdCliente, Nombre FROM Cliente ORDER BY IdCliente ASC";
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setIdCliente(rs.getInt("IdCliente"));
                cli.setNombre(rs.getString("Nombre"));
                lista.add(cli);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar clientes en combo: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public int insertarID(Cliente cli) {
        int idGenerado = -1;
        String sql = "INSERT INTO Cliente(Nombre,Apellido,DNI,Telefono,Direccion,Raz_social,RUC) VALUES (?,?,?,?,?,?,?)";

        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getApellido());
            ps.setString(3, cli.getDni());
            ps.setString(4, cli.getTelefono());
            ps.setString(5, cli.getDireccion());
            ps.setString(6, cli.getRazonSocial());
            ps.setString(7, cli.getRuc());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                String sqlId = "SELECT MAX(IdCliente) AS id FROM Cliente";
                try (PreparedStatement ps2 = conn.prepareStatement(sqlId); ResultSet rs = ps2.executeQuery()) {
                    if (rs.next()) {
                        idGenerado = rs.getInt("id");
                        cli.setIdCliente(idGenerado);
                    }
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar Cliente: " + e.getMessage());
        }

        return idGenerado;
    }
}
