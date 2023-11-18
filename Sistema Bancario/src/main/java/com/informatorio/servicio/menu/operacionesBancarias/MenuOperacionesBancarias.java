package com.informatorio.servicio.menu.operacionesBancarias;

import com.informatorio.domain.Cliente;

public interface MenuOperacionesBancarias {
    void retirar(double monto);
    void depositar(double monto);
    void consultarSaldos(Cliente cliente);
}
