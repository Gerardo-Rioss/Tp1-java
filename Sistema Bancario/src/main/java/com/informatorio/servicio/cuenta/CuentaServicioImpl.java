package com.informatorio.servicio.cuenta;

import com.informatorio.domain.*;
import com.informatorio.enums.TipoCuenta;


public class CuentaServicioImpl implements CuentaServicio {
    private Banco banco;

    public CuentaServicioImpl(Banco banco) {
        this.banco = banco;
    }

    private static final String CUENTA_CREADA_EXITOSA="Cuenta exitosamente. Número único de cuenta: ";
    private static final String CUENTA_ELIMINADA_EXITOSA="Cuenta elimininada exitosamente.- ";
    private static final String OPERACION_EXITOSA="Operacion realizada con éxito!!!.- ";
   @Override
    public int obtenerNuevoNumeroCuenta(Cliente cliente) {
        int nuevoNumeroCuenta = 0;
        try {
            for (Cuenta cuenta : cliente.getCuentas()){
                if (nuevoNumeroCuenta < cuenta.getNumeroCuenta()) {
                    nuevoNumeroCuenta = cuenta.getNumeroCuenta();
                }
            }
            return nuevoNumeroCuenta + 1;
        } catch (NullPointerException e) {
            return 0;
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
    public void depositar(Cliente cliente,int nroCuenta, Double monto ) {
        for (Cuenta cuenta : cliente.getCuentas()){
            if (cuenta.getNumeroCuenta()== nroCuenta){
                cuenta.depositar(monto);
            }
        }
    }

    @Override
    public void retirar(Cliente cliente,int nroCuenta, Double monto ) {
        for (Cuenta cuenta: cliente.getCuentas()){
            if(cuenta.getNumeroCuenta()== nroCuenta) {
                if (cuenta instanceof CuentaCorriente) {
                    CuentaCorriente cuentaCorriente = (CuentaCorriente) cuenta;
                    cuentaCorriente.retirar(monto);
                }
                if (cuenta instanceof CuentaAhorro) {
                    CuentaAhorro cuentaAhorro = (CuentaAhorro) cuenta;
                    cuentaAhorro.retirar(monto);
                }
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
    public void modificarTasaInteresCuentaAhorro(Double nuevoValor) {
        banco.setTasaInteres(nuevoValor);
        for (Cliente cliente : banco.getClientes()) {
            for (Cuenta cuenta : cliente.getCuentas()) {
                if (cuenta instanceof CuentaAhorro) {
                    CuentaAhorro cuentaAhorro = (CuentaAhorro) cuenta;
                    cuentaAhorro.setTasaInteres(nuevoValor);
                }
            }

        }
    }

    @Override
    public void modificarLimiteSobregiro(Double nuevoValor) {
        banco.setLimiteSobregiro(nuevoValor);
        for (Cliente cliente : banco.getClientes()) {
            for (Cuenta cuenta : cliente.getCuentas()) {
                if (cuenta instanceof CuentaCorriente) {
                    CuentaCorriente cuentaCorriente = (CuentaCorriente) cuenta;
                    cuentaCorriente.setLimiteSobregiro(nuevoValor);
                }
            }

        }
    }

    @Override
    public void agregarInteresesCuentasAhorro() {
        for (Cliente cliente : banco.getClientes()) {
            for (Cuenta cuenta : cliente.getCuentas()) {
                if (cuenta instanceof CuentaAhorro) {
                    CuentaAhorro cuentaAhorro = (CuentaAhorro) cuenta;
                    cuentaAhorro.calcularAgregarInteres();
                }
            }

        }
        System.out.println(OPERACION_EXITOSA);
    }
}