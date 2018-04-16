package interfaces;

import excepciones.PersistenciaException;

/**
 *
 * @author Ariiel AB
 */
public interface IControl {

    public String obtenerReceta() throws PersistenciaException;

}
