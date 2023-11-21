package com.informatorio.servicio.menu.cliente;


import com.informatorio.basededatos.BdClientes;
import com.informatorio.domain.Banco;
import com.informatorio.domain.Cliente;
import com.informatorio.entrada.InputConsoleService;


public class MenuClienteImpl implements MenuCliente {
    private Banco banco;

    public MenuClienteImpl(Banco banco) {
        this.banco = banco;
    }

    public static final String MENSAJE_INGRESE_NOMBRE_TEMPLATE="Ingrese el nombre del cliente: ";
    public static final String MENSAJE_INGRESE_DIRECCION_TEMPLATE="Ingrese la direccion del cliente: ";
    public static final String MENSAJE_INGRESAR_CLIENTE_TEMPLATE = "Ingrese el numero de cliente: ";
    public static final String MENSAJE_INGRESE_NUMERO_CUENTA_DEPOSITAR_TEMPLATE="Ingrese el numero de cuenta en la cual quierer depositar: ";
    public static final String MENSAJE_INGRESE_NUMERO_CUENTA_ELIMINAR_TEMPLATE="Ingrese el numero de cuenta que quiere eliminar: ";
    public static final String MENSAJE_INGRESE_NUMERO_CUENTA_RETIRAR_TEMPLATE="Ingrese el numero de cuenta de donde quiere retirar dinero: ";
    public static final String MENSAJE_INGRESE_MONTO_DEPOSITAR_TEMPLATE="Ingrese el monto a depositar: ";
    public static final String MENSAJE_INGRESE_MONTO_RETIRAR_TEMPLATE="Ingrese el monto a retirar: ";
    public static final String MENSAJE_INGRESE_MONTO_INICIAL_TEMPLATE="Ingrese el monto inicial para la cuenta: ";

    @Override
    public void mostrarClientes() {
        System.out.println("===== Lista de Clientes =====");
        StringBuilder listaClientes = new StringBuilder();
        for (Cliente cliente : banco.getClientes() ) {
            listaClientes.append(String.format("Numero:[%d] %s: %s,\n", cliente.getNumeroUnico(), cliente.getNombre(), cliente.getDireccion()));

        }
        System.out.println(listaClientes);
    }
    @Override
    public Cliente seleccionarCliente() {
        mostrarClientes();
        System.out.println(MENSAJE_INGRESAR_CLIENTE_TEMPLATE);
        int numeroCliente =InputConsoleService.getScanner().nextInt();
        Cliente cliente= banco.getClientByNumeroUnico(numeroCliente);
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
    public int ingreseNroCuentaDepositar() {
        System.out.print(MENSAJE_INGRESE_NUMERO_CUENTA_DEPOSITAR_TEMPLATE);
        return InputConsoleService.getScanner().nextInt();
    }

    @Override
    public int ingreseNroCuentaEliminar() {
        System.out.print(MENSAJE_INGRESE_NUMERO_CUENTA_ELIMINAR_TEMPLATE);
        return InputConsoleService.getScanner().nextInt();
    }

    @Override
    public Double ingreseMontoDepositar() {
        System.out.print(MENSAJE_INGRESE_MONTO_DEPOSITAR_TEMPLATE);
        return InputConsoleService.getScanner().nextDouble();
    }

    @Override
    public Double ingreseMontoInicial() {
        System.out.print(MENSAJE_INGRESE_MONTO_INICIAL_TEMPLATE);
        return InputConsoleService.getScanner().nextDouble();
    }

    @Override
    public Double ingreseMontoRetirar() {
        System.out.print(MENSAJE_INGRESE_MONTO_RETIRAR_TEMPLATE);
        return InputConsoleService.getScanner().nextDouble();
    }

    @Override
    public int ingreseNroCuentaRetirar() {
        System.out.print(MENSAJE_INGRESE_NUMERO_CUENTA_RETIRAR_TEMPLATE);
        return InputConsoleService.getScanner().nextInt();
    }


}



