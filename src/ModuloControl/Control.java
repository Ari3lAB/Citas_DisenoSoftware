/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloControl;

import InferfazUsuario.DlgReceta;
import InferfazUsuario.FrmImpresor;
import interfaces.IPersistencia;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import javafx.scene.Parent;
import javax.swing.JFrame;
import objetosNegocio.Consulta;
import objetosNegocio.Orden;
import objetosNegocio.Paciente;
import objetosNegocio.Proovedor;
import objetosNegocio.Receta;
import objetosNegocio.Servicio;
import persistencia.PersistenciaFacade;

/**
 *
 * @author Ariiel AB
 */
public class Control {

    IPersistencia persistencia;
    Consulta consulta;
    Receta receta;
    ArrayList<Servicio> listaServicios;
    ArrayList<Orden> listaOrdenes;

    public Control() {
        persistencia = PersistenciaFacade.getInstance();
        consulta = new Consulta();
        receta = new Receta(new Date());
    }

    public ArrayList<Paciente> obtenerListaCeder(String nss, String nombre) {

        Paciente paciente = new Paciente(nss, nombre, null, null);
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Paciente> encontrados = new ArrayList<>();
        pacientes.add(new Paciente("29384765378", "Jose Lopez", "254434736457", "CAlle x"));
        pacientes.add(new Paciente("92837465271", "Pablo Perez", "178643443536", "CAlle 7"));
        pacientes.add(new Paciente("mm992jwjw99", "Jose Martinez", "1656556456456", "CAlle i"));
        pacientes.add(new Paciente("mmsnhh79297", "Karina Cota", "19283736457", "CAlle s"));
        pacientes.add(new Paciente("32300873hh8", "Abel Rosas", "128912357", "CAlle sd"));
        if (nss != null) {
            if (pacientes.contains(paciente)) {
                encontrados.add(pacientes.get(pacientes.lastIndexOf(paciente)));
            }
        } else {
            pacientes.stream().filter((p) -> (p.getNombre().toUpperCase().contains(nombre.toUpperCase()))).forEachOrdered((p) -> {
                encontrados.add(p);
            });
        }

        return encontrados;
    }

    public void desplegarReceta(JFrame parent, StringBuffer respuesta, Paciente paciente, ArrayList<Servicio> listaServicios) {
        this.consulta.setPaciente(paciente);
        this.listaServicios = listaServicios;

        DlgReceta dlgReceta = new DlgReceta(parent, "Generar receta", respuesta, consulta, receta, this.listaServicios);
        dlgReceta.setVisible(true);
        if (respuesta.equals("Aceptar")) {
            for (Servicio servicio : listaServicios) {
                listaOrdenes.add(new Orden(servicio.getNombre().substring(0, 2), new Date(), servicio.getProovedor().getCodigo() + "", servicio.getProovedor().getNombre(), consulta.getPaciente().getNombre(), consulta.getPaciente().getNss(), servicio.getNombre(), receta.getTratamiento(), new Date()));
            }
            guardarReceta();
        }

    }

