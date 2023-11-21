package com.informatorio;

import com.informatorio.basededatos.BdClientes;

import com.informatorio.domain.Banco;
import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.cliente.ClienteServicio;
import com.informatorio.servicio.cliente.ClienteServicioImpl;
import com.informatorio.servicio.cuenta.CuentaServicio;
import com.informatorio.servicio.cuenta.CuentaServicioImpl;
import com.informatorio.servicio.menu.cliente.MenuCliente;
import com.informatorio.servicio.menu.cliente.MenuClienteImpl;
import com.informatorio.servicio.menu.cuenta.MenuCuenta;
import com.informatorio.servicio.menu.cuenta.MenuCuentaImpl;
import com.informatorio.servicio.menu.principal.MenuPrincipal;
import com.informatorio.servicio.menu.principal.MenuPrincipalImpl;


public class App 
{
    public static void main(String[] args )
    {
        BdClientes.initClients();
        InputConsoleService.createScanner();
        Banco banco= crearBanco();
        ClienteServicio clienteServicio= new ClienteServicioImpl(banco);
        CuentaServicio cuentaServicio= new CuentaServicioImpl(banco);
        MenuCliente menuCliente = new MenuClienteImpl(banco);
        MenuCuenta menuCuenta= new MenuCuentaImpl(banco);
        MenuPrincipal menuPrincipal= new MenuPrincipalImpl(menuCliente,clienteServicio,cuentaServicio,menuCuenta );
        menuPrincipal.iniciar();
        InputConsoleService.closeScanner();
    }
    private static Banco crearBanco(){
        Banco banco= new Banco(1);
        banco.setClientes(BdClientes.clientes);
        banco.setTasaInteres(26.5);
        banco.setLimiteSobregiro(5000.0);
        return banco;
    }
}
