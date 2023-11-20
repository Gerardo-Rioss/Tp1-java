package com.informatorio.domain;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> clientes;
    private int id;
    private Double tasaInteres;
    private Double limiteSobregiro;
    public Banco(int id) {
        this.clientes= new ArrayList<>();
        this.id= id;

    }

    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    public int getId() {
        return id;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes=clientes;
    }

    public Double getTasaInteres() {
        return tasaInteres;
    }

    public Double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public void setTasaInteres(Double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public void setLimiteSobregiro(Double limiteSobregiro) {
        this.limiteSobregiro = limiteSobregiro;
    }
    public Integer obtenerNuevoNumeroCliente(){
        int ultimoNumeroUnico=1;
        for (Cliente cliente : this.clientes){
            int numeroUnicoCliente = cliente.getNumeroUnico();
            if(numeroUnicoCliente>ultimoNumeroUnico){
                ultimoNumeroUnico=numeroUnicoCliente;
            }
        }
        return ultimoNumeroUnico+1;
    }

    public Cliente getClientByNumeroUnico(Integer numero) {
        for (Cliente cliente : this.clientes) {
            if (numero.equals(cliente.getNumeroUnico())) {
                return cliente;
            }
        }
        return null;
    }
}
