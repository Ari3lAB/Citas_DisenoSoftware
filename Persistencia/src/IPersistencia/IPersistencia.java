package IPersistencia;

import excepciones.PersistenciaException;
import java.util.ArrayList;
import objetosNegocio.Consulta;
/**
 *
 * @author Eduardo Ramírez.
 */
public interface IPersistencia {

    /**
     *
     * @param consulta
     * @return
     */
    public Consulta obten(Consulta consulta) throws PersistenciaException;

    /**
     *
     * @param consulta
     * 
     */
    public void agregar(Consulta consulta) throws PersistenciaException;

    /**
     *
     * @param consulta
     * 
     */
    public void actualizar(Consulta consulta)throws PersistenciaException;

/**
     *
     * @param consulta
     * 
     */
    public void eliminar(Consulta consulta) throws PersistenciaException;

    /**
     *
     * @param consulta
     * @return
     * 
     */
    public ArrayList<Consulta> consultarConsultas(Consulta consulta) throws PersistenciaException;

}
