package com.informatorio.servicio.cliente;

import com.informatorio.domain.Cliente;

public interface ClienteServicio {
    void crearCliente(String nombre, String direccion);
    void consultaSaldosCuentasTotal(Cliente cliente);

}
