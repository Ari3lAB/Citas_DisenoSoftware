package objetosNegocio;

import java.util.Objects;







public class Servicio
{
  private Proveedor proovedor;
  private String nombre;
  private String descripcion;
  private String codigoServicio;
  
  public Servicio(String codigoServicio)
  {
    this.codigoServicio = codigoServicio;
  }
  
  public Servicio(String codigoServicio, Proveedor proovedor, String nombre, String descripcion) {
    this.codigoServicio = codigoServicio;
    this.proovedor = new Proveedor(proovedor);
    this.nombre = nombre;
    this.descripcion = descripcion;
  }
  
  public Servicio(Servicio servicio) {
    codigoServicio = servicio.getCodigoServicio();
    nombre = servicio.getNombre();
    proovedor = new Proveedor(servicio.getProovedor());
    descripcion = servicio.getDescripcion();
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
  public int hashCode()
  {
    int hash = 5;
    hash = 97 * hash + Objects.hashCode(codigoServicio);
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
    Servicio other = (Servicio)obj;
    if (!Objects.equals(codigoServicio, codigoServicio)) {
      return false;
    }
    return true;
  }
  
  @Override
  public String toString()
  {
    return nombre;
  }
}