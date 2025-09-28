/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos;

import capadatos.Interface.CategoriaInterface;
import capaentidades.Categoria;
import capaentidades.TipoUsuario;
import conexion.conexion;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class CategoriaDAO implements CategoriaInterface {

    private final conexion cnx;
    private boolean confirmacion;

    public CategoriaDAO() {
        this.cnx = conexion.getInstancia();
    }

    @Override
    public List<Categoria> listar(String texto) {
        List<Categoria> lista = new ArrayList<>();

        String sql = "SELECT*FROM Categoria where Nombre ILIKE ? order by IdCategoria ASC ";

        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + texto + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setIdcategoria(rs.getInt("IdCategoria"));
                cat.setNombre(rs.getString("Nombre"));

                lista.add(cat);
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error de listado " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean insertar(Categoria c) {
        String sql = "Insert into Categoria(Nombre) volues (?)";

        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, c.getIdcategoria());

            int fila = ps.executeUpdate();
            confirmacion = fila > 0;

        } catch (SQLException e) {
            confirmacion = false;
            JOptionPane.showConfirmDialog(null, "Error de listado " + e.getMessage());
        }
        return confirmacion;
    }

    @Override
    public boolean actualizar(Categoria C) {
        String sql = "Update Categoria set Nombre=? where IdCategoria=?";

        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, C.getNombre());
            ps.setInt(2, C.getIdcategoria());
            int fila = ps.executeUpdate();
            confirmacion = fila > 0;
        } catch (SQLException e) {
            confirmacion = false;
            JOptionPane.showConfirmDialog(null, "Error de listado " + e.getMessage());
        }
        return confirmacion;

    }

    @Override
    public boolean eliminar(Categoria p) {
        String sql = "DELETE FROM Categoria WHERE IdCategoria=?";
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getIdcategoria());
            int fila = ps.executeUpdate();
            confirmacion = fila > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los Categoria " + e.getMessage());
            confirmacion = false;
        }
        return confirmacion;
    }

    @Override
    public List<Categoria> seleccionar() {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT IdCategoria,Nombre FROM Categoria ORDER BY Nombre ASC";
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Categoria s = new Categoria();
                s.setIdcategoria(rs.getInt("IdCategoria"));
                s.setNombre(rs.getString("Nombre"));
                lista.add(s);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar Categoria en combo: " + e.getMessage());
        }
        return lista;
    }

}
