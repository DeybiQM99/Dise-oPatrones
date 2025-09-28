/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaentidades;

import java.sql.Date;
import java.sql.Time;

public class Comprobante {
       private int idComprobante;
    private String tipo;
    private String numero;
    private String codigo;
    private Date fecha;
    private Time hora;
    private double igv;
    private double subtotal;
    private double total;
    private int idCliente;
    private int idPago;
    private int idDetalle;
    private int idpedido;
    private int idEmpleado;

    public Comprobante() {
    }

    public Comprobante(int idComprobante, String tipo, String numero, String codigo, Date fecha, Time hora, double igv, double subtotal, double total, int idCliente, int idPago, int idDetalle, int idpedido, int idEmpleado) {
        this.idComprobante = idComprobante;
        this.tipo = tipo;
        this.numero = numero;
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.igv = igv;
        this.subtotal = subtotal;
        this.total = total;
        this.idCliente = idCliente;
        this.idPago = idPago;
        this.idDetalle = idDetalle;
        this.idpedido = idpedido;
        this.idEmpleado = idEmpleado;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    
    
    
    
    
}