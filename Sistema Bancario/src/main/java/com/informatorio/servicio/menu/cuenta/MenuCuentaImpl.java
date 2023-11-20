package com.informatorio.servicio.menu.cuenta;

import com.informatorio.basededatos.BdClientes;
import com.informatorio.domain.Cliente;
import com.informatorio.domain.CuentaAhorro;
import com.informatorio.domain.CuentaCorriente;
import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.cliente.ClienteServicio;
import com.informatorio.servicio.cuenta.CuentaServicio;
import com.informatorio.servicio.cuenta.CuentaServicioImpl;
import com.informatorio.servicio.menu.cliente.MenuCliente;
import com.informatorio.servicio.menu.operacionesBancarias.MenuOperacionesBancarias;

public class MenuCuentaImpl implements MenuCuenta {
    private MenuCliente menuCliente;
    //private MenuOperacionesBancarias menuOperacionesBancarias;
    private CuentaServicio cuentaServicio;
    private ClienteServicio clienteServicio;



    public MenuCuentaImpl(MenuCliente menuCliente,  CuentaServicio cuentaServicio,ClienteServicio clienteServicio) {
        this.menuCliente = menuCliente;

        this.cuentaServicio = cuentaServicio;
        this.clienteServicio = clienteServicio;
    }

    @Override
    public void crearCuenta() {
        menuCliente.mostrarClientes();
        Cliente cliente = menuCliente.seleccionarCliente();
        clienteServicio.consultaSaldosCuentasTotal(cliente);
        int opcTipoCuenta = menuCliente.seleccionarTipoCuenta();
        System.out.print("Ingrese el monto inicial para la cuenta: ");
        double montoInicial = InputConsoleService.getScanner().nextDouble();
        if (opcTipoCuenta ==1){
            cuentaServicio.crearCuentaCorriente(cliente, montoInicial);
            clienteServicio.consultaSaldosCuentasTotal(cliente);
        } else if (opcTipoCuenta == 2) {
            cuentaServicio.crearCuentaAhorro(cliente, montoInicial);
            clienteServicio.consultaSaldosCuentasTotal(cliente);
        }else{
            System.out.println("Opcion de cuenta invalida.-");
        }

    }


}

