/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import objetosNegocio.Paciente;

/**
 *
 * @author duzk
 */
public class Ceder {
    private static Connection conexion;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "rob";
    private static final String password = "rob123";
    private static final String url = "jdbc:mysql://guerrerorob.ddns.net:3306/CEDER";
    
    public Ceder(){
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
    
    public ArrayList<Paciente> obtenerPaciente() throws SQLException{
        String consulta = "SELECT* FROM Pacientes";
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ps = conexion.prepareStatement(consulta);
        rs = ps.executeQuery();
        
        ArrayList<Paciente> pacientes = new ArrayList<>();
        
        while(rs.next()){
            pacientes.add(new Paciente(rs.getString("nss"),rs.getString("nombre"),rs.getString("telefono"),rs.getString("direccion")));
        }
        
        
        return pacientes;
        
    }
    
    public int obtenerUltimaReceta() throws SQLException{
        String consulta = "SELECT folioReceta = MAX(folioReceta)\n" +
                            "FROM Receta\n" +
                            "GROUP BY folioReceta";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ps = conexion.prepareStatement(consulta);
        rs = ps.executeQuery();
        
        System.out.println(rs.getString("folioReceta"));
        
        return Integer.parseInt(rs.getString("folioReceta"));
        
    }
    
    
}