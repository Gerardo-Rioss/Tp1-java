package com.informatorio.servicio.menu.cuenta;

import com.informatorio.domain.Cliente;
import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.cuenta.CuentaServicio;
import com.informatorio.servicio.cuenta.CuentaServicioImpl;

public class MenuCuentaImpl implements MenuCuenta {
    private CuentaServicio cuentaServicio= new CuentaServicioImpl();

    @Override
    public void gestionarCuenta(Cliente cliente) {
        System.out.println("Número único del cliente: " + cliente.getNumeroUnico());
        cliente.mostrarSaldoCuenta();
        int opcion;

        do {
            System.out.println("===== Gestionar Cuentas =====");
            System.out.println("Cliente: " + cliente.getNombre());
            System.out.println("Número único del cliente: " + cliente.getNumeroUnico());
            cliente.mostrarSaldoCuenta();
            System.out.println("1. Crear cuenta de ahorro");
            System.out.println("2. Crear cuenta corriente");
            System.out.println("3. Volver al menú anterior");
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
                    System.out.println("Volviendo al menú anterior.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                    break;
            }

        } while (opcion != 3);
    }

}

