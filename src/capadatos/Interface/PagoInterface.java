/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package capadatos.Interface;

import capaentidades.Pago;
import java.util.List;

/**
 *
 * @author carlo
 */
public interface PagoInterface {
        List<Pago> listar(String texto);

    // Insertar un registro
    boolean insertar(Pago p);

    // Actualizar un registro
    boolean actualizar(Pago p);

    // Eliminar un registro
    boolean eliminar(Pago p);

    // Seleccionar registros (ej. para combos)
    List<Pago> seleccionar();
    
    public int insertarID(Pago p);
}
