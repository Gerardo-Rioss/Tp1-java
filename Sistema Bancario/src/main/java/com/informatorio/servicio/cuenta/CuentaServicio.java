package com.informatorio.servicio.cuenta;

import com.informatorio.domain.Cliente;

public interface CuentaServicio {
    void crearCuentaDeAhorro(Cliente cliente);
    void crearCuentaCorriente(Cliente cliente);

}
