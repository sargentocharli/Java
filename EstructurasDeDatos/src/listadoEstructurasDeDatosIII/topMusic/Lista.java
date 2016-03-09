package listadoEstructurasDatosIII.topMusic;

import java.util.ArrayList;
import java.util.Collections;

public class Lista{
	
	private ArrayList<Cancion> lista = null;
	
	
	Lista(){
		lista = new ArrayList<Cancion>();
	}

	/**
	 * Añade un elemento al final de la lista
	 * @param T element El elemento que se va a añadir
	 */
	void addLista(Cancion element){
		lista.add(null);
	}
	
	/**
	 * Añade un elemento en la posición indicada
	 * @param T element El elemento que va a añadirse
	 * @param posicion La posición en la que se va a añadir el elemento
	 */
	void annadir(String titulo, String artista, int annoGrabacion, int posicion) throws 
					TituloNoValidoException, ArtistaNoValidoException, AnnoGrabacionNoValidoException,PosicionNoValidaException{
		try{
			Cancion cancion = new Cancion(titulo, artista, annoGrabacion);
			lista.add(posicion, cancion);
		} catch(IndexOutOfBoundsException e){
		throw new PosicionNoValidaException("Error. La posición no es válida.");
		}
	}
	
	/**
	 * Elimina un elemento de la posición indicada
	 * @param posicion La posición cuyo elemento va a ser eliminado
	 */
	Cancion sacar(int posicion) throws PosicionNoValidaException{
		try{
		return lista.remove(posicion);
		} catch(IndexOutOfBoundsException e){
			throw new PosicionNoValidaException("Error. La posición no es válida.");
		}
	}
	
	/**
	 * Sube un puesto un elemento de la lista
	 * @param posicion La posición del elemento que va a retroceder un puesto
	 */
	void subir(int posicion) throws PosicionNoValidaException{
		try{
			int posicion1 = lista.indexOf(lista.get(posicion)); // posición del elemento que va a retroceder un puesto
			int posicion2 = posicion1 - 1;	// posición del elemento anterior al elemento que avanza un puesto
			Collections.swap(lista, posicion1, posicion2);	// cambia dos elementos de posición entre sí	
		} catch(IndexOutOfBoundsException e){
			throw new PosicionNoValidaException("Error. La posición no es válida.");
		}
	}
	
	/**
	 * Baja un puesto un elemento de la lista
	 * @param posicion La posición del elemento que va a avanzar un puesto
	 * @throws PosicionNoValidaException 
	 */
	void bajar(int posicion) throws PosicionNoValidaException{
		try{
			int posicion1 = lista.indexOf(lista.get(posicion));
			int posicion2 = posicion1 + 1;
			Collections.swap(lista, posicion1, posicion2);		
		} catch(IndexOutOfBoundsException e){
			throw new PosicionNoValidaException("Error. La posición no es válida.");
		}
	}
	
	/**
	 * Obtiene el primer elemento de la lista
	 * @return El primer elemento de la lista
	 */
	Cancion mostrarTop(){
		return lista.get(0);		
	}
	
	/**
	 * toString, modificar en cada aplicación particular de lista
	 */
	@Override
	public String toString() {
		if(lista.get(0)==null)
			return "Lista vacía\n";
		return "TopMusic\n" + lista + "\n ";
	}	
}
