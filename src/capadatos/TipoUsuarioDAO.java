/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos;

/**
 *
 * @author carlo
 */


import capadatos.Interface.TipoUsuarioInface;
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


public class TipoUsuarioDAO implements TipoUsuarioInface {
      private boolean confirmacion;
    private final conexion cnx;

    public TipoUsuarioDAO() {
        this.cnx = conexion.getInstancia();
    }

    @Override
    public List<TipoUsuario> listar(String texto) {
        List<TipoUsuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM TipoUsuario WHERE Descripcion ILIKE ? Order by IdTipoUsuario ASC";
        try(Connection conn=cnx.conectar();
            PreparedStatement ps=conn.prepareStatement(sql))
        {
            ps.setString(1,"%" + texto + "%");
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                TipoUsuario TU=new TipoUsuario();
                TU.setIdTipoUsuario(rs.getInt("IdTipoUsuario"));
                TU.setDescripcion(rs.getString("Descripcion"));
                lista.add(TU);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar los Usuarios:"+e.getMessage());
        }
    return lista;
    }


    @Override
    public boolean insertar (TipoUsuario p){
        String sql = "INSERT INTO TipoUsuario(Descripcion) VALUES (?)";
        try(Connection conn=cnx.conectar();
            PreparedStatement ps=conn.prepareStatement(sql))
        {
          ps.setString(1, p.getDescripcion());

          int filas=ps.executeUpdate();
          confirmacion=filas>0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Insertar los Usuarios:"+e.getMessage());
        }
        return confirmacion;
    }

    @Override
        public boolean actualizar (TipoUsuario t){
        String sql="UPDATE TipoUsuario SET Descripcion = ? WHERE IdTipoUsuario=?";
        try (Connection conn=cnx.conectar();
             PreparedStatement ps=conn.prepareStatement(sql)
        ){
            ps.setString(1, t.getDescripcion());
            ps.setInt(2, t.getIdTipoUsuario()); 

            int fila =ps.executeUpdate();
            confirmacion=fila>0;  
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los Usuarios:"+e.getMessage());
            confirmacion=false;
        }
        return confirmacion;
    }  
    @Override
    public boolean eliminar (TipoUsuario p) {
        String sql = "DELETE FROM TipoUsuario WHERE IdTipoUsuario=?";
        try (Connection conn = cnx.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, p.getIdTipoUsuario());
            int fila = ps.executeUpdate();
            confirmacion = fila > 0;


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los Usuarios:" + e.getMessage());
            confirmacion = false;
        }
        return confirmacion;
    }
    
    
        @Override
      public List<TipoUsuario> seleccionar() {
        List<TipoUsuario> lista = new ArrayList<>();
        String sql = "SELECT IdTipoUsuario,Descripcion FROM TipoUsuario ORDER BY Descripcion ASC";
        try (Connection conn = cnx.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TipoUsuario s = new TipoUsuario();
                s.setIdTipoUsuario(rs.getInt("IdTipoUsuario"));
                s.setDescripcion(rs.getString("Descripcion"));
                lista.add(s);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar servicios en combo: " + e.getMessage());
        }
        return lista;
    }
    
    
    
    
    
    
}
