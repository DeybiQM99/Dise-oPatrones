/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

/**
 *
 * @author carlo
 */

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    private static final String URL = "jdbc:postgresql://localhost:5432/fastfood";
    private static final String USER = "postgres";
    private static final String PASS = "Leo240705";
    private static final String DRIVER = "org.postgresql.Driver";


    Connection cnx;
    private static conexion instancia;

    conexion() {
        this.cnx = null;
    }

    public Connection conectar() {
        try {
            Class.forName(DRIVER);
            this.cnx = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e.getMessage());
        }
        return this.cnx;
    }

    public void desconectar() {
        try {
            if (this.cnx != null && !this.cnx.isClosed()) {
                this.cnx.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al desconectar: " + e.getMessage());
        }
    }
    public static synchronized conexion getInstancia() {
        if (instancia == null) {
            instancia = new conexion();  // Todo minúscula, coincide con el nombre de la clase
        }
        return instancia;   }
}

