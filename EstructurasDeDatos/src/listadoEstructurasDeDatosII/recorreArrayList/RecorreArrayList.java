package listadoEstructurasDatosII.recorreArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class RecorreArrayList {
		
	private ArrayList<String> arrayList = new ArrayList<String>();
	
	RecorreArrayList(){	
		arrayList.add("gordo");
		arrayList.add("hamburguesa");
		arrayList.add("cama");
		arrayList.add("jazmín");
	}	
	
		void show(){
			System.out.println(arrayList);
		}
		
		/**
		 * Muestra el ArrayList mediante un iterador con el bucle while
		 */
		void showWithIterator(){
			Iterator<String> it = arrayList.iterator();
			
			while(it.hasNext())
				System.out.println("\t" + it.next());
		}
		
		/**
		 * Muestra el ArrayList mediante un iterador con el bucle for
		 */
		void showWithIterator2(){
			for(Iterator<String> it = arrayList.iterator(); it.hasNext();)
				System.out.println("\t" + it.next());
		}
		
		/**
		 * Muestra el ArrayList mediante un for clásico, accediendo mediante la posición (índices)
		 */
		void showWithGet(){
			for(int i = 0; i < arrayList.size(); i++)
				System.out.println("\t" + arrayList.get(i));
		}
		
		/**
		 * Muestra el ArrayList mediante un for mejorado
		 */
		void showWithForEach(){
			for(String elemento : arrayList)
				System.out.println("\t" + elemento);
		}	
		
		/**
		 * Muestra el array mediante un for clásico, accediendo mediante la posición (índices)
		 */
		void showInverseWithGet(){
			for(int i=arrayList.size()-1; i>=0; i--)
				System.out.println("\t" + arrayList.get(i));
		}
}
	
