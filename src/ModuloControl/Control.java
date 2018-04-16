/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloControl;

import interfaces.IPersistencia;
import java.util.ArrayList;
import objetosNegocio.Paciente;
import persistencia.PersistenciaFacade;

/**
 *
 * @author Ariiel AB
 */
public class Control {
    
    IPersistencia persistencia;
    
    public Control(){
        persistencia = PersistenciaFacade.getInstance();
    }
   
    public ArrayList<Paciente> obtenerListaCeder(String nss, String nombre){
        Paciente paciente = new Paciente(nss, nombre, null, null);
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Paciente> encontrados = new  ArrayList<>();
        pacientes.add(new Paciente("29384765378", "Jose Lopez","254434736457", "CAlle x"));
        pacientes.add(new Paciente("92837465271", "Pablo Perez","178643443536", "CAlle 7"));
        pacientes.add(new Paciente("mm992jwjw99", "Jose Martinez","1656556456456", "CAlle i"));
        pacientes.add(new Paciente("mmsnhh79297", "Karina Cota","19283736457", "CAlle s"));
        pacientes.add(new Paciente("32300873hh8", "Abel Rosas","128912357", "CAlle sd"));
        if(nss!=null){
        if(pacientes.contains(paciente)){
            encontrados.add(pacientes.get(pacientes.lastIndexOf(paciente)));
        }
        }
        else{
            pacientes.stream().filter((p) -> (p.getNombre().contains(nombre))).forEachOrdered((p) -> {
                encontrados.add(p);
            });
        }
        
     return encontrados;
    }
}
