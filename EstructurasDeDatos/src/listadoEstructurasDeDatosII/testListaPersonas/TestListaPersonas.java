package listadoEstructurasDatosII.testListaPersonas;

import java.util.ArrayList;
import java.util.ListIterator;

public class TestListaPersonas {

	public static void main(String[] args) {		
		
		ArrayList<Persona> listaPersonas = crearListaPersonas();		
		
		añadirPersonasALaLista(listaPersonas);
		mostrarLista(listaPersonas);
		eliminarUltimoLista(listaPersonas);
		mostrarLista(listaPersonas);
		eliminarPrimeroLista(listaPersonas);
		mostrarLista(listaPersonas);					
	}
	
	/**
	 * Crea una lista de personas
	 * @return la lista de personas
	 */
	static ArrayList<Persona> crearListaPersonas(){
		ArrayList<Persona> listaPersonas = new ArrayList<Persona>();		
		return listaPersonas;
	}
	
	/**
	 * Añade tres personas a la lista
	 * @param ArrayList<Persona> listaPersonas La lista con la que trabaja el método
	 */
	static void añadirPersonasALaLista(ArrayList<Persona> listaPersonas){
		listaPersonas.add(new Persona("Lucas", "Márquez", "Muñoz"));
		listaPersonas.add(new Persona("Miguel Angel", "López", "Moyano"));
		listaPersonas.add(new Persona("Dani", "LoSiento", "NoMeLosSé"));		
	}
	
	/**
	 * Muestra la lista
	 * @param ArrayList<Persona> listaPersonas La lista con la que trabaja el método
	 */
	static void mostrarLista(ArrayList<Persona> listaPersonas){
		ListIterator<Persona> listIterator = listaPersonas.listIterator();
		System.out.println("\nLista actualizada de personas: ");
		while(listIterator.hasNext()){
			//Object object = iterator.next();
			System.out.println(listIterator.next());
		}		
	}
	
	/**
	 * Elimina el último elemento de la lista
	 * @param ArrayList<Persona> listaPersonas La lista con la que trabaja el método
	 */
	static void eliminarUltimoLista(ArrayList<Persona> listaPersonas){
		System.out.println("\nAdiós " + listaPersonas.get(listaPersonas.size() - 1));		
		listaPersonas.remove(listaPersonas.get(listaPersonas.size() - 1));
	}
	
	/**
	 * Elimina el primer elemento de la lista
	 * @param ArrayList<Persona> listaPersonas La lista con la que trabaja el método
	 */
	static void eliminarPrimeroLista(ArrayList<Persona> listaPersonas){
		System.out.println("\nAdiós " + listaPersonas.get(0));		
		listaPersonas.remove(0);
	}	
}
