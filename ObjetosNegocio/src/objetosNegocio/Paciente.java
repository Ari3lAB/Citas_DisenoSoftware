package ObjetosNegocio;

/**
 *
 * @author ArielAB
 */
public class Paciente {

    protected String nss;
    protected String nombre;
    protected String telefono;
    protected String direccion;
    

    

    public Paciente(String nss) {
        this.nss = nss;
    }
    public Paciente(String nss, String nombre, String telefono, String direccion) {
        this.nss = nss;
        this.nombre = nombre;
        this.telefono=telefono;
        this.direccion = direccion;
        
    }
    public Paciente(Paciente paciente){
        this.nss=paciente.getNss();
        
        this.nombre=paciente.getNombre();
        this.telefono=paciente.getTelefono();
        this.direccion=paciente.getDireccion();
        
    }

    public String getNss() {
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
        return this.telefono;
    }
    public void setDireccion(String direccion) {
        this.direccion=direccion;
    }
    public String getDireccion() {
        return this.direccion;
    }
  public boolean equals(Paciente paciente){
      return this.nss.equals(paciente.getNss());
  }

    @Override
    public String toString() {
        return nss + ", " + nombre+ ", " + telefono+ ", " + direccion;
    }

}
