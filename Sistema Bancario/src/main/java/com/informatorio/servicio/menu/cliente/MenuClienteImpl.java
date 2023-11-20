package com.informatorio.servicio.menu.cliente;


import com.informatorio.basededatos.BdClientes;
import com.informatorio.domain.Cliente;
import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.cliente.ClienteServicio;

public class MenuClienteImpl implements MenuCliente {
    public static final String MENSAJE_INGRESE_NOMBRE_TEMPLATE="Ingrese el nombre del cliente: ";
    public static final String MENSAJE_INGRESE_DIRECCION_TEMPLATE="Ingrese la direccion del cliente: ";
    public static final String MENSAJE_INGRESAR_CLIENTE_TEMPLATE = "Ingrese el numero de cliente: ";
    public static final String MENSAJE_INGRESE_NUMERO_CUENTA_TEMPLATE="Ingrese el numero de cuenta en la cual quierer depositar: ";
    public static final String MENSAJE_INGRESE_MONTO_DEPOSITAR_TEMPLATE="Ingrese el monto a depositar: ";

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

    @Override
    public int seleccionarTipoCuenta() {
        System.out.println("Tipo de cuenta: ");
        System.out.println("1. Cuenta Corriente");
        System.out.println("2. Caja de Ahorro");
        System.out.println("Ingrese una opcion");
        return InputConsoleService.getScanner().nextInt();
    }

    @Override
    public String ingresarNombre() {
        System.out.print(MENSAJE_INGRESE_NOMBRE_TEMPLATE);
        return InputConsoleService.getScanner().nextLine();
    }

    @Override
    public String ingresarDireccion() {
        System.out.print(MENSAJE_INGRESE_DIRECCION_TEMPLATE);
        return InputConsoleService.getScanner().nextLine();
    }

    @Override
    public int ingreseNroCuenta() {
        System.out.print(MENSAJE_INGRESE_NUMERO_CUENTA_TEMPLATE);
        return InputConsoleService.getScanner().nextInt();
    }

    @Override
    public Double ingreseMonto() {
        System.out.print(MENSAJE_INGRESE_MONTO_DEPOSITAR_TEMPLATE);
        return InputConsoleService.getScanner().nextDouble();
    }


}



