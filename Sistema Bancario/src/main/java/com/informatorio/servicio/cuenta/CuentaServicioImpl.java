package com.informatorio.servicio.cuenta;

import com.informatorio.domain.Cliente;
import com.informatorio.domain.CuentaAhorro;
import com.informatorio.domain.CuentaCorriente;
import com.informatorio.entrada.InputConsoleService;

public class CuentaServicioImpl implements CuentaServicio {


    @Override
    public void crearCuentaDeAhorro(Cliente cliente) {

        System.out.print("Ingrese el monto inicial para la cuenta de ahorro: ");
        double montoInicial = InputConsoleService.getScanner().nextDouble();
        InputConsoleService.scanner.nextLine();
        int numeroCuentaNuevo = cliente.getUltimoNumeroCuenta() + 1;
        CuentaAhorro cuentaAhorro = new CuentaAhorro(numeroCuentaNuevo, cliente, montoInicial, 6.5);
        cliente.agregarCuenta(cuentaAhorro);
        System.out.println("Cuenta de ahorro creada exitosamente. Número único de cuenta: " + cuentaAhorro.getNumeroCuenta());

    }

    @Override
    public void crearCuentaCorriente(Cliente cliente) {
        System.out.print("Ingrese el monto inicial para la cuenta corriente: ");
        double montoInicial = InputConsoleService.getScanner().nextDouble();
        InputConsoleService.scanner.nextLine();
        int numeroCuentaNuevo = cliente.getUltimoNumeroCuenta() + 1;
        CuentaCorriente cuentaCorriente = new CuentaCorriente(numeroCuentaNuevo,cliente,montoInicial,-1000.0);
        cliente.agregarCuenta(cuentaCorriente);

        System.out.println("Cuenta corriente creada exitosamente. Número único de cuenta: " + cuentaCorriente.getNumeroCuenta());
    }

}

