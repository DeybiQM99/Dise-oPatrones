/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos;



import capadatos.Interface.ProductoInterface;
import capaentidades.Producto;
import conexion.conexion;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.JOptionPane;

public class ProductoDAO implements ProductoInterface{
      private boolean confirmacion;
    private final conexion cnx;

    public ProductoDAO() {
        this.cnx = conexion.getInstancia();
    }
    
    @Override
    public List<Producto> listar(String texto) {
        List<Producto> lista = new ArrayList<>();
        String sql = """
                                 SELECT p.IdProducto,
                                                                             p.IdCategoria,
                                                                             c.Nombre AS NombreCategoria,
                                                                             p.Nombre,
                                                                             p.Descripcion,
                                                                             p.Precio,
                                                                             p.Stock
                                                                      FROM Producto p
                                                                      INNER JOIN Categoria c ON p.IdCategoria = c.IdCategoria
                                                                      WHERE p.Nombre ILIKE ?
                                                                      ORDER BY p.IdProducto ASC;
        """;
        try (Connection conn = cnx.conectar(); 
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + texto + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto ns = new Producto();
                ns.setIdProducto(rs.getInt("IdProducto"));
                ns.setIdCategoria(rs.getInt("IdCategoria"));
                 ns.setNombrecategoria(rs.getString("NombreCategoria"));
                ns.setNombre(rs.getString("Nombre"));
                ns.setDescripcion(rs.getString("Descripcion"));
                ns.setPrecio(rs.getDouble("Precio"));
                ns.setStock(rs.getInt("stock"));
                lista.add(ns);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar Productos " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean insertar(Producto E) {
        String sql = "Insert into Producto(IdCategoria,Nombre,Descripcion,Precio,Stock) values (?,?,?,?,?)";

        try (Connection conn = cnx.conectar(); PreparedStatement rs = conn.prepareStatement(sql)) {
            rs.setInt(1, E.getIdCategoria());
            rs.setString(2, E.getNombre());
            rs.setString(3, E.getDescripcion());
            rs.setDouble(4, E.getPrecio());
              rs.setInt(5, E.getStock());
            int fila = rs.executeUpdate();
            confirmacion = fila > 0;

        } catch (SQLException e) {
            confirmacion=false;
            JOptionPane.showMessageDialog(null, "Error al listar Productos: " + e.getMessage());
        }
        return confirmacion;
    }

    @Override

    public boolean actualizar(Producto E) {
        String sql = "UPDATE Producto SET IdCategoria = ?,Nombre=?,Descripcion=?,Precio=?, Stock=? WHERE IdProducto=?";
        try (Connection conn = cnx.conectar(); PreparedStatement rs = conn.prepareStatement(sql)) {
            rs.setInt(1,E.getIdCategoria());
            rs.setString(2, E.getNombre());
            rs.setString(3, E.getDescripcion());
            rs.setDouble(4, E.getPrecio());
            rs.setInt(5, E.getStock());
            rs.setInt(6, E.getIdProducto());
            int fila = rs.executeUpdate();
            confirmacion = fila > 0;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los Productos:" + e.getMessage());
            confirmacion = false;
        }
        return confirmacion;
    }

    @Override
    public boolean eliminar(Producto E) {
        String sql = "DELETE FROM Producto WHERE IdProducto=?";
        try (Connection conn = cnx.conectar(); PreparedStatement rs = conn.prepareStatement(sql)) {
            rs.setInt(1, E.getIdProducto());
            int fila = rs.executeUpdate();
            confirmacion = fila > 0;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los Producto:" + e.getMessage());
            confirmacion = false;
        }
        return confirmacion;
    }
    
   @Override
      public List<Producto> seleccionar1() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT IdProducto,Nombre FROM Producto ORDER BY IdProducto ASC";
        try (Connection conn = cnx.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Producto s = new Producto();
                s.setIdProducto(rs.getInt("IdProducto"));
                s.setNombre(rs.getString("Nombre"));
                lista.add(s);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar servicios en combo: " + e.getMessage());
        }
        return lista;
    }

      
       public List<Producto> listarTodos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT IdProducto, Nombre, Descripcion, Precio FROM Producto";

        try (Connection conn = cnx.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("IdProducto"));
                p.setNombre(rs.getString("Nombre"));
                p.setDescripcion(rs.getString("Descripcion"));
                p.setPrecio(rs.getDouble("Precio"));

                lista.add(p);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar productos: " + e.getMessage());
        }

        return lista;
    }
}
