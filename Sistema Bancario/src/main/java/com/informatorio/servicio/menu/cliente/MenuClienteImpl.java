package com.informatorio.servicio.menu.cliente;


import com.informatorio.basededatos.BdClientes;
import com.informatorio.domain.Cliente;
import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.menu.principal.MenuPrincipal;

import static com.informatorio.basededatos.BdClientes.clientes;

public class MenuClienteImpl implements MenuCliente {
    private MenuPrincipal menuPrincipal;
    private MenuCliente menuCliente;

    @Override
    public void registrarNuevoCliente() {
        System.out.println("===== Registro de Nuevo Cliente =====");
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = InputConsoleService.getScanner().nextLine();

        System.out.print("Ingrese la dirección del cliente: ");
        String direccion = InputConsoleService.getScanner().nextLine();

        int nuevoNumeroUnico = BdClientes.obtenerUltimoNumeroCliente()+1 ;
        Cliente nuevoCliente = new Cliente(nuevoNumeroUnico,nombre,direccion);
        clientes.add(nuevoCliente);

        System.out.println("Cliente registrado exitosamente. Número único asignado: " + nuevoCliente.getNumeroUnico());

    }

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
                    //crearCuentaDeAhorro(scanner, cliente);
                    break;
                case 2:
                    //crearCuentaCorriente(scanner, cliente);
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



