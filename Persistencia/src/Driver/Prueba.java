/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import java.sql.SQLException;
import objetosNegocio.Paciente;

/**
 *
 * @author 1024zettabytesring
 */
public class Prueba {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Ceder ceder = new Ceder();
        ceder.consultasPorPaciente(new Paciente("16800151921"));
    }
    
}
