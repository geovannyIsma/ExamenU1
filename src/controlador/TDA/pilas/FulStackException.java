package controlador.TDA.pilas;
/**
 *
 * @author romer
 */
public class FulStackException extends Exception{

    /**
     * Creates a new instance of <code>FulStackException</code> without detail
     * message.
     */
    public FulStackException() {
    }

    /**
     * Constructs an instance of <code>FulStackException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public FulStackException(String msg) {
        super(msg);
    }
}
