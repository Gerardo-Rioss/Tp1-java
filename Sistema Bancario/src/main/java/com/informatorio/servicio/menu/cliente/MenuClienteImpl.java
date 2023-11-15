package com.informatorio.servicio.menu.cliente;


import com.informatorio.basededatos.BdClientes;
import com.informatorio.domain.Cliente;
import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.cliente.ClienteServicio;
import com.informatorio.servicio.cuenta.CuentaServicio;
import com.informatorio.servicio.menu.principal.MenuPrincipal;

import static com.informatorio.basededatos.BdClientes.clientes;

public class MenuClienteImpl implements MenuCliente {
    private MenuPrincipal menuPrincipal;
    private MenuCliente menuCliente;
    private CuentaServicio cuentaServicio;
    @Override
    public void ingresaComoCliente() {
        System.out.print("Ingrese el número único del cliente: ");
        int numeroUnicoCliente = InputConsoleService.getScanner().nextInt();
        InputConsoleService.scanner.nextLine();

        Cliente cliente = BdClientes.getClientByNumeroUnico(numeroUnicoCliente);

        if (cliente != null) {
            menuCliente.menuCliente(cliente);
        } else {
            System.out.println("Cliente no encontrado. Por favor, verifique el número único.");
        }
    }

    @Override
    public void menuCliente(Cliente cliente) {
        int opcion;
        do {
            System.out.println("===== Menú Cliente =====");
            System.out.println("Cliente: " + cliente.getNombre());
            System.out.println("Número único del cliente: " + cliente.getNumeroUnico());
            System.out.println("Saldo total: " + cliente.getSaldoTotal());
            System.out.println("1. Crear cuenta de ahorro");
            System.out.println("2. Crear cuenta corriente");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = InputConsoleService.getScanner().nextInt();
            InputConsoleService.scanner.nextLine();

            switch (opcion) {
                case 1:
                    cuentaServicio.crearCuentaDeAhorro(cliente);
                    break;
                case 2:
                    cuentaServicio.crearCuentaCorriente(cliente);
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal.");
                    menuPrincipal.iniciar();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                    break;
            }
        } while (opcion != 3);
    }
}



