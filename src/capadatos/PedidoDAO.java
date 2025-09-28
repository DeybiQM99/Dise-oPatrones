/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos;

import capadatos.Interface.PedidoInterface;
import capaentidades.Pedido;
import conexion.conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PedidoDAO implements PedidoInterface {

    private boolean confirmacion;
    private final conexion cnx;

    public PedidoDAO() {
        this.cnx = conexion.getInstancia();
    }

    @Override
    public List<Pedido> listar(String texto) {
        List<Pedido> lista = new ArrayList<>();
        String sql = """
                     SELECT IdPedido, Numerodepedido, Hora, Fecha, Estado
                     FROM Pedido
                     WHERE Numerodepedido ILIKE ? OR Estado ILIKE ?
                     ORDER BY IdPedido ASC
                     """;
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + texto + "%");
            ps.setString(2, "%" + texto + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("IdPedido"));
    p.setNumeroDePedido(rs.getString("Numerodepedido"));
    p.setHora(rs.getTime("Hora"));               // Hora como java.sql.Time
    p.setFecha(rs.getDate("Fecha"));             // Fecha como java.sql.Date
    p.setEstado(rs.getString("Estado"));
    lista.add(p);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar Pedido: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public boolean insertar(Pedido p) {
        String sql = "INSERT INTO Pedido(Numerodepedido, Hora, Fecha, Estado) VALUES (?,?,?,?)";
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNumeroDePedido());
            ps.setTime(2, p.getHora());
           ps.setDate(3, new java.sql.Date(p.getFecha().getTime()));
            ps.setString(4, p.getEstado());
            int fila = ps.executeUpdate();
            confirmacion = fila > 0;
        } catch (SQLException e) {
            confirmacion = false;
            JOptionPane.showMessageDialog(null, "Error al insertar Pedido: " + e.getMessage());
        }
        return confirmacion;
    }

    @Override
    public boolean actualizar(Pedido p) {
        String sql = "UPDATE Pedido SET Numerodepedido=?, Hora=?, Fecha=?, Estado=? WHERE IdPedido=?";
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNumeroDePedido());
            ps.setTime(2, p.getHora());
            ps.setDate(3, new java.sql.Date(p.getFecha().getTime()));
            ps.setString(4, p.getEstado());
            ps.setInt(5, p.getIdPedido());
            int fila = ps.executeUpdate();
            confirmacion = fila > 0;
        } catch (SQLException e) {
            confirmacion = false;
            JOptionPane.showMessageDialog(null, "Error al actualizar Pedido: " + e.getMessage());
        }
        return confirmacion;
    }

    @Override
    public boolean eliminar(Pedido p) {
        String sql = "DELETE FROM Pedido WHERE IdPedido=?";
        try (Connection conn = cnx.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getIdPedido());
            int fila = ps.executeUpdate();
            confirmacion = fila > 0;
        } catch (SQLException e) {
            confirmacion = false;
            JOptionPane.showMessageDialog(null, "Error al eliminar Pedido: " + e.getMessage());
        }
        return confirmacion;
    }
    
    @Override
    public List<Pedido> seleccionar() {
    List<Pedido> lista = new ArrayList<>();
    String sql = "SELECT IdPedido, Numerodepedido FROM Pedido ORDER BY IdPedido ASC";
    try (Connection conn = cnx.conectar();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Pedido p = new Pedido();
            p.setIdPedido(rs.getInt("IdPedido"));
            p.setNumeroDePedido(rs.getString("Numerodepedido"));
            lista.add(p);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar pedidos en combo: " + e.getMessage());
    }
    return lista;
}
    @Override
    public Pedido generarPedidoAutomatico() {
    Pedido p = new Pedido();

    // Generar número de pedido
    String numero = "PED-0001";
    String sql = "SELECT Numerodepedido FROM Pedido ORDER BY IdPedido DESC LIMIT 1";
    try (Connection conn = cnx.conectar();
         Statement st = conn.createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        if (rs.next()) {
            String ultimo = rs.getString("Numerodepedido");
            int num = Integer.parseInt(ultimo.split("-")[1]) + 1;
            numero = String.format("PED-%04d", num);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al generar número de pedido: " + e.getMessage());
    }

    // Fecha y hora actuales
    java.util.Date now = new java.util.Date();
    java.sql.Date fecha = new java.sql.Date(now.getTime());
    java.sql.Time hora = new java.sql.Time(now.getTime());

    // Asignar al pedido
    p.setNumeroDePedido(numero);
    p.setFecha(fecha);
    p.setHora(hora);

    return p;
}
    

    @Override
    public int insertarID(Pedido p) {
    int idGenerado = -1; // valor por defecto (error)

    String sql = "INSERT INTO Pedido(NumeroDePedido, Hora, Fecha, Estado) VALUES (?,?,?,?)";
    try (Connection conn = cnx.conectar();
         PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        ps.setString(1, p.getNumeroDePedido());
        ps.setTime(2, p.getHora());
        ps.setDate(3, new java.sql.Date(p.getFecha().getTime()));
        ps.setString(4, p.getEstado());

        int filas = ps.executeUpdate();

        if (filas > 0) {
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    idGenerado = rs.getInt(1); // recuperamos el ID generado
                    p.setIdPedido(idGenerado); // opcional: actualizar el objeto en memoria
                }
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al insertar Pedido: " + e.getMessage());
    }

    return idGenerado;}
}