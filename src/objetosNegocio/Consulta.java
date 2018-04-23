package objetosNegocio;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Ariel AB
 */
public class Consulta {

    private static int contadorConsultas = 0;
    private int numeroConsulta;
    private Paciente paciente;
    private Receta receta;
    private ArrayList<Orden> listaOrdenes;
    private ArrayList<Servicio> listaServicios;

    public Consulta() {
        contadorConsultas++;
        this.numeroConsulta = contadorConsultas;
    }

    public Consulta(int numeroConsulta, Paciente paciente, Receta receta, ArrayList<Orden> listaOrdenes,
            ArrayList<Servicio> listaServicios) {
        this.numeroConsulta = numeroConsulta;
        this.paciente = new Paciente(paciente);
        this.listaOrdenes = new ArrayList<>(listaOrdenes);
        this.listaServicios = new ArrayList<>(listaServicios);
    }

    public Consulta(Consulta consulta) {
        this.numeroConsulta = consulta.getNumeroConsulta();
        this.paciente = new Paciente(consulta.getPaciente());
        this.listaOrdenes = new ArrayList<>(consulta.getListaOrdenes());
        this.listaServicios = new ArrayList<>(consulta.getListaServicios());
    }

    public String formatReceta() {
        StringBuilder servicios = new StringBuilder();
        for (Orden orden : listaOrdenes) {
            servicios.append(orden.getServicio()).append("\n");

        }
        String formateada = "Folio: " + receta.getFolio() + "\t\tFecha: " + receta.getFecha() + "\n"
                + "Paciente: " + paciente.getNombre() + "\t" + "NSS: " + paciente.getNss() + "\n"
                + "Direccion: " + paciente.getDireccion() + "Telefono: " + paciente.getTelefono() + "\n"
                + "Diagnóstico:\n" + receta.getDianostico() + "\n\n"
                + "Tratamiento:\n" + receta.getTratamiento() + "\n\n"
                + "Servicios:\n:" + servicios.toString();
        return formateada;
    }

    
    public int getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setNumeroConsulta(int numeroConsulta) {
        contadorConsultas = numeroConsulta;
        this.numeroConsulta = numeroConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public ArrayList<Orden> getListaOrdenes() {
        return new ArrayList<>(this.listaOrdenes);
    }

    public void setListaOrdenes(ArrayList<Orden> listaOrdenes) {

        this.listaOrdenes = new ArrayList<>(listaOrdenes);
    }

    public boolean agregarOrden(Orden orden) {
        return listaOrdenes.add(orden);
    }

    public boolean agregaListaOrdenes(ArrayList<Orden> listaOrdenes) {

        return this.listaOrdenes.addAll(listaOrdenes);
    }

    public ArrayList<Servicio> getListaServicios() {
        return new ArrayList<>(this.listaServicios);
    }

    public void setListaServicios(ArrayList<Servicio> listaServicios) {
        this.listaServicios = null;
        this.listaServicios = new ArrayList<>(listaServicios);
    }

    public boolean agregarServicio(Servicio servicio) {
        return listaServicios.add(servicio);
    }

    public void agregaListaServicios(ArrayList<Servicio> listaServicios) {

        this.listaServicios.addAll(listaServicios);
    }

    public boolean equals(Consulta consulta) {
        return this.numeroConsulta == consulta.getNumeroConsulta();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.numeroConsulta;
        hash = 17 * hash + Objects.hashCode(this.paciente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        if (this.numeroConsulta != other.numeroConsulta) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        return true;
    }

}
