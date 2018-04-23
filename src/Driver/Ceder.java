/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;
import java.sql.*;
/**
 *
 * @author duzk
 */
public class Ceder {
    private static Connection conexion;
    private static final String driver = "ceder.mysql.jdbc.Driver";
    private static final String user = "rob";
    private static final String pswd = "rob123";
    private static final String url  = "jbdc:mysql://guerrerorob.ddns.net:3306";

    
    public Ceder(){
        conexion = null;
        
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(url,user,pswd);
            if(conexion != null){
                System.out.println("Conexion establecida.");
            }
        }catch(Exception e){
            System.out.println("No se hizo la machaca");
        }
        
        
    }
    
    public Connection getConexion(){
       return conexion;
    }
    
    public void desconectar(){
        conexion = null;
        if(conexion == null) System.out.println("Desconexion exitosa");
    }
    
}
