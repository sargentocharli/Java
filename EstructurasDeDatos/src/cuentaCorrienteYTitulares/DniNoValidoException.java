package cuentaCorrienteYTitulares;

public class DniNoValidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DniNoValidoException(String msj){
		super(msj);
	}

}
