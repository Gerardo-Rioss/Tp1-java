package com.informatorio.domain;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> clientes;
    private int id;

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








}
