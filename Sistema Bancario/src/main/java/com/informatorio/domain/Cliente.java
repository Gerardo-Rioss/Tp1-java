package com.informatorio.domain;

import java.util.ArrayList;

public class Cliente {
    private Integer numeroUnico;
    private String nombre;
    private String direccion;
    private ArrayList<Cuenta> cuentas;

    public Cliente() {
    }

    public Cliente(Integer numeroUnico, String nombre, String direccion) {
        this.numeroUnico = numeroUnico;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuentas = new ArrayList<Cuenta>();
    }

    public Integer getNumeroUnico() {
        return numeroUnico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }
    public void agregarCuenta(Cuenta cuenta){
        this.cuentas.add(cuenta);
    }

    public void eliminarCuenta(Cuenta cuenta){
        this.cuentas.remove(cuenta);
    }
    public double getSaldoTotal(){
        double saldoTotal=0;
        for (Cuenta cuenta : this.cuentas){
            saldoTotal+=cuenta.getSaldo();
        }
        return saldoTotal;
    }
    public int getUltimoNumeroCuenta(){
        int ultimoNumeroCuentaActual=0;
        for (Cuenta cuenta : this.cuentas){
            if (ultimoNumeroCuentaActual<cuenta.getNumeroCuenta()){
                ultimoNumeroCuentaActual= cuenta.getNumeroCuenta();
            }
        }
        return ultimoNumeroCuentaActual;
    }
}

