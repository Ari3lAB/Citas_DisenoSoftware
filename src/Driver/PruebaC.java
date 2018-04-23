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
 * @author duzk
 */
public class PruebaC {

    public static void main(String[] args) throws SQLException {
        Ceder bd = new Ceder();
        bd.obtenerPaciente();
        
        for (Paciente paciente : bd.obtenerPaciente()) {
            System.out.println(paciente.getNombre());
            System.out.println(paciente.getDireccion());
            System.out.println(paciente.getNss());
            System.out.println(paciente.getTelefono());
            System.out.println("------------------------------");
           
        }
        
        System.out.println(bd.obtenerUltimaReceta());
        
    }
}
