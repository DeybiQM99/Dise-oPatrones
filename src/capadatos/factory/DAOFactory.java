/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos.factory;

import capadatos.Interface.CategoriaInterface;
import capadatos.Interface.ClienteInterface;
import capadatos.Interface.ComprobanteInterface;
import capadatos.Interface.DetalleInterface;
import capadatos.Interface.EmpleadoInterface;
import capadatos.Interface.PagoInterface;
import capadatos.Interface.PedidoInterface;
import capadatos.Interface.ProductoInterface;
import capadatos.Interface.TipoUsuarioInface; // así se llama en tu proyecto

public abstract class DAOFactory {

    public static DAOFactory getFactory(DBType tipo) {
        switch (tipo) {
            case POSTGRES:
            default:
                return new PostgresDAOFactory();
        }
    }

    public abstract CategoriaInterface getCategoriaDAO();

    public abstract ClienteInterface getClienteDAO();

    public abstract ComprobanteInterface getComprobanteDAO();

    public abstract EmpleadoInterface getEmpleadoDAO();

    public abstract PagoInterface getPagoDAO();

    public abstract PedidoInterface getPedidoDAO();

    public abstract DetalleInterface getPedidoDetalleDAO();

    public abstract ProductoInterface getProductoDAO();

    public abstract TipoUsuarioInface getTipoUsuarioDAO();
}
