package interfaces;

import java.awt.Frame;
import java.util.ArrayList;
import javax.swing.JFrame;
import objetosNegocio.Paciente;

/**
 *
 * @author Ariiel AB
 */
public interface IControl {
    public ArrayList<Paciente> obtenerPaciente(String nss, String Nombre);
    public void setListaPacientes(ArrayList<Paciente> listaPacientes);
    public ArrayList<Paciente> getListaPacientes();
   
}
