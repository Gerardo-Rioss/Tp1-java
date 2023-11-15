package com.informatorio.basededatos;

import com.informatorio.domain.Cliente;
import java.util.List;
public class BdClientes {
    public static List<Cliente> clientes = initClients();

    public static List<Cliente> initClients(){

        Cliente cliente1 = new Cliente(1L,"Rios Gerardo","Pasaje Castelli 4460");
        Cliente cliente2 = new Cliente(2L,"Rios Raul","Alberdi 1950");
        Cliente cliente3 = new Cliente(2L,"Gomez Carlos","Molina 160");
        clientes = List.of(cliente1,cliente2, cliente3);

        return clientes;
    }

    public static Cliente getClientById(Long id){
        for (Cliente clients : clientes) {
            if (id.equals(clients.getNumeroUnico())){
                return clients;
            }
        }
        return null;
    }
}
