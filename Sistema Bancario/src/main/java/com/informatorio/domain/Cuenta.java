package com.informatorio.domain;

public abstract class Cuenta {
    private int numeroCuenta;
    private Cliente cliente;
    private Double saldo;

    public Cuenta() {
    }

    public Cuenta(int numeroCuenta, Cliente cliente, Double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.cliente = cliente;
        this.saldo = saldo;
         }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void depositar(Double monto){
        this.saldo += monto;
    }
    public abstract void retirar(Double monto);



    public abstract String getTipo();
}
