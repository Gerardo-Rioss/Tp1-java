package com.informatorio.servicio.cuenta;

import com.informatorio.domain.*;


public class CuentaServicioImpl implements CuentaServicio {
    private Banco banco;

    public CuentaServicioImpl(Banco banco) {
        this.banco = banco;
    }

    private static final String CUENTA_CREADA_EXITOSA="Cuenta exitosamente. Número único de cuenta: ";
private static final String CUENTA_ELIMINADA_EXITOSA="Cuenta elimininada exitosamente.- ";
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
        CuentaCorriente nuevaCuentaCorriente = new CuentaCorriente(nuevoNumeroCuenta,cliente,montoInicial, banco.getLimiteSobregiro());
        cliente.agregarCuenta(nuevaCuentaCorriente);
        System.out.println(CUENTA_CREADA_EXITOSA + nuevaCuentaCorriente.getNumeroCuenta());
    }

    @Override
    public void crearCuentaAhorro(Cliente cliente, Double montoInicial) {
        int numeroCuentaNuevo = obtenerNuevoNumeroCuenta(cliente);
        CuentaAhorro cuentaAhorro = new CuentaAhorro(numeroCuentaNuevo, cliente, montoInicial, banco.getTasaInteres());
        cliente.agregarCuenta(cuentaAhorro);
        System.out.println(CUENTA_CREADA_EXITOSA + cuentaAhorro.getNumeroCuenta());
    }

    @Override
    public void depositar(Cliente cliente, Double monto, int nroCuenta) {
        for (Cuenta cuenta : cliente.getCuentas()){
            if (cuenta.getNumeroCuenta()== nroCuenta){
                cuenta.depositar(monto);
            }
        }
    }

    @Override
    public void eliminarCuenta(Cliente cliente, int numeroCuenta) {
        for (Cuenta cuenta : cliente.getCuentas()){
            if (cuenta.getNumeroCuenta()== numeroCuenta){
                cliente.eliminarCuenta(cuenta);
                System.out.println(CUENTA_ELIMINADA_EXITOSA);
                break;
            }
        }
    }


    @Override
    public void modificarTasaInteres(Double nuevoValor) {
        banco.setTasaInteres(nuevoValor);
    }
    @Override
    public void modificarLimiteSobregiro(Double nuevoValor) {
        banco.setLimiteSobregiro(nuevoValor);
    }
}

