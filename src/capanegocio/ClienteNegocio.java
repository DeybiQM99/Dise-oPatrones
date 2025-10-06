/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capanegocio;

import capadatos.Interface.ClienteInterface;
import capadatos.factory.DAOFactory;
import capadatos.factory.DBType;

import capaentidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClienteNegocio {

    private final ClienteInterface datos;
    private DefaultTableModel modelotabla;

    /**
     * Constructor por defecto: usa la fábrica POSTGRES
     */
    public ClienteNegocio() {
        this(DAOFactory.getFactory(DBType.POSTGRES));
    }

    /**
     * Constructor con inyección de fábrica (útil para tests o cambiar de motor)
     */
    public ClienteNegocio(DAOFactory factory) {
        this.datos = factory.getClienteDAO();
    }

    // Listar clientes (con búsqueda por nombre o dni)
    public DefaultTableModel listar(String texto) {
        List<Cliente> lista = new ArrayList<>();
        lista.addAll(datos.listar(texto));

        String[] columnas = new String[]{
            "IdCliente", "Nombre", "Apellido", "DNI", "Telefono", "Direccion", "Razon Social", "RUC"
        };
        String[] fila = new String[8];

        this.modelotabla = new DefaultTableModel(null, columnas);

        for (Cliente item : lista) {
            fila[0] = Integer.toString(item.getIdCliente());
            fila[1] = item.getNombre();
            fila[2] = item.getApellido();
            fila[3] = item.getDni();
            fila[4] = item.getTelefono();
            fila[5] = item.getDireccion();
            fila[6] = item.getRazonSocial();
            fila[7] = item.getRuc();
            this.modelotabla.addRow(fila);
        }
        return modelotabla;
    }

    // Insertar cliente
    public String insertar(Cliente cli) {
        if (datos.insertar(cli)) {
            return "✅ Cliente registrado exitosamente";
        } else {
            return "❌ Error al registrar cliente";
        }
    }

    // Actualizar cliente
    public String actualizar(Cliente cli) {
        if (datos.actualizar(cli)) {
            return "✅ Cliente actualizado exitosamente";
        } else {
            return "❌ Error al actualizar cliente";
        }
    }

    // Eliminar cliente
    public String eliminar(Cliente cli) {
        if (datos.eliminar(cli)) {
            return "🗑 Cliente eliminado exitosamente";
        } else {
            return "❌ Error al eliminar cliente";
        }
    }

    // Insertar y devolver ID generado
    public int insertarID(Cliente cli) {
        return datos.insertarID(cli);
    }
}
