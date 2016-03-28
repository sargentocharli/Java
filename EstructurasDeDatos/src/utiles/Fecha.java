package utiles.fecha;

import java.util.Calendar;
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
		if(!esValida(dia,mes-1,anno))
			throw new FechaNoValidaException("Fecha no válida.");
		setGregorianCalendar(dia,mes-1,anno);
	}
	
	/**
	 * Constructor que recibe como parámetro la fecha (como cadena)
	 * @throws FormatoNoValidoException 
	 * @throws NumberFormatException 
	 * @throws FechaNoValidaException 
	 */
	public Fecha(String cadena) throws FormatoNoValidoException, NumberFormatException, FechaNoValidaException{
		if(!esValidoFormato(cadena))
			throw new FormatoNoValidoException("Formato no válido.");
		if(!esValida(cadena))
			throw new FechaNoValidaException("Fecha no válida.");
		String[] array=obtenerArrayDiaMesAnno(cadena);
		setGregorianCalendar(Integer.parseInt(array[0]),
					Integer.parseInt(array[1])-1,
					Integer.parseInt(array[2]));
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
	
	/**
	 * Suma a la fecha los días,meses y años dados
	 * @param dias
	 * @param meses
	 * @param annos
	 * @throws SumaNoValidaException
	 */
	public void sumar(int dias,int meses,int annos) throws SumaNoValidaException{
		if(dias<0 || meses<0 || annos<0)
			throw new SumaNoValidaException("Valores de suma no válidos.");
		
		calendar.add(GregorianCalendar.DAY_OF_MONTH, dias);
		calendar.add(GregorianCalendar.MONTH, meses);
		calendar.add(GregorianCalendar.YEAR, annos);	
	}
	
	/**
	 * Comprueba si la fecha dada a través de enteros (día, mes y año) es válida
	 * @param dia
	 * @param mes
	 * @param anno
	 * @return true si es válida y false si no lo es
	 */
	private boolean esValida(int dia,int mes,int anno){
		try {
			setGregorianCalendar(dia,mes,anno);
			return true;
		} catch (FechaNoValidaException e) {
			return false;
		}
	}
	
	/**
	 * Comprueba si la fecha dada a través de una cadena es válida
	 * @param cadena
	 * @return true si es válida y false si no lo es
	 */
	private boolean esValida(String cadena){
		String[] array=obtenerArrayDiaMesAnno(cadena);
		try {
			setGregorianCalendar(Integer.parseInt(array[0]),
					Integer.parseInt(array[1])-1,
					Integer.parseInt(array[2]));
			return true;
		} catch (NumberFormatException | FechaNoValidaException e) {
			return false;
		}
	}
	
	/**
	 * Calcula la diferencia en días entre dos fechas
	 * @param fecha
	 * @return diferencia en días
	 */
	public long calcularDiasTranscurridos(Fecha fecha){
		long diferencia;
		diferencia=Math.abs((calendar.getTimeInMillis()-
				fecha.calendar.getTimeInMillis())/1000/60/60/24);
		return diferencia;
	}
	
	/**
	 * Calcula la diferencia en años entre dos fechas 
	 * @param fecha
	 * @return diferencia en años
	 */
	public long calcularAnnosTranscurridos(Fecha fecha){
		long diferencia;
		diferencia=Math.abs((calendar.getTimeInMillis()-
				fecha.calendar.getTimeInMillis())/1000/60/60/24/365);
		return diferencia;
	}
	
	/**
	 * Comprueba si la fecha de nacimiento y nos indica si la persona es mayor de edad
	 * @return true si tiene 18 o más y false si tiene menos
	 */
	public boolean esMayorDeEdad(){
		Fecha fecha=new Fecha();
		long diferencia=Math.abs((calendar.getTimeInMillis()-
				fecha.calendar.getTimeInMillis())/1000/60/60/24/365);
		
		if(diferencia<18)
			return false;
		return true;
			
	}
	
	/**
	 * Comprueba si una fecha es posterior a la actual
	 * @return
	 */
	public boolean esFuturo(){
		return calendar.after(GregorianCalendar.getInstance());
	}
	
	/**
	 * Devuelve el día de la semana de una fecha en castellano
	 * @return cadena con el día de la semana
	 */
	public String getDiaDeLaSemana(){
		String dia="";
		switch(calendar.get(Calendar.DAY_OF_WEEK)-1){
		
		case 0:
			dia += "Domingo";
			break;
		case 1:
			dia += "Lunes";
			break;
		case 2:
			dia += "Martes";
			break;
		case 3:
			dia += "Miercoles";
			break;
		case 4:
			dia += "Jueves";
			break;
		case 5:
			dia += "Viernes";
			break;
		case 6:
			dia += "Sabado";
		}
		return dia;
	}
	
	/**
	 * Devuelve el mes en castellano
	 * @return cadena con el mes
	 */
	public String getMes(){
		String mes = "";
		switch (calendar.get(Calendar.MONTH)) {
		case 0:
			mes += "Enero";
			break;
		case 1:
			mes += "Febrero";
			break;
		case 2:
			mes += "Marzo";
			break;
		case 3:
			mes += "Abril";
			break;
		case 4:
			mes += "Mayo";
			break;
		case 5:
			mes += "Junio";
			break;
		case 6:
			mes += "Julio";
			break;
		case 7:
			mes += "Agosto";
			break;
		case 8:
			mes += "Septiembre";
			break;
		case 9:
			mes += "Octubre";
			break;
		case 10:
			mes += "Noviembre";
			break;
		case 11:
			mes += "Diciembre";
		}
		return mes;
	}
	
	/**
	 * Crea una nueva fecha siempre que ésta sea válida
	 * @param dia
	 * @param mes
	 * @param anno
	 * @throws FechaNoValidaException
	 */
	void setGregorianCalendar(int dia,int mes,int anno) throws FechaNoValidaException{
		try {
			calendar= new GregorianCalendar(anno,mes,dia);
			calendar.setLenient(false);
			calendar.getTime();
		} catch (Exception e) {
			throw new FechaNoValidaException("Fecha no válida.");
		}
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
