package com.informatorio.servicio.menu.cliente;


import com.informatorio.App;
import com.informatorio.basededatos.BdClientes;
import com.informatorio.domain.Cliente;
import com.informatorio.domain.Cuenta;
import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.cliente.ClienteServicio;
import com.informatorio.servicio.cuenta.CuentaServicio;
import com.informatorio.servicio.cuenta.CuentaServicioImpl;
import com.informatorio.servicio.menu.principal.MenuPrincipal;
import com.informatorio.servicio.menu.principal.MenuPrincipalImpl;

import static com.informatorio.basededatos.BdClientes.clientes;

public class MenuClienteImpl implements MenuCliente {
    //private final MenuPrincipal menuPrincipal= new MenuPrincipalImpl();
    //private final MenuCliente menuCliente= new MenuClienteImpl();
    private final CuentaServicio cuentaServicio= new CuentaServicioImpl();
    @Override
    public void ingresaNumeroCliente() {
        System.out.print("Ingrese el número único del cliente: ");
        int numeroUnicoCliente = InputConsoleService.getScanner().nextInt();
        InputConsoleService.scanner.nextLine();
        Cliente cliente= App.banco.getClientes().get(numeroUnicoCliente);

        if (cliente ==null){
            System.out.print("No se econtró ningún cliente con ese número ");
        }else{
            menuCliente(cliente);
        }



    }

    @Override
    public void menuCliente(Cliente cliente) {
        int opcion;
        do {
            System.out.println("===== Menú Cliente =====");
            System.out.println("Cliente: " + cliente.getNombre());
            System.out.println("Número único del cliente: " + cliente.getNumeroUnico());
            mostrarSaldoCuentas(cliente);
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
                   //menuPrincipal.iniciar();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione nuevamente.");
                    break;
            }
        } while (opcion != 3);
    }
    private void mostrarSaldoCuentas(Cliente cliente){
        if (cliente.getCuentas() != null) {
            System.out.println("===== Cuentas =====");
            for (Cuenta cuenta : cliente.getCuentas()) {

                System.out.println("NroCuenta: "+ cuenta.getNumeroCuenta()+", Tipo: "+cuenta.getTipo()+", Saldo: "+ cuenta.getSaldo() );
            }
            System.out.println("Saldo total: " + cliente.getSaldoTotal());
        }
    }
}



