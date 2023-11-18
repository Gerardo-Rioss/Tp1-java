package com.informatorio.servicio.menu.principal;


import com.informatorio.App;
import com.informatorio.basededatos.BdClientes;
import com.informatorio.domain.Banco;
import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.cliente.ClienteServicio;
import com.informatorio.servicio.cliente.ClienteServicioImpl;
import com.informatorio.servicio.menu.cliente.MenuCliente;
import com.informatorio.servicio.menu.cliente.MenuClienteImpl;
import com.informatorio.servicio.menu.cuenta.MenuCuenta;

public class MenuPrincipalImpl implements MenuPrincipal {
    private MenuCliente menuCliente;
    private MenuCuenta menuCuenta;


    public MenuPrincipalImpl(MenuCliente menuCliente, MenuCuenta menuCuenta) {
        this.menuCliente = menuCliente;
        this.menuCuenta=menuCuenta;

    }

    @Override
    public void iniciar() {int opcion;
        do {
            System.out.println("===== Menú Principal =====");
            System.out.println("===== Clientes =====");
            System.out.println("1. Registrar nuevo cliente");
            System.out.println("2. Mostrar Lista de Clientes");
            System.out.println("===== Operaciones Bancarias =====");
            System.out.println("3. Depositar");
            System.out.println("4. Retirar");
            System.out.println("5. Consultar Saldo");
            System.out.println("===== Cuentas Bancarias =====");
            System.out.println("6. Crear Cuenta");
            System.out.println("7. Eliminar Cuenta");
            System.out.println("8. Exportar CSV Cuentas Bancarias");
            System.out.println("=============================");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = InputConsoleService.getScanner().nextInt();
            InputConsoleService.scanner.nextLine();
            System.out.println("==================================================");

            switch (opcion) {
                case 1:
                    menuCliente.registrarNuevoCliente();
                    break;
                case 2:
                    menuCliente.mostrarClientes();
                    break;
                case 3:
                    // depositar
                    break;
                case 4:
                    // retirar
                    break;
                case 5:
                    // consultar saldo
                    break;
                case 6:
                    // crear cuenta
                    menuCuenta.crearCuenta();
                    break;
                case 7:
                    // eliminar cuenta
                    break;
                case 8:
                //Exportar CSV Cuentas Bancarias
                break ;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                    break;
            }

        } while (opcion != 0);
    }



}

