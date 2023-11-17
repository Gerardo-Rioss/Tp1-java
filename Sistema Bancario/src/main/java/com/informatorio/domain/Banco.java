package com.informatorio.domain;

import java.util.ArrayList;

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

    public Cliente getClienteByNumero(int numeroUnicoCliente){
        for(Cliente cliente : this.clientes){
            if (cliente.getNumeroUnico() == numeroUnicoCliente){
                return cliente;
            }
        }
        return null;
    }
    public int getUltimoNumeroCliente(){
        int ultimoNumeroClienteActual=0;
        for (Cliente cliente : this.clientes){
            if (ultimoNumeroClienteActual<cliente.getNumeroUnico()){
                ultimoNumeroClienteActual= cliente.getNumeroUnico();
            }
        }
        return ultimoNumeroClienteActual;
    }

    public void mostrarClientes(){
        StringBuilder listaClientes = new StringBuilder();
        for (Cliente cliente : this.clientes) {
            listaClientes.append(String.format("Numero:[%d] %s: %s,\n", cliente.getNumeroUnico(), cliente.getNombre(), cliente.getDireccion()));

        }
        System.out.println(listaClientes);

    }

}
