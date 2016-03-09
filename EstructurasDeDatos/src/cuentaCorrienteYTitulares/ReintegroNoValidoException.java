package cuentaCorrienteYTitulares;

public class ReintegroNoValidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ReintegroNoValidoException(String msj){
		super(msj);
	}

}
