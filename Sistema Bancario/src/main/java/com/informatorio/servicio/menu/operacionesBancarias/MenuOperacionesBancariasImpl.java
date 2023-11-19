package com.informatorio.servicio.menu.operacionesBancarias;

import com.informatorio.domain.Cuenta;
import com.informatorio.domain.Cliente;
public class MenuOperacionesBancariasImpl implements MenuOperacionesBancarias {
    @Override
    public void retirar(double monto) {

    }

    @Override
    public void depositar(double monto) {

    }

    @Override
    public void consultarSaldos(Cliente cliente) {
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
