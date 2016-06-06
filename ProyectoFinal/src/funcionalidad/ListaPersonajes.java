package funcionalidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import excepciones.ArmaNoValidaException;
import excepciones.FechaNoValidaException;
import excepciones.NombreNoValidoException;
import excepciones.PersonajeNoExisteException;
import excepciones.PersonajeYaExisteException;

/**
 * Clase lista de personajes
 * @author Lucas Márquez Muñoz
 * @version 1.0
 */
public class ListaPersonajes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Lista de personajes
	 */

	public ArrayList<Personaje> listaPersonajes = new ArrayList<Personaje>();

	/**
	 * Estado modificado de la lista de personajes
	 */
	private boolean modificado = false;

	/**
	 * Obtiene el estado modificado de la lista de personajes
	 * @return modificado El valor de modificado
	 */
	public boolean estaModificado() {
		return modificado;
	}

	/**
	 * Establece el estado modificado de la lista de personajes
	 * @param modificado El estado de modificado
	 */
	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}

	/**
	 * Añade un personaje no existente a la lista
	 * 
	 * @param nombre El nombre del personaje
	 * @param clase La clase del personaje
	 * @param arma El arma del personaje
	 * @param armadura La armadura del personaje
	 * @param nacimiento El año de nacimiento del  personaje
	 * @throws PersonajeYaExisteException Excepción personaje ya existe
	 * @throws NombreNoValidoException Excepción nombre no válido
	 * @throws ArmaNoValidaException Excepción arma no válida
	 * @throws FechaNoValidaException Excepción fecha no válida
	 */
	public void annadir(String nombre, ClasesPersonaje clase, Arma arma, Armadura armadura, int nacimiento)
			throws PersonajeYaExisteException, NombreNoValidoException, ArmaNoValidaException, FechaNoValidaException {

		Personaje personaje;
		switch (clase) {

		case BRUJO:
			personaje = new Brujo(nombre, arma, armadura, nacimiento);
			
			break;
		case GUERRERO:
			personaje = new Guerrero(nombre, arma, armadura, nacimiento);			
			break;
		case MAGO:
			personaje = new Mago(nombre, arma, armadura, nacimiento);		
			break;
		default://picaro
			personaje = new Picaro(nombre, arma, armadura, nacimiento);
		}
		if (!listaPersonajes.contains(personaje))
			listaPersonajes.add(personaje);
		else
			throw new PersonajeYaExisteException("El personaje ya existe en este jugador. ");
		setModificado(true);
	}

	/**
	 * Elimina un personaje existente de la lista
	 * 
	 * @param nombre El nombre del personaje a borrar
	 * @throws NombreNoValidoException Excepción nombre no válido
	 */
	public void eliminar(String nombre) throws NombreNoValidoException {		
		listaPersonajes.remove(new Personaje(nombre));
		setModificado(true);		
	}

	/**
	 * Obtiene un personaje de la lista según su nombre
	 * @param nombre El nombre del personaje a buscar
	 * @return El pesonaje de la lista obtenido
	 * @throws PersonajeNoExisteException Excepción personaje no existe	 
	 */
	public Personaje getPersonaje(String nombre) throws PersonajeNoExisteException  {
		try {
			return listaPersonajes.get(listaPersonajes.indexOf(new Personaje(nombre)));
		} catch (Exception e) {
			throw new PersonajeNoExisteException("El personaje no existe."); 
		}	
	}

	/**
	 * Obtiene el índice de un personaje buscándolo por su nombre 
	 * @param nombre El nombre del personaje
	 * @return El índice en el que está el personaje obtenido
	 * @throws NombreNoValidoException Excepción nombre no válido
	 * @throws PersonajeNoExisteException Excepción personaje no existe
	 */
	public int getPersonajePosicion(String nombre) throws NombreNoValidoException, PersonajeNoExisteException {
		for (Personaje personaje : listaPersonajes) {
			if (personaje.getNombre().equals(nombre))
				return listaPersonajes.indexOf(personaje);
		}
		throw new PersonajeNoExisteException("El personaje no existe.");
	}

	/**
	 * Obtiene un personaje de la lista buscándolo por su índice 
	 * @param posicion El índice del personaje
	 * @return El personaje que está en el índice introducido
	 */
	public Personaje getPersonajeIndice(int posicion) {		
		return listaPersonajes.get(posicion);
	}

	/**
	 * Modifica un personaje de la lista
	 * 
	 * @param personajeModificado El personaje modificado
	 */
	public void modificar(Personaje personajeModificado) {
		listaPersonajes.set(listaPersonajes.indexOf(personajeModificado), personajeModificado);
		setModificado(true);
	}

	/**
	 * Devuelve la lista de personajes con todos los personajes 
	 * @return listaPersonajes La lista de personajes con todos los personajes
	 */
	public ArrayList<Personaje> getListaPersonajes() {
		return listaPersonajes;
	}

	/**
	 * Genera un array de personajes 
	 * @return cadena El array de personajes
	 */
	public String[] generarListaPersonajes() {
		String[] cadena = new String[listaPersonajes.size()];
		Iterator<Personaje> iterator = listaPersonajes.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			Personaje personaje = (Personaje) iterator.next();
			cadena[i] = personaje.toString();
			i++;
		}
		return cadena;
	}

	@Override
	public String toString() {
		return "ListaPersonajes [listaPersonajes=" + listaPersonajes + "]";
	}
}