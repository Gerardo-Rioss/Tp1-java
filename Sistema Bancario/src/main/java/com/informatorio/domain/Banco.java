package com.informatorio.domain;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> clientes;

    public Banco() {
        this.clientes=new ArrayList<Cliente>();
    }



    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(Cliente cliente) {
        this.clientes.add(cliente);

    }
    public void abrirCuenta(Cliente cliente, Cuenta cuenta) {
        cliente.agregarCuenta(cuenta);
    }

}
