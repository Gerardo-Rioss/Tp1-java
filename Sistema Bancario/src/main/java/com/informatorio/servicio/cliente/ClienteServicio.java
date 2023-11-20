package com.informatorio.servicio.cliente;

import com.informatorio.domain.Cliente;

public interface ClienteServicio {
    void crearCliente(String nombre, String direccion);
    Cliente getClientePorNumero(int numeroCliente);
    void consultaSaldosCuentasTotal(Cliente cliente);

}
