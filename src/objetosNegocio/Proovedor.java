/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocio;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 *
 * @author 1024zettabytes
 */
public class Proovedor {

    private int codigo;
    private String calidad;
    private GregorianCalendar inicioContrato;
    private GregorianCalendar finContrato;
    private int numOrdenes;
    private int diasContrato;
    private String nombre;

    public Proovedor(int codigo) {
        this.codigo = codigo;
    }

    public Proovedor(int codigo, String nombre, String calidad, GregorianCalendar inicioContrato, GregorianCalendar finContrato, int numOrdenes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.calidad = calidad;
        this.inicioContrato = inicioContrato;
        this.finContrato = finContrato;
        this.numOrdenes = numOrdenes;
        this.diasContrato= (int) ((finContrato.getTimeInMillis()-inicioContrato.getTimeInMillis())/86400000);
        
    }

    public Proovedor(Proovedor proovedor) {
        this.codigo = proovedor.getCodigo();
        this.nombre = proovedor.getNombre();
        this.calidad = proovedor.getCalidad();
        this.inicioContrato = proovedor.getInicioContrato();
        this.finContrato = proovedor.getFinContrato();
        this.numOrdenes = proovedor.getNumOrdenes();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.codigo);
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
        final Proovedor other = (Proovedor) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigo + ", " + calidad + ", " + inicioContrato + ", " + finContrato + ", " + numOrdenes;
    }
}
