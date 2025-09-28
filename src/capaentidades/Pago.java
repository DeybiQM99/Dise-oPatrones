/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaentidades;

import java.util.Date;
import java.sql.Time;
/**
 *
 * @author carlo
 */
public class Pago {
        private int idPago;
    private String metodo;
    private double monto;
    private Date fecha;
    private Time hora;

    public Pago(int idPago, String metodo) {
        this.idPago = idPago;
        this.metodo = metodo;
    }

    // Constructor completo
    public Pago(int idPago, String metodo, double monto, Date fecha, Time hora) {
        this.idPago = idPago;
        this.metodo = metodo;
        this.monto = monto;
        this.fecha = fecha;
        this.hora = hora;
    }
    public Pago() {
    }

    // Constructo
    // Getters y Setters
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
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


}
