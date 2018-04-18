package interfaces;

import java.awt.Frame;
import java.util.ArrayList;
import javafx.scene.Parent;
import javax.swing.JFrame;
import objetosNegocio.Consulta;
import objetosNegocio.Paciente;

/**
 *
 * @author Ariiel AB
 */
public interface IControl {
    public void obtenerPaciente(String nss, String Nombre);
    public void setListaPacientes(ArrayList<Paciente> listaPacientes);
    public ArrayList<Paciente> getListaPacientes();
    public void muestraReceta(JFrame parent, StringBuffer receta, Paciente paciente);
    public void imprime();
   
}
