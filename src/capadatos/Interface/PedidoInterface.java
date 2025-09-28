/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos.Interface;

import capaentidades.Pedido;
import java.util.List;

public interface PedidoInterface {

    public List<Pedido> listar(String texto);

    public boolean insertar(Pedido pedido);

    public boolean actualizar(Pedido pedido);

    public boolean eliminar(Pedido pedido);

    public List<Pedido> seleccionar();

    public Pedido generarPedidoAutomatico();

    public int insertarID(Pedido p);
}
