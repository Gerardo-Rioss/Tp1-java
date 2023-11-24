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
        this.cuentas = new ArrayList<>();
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

    public void setNumeroUnico(Integer numeroUnico) {
        this.numeroUnico = numeroUnico;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void agregarCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
    }

    public void eliminarCuenta(Cuenta cuenta) {
        this.cuentas.remove(cuenta);
    }

    public double getSaldoTotal() {
        double saldoTotal = 0;

        for (Cuenta cuenta : this.cuentas) {
            saldoTotal += cuenta.getSaldo();
        }
        return saldoTotal;
    }




}



