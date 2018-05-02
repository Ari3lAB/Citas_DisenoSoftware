package objetosNegocio;

import java.util.Objects;







public class Paciente
{
  private String nss;
  private String nombre;
  private String telefono;
  private String direccion;
  
  public Paciente(String nss)
  {
    this.nss = nss;
  }
  
  public Paciente(String nss, String nombre, String telefono, String direccion) {
    this.nss = nss;
    this.nombre = nombre;
    this.telefono = telefono;
    this.direccion = direccion;
  }
  
  public Paciente(Paciente paciente)
  {
    nss = paciente.getNss();
    
    nombre = paciente.getNombre();
    telefono = paciente.getTelefono();
    direccion = paciente.getDireccion();
  }
  
  public String getNss()
  {
    return nss;
  }
  
  public String getNombre() {
    return nombre;
  }
  
  public void setNss(String nss) {
    this.nss = nss;
  }
  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }
  
  public String getTelefono() {
    return telefono;
  }
  
  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }
  
  public String getDireccion() {
    return direccion;
  }
  
  public int hashCode()
  {
    int hash = 5;
    hash = 67 * hash + Objects.hashCode(nss);
    return hash;
  }
  
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
    Paciente other = (Paciente)obj;
    return Objects.equals(nss, nss);
  }
  


  public String toString()
  {
    return nombre;
  }
}