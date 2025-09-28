/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos.Interface;

import capaentidades.Categoria;
import capaentidades.TipoUsuario;
import java.util.List;

/**
 *
 * @author carlo
 */
public interface CategoriaInterface {
        public List<Categoria> listar(String texto);
    public boolean insertar (Categoria c);
    public boolean actualizar (Categoria p);
    public boolean eliminar (Categoria p);
    public List<Categoria> seleccionar();
}
