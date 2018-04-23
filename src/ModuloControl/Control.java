package ModuloControl;

import Driver.Ceder;
import InferfazUsuario.DlgReceta;
import InferfazUsuario.DlgImpresor;
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
import objetosNegocio.Proveedor;
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
    Ceder ceder;

    public Control() {
        listaOrdenes= new ArrayList<>();
        persistencia = PersistenciaFacade.getInstance();
        consulta = new Consulta();
        receta = new Receta(new Date());
        ceder = new Ceder();
    }

    public ArrayList<Paciente> obtenerListaCeder(String nss, String nombre) {

        Paciente paciente = new Paciente(nss, nombre, null, null);
        ArrayList<Paciente> pacientes = new ArrayList<>(ceder.obtenerPaciente());
        ArrayList<Paciente> encontrados = new ArrayList<>();
        
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
        
        if (respuesta.toString().equals("Aceptar")) {
            
            for (Servicio servicio : listaServicios) {
                Orden o = new Orden(servicio.getNombre().substring(0, 2), new Date(), servicio.getProovedor().getCodigo() + "", servicio.getProovedor().getNombre(), consulta.getPaciente().getNombre(), consulta.getPaciente().getNss(), servicio.getNombre(), receta.getTratamiento(), new Date());
                listaOrdenes.add(o);
            }
            guardarReceta();
        }

    }

    public ArrayList<Servicio> obtenerServiciosCeder() {
        ArrayList<Servicio> listaServicios = new ArrayList<>();
        ArrayList<Servicio> serviciosBuenos = new ArrayList<>();
        ArrayList<Servicio> serviciosRegulares = new ArrayList<>();
        ArrayList<Servicio> serviciosMalos = new ArrayList<>();
        Proveedor pro1 = new Proveedor("a", "Hospital 1", "Regular", new GregorianCalendar(2018, 3, 2), new GregorianCalendar(2019, 3, 2), 0);
        Proveedor pro2 = new Proveedor("b", "Hospital 2", "Buena", new GregorianCalendar(2018, 3, 2), new GregorianCalendar(2018, 6, 2), 1);
        Proveedor pro3 = new Proveedor("c", "Hospital 3", "Mala", new GregorianCalendar(2018, 0, 14), new GregorianCalendar(2018, 0, 23), 0);
        Proveedor pro4 = new Proveedor("d", "Hospital 4", "Mala", new GregorianCalendar(2018, 3, 9), new GregorianCalendar(2019, 3, 20), 0);
        Proveedor pro5 = new Proveedor("e", "Hospital 5", "Regular", new GregorianCalendar(2018, 3, 2), new GregorianCalendar(2019, 0, 2), 1);
        Proveedor pro6 = new Proveedor("f", "Hospital 6", "Buena", new GregorianCalendar(2018, 5, 19), new GregorianCalendar(2019, 3, 2), 0);

        listaServicios.add(new Servicio("msl", pro1, "Rayos X", ""));
        listaServicios.add(new Servicio("wei", pro2, "Ultrasonido", ""));
        listaServicios.add(new Servicio("92j", pro3, "Pediatria", ""));
        listaServicios.add(new Servicio("q82", pro4, "Rayos X", ""));
        listaServicios.add(new Servicio("lqm", pro5, "Pediatria", ""));
        listaServicios.add(new Servicio("owe", pro6, "Rayos X", ""));
        listaServicios.add(new Servicio("902", pro1, "Ultrasonido", ""));
        listaServicios.add(new Servicio("ams", pro5, "Ultrasonido", ""));
        listaServicios.add(new Servicio("laa", pro2, "Pediatria", ""));
        System.out.println(listaServicios.get(0).toString());
        //Clasifica los servicios por calidad.
        for (Servicio serv : listaServicios) {
            Proveedor p = new Proveedor(serv.getProovedor());
            if (p.getCalidad().equals("Buena")) {
                serviciosBuenos.add(serv);
            } else if (p.getCalidad().equals("Regular")) {
                serviciosRegulares.add(serv);
            } else {
                serviciosMalos.add(serv);
            }
        }
        //Ordena servicios de buena calidad or margen de contrato.
        Collections.sort(serviciosBuenos, (a, b) -> a.getProovedor().getDiasContrato() > b.getProovedor().getDiasContrato() ? -1 : a.getProovedor().getDiasContrato() == b.getProovedor().getDiasContrato() ? 0 : 1);
        //Ordena servicios de buena calidad por número de ordenes.
        Collections.sort(serviciosBuenos, (a, b) -> a.getProovedor().getNumOrdenes() < b.getProovedor().getNumOrdenes() ? -1 : a.getProovedor().getNumOrdenes() == b.getProovedor().getNumOrdenes() ? 0 : 1);
         //Ordena servicios de calidad regular por margen de contrato.
        Collections.sort(serviciosRegulares, (a, b) -> a.getProovedor().getDiasContrato() < b.getProovedor().getDiasContrato() ? -1 : a.getProovedor().getDiasContrato() == b.getProovedor().getDiasContrato() ? 0 : 1);
        //Ordena servicios de calidad regular por número de ordenes.
        Collections.sort(serviciosRegulares, (a, b) -> a.getProovedor().getNumOrdenes() < b.getProovedor().getNumOrdenes() ? -1 : a.getProovedor().getNumOrdenes() == b.getProovedor().getNumOrdenes() ? 0 : 1);
         //Ordena servicios de calidad mala por margen de contrato.
        Collections.sort(serviciosMalos, (a, b) -> a.getProovedor().getDiasContrato() < b.getProovedor().getDiasContrato() ? -1 : a.getProovedor().getDiasContrato() == b.getProovedor().getDiasContrato() ? 0 : 1);
        //Ordena servicios de calidad regular por número de ordenes.
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
        System.out.println(consulta.getListaOrdenes());
    }

    public void imprimirReceta(Frame frame, StringBuffer respuesta) {
        DlgImpresor impresor = new DlgImpresor(frame, "Imprimir Receta", respuesta, null);
        impresor.setVisible(true);
    }

    public void imprimirOrdenes(Frame frame) {
        for (Orden orden : consulta.getListaOrdenes()) {
            DlgImpresor impresor = new DlgImpresor(frame, "Imprimir Orden", null, orden);
            impresor.setVisible(true);
        }

    }
    public Consulta getConsulta(){
        return this.consulta;
    }

}
