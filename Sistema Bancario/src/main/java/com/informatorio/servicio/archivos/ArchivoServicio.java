package com.informatorio.servicio.archivos;

import com.informatorio.domain.Cliente;

import java.util.List;

public interface ArchivoServicio {
    void exportarProductosACsv(List<Cliente> clientes, String nombreArchivo);
}
