/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos;

/**
 *
 * @author carlo
 */
import capadatos.Interface.EmpleadoInterface;
import capaentidades.Empleado;
import capaentidades.TipoUsuario;
import conexion.conexion;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO implements EmpleadoInterface {

    private boolean confirmacion;
    private final conexion cnx;

    public EmpleadoDAO() {
        this.cnx = conexion.getInstancia();
    }

    @Override
    public List<Empleado> listar(String texto) {
        List<Empleado> lista = new ArrayList<>();
        String sql = """
                            SELECT e.IdEmpleado,
                                                               e.IdTipoUsuario,
                                                               tu.Descripcion,
                                                               e.Usuario,
                                                               e.Nombre,
                                                               e.Apellido,
                                                               e.Contrasenia
                                                        FROM Empleado e
                                                        INNER JOIN TipoUsuario tu ON e.IdTipoUsuario = tu.IdTipoUsuario
                                                        WHERE e.Nombre ILIKE ?
                                                        ORDER BY e.IdEmpleado ASC
        """;
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + texto + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Empleado ns = new Empleado();
                ns.setIdEmpleado(rs.getInt("IdEmpleado"));
                ns.setIdTipoUsuario(rs.getInt("IdTipoUsuario"));
                ns.setDescripcion(rs.getString("Descripcion"));
                ns.setUsuario(rs.getString("Usuario"));
                ns.setNombre(rs.getString("Nombre"));
                ns.setApellido(rs.getString("Apellido"));
                ns.setContrasenia(rs.getString("Contrasenia"));
                lista.add(ns);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar Empleado" + e.getMessage());
        }
        return lista;
    }

    @Override

    public boolean insertar(Empleado E) {
        String sql = "Insert into Empleado(IdTipoUsuario,Usuario,Nombre,Apellido,Contrasenia) values (?,?,?,?,?)";

        try (Connection conn = cnx.conectar(); PreparedStatement rs = conn.prepareStatement(sql)) {
            rs.setInt(1, E.getIdTipoUsuario());
            rs.setString(2, E.getUsuario());
            rs.setString(3, E.getNombre());
            rs.setString(4, E.getApellido());
            rs.setString(5, E.getContrasenia());
            int fila = rs.executeUpdate();
            confirmacion = fila > 0;

        } catch (SQLException e) {
            confirmacion = false;
            JOptionPane.showMessageDialog(null, "Error al listar Empleados: " + e.getMessage());
        }
        return confirmacion;
    }

    @Override

    public boolean actualizar(Empleado E) {
        String sql = "UPDATE Empleado SET IdTipoUsuario = ?,Usuario=?,Nombre=?,Apellido=?, Contrasenia=? WHERE IdEmpleado=?";
        try (Connection conn = cnx.conectar(); PreparedStatement rs = conn.prepareStatement(sql)) {
            rs.setInt(1, E.getIdTipoUsuario());
            rs.setString(2, E.getUsuario());
            rs.setString(3, E.getNombre());
            rs.setString(4, E.getApellido());
            rs.setString(5, E.getContrasenia());
            rs.setInt(6, E.getIdEmpleado());
            int fila = rs.executeUpdate();
            confirmacion = fila > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los Empleados:" + e.getMessage());
            confirmacion = false;
        }
        return confirmacion;
    }

    @Override

    public boolean eliminar(Empleado E) {
        String sql = "DELETE FROM Empleado WHERE IdEmpleado=?";
        try (Connection conn = cnx.conectar(); PreparedStatement rs = conn.prepareStatement(sql)) {
            rs.setInt(1, E.getIdEmpleado());
            int fila = rs.executeUpdate();
            confirmacion = fila > 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los Empleados:" + e.getMessage());
            confirmacion = false;
        }
        return confirmacion;
    }

    @Override
    public List<Empleado> seleccionar() {
        List<Empleado> lista = new ArrayList<>();
        String sql = """
                 SELECT e.IdEmpleado,
                        tu.Descripcion,
                        e.Usuario
                 FROM Empleado e
                 INNER JOIN TipoUsuario tu ON e.IdTipoUsuario = tu.IdTipoUsuario
                 WHERE tu.Descripcion = 'cajera'
                 ORDER BY e.IdEmpleado ASC
                 """;
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setIdEmpleado(rs.getInt("IdEmpleado"));
                emp.setDescripcion(rs.getString("Descripcion"));
                emp.setUsuario(rs.getString("Usuario"));
                lista.add(emp);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar empleados en combo: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public int insertarID(Empleado e) {
        int idGenerado = -1;
        String sql = "INSERT INTO Empleado(IdTipoUsuario,Usuario,Nombre,Apellido,Contrasenia) VALUES (?,?,?,?,?)";

        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getIdTipoUsuario());
            ps.setString(2, e.getUsuario());
            ps.setString(3, e.getNombre());
            ps.setString(4, e.getApellido());
            ps.setString(5, e.getContrasenia());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                String sqlId = "SELECT MAX(IdEmpleado) AS id FROM Empleado";
                try (PreparedStatement ps2 = conn.prepareStatement(sqlId); ResultSet rs = ps2.executeQuery()) {
                    if (rs.next()) {
                        idGenerado = rs.getInt("id");
                        e.setIdEmpleado(idGenerado);
                    }
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar Empleado: " + ex.getMessage());
        }

        return idGenerado;
    }

    @Override
    public Empleado obtenerPorUsuario(String usuario) {
        Empleado emp = null;
        String sql = "SELECT e.IdEmpleado, e.Usuario, e.Contrasenia, e.Nombre, e.Apellido, e.IdTipoUsuario, t.Descripcion "
                + "FROM Empleado e "
                + "INNER JOIN TipoUsuario t ON e.IdTipoUsuario = t.IdTipoUsuario "
                + "WHERE e.Usuario = ?";

        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                emp = new Empleado();
                emp.setIdEmpleado(rs.getInt("IdEmpleado"));
                emp.setUsuario(rs.getString("Usuario"));
                emp.setContrasenia(rs.getString("Contrasenia"));
                emp.setNombre(rs.getString("Nombre"));
                emp.setApellido(rs.getString("Apellido"));
                emp.setIdTipoUsuario(rs.getInt("IdTipoUsuario"));
                emp.setDescripcion(rs.getString("Descripcion")); // admin, cajero, cocinero
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener empleado: " + e.getMessage());
        }

        return emp;
    }

}
