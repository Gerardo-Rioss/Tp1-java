package com.informatorio.basededatos;

import com.informatorio.domain.Cliente;
import com.informatorio.domain.Cuenta;
import com.informatorio.domain.CuentaAhorro;
import com.informatorio.domain.CuentaCorriente;

import java.util.ArrayList;
import java.util.List;
public class BdClientes {
    public static ArrayList<Cliente> clientes = initClients();
        public static ArrayList<Cliente> initClients(){

        Cliente cliente1 = new Cliente(1,"Rios Gerardo","Pasaje Castelli 4460");
        Cliente cliente2 = new Cliente(2,"Rios Raul","Alberdi 1950");
        Cliente cliente3 = new Cliente(3,"Gomez Carlos","Molina 160");

        Cuenta cuenta1 = new CuentaAhorro(1,cliente1,500.0,26.5);
        Cuenta cuenta2 = new CuentaCorriente(2,cliente1,500.0,5000.0);
        cliente1.agregarCuenta(cuenta1);
        cliente1.agregarCuenta(cuenta2);
        Cuenta cuenta3 = new CuentaAhorro(1,cliente2,10000.0,26.5);
        Cuenta cuenta4 = new CuentaCorriente(2,cliente2,600000.0,5000.0);
        cliente2.agregarCuenta(cuenta3);
        cliente2.agregarCuenta(cuenta4);
        Cuenta cuenta5 = new CuentaAhorro(1,cliente3,15000.0,26.5);
        Cuenta cuenta6 = new CuentaCorriente(2,cliente3,6700000.0,5000.0);
        cliente3.agregarCuenta(cuenta5);
        cliente3.agregarCuenta(cuenta6);
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        return clientes;
    }



}
