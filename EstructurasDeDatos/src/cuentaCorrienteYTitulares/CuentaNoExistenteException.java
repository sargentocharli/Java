package cuentaCorrienteYTitulares;

public class CuentaNoExistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	CuentaNoExistenteException(String msj){
		super(msj);
	}
}
