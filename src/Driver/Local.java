/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import objetosNegocio.Consulta;
import objetosNegocio.Orden;
import objetosNegocio.Receta;

/**
 *
 * @author duzk
 */
public class Local {
      private static Local INSTANCE = null;
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
    public static Local getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
  
    private static void createInstance() {
        if (INSTANCE == null) {
            // Sólo se accede a la zona sincronizada
            // cuando la instancia no está creada
                if (INSTANCE == null) { 
                    INSTANCE = new Local();
                }
            }
        }
     public Connection getConnection(){
        return conexion;
    }

    public void desconectar(){
        conexion = null;
        if(conexion == null) System.out.println("bye plebes");
    } 
    
    public void insertarReceta(Receta receta) {
        
        String ano = String.valueOf(receta.getFecha().get(Calendar.YEAR));
        String mes = "";
        String dia = "";
        String diagnostico = receta.getDianostico();
        String tratamiento = receta.getTratamiento();
        
        try{
        if(receta.getFecha().get(Calendar.MONTH) < 10){
            mes = "0"+String.valueOf(receta.getFecha().get(Calendar.MONTH));
        }else{
            mes = String.valueOf(receta.getFecha().get(Calendar.MONTH));
        }
        
        if(receta.getFecha().get(Calendar.DAY_OF_MONTH) < 10){
            dia = "0"+String.valueOf(receta.getFecha().get(Calendar.DAY_OF_MONTH));
        }else{
            dia = String.valueOf(receta.getFecha().get(Calendar.DAY_OF_MONTH));
        }
        
        String fecha = ano+"-"+mes+"-"+dia;
        PreparedStatement query = conexion.prepareStatement("INSERT INTO Receta(diagnostico,tratamiento,fechaReceta)  VALUES('"+diagnostico+"','"+tratamiento+"','"+fecha+"')");
        
        query.executeUpdate();
    }catch(SQLException e){
            System.out.println(e.getMessage());
            } 
       
        
        
    }
    public void insertaOrden(Consulta consulta) {
        
        
        
        
        for (Orden ordene : consulta.getListaOrdenes()) {
            
            String anosS = String.valueOf(ordene.getFechaSolicitud().get(Calendar.YEAR));
            String mesS = "";
            String diasS = "";
            
            String ano2 = String.valueOf(ordene.getFechaServicio().get(Calendar.YEAR));
            String mes2 = "";
            String dias2 = "";
            
            if(ordene.getFechaSolicitud().get(Calendar.MONTH) < 10){
            mesS = "0"+String.valueOf(ordene.getFechaSolicitud().get(Calendar.MONTH)+1);
            }else{
            mesS = String.valueOf(ordene.getFechaSolicitud().get(Calendar.MONTH)+1);
            }
        
            if(ordene.getFechaSolicitud().get(Calendar.DAY_OF_MONTH) < 10){
            diasS = "0"+String.valueOf(ordene.getFechaSolicitud().get(Calendar.DAY_OF_MONTH));
            }else{
            diasS = String.valueOf(ordene.getFechaSolicitud().get(Calendar.DAY_OF_MONTH));
            }
            
            ///////////////////////////////////////////////////////////////////////////
            
            if(ordene.getFechaServicio().get(Calendar.MONTH) < 10){
            mes2 = "0"+String.valueOf(ordene.getFechaServicio().get(Calendar.MONTH)+1);
            }else{
            mes2 = String.valueOf(ordene.getFechaServicio().get(Calendar.MONTH)+1);
            }
        
            if(ordene.getFechaServicio().get(Calendar.DAY_OF_MONTH) < 10){
            dias2 = "0"+String.valueOf(ordene.getFechaServicio().get(Calendar.DAY_OF_MONTH));
            }else{
            dias2 = String.valueOf(ordene.getFechaServicio().get(Calendar.DAY_OF_MONTH));
            }
            
            
            String codigoProveedor = ordene.getCodigoProovedor();
            String fechaSolicitud = anosS+"-"+mesS+"-"+diasS;
            //Numero de Solicitud se autogenera
            String idServicio = ordene.getServicio();
            String fechaServicio = ano2+"-"+mes2+"-"+dias2;
            String indicaciones = ordene.getIndicaciones();
            String nssPaciente = ordene.getNSSPaciente();
            String numConsulta = String.valueOf(consulta.getNumeroConsulta());
            String numeroOrden = ordene.getNumeroOrden();
            int folioReceta = consulta.getReceta().getFolio();
            try{
            PreparedStatement query = conexion.prepareStatement("INSERT INTO Orden (idProveedor,fechaSolicitud,idServicio,fechaServicio,indicaciones,nssPaciente,folioReceta,numeroOrden)"
                                                                    + " VALUES('"+codigoProveedor+"','"+fechaSolicitud+"','"+idServicio+"','"+fechaServicio+"','"+indicaciones+"','"+nssPaciente+"',"+folioReceta+",'"+numeroOrden+"')");
        
            query.executeUpdate();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
            
            
        }
    public void insertarConsulta(Consulta consulta){
        String nssPaciente = consulta.getPaciente().getNss();
        int folioReceta = consulta.getReceta().getFolio();
        try{
        PreparedStatement query = conexion.prepareStatement("INSERT INTO Consulta (nssPaciente,folioReceta)"
                                                                    + "VALUES('"+nssPaciente+"',"+folioReceta+")");
        
        query.executeUpdate();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
