package com.informatorio.domain;

public class CuentaAhorro extends Cuenta {
    private Double tasa;
    private static final String tipo= "Cuenta de ahorro";

    public CuentaAhorro() {
    }
    public CuentaAhorro(int numeroCuenta, Cliente cliente, Double saldo, String tipo, Double tasa) {
        super(numeroCuenta, cliente, saldo, tipo);
        this.tasa = tasa;
    }

    public Double getTasa() {
        return tasa;
    }

    @Override
    public void retirar(Double monto) {
        if (monto <= this.getSaldo()) {
           this.depositar(-monto);
        } else {
            System.out.println("No se puede retirar más que el saldo disponible");
        }
    }

    public void calcularDepositarInteres(){
        Double interes = this.getSaldo()* this.getTasa();
        this.depositar(interes);
    }

    @Override
    public String getTipo() {
        return tipo;
    }
}
