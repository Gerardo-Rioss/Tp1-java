package com.informatorio.domain;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private ArrayList<Cliente> clientes;
    private int NumeroUnicoCliente;

    public Banco() {
        this.clientes= new ArrayList<>();
    }



    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes=clientes;
    }

    public void registrarCliente(Cliente cliente){
        this.clientes.add(cliente);
    }
   



}
