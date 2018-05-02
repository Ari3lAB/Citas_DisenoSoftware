/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InferfazUsuario;

import Driver.Ceder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author duzk
 */
public class Prueba2 {
    public static void main(String[] args) throws SQLException {
        
        
        try{
            String nss = "16800151921";
        
        Ceder ceder = new Ceder();
        Connection conexion = ceder.getInstance().getConnection();
        
        
        String consulta = "SELECT * FROM Pacientes";
        PreparedStatement ps = conexion.prepareStatement(consulta);
        
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            System.out.println(rs.getString("nombre"));

        }
        
        
        }catch(Exception e){
            
        }
    }
}
