package com.informatorio.servicio.menu.operacionesBancarias;

import com.informatorio.domain.Cuenta;
import com.informatorio.domain.Cliente;
import com.informatorio.domain.CuentaAhorro;
import com.informatorio.domain.CuentaCorriente;
import com.informatorio.entrada.InputConsoleService;
import com.informatorio.servicio.cliente.ClienteServicio;
import com.informatorio.servicio.cuenta.CuentaServicio;

import java.util.Optional;

public class MenuOperacionesBancariasImpl implements MenuOperacionesBancarias {
    private  MenuOperacionesBancarias menuOperacionesBancarias;
    private ClienteServicio clienteServicio;
    private CuentaServicio cuentaServicio;

    public MenuOperacionesBancariasImpl(ClienteServicio clienteServicio, CuentaServicio cuentaServicio) {
        this.clienteServicio = clienteServicio;
        this.cuentaServicio = cuentaServicio;
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

    @Override
    public void ingreseDatosDeposito() {
        System.out.println("Ingrese nro de cliente: ");
        int nroCliente = InputConsoleService.getScanner().nextInt();
        Cliente cliente = clienteServicio.getClientePorNumero(nroCliente);
        menuOperacionesBancarias.consultarSaldos(cliente);
        System.out.println("Ingrese nro de cuenta en la cual desea depositar: ");
        int nroCuenta = InputConsoleService.getScanner().nextInt();
        System.out.println("Ingrese el monto a depositar: ");
        Double monto = InputConsoleService.getScanner().nextDouble();
        cuentaServicio.depositar(cliente, monto, nroCuenta);
        menuOperacionesBancarias.consultarSaldos(cliente);
    }


}
