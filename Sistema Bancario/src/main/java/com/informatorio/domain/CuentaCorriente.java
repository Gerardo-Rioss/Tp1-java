package com.informatorio.domain;

public class CuentaCorriente extends Cuenta {
    private Double limiteSobregiro;
    private static final String tipo= "Cuenta corriente";

    public CuentaCorriente(int numeroCuenta, Cliente cliente, Double saldo,  Double limiteSobregiro) {
        super(numeroCuenta, cliente, saldo);
        this.limiteSobregiro = limiteSobregiro;
    }

    public Double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public void setLimiteSobregiro(Double limiteSobregiro) {
        this.limiteSobregiro = limiteSobregiro;
    }

    @Override
    public void retirar(Double monto) {
        if (monto <= this.getSaldo() + this.getLimiteSobregiro()) {
            this.depositar(-monto);
        } else {
            System.out.println("No se puede retirar más que el límite de sobregiro");
        }
    }

    @Override
    public String getTipo() {
        return tipo;
    }
}
