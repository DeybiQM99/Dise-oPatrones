/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package capadatos.Interface;

import capaentidades.Empleado;
import java.util.List;

/**
 *
 * @author carlo
 */
public interface EmpleadoInterface {

    public List<Empleado> listar(String texto);

    public boolean insertar(Empleado E);

    public boolean actualizar(Empleado E);

    public boolean eliminar(Empleado E);

    public List<Empleado> seleccionar();

    public int insertarID(Empleado e);
    
    public Empleado obtenerPorUsuario(String usuario);
}
