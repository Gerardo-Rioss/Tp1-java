package com.informatorio;

import com.informatorio.basededatos.BdClientes;
import com.informatorio.domain.Banco;
import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.cliente.ClienteServicioImpl;
import com.informatorio.servicio.cuenta.CuentaServicioImpl;
import com.informatorio.servicio.menu.cliente.MenuClienteImpl;
import com.informatorio.servicio.menu.cuenta.MenuCuentaImpl;
import com.informatorio.servicio.menu.principal.MenuPrincipal;
import com.informatorio.servicio.menu.principal.MenuPrincipalImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static Banco banco;


    public static void main(String[] args )
    {
        BdClientes.initClients();
        App.banco = new Banco();
        banco.setClientes(BdClientes.clientes);
        InputConsoleService.createScanner();
        MenuPrincipal menuPrincipal= new MenuPrincipalImpl(new MenuClienteImpl(new MenuCuentaImpl(new CuentaServicioImpl())),new ClienteServicioImpl());
        menuPrincipal.iniciar();


    }
}
