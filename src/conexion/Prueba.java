/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

/**
 *
 * @author carlo
 */
public class Prueba {
     public static void main(String[] args) {
        conexion cnx= new conexion();
        cnx.conectar();
        if (cnx.cnx !=null) {
            System.out.println("conexion exitosa");
        }else {   
            System.out.println("Conexion fallida  ");
        }    
    }
}
