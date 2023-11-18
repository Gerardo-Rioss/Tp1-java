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
        CuentaServicio cuentaServicio= new CuentaServicioImpl();
        ClienteServicio clienteServicio= new ClienteServicioImpl();
        MenuCuenta menuCuenta = new MenuCuentaImpl();
        MenuCliente menuCliente = new MenuClienteImpl();
        MenuPrincipal menuPrincipal= new MenuPrincipalImpl(menuCliente);
        menuPrincipal.iniciar();
        InputConsoleService.closeScanner();
    }
}
