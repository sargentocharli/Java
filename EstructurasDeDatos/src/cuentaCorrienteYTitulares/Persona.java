package cuentaCorrienteYTitulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Lucas Márquez Muñoz
 *
 */

public class Persona {
	
	private String nombre;
	private String dni;
	private String direccion;
	
	/**
	 * constructor que recibe los tres atributos
	 * @param nombre El nombre de la persona
	 * @param dni El DNI de la persona
	 * @param direccion La dirección de la persona
	 * @throws DniNoValidoException 
	 * @throws NombreNoValidoException 
	 */
	
	Persona (String nombre, String dni, String direccion) throws DniNoValidoException, NombreNoValidoException{
		
			setNombre(nombre);
			setDni(dni);
			setDireccion(direccion);			
	}
	
	/**
	 * Constructor que recibe solo el DNI	 
	 * @throws DniNoValidoException 
	 */
	
	Persona (String dni) throws DniNoValidoException{
		setDni(dni);
	}
	
	
	//Getters & Setters

	String getNombre() {
		return nombre;
	}

	void setNombre(String nombre) throws NombreNoValidoException{
		if(validaNombre(nombre))
			this.nombre = nombre;
		else
			throw new NombreNoValidoException("Error. Nombre no válido.");
	}

	String getDni() {
		return dni;
	}

	void setDni(String dni) throws DniNoValidoException{
		if(!validaDni(dni))
			throw new DniNoValidoException("Error. DNI " + dni + " no válido.");
		this.dni = dni;
			
	}

	String getDireccion() {
		return direccion;
	}

	void setDireccion(String direccion) {
		this.direccion = direccion;
	}	

	/**
	 * Comprueba que el DNI introducido sea válido usando expresiones regulares
	 * @param dni El DNI a comprobar
	 * @return True si es válido, false si no lo es
	 */
	public static boolean validaDni(String dni){		   
		 
		Pattern dniPattern = Pattern.compile("^(?i)(\\d{8})[- ]?([TRWAGMYFPDXBNJZSQVHLCKE])$"); //Crea patrón
		Matcher dniMatcher = dniPattern.matcher(dni); //comprueba el valor de la variable con el patrón anterior
		if(dniMatcher.matches()){ //si hay coincidencia con el patrón
			String letraDni = dniMatcher.group(2);	//almacena en letraDni la letra del DNI introducido	
			String letrasDniValidas = "TRWAGMYFPDXBNJZSQVHLCKE"; // cadena con las posibles letras válidas del DNI ordenadas
			int numeroDni = Integer.parseInt(dniMatcher.group(1)); // almacena en numeroDni el número del DNI introducido
			numeroDni = numeroDni % 23; // calcula el módulo 23 del número
			String letraDniCalculada = letrasDniValidas.substring(numeroDni,numeroDni+1); //almacena en letraDniCalculada la letra de la cadena LetrasDniValidas que coincide con el módulo 23 calculado anteriormente
			 
			return letraDniCalculada.equalsIgnoreCase(letraDni);// En caso de que la letra calculada coincida con la letra del DNI introducido							
		}
		else
			return false;
		}
	
	/**
	 * Comprueba que el nombre introducido sea válido usando expresiones regulares
	 * @param dni El nombre a comprobar
	 * @return True si es válido, false si no lo es
	 */
	public static boolean validaNombre(String nombre){		   
		Pattern pattern = Pattern.compile("(?i)^[a-záéíóú\\s,.]+$");
		return pattern.matcher(nombre).matches();		
	}
	
	//toString
	
	@Override
	public String toString() {
		return dni + ", " + nombre + ", " + direccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
	

}
