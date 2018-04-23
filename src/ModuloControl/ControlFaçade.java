/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloControl;


import InferfazUsuario.DlgSeleccionPaciente;

import excepciones.PersistenciaException;

import interfaces.IControl;
import java.awt.Dialog;
import java.awt.Frame;
import java.util.ArrayList;
import javafx.scene.Parent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import objetosNegocio.Consulta;
import objetosNegocio.Paciente;
import objetosNegocio.Servicio;

/**
 *
 * @author Ariel AB
 */
public class ControlFaçade implements IControl {

    private static ControlFaçade INSTANCE = null;
    public Control control;
    private ArrayList<Paciente> listaPacientes;
    
    private ControlFaçade(){
        this.control= new Control();
    }
     public static ControlFaçade getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
  
    private static void createInstance() {
        if (INSTANCE == null) {
            // Sólo se accede a la zona sincronizada
            // cuando la instancia no está creada
                if (INSTANCE == null) { 
                    INSTANCE = new ControlFaçade();
                }
            }
        }
     @Override
    public void obtenerPaciente(String nss, String nombre) {
        
        listaPacientes = new ArrayList<>(control.obtenerListaCeder(nss, nombre));
        
    
       
            
    
    }
    @Override
    public void muestraReceta(JFrame parent, StringBuffer respuesta, Paciente paciente){
        ArrayList<Servicio> listaSerVicios = control.obtenerServiciosCeder();
        
        control.desplegarReceta(parent, respuesta, paciente, listaSerVicios);
        
        
        
        
    }

    @Override
    public ArrayList<Paciente> getListaPacientes() {
        return new ArrayList<>(listaPacientes);
    }

    @Override
    public void setListaPacientes(ArrayList<Paciente> listaPacientes) {
        this.listaPacientes = new ArrayList<>(listaPacientes);
    }
    @Override
    public void imprime(Frame frame, StringBuffer respuesta){
        control.imprimirReceta(frame,respuesta);
        System.out.println(control.getConsulta().getReceta());
        if(respuesta.toString().equals("Aceptar")){
            System.out.println("Ordenes");
        control.imprimirOrdenes(frame);
        }
    }

    public void setControl(Control control) {
        this.control = control;
    }
   
    
}
