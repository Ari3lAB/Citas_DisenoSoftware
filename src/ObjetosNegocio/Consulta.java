package ObjetosNegocio;

import java.util.ArrayList;

/**
 *
 * @author Ariel AB
 */
public class Consulta {

    protected int numeroConsulta;
    protected Paciente paciente;
    protected Receta receta;
    protected ArrayList<Orden> listaOrdenes;
    protected ArrayList<Servicio> listaServicios;
    public Consulta(int numeroConsulta){
        this.numeroConsulta = numeroConsulta;
    }
    public Consulta(int numeroConsulta, Paciente paciente, Receta receta, ArrayList<Orden> listaOrdenes,
            ArrayList<Servicio> listaServicios){
        this.numeroConsulta = numeroConsulta;
        this.paciente = new Paciente(paciente);
        this.listaOrdenes = new ArrayList<>(listaOrdenes);
        this.listaServicios = new ArrayList<>(listaServicios);
    }
    public Consulta(Consulta consulta){
        this.numeroConsulta = consulta.getNumeroConsulta();
        this.paciente = new Paciente(consulta.getPaciente());
        this.listaOrdenes = new ArrayList<>(consulta.getListaOrdenes());
        this.listaServicios = new ArrayList<>(consulta.getListaServicios());
    }

    public int getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setNumeroConsulta(int numeroConsulta) {
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
        return new ArrayList<> (this.listaOrdenes);
    }

    public void setListaOrdenes(ArrayList<Orden> listaOrdenes) {
        this.listaOrdenes=null;
        this.listaOrdenes = new ArrayList<>(listaOrdenes);
    }
    public boolean agregarOrden(Orden orden){
        return listaOrdenes.add(orden);
    }
    public boolean agregaListaOrdenes(ArrayList<Orden> listaOrdenes){
        
        return this.listaOrdenes.addAll(listaOrdenes);
    }
    public ArrayList<Servicio> getListaServicios() {
        return new ArrayList<> (this.listaServicios);
    }

    public void setListaServicios(ArrayList<Servicio> listaServicios){
        this.listaServicios=null;
        this.listaServicios= new ArrayList<>(listaServicios);
    }
    
    public boolean agregarServicio(Servicio servicio){
        return listaServicios.add(servicio);
    }
    public void agregaListaServicios(ArrayList<Servicio> listaServicios){
        
        this.listaServicios.addAll(listaServicios);
    }
    public boolean equals(Consulta consulta){
        return this.numeroConsulta == consulta.getNumeroConsulta();
    }
}
