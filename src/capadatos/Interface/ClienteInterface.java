/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package capadatos.Interface;

import capaentidades.Cliente;
import java.util.List;

/**
 *
 * @author carlo
 */
public interface ClienteInterface {

    public List<Cliente> listar(String texto);

    public boolean insertar(Cliente cli);

    public boolean actualizar(Cliente cli);

    public boolean eliminar(Cliente cli);

    public List<Cliente> seleccionar();

    public int insertarID(Cliente cli);
}
