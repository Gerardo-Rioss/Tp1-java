package com.informatorio.servicio.archivos;

import com.informatorio.domain.Cliente;
import com.informatorio.domain.Cuenta;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArchivoServicioImpl implements ArchivoServicio {
    private final String UBICACION_ARCHIVO = "/Sistema Bancario/src/main/java/com/informatorio/recursos/";
    //C:\Users\Gera\OneDrive\Escritorio\Tp1-java\Sistema Bancario\src\main\java\com\informatorio\recursos

    @Override
    public void exportarClientesACsv(List<Cliente> clientes, String nombreArchivo) {
        System.out.println(System.getProperty("user.dir"));
        String ruta = System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat(nombreArchivo);
        try(CSVWriter writer = new CSVWriter(new FileWriter(ruta))){
            //Escribir encabezado
            String[] encabezados = {"NroUnico","Nombre", "Saldo","Tipo"};
            writer.writeNext(encabezados);

            //Escribir datos de productos
            for (Cliente cliente: clientes) {

                    String[] datosCliente = {
                            String.valueOf(cliente.getNumeroUnico()),
                            cliente.getNombre(),
                    };
                    writer.writeNext(datosCliente);

                    for (Cuenta cuenta: cliente.getCuentas()){
                        String[] datosCuenta ={
                                String.valueOf(cuenta.getSaldo()),
                                cuenta.getTipo(),
                        };
                        writer.writeNext(datosCuenta);
                    }

            }

            //Cerrar escritor
            writer.close();
            System.out.println("Exportacion a CSV exitosa");
        } catch (IOException e ) {
            System.out.println("Algo salio mal motivo : " +
                    e.getMessage().concat(" Ubicacion indicada : " + ruta)
            );
        }

    }
}
