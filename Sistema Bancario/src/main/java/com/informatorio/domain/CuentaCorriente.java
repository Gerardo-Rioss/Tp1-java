package com.informatorio.domain;

import com.informatorio.enums.TipoCuenta;

public class CuentaCorriente extends Cuenta {
    private Double limiteSobregiro;
    private String tipo;



    public CuentaCorriente(int numeroCuenta, Cliente cliente, Double saldo, Double limiteSobregiro) {
        super(numeroCuenta, cliente, saldo);
        this.limiteSobregiro = limiteSobregiro;
        this.tipo= String.valueOf(TipoCuenta.CuentaCorriente);
    }

    public Double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public void setLimiteSobregiro(Double limiteSobregiro) {
        this.limiteSobregiro = limiteSobregiro;
    }

    @Override
    public Boolean retirar(Double monto) {
        if (monto <= this.getSaldo() + this.getLimiteSobregiro()) {
            this.depositar(-monto);
            return Boolean.TRUE;
        } else {
            System.out.println("No se puede retirar más que el límite de sobregiro");
            return Boolean.FALSE;
        }
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }
}
