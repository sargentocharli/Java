package listadoEstructurasDatosIII.pila;

import java.util.ArrayList;

public class Pila<T> {
	
	ArrayList<T> pila = null;
	
	Pila(){
		this.pila = new ArrayList<T>();
	}
	
	/**
	 * Añade un elemento al final de la pila
	 * @param elemento El elemento que se va a añadir
	 */
	void push(T elemento){
		pila.add(elemento);
	}
	
	/**
	 * Devuelve y elimina el último elemento de la pila
	 * @return null en caso de que la pila esté vacía. El último elemento de la pila en caso contrario
	 */
	T pop(){
		if(pila.size()==0)
			return null;
		return pila.remove(pila.size() - 1);
	}
	
	/**
	 * Devuelve el último elemento de la pila
	 * @return null en caso de que la pila esté vacía. El último elemento de la pila en caso contrario
	 */
	
	T top(){
		if(pila.size()==0)
			return null;
		return pila.get(pila.size() - 1);
	}
}
