/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos.Interface;

import capaentidades.TipoUsuario;
import java.util.List;

/**
 *
 * @author carlo
 */
public interface TipoUsuarioInface {
    public List<TipoUsuario> listar(String texto);
    public boolean insertar (TipoUsuario p);
    public boolean actualizar (TipoUsuario p);
    public boolean eliminar (TipoUsuario p);
    public List<TipoUsuario> seleccionar();
}
