package com.informatorio.servicio.menu.cliente;


import com.informatorio.App;
import com.informatorio.basededatos.BdClientes;
import com.informatorio.domain.Cliente;
import com.informatorio.domain.Cuenta;
import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.cliente.ClienteServicio;
import com.informatorio.servicio.cuenta.CuentaServicio;
import com.informatorio.servicio.cuenta.CuentaServicioImpl;
import com.informatorio.servicio.menu.cuenta.MenuCuenta;
import com.informatorio.servicio.menu.cuenta.MenuCuentaImpl;
import com.informatorio.servicio.menu.principal.MenuPrincipal;
import com.informatorio.servicio.menu.principal.MenuPrincipalImpl;

import java.util.Optional;

import static com.informatorio.basededatos.BdClientes.clientes;

public class MenuClienteImpl implements MenuCliente {
    private final MenuCuenta menuCuenta= new MenuCuentaImpl();

    @Override
    public void ingresaNumeroCliente() {
        System.out.print("Ingrese el número único del cliente: ");
        int numeroUnicoCliente = InputConsoleService.getScanner().nextInt();
        InputConsoleService.scanner.nextLine();
        try {
            Cliente cliente = App.banco.getClienteByNumero(numeroUnicoCliente);
            menuCliente(cliente);
        } catch (NullPointerException e) {
            System.out.println("No se econtró ningún cliente con ese número: '" + numeroUnicoCliente +"'");
        }

    }

    @Override
    public void menuCliente(Cliente cliente) {
        int opcion;
        do {
            System.out.println("===== Menú Cliente =====");
            System.out.println("Cliente: " + cliente.getNombre());
            System.out.println("1. Gestionar Cuentas y consultar saldos");
            System.out.println("2. Realizar Depósito o Retiro de dinero");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = InputConsoleService.getScanner().nextInt();
            InputConsoleService.scanner.nextLine();

            switch (opcion) {
                case 1:
                    //cuentaServicio.crearCuentaDeAhorro(cliente);
                    menuCuenta.gestionarCuenta(cliente);
                    break;
                case 2:
                    //cuentaServicio.crearCuentaCorriente(cliente);
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal.");
                   //menuPrincipal.iniciar();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                    break;
            }
        } while (opcion != 3);
    }

}



