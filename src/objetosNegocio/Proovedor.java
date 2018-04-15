/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosNegocio;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 1024zettabytes
 */
public class Proovedor {

    protected String codigo;
    protected String calidad;
    protected Date inicioContrato;
    protected Date finContrato;
    protected int numOrdenes;

    public Proovedor(String codigo) {
        this.codigo = codigo;
    }

    public Proovedor(String codigo, String calidad, Date inicioContrato, Date finContrato, int numOrdenes) {
        this.codigo = codigo;
        this.calidad = calidad;
        this.inicioContrato = inicioContrato;
        this.finContrato = finContrato;
        this.numOrdenes = numOrdenes;
    }

    public Proovedor(Proovedor proovedor) {
        this.codigo = proovedor.getCodigo();
        this.calidad = proovedor.getCalidad();
        this.inicioContrato = proovedor.getInicioContrato();
        this.finContrato = proovedor.getFinContrato();
        this.numOrdenes = proovedor.getNumOrdenes();
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

    public Date getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(Date inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    public Date getFinContrato() {
        return finContrato;
    }

    public void setFinContrato(Date finContrato) {
        this.finContrato = finContrato;
    }

    public int getNumOrdenes() {
        return numOrdenes;
    }

    public void setNumOrdenes(int numOrdenes) {
        this.numOrdenes = numOrdenes;
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
