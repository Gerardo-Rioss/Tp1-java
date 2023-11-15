package com.informatorio.domain;

import java.util.ArrayList;

public class Cliente {
    private Long numeroUnico;
    private String nombre;
    private String direccion;
    private ArrayList<Cuenta> cuentas;

    public Cliente() {
    }

    public Cliente(Long numeroUnico, String nombre, String direccion, ArrayList<Cuenta> cuentas) {
        this.numeroUnico = numeroUnico;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuentas = new ArrayList<Cuenta>();
    }

    public Long getNumeroUnico() {
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
    public double consultaSaldoTotal(){
        double saldoTotal=0;
        for (Cuenta cuenta : this.cuentas){
            saldoTotal+=cuenta.getSaldo();
        }
        return saldoTotal;
    }
}

