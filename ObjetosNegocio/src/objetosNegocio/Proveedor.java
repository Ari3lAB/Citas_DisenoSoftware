package objetosNegocio;

import java.util.GregorianCalendar;
import java.util.Objects;











public class Proveedor
{
  private String codigo;
  private String calidad;
  private GregorianCalendar inicioContrato;
  private GregorianCalendar finContrato;
  private int numOrdenes;
  private int diasContrato;
  private String nombre;
  
  public Proveedor(String codigo)
  {
    this.codigo = codigo;
  }
  
  public Proveedor(String codigo, String nombre, String calidad, GregorianCalendar inicioContrato, GregorianCalendar finContrato, int numOrdenes) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.calidad = calidad;
    this.inicioContrato = inicioContrato;
    this.finContrato = finContrato;
    this.numOrdenes = numOrdenes;
    diasContrato = ((int)((finContrato.getTimeInMillis() - inicioContrato.getTimeInMillis()) / 86400000L));
  }
  
  public Proveedor(Proveedor proovedor)
  {
    codigo = proovedor.getCodigo();
    nombre = proovedor.getNombre();
    calidad = proovedor.getCalidad();
    inicioContrato = proovedor.getInicioContrato();
    finContrato = proovedor.getFinContrato();
    numOrdenes = proovedor.getNumOrdenes();
  }
  
  public String getCodigo() {
    return codigo;
  }
  
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  
  public String getCalidad() {
    return calidad;
  }
  
  public void setCalidad(String calidad) {
    this.calidad = calidad;
  }
  
  public GregorianCalendar getInicioContrato() {
    return inicioContrato;
  }
  
  public void setInicioContrato(GregorianCalendar inicioContrato) {
    this.inicioContrato = inicioContrato;
  }
  
  public GregorianCalendar getFinContrato() {
    return finContrato;
  }
  
  public void setFinContrato(GregorianCalendar finContrato) {
    this.finContrato = finContrato;
  }
  
  public int getNumOrdenes() {
    return numOrdenes;
  }
  
  public void setNumOrdenes(int numOrdenes) {
    this.numOrdenes = numOrdenes;
  }
  
  public int getDiasContrato() {
    return diasContrato;
  }
  
  public void setDiasContrato(int diasContrato) {
    this.diasContrato = diasContrato;
  }
  
  public String getNombre() {
    return nombre;
  }
  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  @Override
  public int hashCode()
  {
    int hash = 3;
    hash = 17 * hash + Objects.hashCode(codigo);
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
    Proveedor other = (Proveedor)obj;
    if (!Objects.equals(codigo, codigo)) {
      return false;
    }
    return true;
  }
  
  @Override
  public String toString()
  {
    return codigo + ", " + calidad + ", " + inicioContrato + ", " + finContrato + ", " + numOrdenes;
  }
}