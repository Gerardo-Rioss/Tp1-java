package com.informatorio.servicio.menu.cuenta;

import com.informatorio.domain.Banco;
import com.informatorio.entrada.InputConsoleService;

public class MenuCuentaImpl implements MenuCuenta {
    private Banco banco;

    public MenuCuentaImpl(Banco banco) {
        this.banco = banco;
    }

    private static final String TASA_INTERES_ACTUAL_TEMPLATE= "La tasa de interes actual es: ";
    private static final String LIMITE_SOBREGIRO_ACTUAL_TEMPLATE="El limite de sobregiro actual es: ";
    private static final String INGRESE_TASA_INTERES_NUEVO_EMPLATE="Ingrese el nuevo valor de la tasa de interes: ";
    private static final String INGRESE_NUEVO_LIMITE_SOBREGIRO_EMPLATE="Ingrese el valor del nuevo limite de sobregiro: ";
    @Override
    public void mostrarTasaInteresActual() {
        System.out.println(TASA_INTERES_ACTUAL_TEMPLATE+ banco.getTasaInteres());
    }

    @Override
    public void mostrarLimiteSobregiroActual() {
        System.out.println(LIMITE_SOBREGIRO_ACTUAL_TEMPLATE+ banco.getLimiteSobregiro());
    }

    @Override
    public double ingreseNuevaTasaInteres() {
        System.out.println(INGRESE_TASA_INTERES_NUEVO_EMPLATE);
        return InputConsoleService.getScanner().nextDouble();
    }

    @Override
    public double ingreseNuevoLimiteSobreGiro() {
        System.out.println(INGRESE_NUEVO_LIMITE_SOBREGIRO_EMPLATE);
        return InputConsoleService.getScanner().nextDouble();
    }
}
