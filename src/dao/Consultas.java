package dao;

import excepciones.DAOException;
import java.util.ArrayList;

import objetosNegocio.Consulta;

/**
 *
 * @author 1024zettabytes
 */
public class Consultas {
    /**
     * lista de consultas.
     */
    public ArrayList<Consulta> consultas;

    /**
     * Constructor. Inicializa la lista de consultas a un ArrayList.
     */
    public Consultas() {
        this.consultas = new ArrayList();
    }
    /**
     * Devuelve la consulta que coincide con el numero de consulta de la conulta
     * recibida, regresa null si ninguna coincide.
     *
     * @param consulta Consulta a buscar.
     * @return COnsulta encontrado.
     */
    public Consulta obten(Consulta consulta) {
        if (consulta != null && consultas.contains(consulta)) {
            return consultas.get(consultas.indexOf(consulta));
        }
        return null;
    }

    /**
     * Agrega la consulta recibida a la lista de consultas.
     *
     * @param consulta Consulta a agregar.
     */
    public void agrega(Consulta consulta) {
        if (consulta != null) {
            consultas.add(consulta);
        }
    }
     /**
     * Busca la consulta recibida en la lista de consultas y actualiza su valor,
     *
     * @param consulta Consulta a actualizar.
     */
    public void actualiza(Consulta consulta) {
        if (consulta != null && consultas.contains(consulta)){ 
            consultas.set(consultas.indexOf(consulta), consulta);
            return;
        }throw new DAOException("***ERROR:No se encontró la Consulta a actualizar.");
            
    }

    /**
     * Busca las consulta recibida en la lista de consultas y la elimina de esta.
     *
     * @param consulta Consulta a eliminar.
     */
    public void elimina(Consulta consulta) {
        if (consulta != null && consultas.remove(consulta)){
            return;
        }throw new DAOException("***ERROR:No se encontró la consulta a eliminar.");
  
    }

    /**
     * Devuelve la lista de consultas.
     *
     * @return Lista de consultas.
     */
    public ArrayList<Consulta> lista() {
        return new ArrayList(consultas);
    }

}
