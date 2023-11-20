package com.informatorio.servicio.cuenta;

import com.informatorio.domain.Cliente;
import com.informatorio.domain.Cuenta;
import com.informatorio.domain.CuentaAhorro;
import com.informatorio.domain.CuentaCorriente;
import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.cliente.ClienteServicio;
import com.informatorio.servicio.menu.operacionesBancarias.MenuOperacionesBancarias;

public class CuentaServicioImpl implements CuentaServicio {

   @Override
    public int obtenerNuevoNumeroCuenta(Cliente cliente) {
        int nuevoNumeroCuenta = 1;
        try {
            for (Cuenta cuenta : cliente.getCuentas()){
                if (nuevoNumeroCuenta <= cuenta.getNumeroCuenta()) {
                    nuevoNumeroCuenta = cuenta.getNumeroCuenta();
                }
            }
            return nuevoNumeroCuenta;
        } catch (NullPointerException e) {
            return 1;
        }
    }

    @Override
    public void crearCuentaCorriente(Cliente cliente, Double montoInicial) {
        int nuevoNumeroCuenta = obtenerNuevoNumeroCuenta(cliente);
        CuentaCorriente nuevaCuentaCorriente = new CuentaCorriente(nuevoNumeroCuenta,cliente,montoInicial,5000.0);
        cliente.agregarCuenta(nuevaCuentaCorriente);
        System.out.println("Cuenta de ahorro creada exitosamente. Número único de cuenta: " + nuevaCuentaCorriente.getNumeroCuenta());


    }

    @Override
    public void crearCuentaAhorro(Cliente cliente, Double montoInicial) {
        int numeroCuentaNuevo = obtenerNuevoNumeroCuenta(cliente);
        CuentaAhorro cuentaAhorro = new CuentaAhorro(numeroCuentaNuevo, cliente, montoInicial, 6.5);
        cliente.agregarCuenta(cuentaAhorro);
        System.out.println("Cuenta de ahorro creada exitosamente. Número único de cuenta: " + cuentaAhorro.getNumeroCuenta());


    }

    @Override
    public void depositar(Cliente cliente, Double monto, int nroCuenta) {
        for (Cuenta cuenta : cliente.getCuentas()){
            if (cuenta.getNumeroCuenta()== nroCuenta){
                cuenta.depositar(monto);
            }
        }
    }


}

