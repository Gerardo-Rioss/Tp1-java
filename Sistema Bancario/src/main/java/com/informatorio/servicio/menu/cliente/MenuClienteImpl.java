package com.informatorio.servicio.menu.cliente;


import com.informatorio.App;
import com.informatorio.basededatos.BdClientes;
import com.informatorio.domain.Cliente;
import com.informatorio.domain.Cuenta;
import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.cliente.ClienteServicio;
import com.informatorio.servicio.cuenta.CuentaServicio;
import com.informatorio.servicio.cuenta.CuentaServicioImpl;
import com.informatorio.servicio.menu.cuenta.MenuCuenta;
import com.informatorio.servicio.menu.cuenta.MenuCuentaImpl;
import com.informatorio.servicio.menu.principal.MenuPrincipal;
import com.informatorio.servicio.menu.principal.MenuPrincipalImpl;

import java.util.ArrayList;
import java.util.Optional;

import static com.informatorio.basededatos.BdClientes.clientes;

public class MenuClienteImpl implements MenuCliente {
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
    public void registrarNuevoCliente() {
        System.out.println("===== Registro de Nuevo Cliente =====");
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = InputConsoleService.getScanner().nextLine();
        System.out.print("Ingrese la dirección del cliente: ");
        String direccion = InputConsoleService.getScanner().nextLine();
        int nuevoNumeroUnico =BdClientes.obtenerUltimoNumeroCliente()+1;
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
    public Optional<Cliente> seleccionarCliente() {
        mostrarClientes();
        System.out.println(MENSAJE_INGRESAR_CLIENTE_TEMPLATE);
        int numeroCliente =InputConsoleService.getScanner().nextInt();
        Optional<Cliente> cliente= Optional.ofNullable(BdClientes.getClientByNumeroUnico(numeroCliente));
        return Optional.empty();
    }


}



