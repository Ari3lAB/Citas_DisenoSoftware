package objetosNegocio;

import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author Ariel AB
 */
public class Servicio {
    
    private Proveedor proovedor;
    private String nombre;
    private String descripcion;
    private String codigoServicio;

    public Servicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public Servicio(String codigoServicio, Proveedor proovedor, String nombre, String descripcion) {
        this.codigoServicio = codigoServicio;
        this.proovedor = new Proveedor(proovedor);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Servicio(Servicio servicio) {
        this.codigoServicio = servicio.getCodigoServicio();
        this.nombre = servicio.getNombre();
        this.proovedor = new Proveedor(servicio.getProovedor());
        this.descripcion = servicio.getDescripcion();
    }

    public String getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(String codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proveedor getProovedor() {
        return new Proveedor(proovedor);
    }

    public void setProovedor(Proveedor proovedor) {
        this.proovedor = new Proveedor(proovedor);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.codigoServicio);
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
        final Servicio other = (Servicio) obj;
        if (!Objects.equals(this.codigoServicio, other.codigoServicio)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }

    

    


}
