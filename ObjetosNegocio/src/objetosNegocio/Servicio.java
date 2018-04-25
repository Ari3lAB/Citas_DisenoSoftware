package ObjetosNegocio;

import java.util.Objects;

/**
 *
 * @author Ariel AB
 */
public class Servicio {

    protected Proovedor proovedor;
    protected String nombre;
    protected String descripcion;
    protected String codigoServicio;
    public Servicio(String codigoServicio){
        this.codigoServicio=codigoServicio;
    }
    public Servicio(String codigoServicio, Proovedor proovedor, String nombre, String descripcion) {
        this.codigoServicio=codigoServicio;
        this.proovedor=new Proovedor(proovedor);
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public Servicio(Servicio servicio){
        this.codigoServicio=servicio.getCodigoServicio();
        this.nombre=servicio.getNombre();
         this.proovedor=new Proovedor(servicio.getProovedor());
        this.descripcion=servicio.getDescripcion();
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
    public Proovedor getProovedor(){
        return new Proovedor(proovedor);
    }
    public void setProovedor(Proovedor proovedor){
        this.proovedor=new Proovedor(proovedor);
    }
    

    @Override
    public String toString() {
        return nombre + ", " + descripcion+", "+proovedor.getCodigo();
    }

}
