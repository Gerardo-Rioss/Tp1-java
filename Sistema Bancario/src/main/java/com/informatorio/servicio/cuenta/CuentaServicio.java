package com.informatorio.servicio.cuenta;

import com.informatorio.domain.Cliente;

public interface CuentaServicio {


    int obtenerNuevoNumeroCuenta(Cliente cliente);

    void crearCuentaCorriente(Cliente cliente, Double montoInicial);

    void crearCuentaAhorro(Cliente cliente, Double montoInicial);
    void depositar(Cliente cliente, Double monto, int nroCuenta);
    void eliminarCuenta(Cliente cliente, int numeroCuenta);

    void modificarTasaInteresCuentaAhorro(Double nuevoValor);

    void modificarLimiteSobregiro(Double nuevoValor);
    void agregarInteresesCuentasAhorro();


}