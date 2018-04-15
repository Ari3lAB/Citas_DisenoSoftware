package ObjetosNegocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author ArielAB
 */
public class Receta {

    protected String Diagnostico;
    protected ArrayList medicamentos;
    protected Date fecha;
    //protected Medico doc;
    protected Paciente paciente;
    protected int folioReceta = 1;

    public Receta(String descripcion, Date fecha, Paciente paciente) {
        this.Diagnostico = descripcion;
        this.fecha = fecha;
        this.paciente = paciente;
        folioReceta++;
    }

    public Receta(Date fecha, Paciente paciente) {
        this.fecha = fecha;
        this.paciente = paciente;
        medicamentos = new ArrayList<>();
        folioReceta++;
    }

    public void agregarMedicamento(String medicamento) {
        medicamentos.add(medicamento);
    }

    public void agregarMedicamento(String[] medicamentos) {
        this.medicamentos.addAll(Arrays.asList(medicamentos));
    }

    public String getDescripcion() {
        return Diagnostico;
    }

    public ArrayList getMedicamentos() {
        return medicamentos;
    }

    public Date getFecha() {
        return fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public int getFolio() {
        return folioReceta;
    }

    public void setDescripcion(String descripcion) {
        this.Diagnostico = descripcion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {

        return "Folio=" + folioReceta + "\nFecha=" + fecha + "\nPaciente=" + paciente + "Diagnostico: " + Diagnostico + "\nMedicamentos: " + medicamentos.toString();
    }

}
