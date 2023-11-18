package com.informatorio.servicio.menu.cuenta;

import com.informatorio.basededatos.BdClientes;
import com.informatorio.domain.Cliente;
import com.informatorio.domain.CuentaAhorro;
import com.informatorio.domain.CuentaCorriente;
import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.cuenta.CuentaServicio;
import com.informatorio.servicio.cuenta.CuentaServicioImpl;
import com.informatorio.servicio.menu.cliente.MenuCliente;

public class MenuCuentaImpl implements MenuCuenta {
    private MenuCliente menuCliente;

    public MenuCuentaImpl(MenuCliente menuCliente) {
        this.menuCliente = menuCliente;
    }

    @Override
    public void crearCuenta() {
        menuCliente.mostrarClientes();
        System.out.print("Ingrese el numero de Cliente: ");
        int numeroCliente = InputConsoleService.getScanner().nextInt();
        Cliente cliente = BdClientes.getClientByNumeroUnico(numeroCliente);
        System.out.print("Ingrese el monto inicial para la cuenta de ahorro: ");
        double montoInicial = InputConsoleService.getScanner().nextDouble();
        InputConsoleService.scanner.nextLine();
        int numeroCuentaNuevo = cliente.getUltimoNumeroCuenta() + 1;
        int opc;
        do {
            System.out.println("1. Cuenta Corriente");
            System.out.println("2. Caja de Ahorro");
            System.out.println("0. Cancelar y salir");
            System.out.println("Ingrese una opcion");
            opc = InputConsoleService.getScanner().nextInt();
            switch (opc) {
                case 1:
                    //Crear cuenta Corriente
                    CuentaCorriente cuentaCorriente = new CuentaCorriente(numeroCuentaNuevo, cliente, montoInicial, 5000.0);
                    cliente.agregarCuenta(cuentaCorriente);
                    System.out.println("Cuenta de ahorro creada exitosamente. Número único de cuenta: " + cuentaCorriente.getNumeroCuenta());
                    break;
                case 2:
                    //Crear Caja de ahorro
                    CuentaAhorro cuentaAhorro = new CuentaAhorro(numeroCuentaNuevo, cliente, montoInicial, 6.5);
                    cliente.agregarCuenta(cuentaAhorro);
                    System.out.println("Cuenta de ahorro creada exitosamente. Número único de cuenta: " + cuentaAhorro.getNumeroCuenta());
                    break;
                case 0:
                    System.out.println("Salir");
                    break;
                default:
                    System.out.println("Error! Opcion invalida");
            }

        }while (opc != 0) ;
    }
}

