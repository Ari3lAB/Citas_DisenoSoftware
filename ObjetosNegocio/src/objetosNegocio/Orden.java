package ObjetosNegocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Ariel AB
 */
public class Orden {

   
    protected String numeroOrden;//3 primeras letras del nombre de servicio
    protected String codigoProovedor;
    protected Date fechaSolicitud;
    protected int numeroSolicitud;
    protected String nombreProovedor;
    protected String nombrePaciente;
    protected String NSSPaciente;
    protected String servicio;
    protected String indicaciones;
    protected Date fechaServicio;

   

    public Orden(int numeroSolicitud) {
        
        this.numeroSolicitud = numeroSolicitud;
    }

    public Orden(int numeroSolicitud, String numeroOrden , 
            Date fechaSolicitud, String codigoProovedor, String nombreProovedor, String nombrePaciente, 
            String NSSPaciente, String servicio, Date fechaServicio) {
        this.numeroOrden = numeroOrden;
        this.numeroSolicitud = numeroSolicitud;
        this.fechaSolicitud = fechaSolicitud;
       this.codigoProovedor = codigoProovedor;
       this.nombreProovedor = nombreProovedor;
       this.nombrePaciente = nombrePaciente;
       this.NSSPaciente =NSSPaciente;
       this.servicio = servicio;
       this.fechaServicio = fechaServicio;
    }
    public Orden(Orden orden){
        this.numeroOrden = orden.getNumeroOrden();
        this.numeroSolicitud = orden.getNumeroSolicitud();
        this.fechaSolicitud = orden.getFechaSolicitud();
       this.codigoProovedor = orden.getCodigoProovedor();
       this.nombreProovedor = orden.getNombreProovedor();
       this.nombrePaciente = orden.getNombrePaciente();
       this.NSSPaciente =orden.getNSSPaciente();
       this.servicio = orden.getServicio();
       this.fechaServicio = orden.getFechaServicio();
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

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
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

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    
    public boolean equals(Orden orden) {
        return this.numeroSolicitud == orden.getNumeroSolicitud();
    }
    
   

    @Override
    public String toString() {
        return  numeroOrden+", "+numeroSolicitud+", "+fechaSolicitud+", "+codigoProovedor+", "+
                nombreProovedor+", "+nombrePaciente +", "+NSSPaciente+", "+servicio+", "+fechaServicio;
    }

}
