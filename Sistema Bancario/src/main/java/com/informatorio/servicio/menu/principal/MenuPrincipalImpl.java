package com.informatorio.servicio.menu.principal;


import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.menu.cliente.MenuCliente;

public class MenuPrincipalImpl implements MenuPrincipal {
    private MenuCliente menuCliente;
    @Override
    public void iniciar() {int opcion;
        do {
            System.out.println("===== Menú Principal =====");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Ingresar como cliente");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = InputConsoleService.getScanner().nextInt();
            InputConsoleService.scanner.nextLine();

            switch (opcion) {
                case 1:
                    menuCliente.registrarNuevoCliente();
                    break;
                case 2:
                    menuCliente.ingresaComoCliente();
                    break;
                case 3:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                    break;
            }

        } while (opcion != 3);
    }

}

