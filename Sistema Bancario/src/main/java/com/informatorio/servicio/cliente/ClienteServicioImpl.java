package com.informatorio.servicio.cliente;

import com.informatorio.basededatos.BdClientes;
import com.informatorio.domain.Cliente;
import com.informatorio.entrada.InputConsoleService;

import static com.informatorio.basededatos.BdClientes.clientes;

public class ClienteServicioImpl implements ClienteServicio {
    @Override
    public void registrarNuevoCliente() {
        System.out.println("===== Registro de Nuevo Cliente =====");
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = InputConsoleService.getScanner().nextLine();

        System.out.print("Ingrese la dirección del cliente: ");
        String direccion = InputConsoleService.getScanner().nextLine();

        int nuevoNumeroUnico = BdClientes.obtenerUltimoNumeroCliente()+1 ;
        Cliente nuevoCliente = new Cliente(nuevoNumeroUnico,nombre,direccion);
        clientes.add(nuevoCliente);

        System.out.println("Cliente registrado exitosamente. Número único asignado: " + nuevoCliente.getNumeroUnico());

    }

}
