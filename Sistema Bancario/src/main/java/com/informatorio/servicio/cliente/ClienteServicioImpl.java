package com.informatorio.servicio.cliente;

import com.informatorio.basededatos.BdClientes;
import com.informatorio.domain.Cliente;
import com.informatorio.domain.Cuenta;

import java.util.ArrayList;

import static com.informatorio.basededatos.BdClientes.clientes;

public class ClienteServicioImpl implements ClienteServicio {


    @Override
    public void crearCliente(String nombre, String direccion) {
        int nuevoNumeroUnico =BdClientes.obtenerNuevoNumeroCliente();
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNumeroUnico(nuevoNumeroUnico);
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setDireccion(direccion);
        nuevoCliente.setCuentas(new ArrayList<Cuenta>());
        clientes.add(nuevoCliente);
        System.out.println("Cliente registrado exitosamente. Número único asignado: " + nuevoCliente.getNumeroUnico());
        System.out.println("==================================================");

    }

    @Override
    public Cliente getClientePorNumero(int numeroCliente) {
        Cliente cliente = BdClientes.getClientByNumeroUnico(numeroCliente);
        return cliente;
    }
}
