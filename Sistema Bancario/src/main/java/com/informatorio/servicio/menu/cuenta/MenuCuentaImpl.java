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
    private CuentaServicio cuentaServicio;
    private MenuCuenta menuCuenta;


    public MenuCuentaImpl(MenuCliente menuCliente, MenuOperacionesBancarias menuOperacionesBancarias, CuentaServicio cuentaServicio) {
        this.menuCliente = menuCliente;
        this.menuOperacionesBancarias = menuOperacionesBancarias;
        this.cuentaServicio = cuentaServicio;
    }

    @Override
    public void crearCuenta() {
        menuCliente.mostrarClientes();
        Cliente cliente = menuCliente.seleccionarCliente();
        menuOperacionesBancarias.consultarSaldos(cliente);
        int opcTipoCuenta = menuCuenta.seleccionarTipoCuenta();
        System.out.print("Ingrese el monto inicial para la cuenta: ");
        double montoInicial = InputConsoleService.getScanner().nextDouble();
        if (opcTipoCuenta ==1){
            cuentaServicio.crearCuentaCorriente(cliente, montoInicial);
            menuOperacionesBancarias.consultarSaldos(cliente);
        } else if (opcTipoCuenta == 2) {
            cuentaServicio.crearCuentaAhorro(cliente, montoInicial);
            menuOperacionesBancarias.consultarSaldos(cliente);
        }else{
            System.out.println("Opcion de cuenta invalida.-");
        }

    }

    @Override
    public int seleccionarTipoCuenta() {
        System.out.println("Tipo de cuenta: ");
        System.out.println("1. Cuenta Corriente");
        System.out.println("2. Caja de Ahorro");
        System.out.println("Ingrese una opcion");
        int opcTipoCuenta =InputConsoleService.getScanner().nextInt();
        return opcTipoCuenta;
    }
}

