package com.informatorio.servicio.cliente;

import com.informatorio.basededatos.BdClientes;
import com.informatorio.domain.Banco;
import com.informatorio.domain.Cliente;
import com.informatorio.domain.Cuenta;

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
    public Cliente getClientePorNumero(int numeroCliente) {
        Cliente cliente= banco.getClientByNumeroUnico(numeroCliente);
        return cliente;
    }

    @Override
    public void consultaSaldosCuentasTotal(Cliente cliente) {
        System.out.println("===== Datos Cliente =====");
        System.out.println("Nro CLiente: "+ cliente.getNumeroUnico()+", Nombre: "+ cliente.getNombre());
        try {
            System.out.println("===== Cuentas =====");
            for (Cuenta cuenta : cliente.getCuentas()) {
                System.out.println("NroCuenta: " + cuenta.getNumeroCuenta() + ", Tipo: " + cuenta.getTipo() + ", Saldo: " + cuenta.getSaldo());
            }
            System.out.println("Saldo total: " + cliente.getSaldoTotal());
        } catch (Exception e) {
            System.out.println("No tiene ninguna cuenta asignada.-");
        }
        System.out.println();
    }
}
