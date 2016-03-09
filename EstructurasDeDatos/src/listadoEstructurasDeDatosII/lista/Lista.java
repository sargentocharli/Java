package listadoEstructurasDatosII.lista;

import java.util.ArrayList;
import java.util.Iterator;

public class Lista {

	private ArrayList<Videojuego> listaVideojuegos = new ArrayList<Videojuego>();	
	
	ArrayList<Videojuego> listaCopiada;
	
	/**
	 * Añade un videojuego al final de la lista	 * 
	 * @param titulo El título del videojuego
	 * @param genero El género del videojuego
	 */
	void annadirAlFinal(String titulo, String genero){
		listaVideojuegos.add(new Videojuego(titulo, genero));
	}
	
	/**
	 * Inserta un videojuego en la posición indicada
	 * @param titulo El título del videojuego
	 * @param genero El género del videojuego
	 * @param posicion La posición en la que se insertará el nuevo videojuego
	 */
	 void insertarEnPosicion(String titulo, String genero, int posicion){
		listaVideojuegos.add(posicion, new Videojuego(titulo, genero));		
	}
	
	/**
	 * Modifica un videojuego reemplazándolo por otro nuevo
	 * @param titulo El título del videojuego
	 * @param genero El género del videojuego
	 * @param posicion La posición en la que se insertará el nuevo videojuego(eliminando el que ya había en dicha posición)
	 */
	 void modificar(String titulo, String genero, int posicion){
		listaVideojuegos.set(posicion, new Videojuego(titulo, genero));
	}
	
	/**
	 * Devuelve el tamaño de la lista
	 */
	 int size(){
		return listaVideojuegos.size();
	}
	
	/**
	 * Elimina el videojuego que ocupe la posición indicada por el usuario
	 * @param posicion La posición en la que se eliminará el videojuego
	 */
	 void eliminar(int posicion){
		listaVideojuegos.remove(posicion);
	}
	
	/**
	 * Busca un videojuego según la cadena introducida
	 * @param busqueda La cadena introducida
	 */
	 void buscar(String busqueda){
		 boolean encontrado = false;
		 for(Iterator<Videojuego> it = listaVideojuegos.iterator();it.hasNext();){
			 if(it.next().titulo.equals(busqueda)){
				 
				 System.out.println("Juego encontrado: " + busqueda);
			 	encontrado = true;
			 }			 
		 }
		 if(!encontrado)
			 System.out.println("No se han encontrado coincidencias para: " + busqueda);
	}

	@Override
	public String toString() {
		return "Lista [listaVideojuegos=" + listaVideojuegos + "]";
	}
	
	/**
	 * Crea una lista nueva copiando los datos de la lista pasada
	 */
	ArrayList<Videojuego> copiar(){
		listaCopiada = new ArrayList<Videojuego>(listaVideojuegos);
		return listaCopiada;
		
	}	
}
