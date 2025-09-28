/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos;


import capadatos.Interface.DetalleInterface;
import capaentidades.PedidoDetalle;
import conexion.conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PedidoDetalleDAO implements DetalleInterface {

    private boolean confirmacion;
    private final conexion cnx;

    public PedidoDetalleDAO() {
        this.cnx = conexion.getInstancia();
    }

    @Override
    public List<PedidoDetalle> listar(String texto) {
        List<PedidoDetalle> lista = new ArrayList<>();
        String sql = """
                     SELECT d.IdDetalle,
                            d.IdProducto,
                            p.Nombre AS NombreProducto,
                            d.IdPedido,
                            ped.Numerodepedido AS NumeroDePedido,
                            d.Cantidad,
                            d.Precio_unitario,
                            d.Subtotal
                     FROM Pedido_detalle d
                     INNER JOIN Producto p ON d.IdProducto = p.IdProducto
                     INNER JOIN Pedido ped ON d.IdPedido = ped.IdPedido
                     WHERE p.Nombre ILIKE ?
                     ORDER BY d.IdDetalle ASC
                     """;
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + texto + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PedidoDetalle det = new PedidoDetalle();
                // IDs primero
                det.setIdDetalle(rs.getInt("IdDetalle"));
                det.setIdProducto(rs.getInt("IdProducto"));
                det.setIdPedido(rs.getInt("IdPedido"));
                // Campos auxiliares
                det.setNombreProducto(rs.getString("NombreProducto"));
                det.setNumeroDePedido(rs.getString("NumeroDePedido"));
                // Otros campos
                det.setCantidad(rs.getInt("Cantidad"));
                det.setPrecioUnitario(rs.getDouble("Precio_unitario"));
                det.setSubtotal(rs.getDouble("Subtotal"));
                lista.add(det);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar DetallePedido: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean insertar(PedidoDetalle d) {
    boolean confirmacion = false;
    String sql = "INSERT INTO Pedido_detalle(IdProducto, IdPedido, Cantidad, Precio_unitario) VALUES (?,?,?,?)";
    try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, d.getIdProducto());
        ps.setInt(2, d.getIdPedido());
        ps.setInt(3, d.getCantidad());
        ps.setDouble(4, d.getPrecioUnitario());
        
        int fila = ps.executeUpdate();
        confirmacion = fila > 0;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al insertar DetallePedido: " + e.getMessage());
    }
    return confirmacion;
}
    @Override
    public boolean actualizar(PedidoDetalle d) {
        String sql = """
                     UPDATE Pedido_detalle 
                     SET IdProducto=?, IdPedido=?, Cantidad=?, Precio_unitario=?
                     WHERE IdDetalle=?
                     """;
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, d.getIdProducto());
            ps.setInt(2, d.getIdPedido());
            ps.setInt(3, d.getCantidad());
            ps.setDouble(4, d.getPrecioUnitario());
            ps.setInt(5, d.getIdDetalle());
            int fila = ps.executeUpdate();
            confirmacion = fila > 0;
        } catch (SQLException e) {
            confirmacion = false;
            JOptionPane.showMessageDialog(null, "Error al actualizar DetallePedido: " + e.getMessage());
        }
        return confirmacion;
    }

    @Override
    public boolean eliminar(PedidoDetalle d) {
        String sql = "DELETE FROM Pedido_detalle WHERE IdDetalle=?";
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, d.getIdDetalle());
            int fila = ps.executeUpdate();
            confirmacion = fila > 0;
        } catch (SQLException e) {
            confirmacion = false;
            JOptionPane.showMessageDialog(null, "Error al eliminar DetallePedido: " + e.getMessage());
        }
        return confirmacion;
    }
    
    
     public boolean insertardetalle(PedidoDetalle d) {
        String sql = "INSERT INTO Pedido_detalle (Cantidad, Precio_unitario, Subtotal, IdProducto, IdPedido) VALUES (?,?,?,?,?)";
        try (Connection conn = cnx.conectar(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, d.getCantidad());
            ps.setDouble(2, d.getPrecioUnitario());
            ps.setDouble(3, d.getSubtotal());
            ps.setInt(4, d.getIdProducto());
            ps.setInt(5, d.getIdPedido());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar detalle: " + e.getMessage());
            return false;
        }
    }
}