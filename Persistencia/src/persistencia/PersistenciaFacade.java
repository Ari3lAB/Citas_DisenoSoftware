/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dao.Consultas;
import excepciones.DAOException;
import excepciones.PersistenciaException;
import IPersistencia.IPersistencia;
import java.util.ArrayList;
import objetosNegocio.Consulta;

/**
 *
 * @author 1024zettabytes
 */
public class PersistenciaFacade implements IPersistencia{
 private static PersistenciaFacade INSTANCE = null;
    /**
     * Registro de consultas.
     */
    Consultas registroConsultas;
    /**
     * Constructor. Inicializa los registros.
     */
    private PersistenciaFacade() {
        this.registroConsultas = new Consultas();

    }
    public static PersistenciaFacade getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    private static void createInstance() {
        if (INSTANCE == null) {
            // Sólo se accede a la zona sincronizada
            // cuando la instancia no está creada
                if (INSTANCE == null) { 
                    INSTANCE = new PersistenciaFacade();
                }
            }
        }
    
    /**
     * Obtiene una consulta del registro de consultas, regresa null en caso de no
     * encontrala o se genera una excepción de tipo PersistenciaException si no
     * se puede acceder al registro de consultas.
     * @param consulta Consulta a buscar.
     * @return Consulta encontrada o null.
     */
    @Override
    public Consulta obten(Consulta consulta) throws PersistenciaException {
         if (registroConsultas != null) {
            return registroConsultas.obten(consulta);
        }
         throw new PersistenciaException("***ERROR: No se puede acceder al registro de consultas.");
    }
    /**
     * Agrega una nuevo consulta al registro, si esta no existe en el registro, lanza una excepción de tipo
     * PersistenciaException si el la consulta ya existe en el registro.
     *
     * @param consulta Consulta a agregar.
     */
    @Override
    public void agregar(Consulta consulta)  throws PersistenciaException {
      if (consulta != null && !registroConsultas.lista().contains(consulta)) {
            registroConsultas.agrega(consulta);
            return;
        }
      throw new PersistenciaException("***ERROR: No se puede agregar la consulta al registro.");
    }

    /**
     * Actualiza una consulta del registro, lanza una excepción de tipo
     * PersistenciaException si la consulta no existe en el registro.
     *
     * @param consulta Consulta a actualizar.
     * @throws PersistenciaException
     */
    @Override
    public void actualizar(Consulta consulta) throws PersistenciaException {
        try {
            registroConsultas.actualiza(consulta);
        } catch (DAOException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }
    /**
     * Elimina una consulta del registro, lanza una excepción de tipo
     * PersistenciaException si la consulta no existe en el registro.
     *
     * @param consulta Consulta a eliminar.
     * @throws PersistenciaException
     */
    @Override
    public void eliminar(Consulta consulta) throws PersistenciaException {
        try {
            registroConsultas.elimina(consulta);
        } catch (DAOException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    
/**
     * Regresa la lista de consultas del registro, gnera una excepción si
     * no se puede acceder al registro de consultas.
     *
     * @return Lista de consultas.
     * @throws PersistenciaException
     */
    @Override
    public ArrayList<Consulta> consultarConsultas(Consulta consulta)throws PersistenciaException {
        if (registroConsultas != null) {
            return registroConsultas.lista();
        }
        throw new PersistenciaException("***ERROR: No se puede acceder al registro de consultas.");
    }
    
    
}
