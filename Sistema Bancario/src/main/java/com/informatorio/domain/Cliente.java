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

    public int getUltimoNumeroCuenta() {
        try {
            int ultimoNumeroCuentaActual = 0;
            for (Cuenta cuenta : this.cuentas) {
                if (ultimoNumeroCuentaActual < cuenta.getNumeroCuenta()) {
                    ultimoNumeroCuentaActual = cuenta.getNumeroCuenta();
                }
            }
            return ultimoNumeroCuentaActual;
        } catch (Exception e) {
            System.out.println("ACA REVIENTA");
        }
        return 0;
    }

    public void mostrarSaldoCuenta() {
        try {
            System.out.println("===== Cuentas =====");
            for (Cuenta cuenta : this.getCuentas()) {
                System.out.println("NroCuenta: " + cuenta.getNumeroCuenta() + ", Tipo: " + cuenta.getTipo() + ", Saldo: " + cuenta.getSaldo());
            }
            System.out.println("Saldo total: " + this.getSaldoTotal());
        } catch (Exception e) {
            System.out.println("No tiene ninguna cuenta asignada.-");
        }


    }
}



