package com.informatorio.servicio.menu.operacionesBancarias;

import com.informatorio.domain.Cliente;

public interface MenuOperacionesBancarias {

    void consultarSaldos(Cliente cliente);
    void ingreseDatosDeposito();

}
