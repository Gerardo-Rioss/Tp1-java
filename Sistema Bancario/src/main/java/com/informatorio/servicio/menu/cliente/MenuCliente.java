package com.informatorio.servicio.menu.cliente;

import com.informatorio.domain.Cliente;

public interface MenuCliente {
    void mostrarClientes();
    void ingresarNuevoCliente();

    Cliente seleccionarCliente();

}
