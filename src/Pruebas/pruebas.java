/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import SistemaImpresion.ControlImpresion;
import java.io.IOException;

/**
 *
 * @author Ariiel AB
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControlImpresion control = new ControlImpresion("Hola\n nuevo \nadios\njoto");
        try {
            control.convertToTxt();
        } catch (IOException e) {

        }
    }
}
