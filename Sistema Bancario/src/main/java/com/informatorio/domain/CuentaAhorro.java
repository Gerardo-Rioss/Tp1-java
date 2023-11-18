package com.informatorio.domain;

import com.informatorio.enums.TipoCuenta;

public class CuentaAhorro extends Cuenta {
    private Double tasaInteres;
    private String tipo;


    public CuentaAhorro() {
    }
    public CuentaAhorro(int numeroCuenta, Cliente cliente, Double saldo, Double tasaInteres) {
        super(numeroCuenta, cliente, saldo);
        this.tasaInteres = tasaInteres;
        this.tipo= String.valueOf(TipoCuenta.CuentaAhorro);
    }

    public Double getTasaInteres() {
        return tasaInteres;
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

    public void setTasaInteres(Double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    @Override
    public Boolean retirar(Double monto) {
        if (monto <= this.getSaldo()) {
           this.depositar(-monto);
        } else {
            System.out.println("No se puede retirar más que el saldo disponible");
        }
        return null;
    }

    public void calcularAgregarInteres(){
        Double intereses = this.getSaldo()* this.getTasaInteres()/100;
        this.depositar(intereses);
    }


}
