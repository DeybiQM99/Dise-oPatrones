/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capanegocio;

import capadatos.Interface.PedidoInterface;
import capadatos.factory.DAOFactory;
import capadatos.factory.DBType;

import capaentidades.Pedido;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PedidoNegocio {

    private final PedidoInterface datos;
    private DefaultTableModel modelotabla;

    /**
     * Constructor por defecto: usa la fábrica POSTGRES
     */
    public PedidoNegocio() {
        this(DAOFactory.getFactory(DBType.POSTGRES));
    }

    /**
     * Constructor con inyección de fábrica (tests / otros motores)
     */
    public PedidoNegocio(DAOFactory factory) {
        this.datos = factory.getPedidoDAO();
    }

    public DefaultTableModel listar(String texto) {
        List<Pedido> lista = new ArrayList<>();
        lista.addAll(datos.listar(texto));

        String[] columnas = new String[]{
            "IdPedido", "Numero de Pedido", "Hora", "Fecha", "Estado"
        };
        String[] fila = new String[5];
        this.modelotabla = new DefaultTableModel(null, columnas);

        for (Pedido item : lista) {
            fila[0] = Integer.toString(item.getIdPedido());
            fila[1] = item.getNumeroDePedido();
            fila[2] = item.getHora().toString();
            fila[3] = item.getFecha().toString();
            fila[4] = item.getEstado();
            this.modelotabla.addRow(fila);
        }
        return modelotabla;
    }

    public String insertar(Pedido p) {
        return datos.insertar(p)
                ? "Registro insertado exitosamente"
                : "Registro insertado no exitoso";
    }

    public String actualizar(Pedido p) {
        return datos.actualizar(p)
                ? "Actualizado exitosamente"
                : "Actualización no exitosa";
    }

    public String eliminar(Pedido p) {
        return datos.eliminar(p)
                ? "Eliminado exitosamente"
                : "Eliminación no exitosa";
    }

    /**
     * Inserta generando un pedido automático desde el DAO
     */
    public String insertarAutomatico(Pedido p) {
        Pedido nuevo = datos.generarPedidoAutomatico(); // método en el DAO/Interface
        nuevo.setEstado(p.getEstado());

        return datos.insertar(nuevo)
                ? "Pedido insertado exitosamente con número: " + nuevo.getNumeroDePedido()
                : "Error al insertar pedido";
    }

    /**
     * Genera un pedido automático desde la capa de negocio (opcional)
     */
    public Pedido generarAutomatico() {
        Pedido ped = new Pedido();

        // Generar número único: PED + yyyyMMddHHmmss
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String numero = "PED" + sdf.format(new java.util.Date());
        ped.setNumeroDePedido(numero);

        // Fecha y hora actuales
        java.util.Date ahora = new java.util.Date();
        ped.setFecha(new java.sql.Date(ahora.getTime()));
        ped.setHora(new java.sql.Time(ahora.getTime()));

        // Estado por defecto
        ped.setEstado("En preparacion");
        return ped;
    }

    public int insertarID(Pedido p) {
        return datos.insertarID(p);
    }
}
