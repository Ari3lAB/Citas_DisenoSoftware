package ObjetosNegocio;

import java.util.ArrayList;

import java.util.Date;

/**
 *
 * @author ArielAB
 */
public class Receta {

    protected String Diagnostico;
    protected String tratamiento;
    protected Date fecha;
    
    protected  int folio;
public Receta(int folio, Date fecha) {
        this.folio=folio;
        this.fecha = fecha;
        
        
    }
    public Receta(int folio,String diagnostico, Date fecha,String tratamiento) {
        this.folio=folio;
        this.Diagnostico = diagnostico;
        this.fecha = fecha;
        
        this.tratamiento=tratamiento;
        
        
    }
public Receta(Receta receta){
    this.folio=receta.getFolio();
        this.Diagnostico = receta.getDianostico();
        this.fecha = receta.getFecha();
        
        this.tratamiento=receta.getTratamiento();
}
    

    public void setFolioReceta(int folio) {
        this.folio = folio;
    }

    public int getFolio() {
        return folio;
    }
public void setDiagnostico(String diagnostico) {
        this.Diagnostico = diagnostico;
    }
    public String getDianostico() {
        return Diagnostico;
    }

   public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Date getFecha() {
        return fecha;
    }
   
    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
    public String getTratamiento() {
        return tratamiento;
    }
    
    public boolean agregarServicio(ArrayList<Servicio> listaServicios){
        return listaServicios.addAll(listaServicios);
    }
    
    public boolean equals(Receta receta){
       return folio == receta.getFolio();
    }

    

    

    @Override
    public String toString() {

        return folio + ", " + fecha + ", " + Diagnostico+", " + tratamiento;
    }

}
