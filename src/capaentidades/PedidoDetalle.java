/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capaentidades;

public class PedidoDetalle {
       private int IdDetalle;
    private int IdProducto;
    private int IdPedido;
    private String numeroDePedido; 
    private String nombreProducto;
    private int Cantidad;
    private double PrecioUnitario;
    private double Subtotal;

    public PedidoDetalle(int IdDetalle, int IdProducto, int Cantidad, double PrecioUnitario) {
        this.IdDetalle = IdDetalle;
        this.IdProducto = IdProducto;
        this.Cantidad = Cantidad;
        this.PrecioUnitario = PrecioUnitario;
    }

    public PedidoDetalle(int IdDetalle, int IdProducto, int IdPedido, int Cantidad, double PrecioUnitario, double Subtotal) {
        this.IdDetalle = IdDetalle;
        this.IdProducto = IdProducto;
        this.IdPedido = IdPedido;
        this.Cantidad = Cantidad;
        this.PrecioUnitario = PrecioUnitario;
        this.Subtotal = Subtotal;
    }
    
    
    
    

    public PedidoDetalle(int IdDetalle, int IdProducto, int IdPedido, String numeroDePedido, String nombreProducto, int Cantidad, double PrecioUnitario, double Subtotal) {
        this.IdDetalle = IdDetalle;
        this.IdProducto = IdProducto;
        this.IdPedido = IdPedido;
        this.numeroDePedido = numeroDePedido;
        this.nombreProducto = nombreProducto;
        this.Cantidad = Cantidad;
        this.PrecioUnitario = PrecioUnitario;
        this.Subtotal = Subtotal;
    }

    public PedidoDetalle(int IdDetalle, int IdProducto, int IdPedido, int Cantidad, double PrecioUnitario) {
        this.IdDetalle = IdDetalle;
        this.IdProducto = IdProducto;
        this.IdPedido = IdPedido;
        this.Cantidad = Cantidad;
        this.PrecioUnitario = PrecioUnitario;
    }



    
    
        public PedidoDetalle() {
    }


    public int getIdDetalle() {
        return IdDetalle;
    }

    public void setIdDetalle(int IdDetalle) {
        this.IdDetalle = IdDetalle;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getIdPedido() {
        return IdPedido;
    }

    public void setIdPedido(int IdPedido) {
        this.IdPedido = IdPedido;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public double getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(double Subtotal) {
        this.Subtotal = Subtotal;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNumeroDePedido() {
        return numeroDePedido;
    }

    public void setNumeroDePedido(String numeroDePedido) {
        this.numeroDePedido = numeroDePedido;
    }

    // utilidad para calcular subtotal en java si lo necesitas
    public void calcularSubtotal() {
        this.Subtotal = this.Cantidad * this.PrecioUnitario;
    }
}