package listadoEstructurasDatosIII.cola;

import java.util.ArrayList;

public class Cola<T> {
	
	ArrayList<T> cola = null;
	
	Cola(){
		this.cola = new ArrayList<T>();
	}
	
	/**
	 * Añade un elemento al final de la cola
	 * @param elemento El elemento que se va a añadir
	 */
	void push(T elemento){
		cola.add(elemento);
	}
	
	/**
	 * Devuelve y elimina el primer elemento de la cola
	 * @return null en caso de que la cola esté vacía. El último elemento de la cola en caso contrario
	 */
	T pop(){
		if(cola.size()==0)
			return null;
		return cola.remove(0);
	}
	
	/**
	 * Devuelve el primer elemento de la cola
	 * @return null en caso de que la cola esté vacía. El último elemento de la cola en caso contrario
	 */	
	T head(){
		if(cola.size()==0)
			return null;
		return cola.get(0);
	}	
}

