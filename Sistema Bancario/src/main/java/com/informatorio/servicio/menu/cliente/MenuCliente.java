package com.informatorio.servicio.menu.cliente;

import com.informatorio.domain.Cliente;

import java.util.Optional;

public interface MenuCliente {
    void mostrarClientes();
    void registrarNuevoCliente();
    Optional <Cliente> seleccionarCliente();
}
