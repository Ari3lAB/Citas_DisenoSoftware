package objetosNegocio;

import java.util.GregorianCalendar;











public class Orden
{
  private String numeroOrden;
  private String codigoProovedor;
  private GregorianCalendar fechaSolicitud;
  private int numeroSolicitud;
  private String nombreProovedor;
  private String nombrePaciente;
  private String NSSPaciente;
  private String servicio;
  private String indicaciones;
  private GregorianCalendar fechaServicio;
  private static int contadorOrdenes = 0;
  
  public Orden() {
    contadorOrdenes += 1;
    numeroSolicitud = contadorOrdenes;
  }
  

  public Orden(String numeroOrden, GregorianCalendar fechaSolicitud, String codigoProovedor, String nombreProovedor, String nombrePaciente, String NSSPaciente, String servicio, String indicaciones, GregorianCalendar fechaServicio)
  {
    contadorOrdenes += 1;
    numeroSolicitud = contadorOrdenes;
    this.numeroOrden = numeroOrden;
    
    this.fechaSolicitud = fechaSolicitud;
    this.codigoProovedor = codigoProovedor;
    this.nombreProovedor = nombreProovedor;
    this.nombrePaciente = nombrePaciente;
    this.NSSPaciente = NSSPaciente;
    this.servicio = servicio;
    this.indicaciones = indicaciones;
    this.fechaServicio = fechaServicio;
  }
  
  public Orden(Orden orden) {
    numeroOrden = orden.getNumeroOrden();
    numeroSolicitud = orden.getNumeroSolicitud();
    fechaSolicitud = orden.getFechaSolicitud();
    codigoProovedor = orden.getCodigoProovedor();
    nombreProovedor = orden.getNombreProovedor();
    nombrePaciente = orden.getNombrePaciente();
    NSSPaciente = orden.getNSSPaciente();
    servicio = orden.getServicio();
    indicaciones = orden.getIndicaciones();
    fechaServicio = orden.getFechaServicio();
  }
  
  public String getNumeroOrden() {
    return numeroOrden;
  }
  
  public void setNumeroOrden(String numeroOrden) {
    this.numeroOrden = numeroOrden;
  }
  
  public String getCodigoProovedor() {
    return codigoProovedor;
  }
  
  public void setCodigoProovedor(String codigoProovedor) {
    this.codigoProovedor = codigoProovedor;
  }
  
  public GregorianCalendar getFechaSolicitud() {
    return fechaSolicitud;
  }
  
  public void setFechaSolicitud(GregorianCalendar fechaSolicitud) {
    this.fechaSolicitud = fechaSolicitud;
  }
  
  public int getNumeroSolicitud() {
    return numeroSolicitud;
  }
  
  public void setNumeroSolicitud(int numeroSolicitud) {
    this.numeroSolicitud = numeroSolicitud;
  }
  
  public String getNombreProovedor() {
    return nombreProovedor;
  }
  
  public void setNombreProovedor(String nombreProovedor) {
    this.nombreProovedor = nombreProovedor;
  }
  
  public String getNombrePaciente() {
    return nombrePaciente;
  }
  
  public void setNombrePaciente(String nombrePaciente) {
    this.nombrePaciente = nombrePaciente;
  }
  
  public String getNSSPaciente() {
    return NSSPaciente;
  }
  
  public void setNSSPaciente(String NSSPaciente) {
    this.NSSPaciente = NSSPaciente;
  }
  
  public String getServicio() {
    return servicio;
  }
  
  public void setServicio(String servicio) {
    this.servicio = servicio;
  }
  
  public String getIndicaciones() {
    return indicaciones;
  }
  
  public void setIndicaciones(String indicaciones) {
    this.indicaciones = indicaciones;
  }
  
  public GregorianCalendar getFechaServicio() {
    return fechaServicio;
  }
  
  public void setFechaServicio(GregorianCalendar fechaServicio) {
    this.fechaServicio = fechaServicio;
  }
  
  @Override
  public int hashCode()
  {
    int hash = 7;
    hash = 19 * hash + numeroSolicitud;
    return hash;
  }
  
    /**
     *
     * @param obj
     * @return
     */
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
    Orden other = (Orden)obj;
    return numeroSolicitud == numeroSolicitud;
  }
  
  @Override
  public String toString()
  {
    return numeroOrden + ", " + numeroSolicitud + ", " + fechaSolicitud + ", " + codigoProovedor + ", " + nombreProovedor + ", " + nombrePaciente + ", " + NSSPaciente + ", " + servicio + ", " + fechaServicio;
  }
}