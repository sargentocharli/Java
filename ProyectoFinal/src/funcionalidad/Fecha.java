package funcionalidad;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;
import excepciones.FechaNoValidaException;

/**
 * Clase Fecha utilizada para el cálculo de edades de los personajes
 * @author Lucas Márquez Muñoz
 * @version 1.0
 */
public class Fecha {
	private GregorianCalendar calendar;
	
	/**
	 * Constructor por defecto
	 */
	public Fecha(){
		calendar=new GregorianCalendar();
	}
	
	/**
	 * Constructor que recibe como parámetros el dia, el mes y el año
	 * @param dia El día de la fecha
	 * @param mes El mes de la fecha
	 * @param anno El año de la fecha
	 * @throws FechaNoValidaException Excepción fecha no válida
	 */
	public Fecha(int dia, int mes, int anno) throws FechaNoValidaException{
		if(!esValida(dia, mes, anno))
			throw new FechaNoValidaException("Fecha no válida.");
		setGregorianCalendar(dia, mes, anno);
	}		
	
	/**
	 * Comprueba si la fecha dada a través de enteros (día, mes y año) es válida
	 * @param dia El día de la fecha
	 * @param mes El mes de la fecha
	 * @param anno El año de la fecha
	 * @return true si es válida y false si no lo es
	 */
	private boolean esValida(int dia,int mes,int anno){
		try {
			setGregorianCalendar(dia, mes, anno);
			if(esFuturo())
				return false;
			return true;
		} catch (FechaNoValidaException e) {
			return false;
		}
	}	
	
	/**
	 * Comprueba si una fecha es posterior a la actual
	 * @return true en caso de que sea posterior, false en caso contrario
	 */
	public boolean esFuturo(){
		return calendar.after(GregorianCalendar.getInstance());
	}	
	
	/**
	 * Devuelve la edad en años según la fecha de nacimiento recibida
	 * @return La edad en años
	 */
	public int obtenerEdad(){
		LocalDate fecha=LocalDate.of(calendar.get(GregorianCalendar.YEAR), 
				calendar.get(GregorianCalendar.MONTH)+1,
				calendar.get(GregorianCalendar.DAY_OF_MONTH));
		
		LocalDate fecha2 = LocalDate.now();
		
		return (int)ChronoUnit.YEARS.between(fecha, fecha2);
	}
	
	/**
	 * Crea una nueva fecha siempre que ésta sea válida
	 * @param dia El día del mes de la fecha a crear
	 * @param mes El mes de la fecha a crear
	 * @param anno El año de la fecha a crear
	 * @throws FechaNoValidaException Excepción fecha no válida
	 */
	void setGregorianCalendar(int dia, int mes, int anno) throws FechaNoValidaException{
		try {
			calendar= new GregorianCalendar(anno, mes, dia);
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