package com.informatorio.servicio.menu.cliente;


import com.informatorio.basededatos.BdClientes;
import com.informatorio.domain.Cliente;
import com.informatorio.domain.Cuenta;
import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.cliente.ClienteServicio;

import java.util.ArrayList;

import static com.informatorio.basededatos.BdClientes.clientes;

public class MenuClienteImpl implements MenuCliente {
    private ClienteServicio clienteServicio;

    public MenuClienteImpl(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    public static final String MENSAJE_INGRESAR_CLIENTE_TEMPLATE = "Ingrese el numero de cliente: ";

    @Override
    public void mostrarClientes() {
        System.out.println("===== Lista de Clientes =====");
        StringBuilder listaClientes = new StringBuilder();
        for (Cliente cliente : BdClientes.clientes) {
            listaClientes.append(String.format("Numero:[%d] %s: %s,\n", cliente.getNumeroUnico(), cliente.getNombre(), cliente.getDireccion()));

        }
        System.out.println(listaClientes);
    }

    @Override
    public void ingresarNuevoCliente() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = InputConsoleService.getScanner().nextLine();
        System.out.print("Ingrese la dirección del cliente: ");
        String direccion = InputConsoleService.getScanner().nextLine();
        clienteServicio.crearCliente(nombre, direccion);
    }


    @Override
    public Cliente seleccionarCliente() {
        mostrarClientes();
        System.out.println(MENSAJE_INGRESAR_CLIENTE_TEMPLATE);
        int numeroCliente =InputConsoleService.getScanner().nextInt();
        Cliente cliente= BdClientes.getClientByNumeroUnico(numeroCliente);
        if (cliente==null){
            System.out.println("No existe ningun cliente con ese Numero.-" + numeroCliente);
        }
        return cliente;

    }





}



