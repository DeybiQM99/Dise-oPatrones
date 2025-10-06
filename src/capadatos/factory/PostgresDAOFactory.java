package capadatos.factory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import capadatos.*;

import capadatos.Interface.*;

public class PostgresDAOFactory extends DAOFactory {

    @Override
    public CategoriaInterface getCategoriaDAO() {
        return new CategoriaDAO();
    }

    @Override
    public ClienteInterface getClienteDAO() {
        return new ClienteDAO();
    }

    @Override
    public ComprobanteInterface getComprobanteDAO() {
        return new ComprobanteDAO();
    }

    @Override
    public EmpleadoInterface getEmpleadoDAO() {
        return new EmpleadoDAO();
    }

    @Override
    public PagoInterface getPagoDAO() {
        return new PagoDAO();
    }

    @Override
    public PedidoInterface getPedidoDAO() {
        return new PedidoDAO();
    }

    @Override
    public DetalleInterface getPedidoDetalleDAO() {
        return new PedidoDetalleDAO();
    }

    @Override
    public ProductoInterface getProductoDAO() {
        return new ProductoDAO();
    }

    @Override
    public TipoUsuarioInface getTipoUsuarioDAO() {
        return new TipoUsuarioDAO();
    }
}
