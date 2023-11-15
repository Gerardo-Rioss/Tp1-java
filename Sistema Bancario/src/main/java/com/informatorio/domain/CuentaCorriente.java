package com.informatorio.domain;

public class CuentaCorriente extends Cuenta {
    private Double limite;
    private static final String tipo= "Cuenta corriente";

    public CuentaCorriente() {
    }

    public CuentaCorriente(Long numeroCuenta, Cliente cliente, Double saldo, String tipo, Double limite) {
        super(numeroCuenta, cliente, saldo, tipo);
        this.limite = limite;
    }

    public Double getLimite() {
        return limite;
    }

    @Override
    public void retirar(Double monto) {
        if (monto <= this.getSaldo() + this.getLimite()) {
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
