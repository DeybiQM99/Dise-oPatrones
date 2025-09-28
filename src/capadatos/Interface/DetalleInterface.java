/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos.Interface;

import capaentidades.Categoria;
import capaentidades.PedidoDetalle;
import capaentidades.TipoUsuario;
import java.util.List;

/**
 *
 * @author carlo
 */
public interface DetalleInterface {
        public List<PedidoDetalle> listar(String texto);
    public boolean insertar(PedidoDetalle detalle);
    public boolean actualizar(PedidoDetalle detalle);
    public boolean eliminar(PedidoDetalle detalle);
}
