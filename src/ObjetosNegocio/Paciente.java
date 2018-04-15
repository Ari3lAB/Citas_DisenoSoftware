package ObjetosNegocio;

/**
 *
 * @author ArielAB
 */
public class Paciente {

    protected String nss;
    protected String nombre;
    protected float peso;

    public Paciente(String nss, String nombre, float peso) {
        this.nss = nss;
        this.nombre = nombre;
        this.peso = peso;
    }

    public Paciente(String nss) {
        this.nss = nss;
    }

    public String getNss() {
        return nss;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPeso() {
        return peso;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return nss + " " + nombre;
    }

}
