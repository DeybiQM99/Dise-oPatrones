/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaentidades;
import java.sql.Time;
import java.util.Date;
/**
 *
 * @author carlo
 */
public class Pedido {
        private int idPedido;
    private String numeroDePedido;
    private Time hora;
    private Date fecha;
    private String estado;

    public Pedido() {
    }

    public Pedido(int idPedido, String numeroDePedido) {
        this.idPedido = idPedido;
        this.numeroDePedido = numeroDePedido;
    }
    
    

    public Pedido(int idPedido, String numeroDePedido, Time hora, Date fecha, String estado) {
        this.idPedido = idPedido;
        this.numeroDePedido = numeroDePedido;
        this.hora = hora;
        this.fecha = fecha;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getNumeroDePedido() {
        return numeroDePedido;
    }

    public void setNumeroDePedido(String numeroDePedido) {
        this.numeroDePedido = numeroDePedido;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
     @Override
    public String toString() {
        return idPedido+" "+numeroDePedido; 
    }
    
    
}