    public ArrayList<Servicio> obtenerServiciosCeder() {
        ArrayList<Servicio> listaServicios = new ArrayList<>();
        ArrayList<Servicio> serviciosBuenos = new ArrayList<>();
        ArrayList<Servicio> serviciosRegulares = new ArrayList<>();
        ArrayList<Servicio> serviciosMalos = new ArrayList<>();
        Proovedor pro1 = new Proovedor(1, "Hospital 1", "Regular", new GregorianCalendar(2018, 3, 2), new GregorianCalendar(2019, 3, 2), 0);
        Proovedor pro2 = new Proovedor(2, "Hospital 2", "Buena", new GregorianCalendar(2018, 3, 2), new GregorianCalendar(2018, 6, 2), 1);
        Proovedor pro3 = new Proovedor(3, "Hospital 3", "Mala", new GregorianCalendar(2018, 0, 14), new GregorianCalendar(2018, 0, 23), 0);
        Proovedor pro4 = new Proovedor(4, "Hospital 4", "Mala", new GregorianCalendar(2018, 9, 20), new GregorianCalendar(2018, 3, 2), 0);
        Proovedor pro5 = new Proovedor(5, "Hospital 5", "Regular", new GregorianCalendar(2018, 3, 2), new GregorianCalendar(2019, 0, 2), 1);
        Proovedor pro6 = new Proovedor(6, "Hospital 6", "Buena", new GregorianCalendar(2018, 5, 19), new GregorianCalendar(2019, 3, 2), 0);

        listaServicios.add(new Servicio("msl", pro1, "Rayos X", ""));
        listaServicios.add(new Servicio("wei", pro2, "Ultrasonido", ""));
        listaServicios.add(new Servicio("92j", pro3, "Pediatria", ""));
        listaServicios.add(new Servicio("q82", pro4, "Rayos X", ""));
        listaServicios.add(new Servicio("lqm", pro5, "Pediatria", ""));
        listaServicios.add(new Servicio("owe", pro6, "Rayos X", ""));
        listaServicios.add(new Servicio("902", pro1, "Ultrasonido", ""));
        listaServicios.add(new Servicio("ams", pro5, "Ultrasonido", ""));
        listaServicios.add(new Servicio("laa", pro2, "Pediatria", ""));
        for (Servicio serv : listaServicios) {
            Proovedor p = new Proovedor(serv.getProovedor());
            if (p.getCalidad().equals("Buena")) {
                serviciosBuenos.add(serv);
            } else if (p.getCalidad().equals("Regular")) {
                serviciosRegulares.add(serv);
            } else {
                serviciosMalos.add(serv);
            }
        }
        Collections.sort(serviciosBuenos, (a, b) -> a.getProovedor().getDiasContrato() < b.getProovedor().getDiasContrato() ? -1 : a.getProovedor().getDiasContrato() == b.getProovedor().getDiasContrato() ? 0 : 1);
        Collections.sort(serviciosBuenos, (a, b) -> a.getProovedor().getNumOrdenes() < b.getProovedor().getNumOrdenes() ? -1 : a.getProovedor().getNumOrdenes() == b.getProovedor().getNumOrdenes() ? 0 : 1);
        Collections.sort(serviciosRegulares, (a, b) -> a.getProovedor().getDiasContrato() < b.getProovedor().getDiasContrato() ? -1 : a.getProovedor().getDiasContrato() == b.getProovedor().getDiasContrato() ? 0 : 1);
        Collections.sort(serviciosRegulares, (a, b) -> a.getProovedor().getNumOrdenes() < b.getProovedor().getNumOrdenes() ? -1 : a.getProovedor().getNumOrdenes() == b.getProovedor().getNumOrdenes() ? 0 : 1);
        Collections.sort(serviciosMalos, (a, b) -> a.getProovedor().getDiasContrato() < b.getProovedor().getDiasContrato() ? -1 : a.getProovedor().getDiasContrato() == b.getProovedor().getDiasContrato() ? 0 : 1);
        Collections.sort(serviciosMalos, (a, b) -> a.getProovedor().getNumOrdenes() < b.getProovedor().getNumOrdenes() ? -1 : a.getProovedor().getNumOrdenes() == b.getProovedor().getNumOrdenes() ? 0 : 1);
        listaServicios.removeAll(listaServicios);
        listaServicios.addAll(serviciosBuenos);
        listaServicios.addAll(serviciosRegulares);
        listaServicios.addAll(serviciosMalos);
        return listaServicios;

    }

    public void guardarReceta() {
        consulta.setReceta(receta);
        consulta.setListaOrdenes(listaOrdenes);
        consulta.setListaServicios(listaServicios);
        persistencia.agregar(consulta);
    }

    public void imprimirReceta(Frame frame, StringBuffer respuesta) {
        FrmImpresor impresor = new FrmImpresor(frame, "Imprimir Receta", respuesta, null);
        impresor.setVisible(true);
    }

    public void imprimirOrdenes(Frame frame) {
        for (Orden orden : consulta.getListaOrdenes()) {
            FrmImpresor impresor = new FrmImpresor(frame, "Imprimir Orden", null, orden);
            impresor.setVisible(true);
        }

    }

}
