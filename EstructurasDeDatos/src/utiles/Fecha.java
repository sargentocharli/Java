package utiles;

import java.util.GregorianCalendar;
import java.util.regex.Pattern;

public class Fecha {
	private GregorianCalendar calendar;
	
	/**
	 * Constructor por defecto
	 */
	public Fecha(){
		calendar=new GregorianCalendar();
	}
	/**
	 * Constructor que recibe como parámetros el día, el mes y el año
	 * @throws FechaNoValidaException 
	 */
	public Fecha(int dia,int mes,int anno) throws FechaNoValidaException{
		try {
			calendar= new GregorianCalendar(anno,mes-1,dia);
			calendar.setLenient(false);
			calendar.getTime();
		} catch (Exception e) {
			throw new FechaNoValidaException("Fecha no válida."); 
		}
	}
	
	/**
	 * Constructor que recibe como parámetro la fecha (como cadena)
	 * @throws FormatoNoValidoException 
	 * @throws FechaNoValidaException 
	 */
	public Fecha(String cadena) throws FechaNoValidaException, FormatoNoValidoException, IllegalArgumentException{
		if(!esValidoFormato(cadena))
			throw new FormatoNoValidoException("Formato no válido.");
		String[] array=obtenerArrayDiaMesAnno(cadena);
		try {
			calendar= new GregorianCalendar(Integer.parseInt(array[2]),Integer.parseInt(array[1])-1,Integer.parseInt(array[0]));
			calendar.setLenient(false);
			calendar.getTime();
		} catch (Exception e) {
			throw new FechaNoValidaException("Fecha no válida."); 
		}
	}

	/**
	 * Comprueba si el formato de la fecha es válido
	 * @param cadena
	 * @return true si la cadena cumple el patrón
	 */
	private boolean esValidoFormato(String cadena){
		Pattern pattern=Pattern.compile("(0?[1-9]|[12][0-9]|3[01])[- /](0?[1-9]|1[012])[- /](19|20)\\d\\d");
		return pattern.matcher(cadena).matches();
	}
	
	/**
	 * A partir de una cadena obtenemos un array con 3 subcadenas, el día el mes y el año
	 * @param cadena
	 * @return array de cadenas
	 */
	private String[] obtenerArrayDiaMesAnno(String cadena){
		return cadena.split("[ -/]");
	}
	
	Fecha sumar(Fecha fecha){
		Fecha suma = new Fecha();
		suma.calendar.setTimeInMillis(fecha.calendar.getTimeInMillis()
				+ calendar.getTimeInMillis());
		return suma;
		
	}
	
	Fecha calcularDiferencia(Fecha fecha){
		return null;
	}
	
	boolean esMayorDeEdad(){
		return false;
	}
	
	boolean esFuturo(){
		return calendar.after(GregorianCalendar.getInstance());
	}
	
	public GregorianCalendar getFecha() {
		return calendar;
	}

	@Override
	public String toString() {
		return "Fecha: " + calendar.get(GregorianCalendar.DAY_OF_MONTH) + 
				"/" + 
				(calendar.get(GregorianCalendar.MONTH)+1) + 
				"/" +
				calendar.get(GregorianCalendar.YEAR);
	}
}
