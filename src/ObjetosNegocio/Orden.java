package ObjetosNegocio;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Ariel AB
 */
public class Orden {

    protected ArrayList serviciosList;
    protected static int folioOrden = 1;

    public Orden(Servicio servicio) {
        serviciosList = new ArrayList();
        serviciosList.add(servicio);
        folioOrden++;
    }

    public Orden(Servicio[] servicios) {
        serviciosList = new ArrayList();
        serviciosList.addAll(Arrays.asList(servicios));
        folioOrden++;
    }

    public ArrayList getServiciosList() {
        return serviciosList;
    }

    public int getFolioOrden() {
        return folioOrden;
    }

    public void setServiciosList(ArrayList serviciosList) {
        this.serviciosList = serviciosList;
    }

    @Override
    public String toString() {
        return "Servicios a solicitar: " + serviciosList;
    }

}
