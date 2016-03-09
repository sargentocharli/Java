package concesionario;

import java.util.ArrayList;

/**
 * 
 * @author d15mamul
 *
 */

public class Concesionario {
	
	/**
	 * ArrayList de coches
	 */
	private ArrayList<Coche> concesionario = null;
	
	/**
	 * Constructor del ArrayList<Coche>
	 */
	Concesionario(){
		concesionario = new ArrayList<Coche>();
	}
	
	/**
	 * Comprueba si existe un coche en el concesionario con la matrícula pasada
	 * @param matricula La matrícula del coche a comprobar
	 * @return El coche en caso de exista
	 * @throws MatriculaNoValidaException 
	 */
	Coche buscarCoche(Coche coche) throws MatriculaNoValidaException{
		try{		
		return concesionario.get(concesionario.indexOf(coche));
		}catch (ArrayIndexOutOfBoundsException e){
		throw new MatriculaNoValidaException("Error. No hay coches en el concesionario con esa matrícula.");
		}			
	}
	
	/**
	 * Añade un coche, en caso de que sea válido, al concesionario
	 * @param coche El coche que va a añadirse
	 */
	void annadirCoche(Coche coche) throws YaExisteCocheException{
		if(concesionario.contains(coche))
			throw new YaExisteCocheException("Error. El coche ya está en el concesionario.");
		concesionario.add(coche);
		
	}
	
	/**
	 * Elimina un coche, en caso de que sea válido, del concesionario
	 * @param coche El coche que se va a eliminar
	 */
	void eliminarCoche(Coche coche) throws MatriculaNoValidaException{
		if(!concesionario.contains(coche))
			throw new MatriculaNoValidaException("Error. No hay coches en el concesionario con esa matrícula.");
		concesionario.remove(coche);		
	}
	
	/**
	 * Devuelve el número total de coches que hay en el concesionario
	 */
	int cuentaCoches(){
		return concesionario.size();
	}
	
	/**
	 * Crea un arrayList, lo rellena con los coches que contengan el color pasado y lo devuelve
	 * @param color El color pasado
	 */
	ArrayList<Coche> getCochesMismoColor(Color color){
		ArrayList<Coche> arrayListCochesMismoColor = new ArrayList<Coche>();
		for(Coche coche : concesionario){
			if(coche.getColor()== color)
				arrayListCochesMismoColor.add(coche);
		}
		return arrayListCochesMismoColor;
	}
	
	@Override
	public String toString() {
		return "Concesionario [concesionario=" + concesionario + "]";
	}		
	
}
