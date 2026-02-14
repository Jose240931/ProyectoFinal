package org.main.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileService {
    //Servicio para generar un archivo a partir de la lista ordenada
    public File crearTxtDesdeLista(List<String> lineas) throws IOException {
        //Se genera el archivo de la lista de la compra
        File file = File.createTempFile("lista_compra_", ".txt");

        //Se usa el filewriter para copiar cada linea del listview al archivo
        try (FileWriter writer = new FileWriter(file)) {
            for (String linea : lineas) {
                writer.write(linea + System.lineSeparator());
            }
        }
        return file;
    }
}
