package com.informatorio.servicio.menu.cliente;

import com.informatorio.domain.Cliente;

public interface MenuCliente {
    void mostrarClientes();
    Cliente seleccionarCliente();
    public int seleccionarTipoCuenta();
    String ingresarNombre();
    String ingresarDireccion();
    public int ingreseNroCuentaDepositar();
    public int ingreseNroCuentaEliminar();
    public Double ingreseMontoDepositar();
    public Double ingreseMontoInicial();
    public Double ingreseMontoRetirar();
    public int ingreseNroCuentaRetirar();
}
