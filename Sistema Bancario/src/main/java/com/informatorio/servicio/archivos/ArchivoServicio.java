package com.informatorio.servicio.archivos;

import com.informatorio.domain.Cliente;

import java.util.List;

public interface ArchivoServicio {
    void exportarClientesACsv(List<Cliente> clientes, String nombreArchivo);
}
