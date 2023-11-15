package com.informatorio.basededatos;

import com.informatorio.domain.Cliente;
import java.util.List;
public class BdClientes {
    public static List<Cliente> clientes = initClients();

    public static List<Cliente> initClients(){

        Cliente cliente1 = new Cliente(1,"Rios Gerardo","Pasaje Castelli 4460");
        Cliente cliente2 = new Cliente(2,"Rios Raul","Alberdi 1950");
        Cliente cliente3 = new Cliente(3,"Gomez Carlos","Molina 160");
        clientes = List.of(cliente1,cliente2, cliente3);

        return clientes;
    }

    public static Cliente getClientByNumeroUnico(Integer numero){
        for (Cliente cliente : clientes) {
            if (numero.equals(cliente.getNumeroUnico())){
                return cliente;
            }
        }
        return null;
    }
    public static Integer obtenerUltimoNumeroCliente(){
        int ultimoNumeroUnico=1;
        for (Cliente cliente : clientes){
            int numeroUnicoCliente = cliente.getNumeroUnico();
            if(numeroUnicoCliente>ultimoNumeroUnico){
                ultimoNumeroUnico=numeroUnicoCliente;
            }
        }
        return ultimoNumeroUnico;
    }
}
