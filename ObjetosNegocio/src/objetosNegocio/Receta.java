package objetosNegocio;

import java.util.GregorianCalendar;











public class Receta
{
  private String Diagnostico;
  private String tratamiento;
  private GregorianCalendar fecha;
  private int folio;
  private static int contadorRecetas = 0;
  
  public Receta(GregorianCalendar fecha) {
    contadorRecetas += 1;
    folio = contadorRecetas;
    this.fecha = fecha;
  }
  
  public Receta(String diagnostico, GregorianCalendar fecha, String tratamiento)
  {
    contadorRecetas += 1;
    folio = contadorRecetas;
    this.fecha = fecha;
    this.Diagnostico= diagnostico;
    
    this.tratamiento = tratamiento;
  }
  
  public Receta(Receta receta)
  {
    folio = receta.getFolio();
    Diagnostico = receta.getDianostico();
    fecha = receta.getFecha();
    
    tratamiento = receta.getTratamiento();
  }
  
  public void setFolioReceta(int folio) {
    this.folio = folio;
  }
  
  public int getFolio() {
    return folio;
  }
  
  public void setDiagnostico(String diagnostico) {
    Diagnostico = diagnostico;
  }
  
  public String getDianostico() {
    return Diagnostico;
  }
  
  public void setFecha(GregorianCalendar fecha) {
    this.fecha = fecha;
  }
  
  public GregorianCalendar getFecha() {
    return fecha;
  }
  
  public void setTratamiento(String tratamiento) {
    this.tratamiento = tratamiento;
  }
  
  public String getTratamiento() {
    return tratamiento;
  }
  
  public int hashCode()
  {
    int hash = 3;
    hash = 71 * hash + folio;
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
    Receta other = (Receta)obj;
    if (folio != folio) {
      return false;
    }
    return true;
  }
  

  public String toString()
  {
    return folio + ", " + fecha + ", " + Diagnostico + ", " + tratamiento;
  }
}
