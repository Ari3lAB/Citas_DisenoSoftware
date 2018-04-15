package excepciones;

/**
 *
 * @author Eduardo Ramírez.
 */
public class DAOException extends RuntimeException {

    /**
     * Constructor. Recibe un string y llama al constructor de RunTimeException
     * con este mismo.
     *
     * @param s
     */
    public DAOException(String s) {
        super(s);
    }
}
