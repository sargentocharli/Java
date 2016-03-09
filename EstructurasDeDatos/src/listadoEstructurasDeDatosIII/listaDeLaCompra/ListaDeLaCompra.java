package listadoEstructurasDatosIII.listaDeLaCompra;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaDeLaCompra {
	/**
	 * Lista de artículos
	 */
	private ArrayList<Articulo> lista=null;
	
	/**
	 * Constructor
	 */
	ListaDeLaCompra(){
		lista=new ArrayList<Articulo>();
	}
	
	/**
	 * Añade un artículo a la lista si no existe previamente
	 * @param articulo
	 * @return true si se añade y false si no se añade
	 */
	void anadir(Articulo articulo)throws YaExisteArticuloException{
			if(lista.contains(articulo))
				throw new YaExisteArticuloException("Ya existe este artículo.");
			else
				lista.add(articulo);		
	}	
	
	/**
	 * Elimina un artículo de la lista
	 * @param articulo
	 * @return true si se elimina
	 */
	boolean eliminar(Articulo articulo){
		return lista.remove(articulo);
	}
	
	/**
	 * Modifica la cantidad mínima de un artículo
	 * @param articulo
	 * @param cantidad
	 * @return true si se modifica y false si no
	 * @throws MinimoNoValidoException 
	 */
	void setCantidadMinima(Articulo articulo,int cantidad) throws MinimoNoValidoException, NoExisteArticuloException{
		try{
		articulo = lista.get(lista.indexOf(articulo));
		articulo.setMinimo(cantidad);
		} catch(ArrayIndexOutOfBoundsException e){
			throw new NoExisteArticuloException("No existe ese artículo.");
		}
	}
	
	/**
	 * Incrementa el número de existencias del artículo en la
	 * cantidad que se le indica (siempre que exista el artículo
	 * en la lista)
	 * @param articulo
	 * @param incremento
	 * @return true si se incrementa y false si no
	 * @throws ExistenciasNoValidasException 
	 */
	void incrementarExistencias(Articulo articulo, int incremento) throws ExistenciasNoValidasException, NoExisteArticuloException, IncrementoNoValidoException{
		try{
		articulo = lista.get(lista.indexOf(articulo));
		articulo.incrementar(incremento);
		} catch(ArrayIndexOutOfBoundsException e){
			throw new NoExisteArticuloException("No existe ese artículo.");
		}
	}
	
	/**
	 * Decrementa el número de existencias del artículo en la
	 * cantidad que se le indica (siempre que exista el artículo
	 * en la lista)
	 * @param articulo
	 * @param decremento
	 * @return true si se decrementa y false si no
	 * @throws ExistenciasNoValidasException 
	 * @throws DecrementoNoValidoException 
	 */
	void decrementarExistencias(Articulo articulo, int decremento) throws 
	ExistenciasNoValidasException, NoExisteArticuloException, DecrementoNoValidoException{
		try{
		articulo = lista.get(lista.indexOf(articulo));
		articulo.decrementar(decremento);
		} catch(ArrayIndexOutOfBoundsException e){
			throw new NoExisteArticuloException("No existe ese artículo.");
		}		
	}
	
	/**
	 * Genera la lista a partir de los artículos que no tienen la cantidad mínima
	 * @return cadena
	 */
	String generarListaDeLaCompra() throws ListaVaciaException{		
			if(lista.isEmpty()){
				throw new ListaVaciaException("La lista está vacía.");
			}
			else{
				String cadena = new String();
				Iterator<Articulo> iterator=lista.iterator();
				while (iterator.hasNext()) {
					Articulo articulo = (Articulo) iterator.next();
					if(articulo.porDebajoDelMinimo())
						cadena+="\n("+Integer.valueOf(articulo.getExistencias()
										- articulo.getMinimo())
										+ ") " + articulo.getNombre();		
				}
				return cadena;
			}
	}

	@Override
	public String toString(){
		return lista.toString();
	}
}
