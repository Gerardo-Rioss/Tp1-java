package com.informatorio.servicio.cuenta;

import com.informatorio.domain.Cliente;
import com.informatorio.domain.CuentaAhorro;
import com.informatorio.entrada.InputConsoleService;

public class CuentaServicioImpl implements CuentaServicio {

    @Override
    public void crearCuentaDeAhorro() {
        System.out.print("Ingrese el monto inicial para la cuenta de ahorro: ");
        double montoInicial = InputConsoleService.getScanner().nextDouble();
        InputConsoleService.scanner.nextLine();

        CuentaAhorro cuentaAhorro = new CuentaAhorro()
        CuentaAhorro cuentaAhorro = new CuentaDeAhorro(numeroUnicoCuentaActual++, cliente.getNombre(), montoInicial, 3.0);
        cliente.agregarCuenta(cuentaAhorro);

        System.out.println("Cuenta de ahorro creada exitosamente. Número único de cuenta: " + cuentaAhorro.getNumeroUnico());

    }





}