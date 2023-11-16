package com.informatorio.domain;

public class CuentaAhorro extends Cuenta {
    private Double tasaInteres;
    private static final String tipo= "Cuenta de ahorro";


    public CuentaAhorro() {
    }
    public CuentaAhorro(int numeroCuenta, Cliente cliente, Double saldo, Double tasa) {
        super(numeroCuenta, cliente, saldo);
        this.tasaInteres = tasa;
    }

    public Double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(Double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    @Override
    public void retirar(Double monto) {
        if (monto <= this.getSaldo()) {
           this.depositar(-monto);
        } else {
            System.out.println("No se puede retirar más que el saldo disponible");
        }
    }

    public void calcularInteres(){
        Double intereses = this.getSaldo()* this.getTasaInteres()/100;
        this.depositar(intereses);
    }

    @Override
    public String getTipo() {
        return tipo;
    }
}
