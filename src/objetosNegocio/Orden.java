package objetosNegocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Ariel AB
 */
public class Orden {

    private String numeroOrden;//3 primeras letras del nombre de servicio
    private String codigoProovedor;
    private Date fechaSolicitud;
    private int numeroSolicitud;
    private String nombreProovedor;
    private String nombrePaciente;
    private String NSSPaciente;
    private String servicio;
    private String indicaciones;
    private Date fechaServicio;

    private static int contadorOrdenes = 0;

    public Orden() {
        contadorOrdenes++;
        this.numeroSolicitud = contadorOrdenes;
    }

    public Orden(String numeroOrden,
            Date fechaSolicitud, String codigoProovedor, String nombreProovedor, String nombrePaciente,
            String NSSPaciente, String servicio, String indicaciones, Date fechaServicio) {
        contadorOrdenes++;
        this.numeroSolicitud = contadorOrdenes;
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
        this.numeroOrden = orden.getNumeroOrden();
        this.numeroSolicitud = orden.getNumeroSolicitud();
        this.fechaSolicitud = orden.getFechaSolicitud();
        this.codigoProovedor = orden.getCodigoProovedor();
        this.nombreProovedor = orden.getNombreProovedor();
        this.nombrePaciente = orden.getNombrePaciente();
        this.NSSPaciente = orden.getNSSPaciente();
        this.servicio = orden.getServicio();
        this.indicaciones = orden.getIndicaciones();
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.numeroSolicitud;
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
        final Orden other = (Orden) obj;
        return this.numeroSolicitud == other.numeroSolicitud;
    }

    @Override
    public String toString() {
        return numeroOrden + ", " + numeroSolicitud + ", " + fechaSolicitud + ", " + codigoProovedor + ", "
                + nombreProovedor + ", " + nombrePaciente + ", " + NSSPaciente + ", " + servicio + ", " + fechaServicio;
    }

}
