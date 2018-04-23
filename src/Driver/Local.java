/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import objetosNegocio.Consulta;

/**
 *
 * @author duzk
 */
public class Local {
    private static Connection conexion;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "rob";
    private static final String password = "rob123";
    private static final String url = "jdbc:mysql://guerrerorob.ddns.net:3306/LOCAL";
    
    
    public Local(){
        conexion = null;
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, password);
            if(conexion != null){
                System.out.println("Conexion establecida");
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar");
        }
    }
    
     public Connection getConnection(){
        return conexion;
    }

    public void desconectar(){
        conexion = null;
        if(conexion == null) System.out.println("bye plebes");
    } 
    
    public void insertarReceta(Consulta consulta) throws SQLException{
        
        String ano = String.valueOf(consulta.getReceta().getFecha().get(Calendar.YEAR));
        String mes = "";
        String dia = "";
        String diagnostico = consulta.getReceta().getDianostico();
        String tratamiento = consulta.getReceta().getTratamiento();
        
        
        if(consulta.getReceta().getFecha().get(Calendar.MONTH) < 10){
            mes = "0"+String.valueOf(consulta.getReceta().getFecha().get(Calendar.MONTH));
        }else{
            mes = String.valueOf(consulta.getReceta().getFecha().get(Calendar.MONTH));
        }
        
        if(consulta.getReceta().getFecha().get(Calendar.DAY_OF_MONTH) < 10){
            dia = "0"+String.valueOf(consulta.getReceta().getFecha().get(Calendar.DAY_OF_MONTH));
        }else{
            dia = String.valueOf(consulta.getReceta().getFecha().get(Calendar.DAY_OF_MONTH));
        }
        
        String fecha = ano+mes+dia;
        PreparedStatement query = conexion.prepareStatement("INSERT INTO Receta(diagnostico,tratamiento,fechaReceta)  VALUES("+diagnostico+","+tratamiento+","+fecha+")");
        
        query.executeUpdate();
        
       
        
        
    }
    
    
}
