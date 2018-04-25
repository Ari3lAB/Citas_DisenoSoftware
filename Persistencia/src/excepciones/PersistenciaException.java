package excepciones;

/**
 *
 * @author Eduardo Ramírez.
 */
public class PersistenciaException extends RuntimeException {

    /**
     * Constructor. Recibe un string y llama al constructor de RunTimeException
     * con este mismo.
     *
     * @param s
     */
    public PersistenciaException(String s) {
        super(s);
    }
}
