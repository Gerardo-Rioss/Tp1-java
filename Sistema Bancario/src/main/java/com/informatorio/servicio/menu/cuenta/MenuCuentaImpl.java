package com.informatorio.servicio.menu.cuenta;

import com.informatorio.basededatos.BdClientes;
import com.informatorio.domain.Cliente;
import com.informatorio.domain.CuentaAhorro;
import com.informatorio.domain.CuentaCorriente;
import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.cuenta.CuentaServicio;
import com.informatorio.servicio.cuenta.CuentaServicioImpl;
import com.informatorio.servicio.menu.cliente.MenuCliente;
import com.informatorio.servicio.menu.operacionesBancarias.MenuOperacionesBancarias;

public class MenuCuentaImpl implements MenuCuenta {
    private MenuCliente menuCliente;
    private MenuOperacionesBancarias menuOperacionesBancarias;

    public MenuCuentaImpl(MenuCliente menuCliente, MenuOperacionesBancarias menuOperacionesBancarias) {
        this.menuCliente = menuCliente;
        this.menuOperacionesBancarias = menuOperacionesBancarias;
    }

    @Override
    public void crearCuenta() {
        menuCliente.mostrarClientes();
        System.out.print("Ingrese el numero de Cliente: ");
        int numeroCliente = InputConsoleService.getScanner().nextInt();
        Cliente cliente = BdClientes.getClientByNumeroUnico(numeroCliente);
        System.out.println();
        menuOperacionesBancarias.consultarSaldos(cliente);
        System.out.println();
        System.out.println("Tipo de cuenta: ");
        System.out.println("1. Cuenta Corriente");
        System.out.println("2. Caja de Ahorro");
        System.out.println("Ingrese una opcion");
        int opcTipoCuenta =InputConsoleService.getScanner().nextInt();
        System.out.print("Ingrese el monto inicial para la cuenta: ");
        double montoInicial = InputConsoleService.getScanner().nextDouble();
        InputConsoleService.scanner.nextLine();
        int numeroCuentaNuevo = cliente.getUltimoNumeroCuenta() + 1;
        if (opcTipoCuenta ==1){
            //Crear cuenta Corriente
            CuentaCorriente cuentaCorriente = new CuentaCorriente(numeroCuentaNuevo, cliente, montoInicial, 5000.0);
            cliente.agregarCuenta(cuentaCorriente);
            System.out.println("Cuenta de ahorro creada exitosamente. Número único de cuenta: " + cuentaCorriente.getNumeroCuenta());
            menuOperacionesBancarias.consultarSaldos(cliente);

        }else if(opcTipoCuenta ==2){
            //Crear Caja de ahorro
            CuentaAhorro cuentaAhorro = new CuentaAhorro(numeroCuentaNuevo, cliente, montoInicial, 6.5);
            cliente.agregarCuenta(cuentaAhorro);
            System.out.println("Cuenta de ahorro creada exitosamente. Número único de cuenta: " + cuentaAhorro.getNumeroCuenta());
            menuOperacionesBancarias.consultarSaldos(cliente);
        }else{
            System.out.println("Opcion de cuenta invalida.-");
        }

    }
}

