package objetosNegocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Objects;







public class Consulta
{
  private static int contadorConsultas = 0;
  private int numeroConsulta;
  private Paciente paciente;
  private Receta receta;
  private ArrayList<Orden> listaOrdenes;
  private ArrayList<Servicio> listaServicios;
  
  public Consulta() {
    contadorConsultas += 1;
    numeroConsulta = contadorConsultas;
  }
  
  public Consulta(int numeroConsulta, Paciente paciente, Receta receta, ArrayList<Orden> listaOrdenes, ArrayList<Servicio> listaServicios)
  {
    this.numeroConsulta = numeroConsulta;
    this.paciente = new Paciente(paciente);
    this.listaOrdenes = new ArrayList(listaOrdenes);
    this.listaServicios = new ArrayList(listaServicios);
  }
  
  public Consulta(Consulta consulta) {
    numeroConsulta = consulta.getNumeroConsulta();
    paciente = new Paciente(consulta.getPaciente());
    listaOrdenes = new ArrayList(consulta.getListaOrdenes());
    listaServicios = new ArrayList(consulta.getListaServicios());
  }
  
  public String formatReceta() {
    StringBuilder servicios = new StringBuilder();
    for (Orden orden : listaOrdenes) {
      servicios.append(orden.getServicio()).append("\n");
    }
    

    String ano = String.valueOf(receta.getFecha().get(1));
    String mes; if (receta.getFecha().get(2) < 10) {
      mes = "0" + String.valueOf(receta.getFecha().get(2));
    } else
      mes = String.valueOf(receta.getFecha().get(2));
    
    String dia;
    if (receta.getFecha().get(5) < 10) {
      dia = "0" + String.valueOf(receta.getFecha().get(5));
    } else {
      dia = String.valueOf(receta.getFecha().get(5));
    }
    
    String fecha = ano + "-" + mes + "-" + dia;
    




    String formateada = "Folio: " + receta.getFolio() + "\t\tFecha: " + fecha + "\nPaciente: " + paciente.getNombre() + "\tNSS: " + paciente.getNss() + "\nDireccion: " + paciente.getDireccion() + "Telefono: " + paciente.getTelefono() + "\nDiagnóstico:\n" + receta.getDianostico() + "\n\nTratamiento:\n" + receta.getTratamiento() + "\n\nServicios:\n:" + servicios.toString();
    return formateada;
  }
  
  public int getNumeroConsulta()
  {
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
    return new ArrayList(listaOrdenes);
  }
  
  public void setListaOrdenes(ArrayList<Orden> listaOrdenes)
  {
    this.listaOrdenes = new ArrayList(listaOrdenes);
  }
  
  public boolean agregarOrden(Orden orden) {
    return listaOrdenes.add(orden);
  }
  
  public boolean agregaListaOrdenes(ArrayList<Orden> listaOrdenes)
  {
    return this.listaOrdenes.addAll(listaOrdenes);
  }
  
  public ArrayList<Servicio> getListaServicios() {
    return new ArrayList(listaServicios);
  }
  
  public void setListaServicios(ArrayList<Servicio> listaServicios) {
    this.listaServicios = null;
    this.listaServicios = new ArrayList(listaServicios);
  }
  
  public boolean agregarServicio(Servicio servicio) {
    return listaServicios.add(servicio);
  }
  
  public void agregaListaServicios(ArrayList<Servicio> listaServicios)
  {
    this.listaServicios.addAll(listaServicios);
  }
  
  public boolean equals(Consulta consulta) {
    return numeroConsulta == consulta.getNumeroConsulta();
  }
  
  @Override
  public int hashCode()
  {
    int hash = 7;
    hash = 17 * hash + numeroConsulta;
    hash = 17 * hash + Objects.hashCode(paciente);
    return hash;
  }
  
  @Override
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Consulta other = (Consulta)obj;
    if (numeroConsulta != numeroConsulta) {
      return false;
    }
    if (!Objects.equals(paciente, paciente)) {
      return false;
    }
    return true;
  }
}
