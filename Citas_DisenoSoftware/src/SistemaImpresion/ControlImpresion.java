package SistemaImpresion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author ArielAB
 */
public class ControlImpresion {

    private String receta;
    private File archivoReceta;
    List<String> listaLineas;

    public ControlImpresion(String receta) {
        this.receta = receta;
        archivoReceta = new File("./TxtRecetas/receta.txt");
        listaLineas = new ArrayList<>(Arrays.asList(receta.split("\n")));

    }

    public void convertToTxt() throws FileNotFoundException, IOException {
        FileUtils.writeLines(archivoReceta, listaLineas);
    }

    public String getReceta() {
        return receta;
    }

}
