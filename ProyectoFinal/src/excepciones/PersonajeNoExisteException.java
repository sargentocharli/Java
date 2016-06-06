package excepciones;

public class PersonajeNoExisteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonajeNoExisteException(String msj) {
		super(msj);
	}

}
