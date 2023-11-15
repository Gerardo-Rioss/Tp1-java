package com.informatorio;

import com.informatorio.basededatos.BdClientes;
import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.menu.principal.MenuPrincipal;
import com.informatorio.servicio.menu.principal.MenuPrincipalImpl;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        BdClientes.initClients();
        InputConsoleService.createScanner();
        MenuPrincipal menuPrincipal= new MenuPrincipalImpl();
        menuPrincipal.iniciar();


    }
}
