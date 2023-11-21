package com.informatorio.servicio.cliente;

import com.informatorio.basededatos.BdClientes;
import com.informatorio.domain.*;

import java.util.ArrayList;

import static com.informatorio.basededatos.BdClientes.clientes;

public class ClienteServicioImpl implements ClienteServicio {
    private Banco banco;

    public ClienteServicioImpl(Banco banco) {
        this.banco = banco;
    }

    @Override
    public void crearCliente(String nombre, String direccion) {
        int nuevoNumeroUnico = banco.obtenerNuevoNumeroCliente();
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNumeroUnico(nuevoNumeroUnico);
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setDireccion(direccion);
        nuevoCliente.setCuentas(new ArrayList<Cuenta>());
        banco.getClientes().add(nuevoCliente);
        System.out.println("Cliente registrado exitosamente. Número único asignado: " + nuevoCliente.getNumeroUnico());
        System.out.println("==================================================");

    }



    @Override
    public void consultaSaldosCuentasTotal(Cliente cliente) {
        System.out.println("===== Datos Cliente =====");
        System.out.println("Nro CLiente: "+ cliente.getNumeroUnico()+", Nombre: "+ cliente.getNombre());
        try {
            System.out.println("===== Cuentas =====");
            for (Cuenta cuenta : cliente.getCuentas()) {
                System.out.print("NroCuenta: " + cuenta.getNumeroCuenta() + ", Tipo: " + cuenta.getTipo() + ", Saldo: " + cuenta.getSaldo());
                if (cuenta instanceof CuentaAhorro) {
                    CuentaAhorro cuentaAhorro = (CuentaAhorro) cuenta;
                    System.out.println(", Tasa Interes: " +cuentaAhorro.getTasaInteres());
                }
                if (cuenta instanceof CuentaCorriente) {
                    CuentaCorriente cuentaCorriente = (CuentaCorriente) cuenta;
                    System.out.println(", Limite sobregiro: " +cuentaCorriente.getLimiteSobregiro());
                }
            }
            System.out.println("Saldo total: " + cliente.getSaldoTotal());
        } catch (Exception e) {
            System.out.println("No tiene ninguna cuenta asignada.-");
        }
        System.out.println();
    }
}
