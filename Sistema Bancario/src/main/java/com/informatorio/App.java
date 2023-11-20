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
import com.informatorio.servicio.menu.operacionesBancarias.MenuOperacionesBancarias;
import com.informatorio.servicio.menu.operacionesBancarias.MenuOperacionesBancariasImpl;
import com.informatorio.servicio.menu.principal.MenuPrincipal;
import com.informatorio.servicio.menu.principal.MenuPrincipalImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args )
    {
        BdClientes.initClients();
        InputConsoleService.createScanner();

        ClienteServicio clienteServicio= new ClienteServicioImpl();
        CuentaServicio cuentaServicio= new CuentaServicioImpl();
        MenuOperacionesBancarias menuOperacionesBancarias= new MenuOperacionesBancariasImpl(clienteServicio,cuentaServicio);
        MenuCliente menuCliente = new MenuClienteImpl(clienteServicio);
        MenuCuenta menuCuenta = new MenuCuentaImpl(menuCliente, menuOperacionesBancarias, cuentaServicio);
        MenuPrincipal menuPrincipal= new MenuPrincipalImpl(menuCliente, menuCuenta, menuOperacionesBancarias,clienteServicio);
        menuPrincipal.iniciar();
        InputConsoleService.closeScanner();
    }
}
