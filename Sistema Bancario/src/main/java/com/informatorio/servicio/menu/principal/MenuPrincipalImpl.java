package com.informatorio.servicio.menu.principal;



import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.cliente.ClienteServicio;
import com.informatorio.servicio.cuenta.CuentaServicio;
import com.informatorio.servicio.menu.cliente.MenuCliente;

public class MenuPrincipalImpl implements MenuPrincipal {
    private MenuCliente menuCliente;


    private ClienteServicio clienteServicio;
    private CuentaServicio cuentaServicio;


    public MenuPrincipalImpl(MenuCliente menuCliente,   ClienteServicio clienteServicio, CuentaServicio cuentaServicio) {
        this.menuCliente = menuCliente;
        this.clienteServicio= clienteServicio;
        this.cuentaServicio= cuentaServicio;

    }

    @Override
    public void iniciar() {int opcion;
        do {
            System.out.println("       Menú Principal      ");
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
            System.out.println("===== Banco Administracion =====");
            System.out.println("9. Modificar Interes Cuenta Ahorro");
            System.out.println("10. Agregar Interes a las Cuentas Ahorro");
            System.out.println("11. Modificar limite sobregiro de las Cuentas Corrientes");
            System.out.println("=============================");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = InputConsoleService.getScanner().nextInt();
            InputConsoleService.scanner.nextLine();
            System.out.println("==================================================");

            switch (opcion) {
                case 1:
                    //Registrar nuevo cliente
                    clienteServicio.crearCliente(menuCliente.ingresarNombre(),menuCliente.ingresarDireccion());
                    break;
                case 2:
                    //Mostrar Lista de Clientes
                    menuCliente.mostrarClientes();
                    break;
                case 3:
                    // depositar
                    cuentaServicio.depositar(menuCliente.seleccionarCliente(),menuCliente.ingreseMontoDepositar(),menuCliente.ingreseNroCuenta());
                    break;
                case 4:
                    // retirar
                    break;
                case 5:
                    //Consultar Saldo
                    clienteServicio.consultaSaldosCuentasTotal(menuCliente.seleccionarCliente());
                    break;
                case 6:
                    //Crear Cuenta
                    int tipo = menuCliente.seleccionarTipoCuenta();
                    if(tipo==1){
                        cuentaServicio.crearCuentaCorriente(menuCliente.seleccionarCliente(),menuCliente.ingreseMontoInicial());
                    } else if (tipo == 2) {
                        cuentaServicio.crearCuentaAhorro(menuCliente.seleccionarCliente(),menuCliente.ingreseMontoInicial());
                    }else {
                        System.out.println("Opcion de cuenta invalida.-");
                    }



                    break;
                case 7:
                    // eliminar cuenta
                    break;
                case 8:
                //Exportar CSV Cuentas Bancarias
                break ;
                case 9:
                    // Modificar Interes Cuenta Ahorro
                    break;
                case 10:
                    // Agregar Interes a las Cuentas Ahorro
                    break;
                case 11:
                    //Modificar limite sobregiro de las Cuentas Corrientes
                    break;
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

