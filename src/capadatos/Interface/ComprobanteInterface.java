/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capadatos.Interface;

import capaentidades.Comprobante;

/**
 *
 * @author carlo
 */
public interface ComprobanteInterface {

    public int insertarID(Comprobante comp);

    public boolean insertar(Comprobante c);

    public String generarNumero();

    public String generarCodigo();

    public int obtenerUltimoNumero(String tipo);

    public int obtenerUltimoNumero1(String tipo);
}
