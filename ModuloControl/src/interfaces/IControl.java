package interfaces;

import ModuloControl.Control;
import java.awt.Frame;
import java.sql.SQLException;
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
    public void obtenerPaciente(String nss, String Nombre) throws SQLException ;
    public void setListaPacientes(ArrayList<Paciente> listaPacientes);
    public ArrayList<Paciente> getListaPacientes() throws SQLException;
    public void muestraReceta(JFrame parent, StringBuffer receta, Paciente paciente);
    public void imprime(Frame frame, StringBuffer respuesta);
    public void setControl(Control control);
    public ArrayList<Consulta> getListaConsultas(Paciente paciente) throws SQLException;
    
}
