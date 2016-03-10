/**
* Crea una clase DelReves que implemente el método mostrarDelReves(int []). Se le
* pasará como argumento un vector de enteros inicializado mediante llaves. Mostrará
dicho vector del revés.
*/

public class DelReves{
	public static void main(String[] args){
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		mostrarDelReves(array);
	}
	/**
	* Recibe un array y lo muestra por pantalla del revés
	* @param array: El array con el que trabaja el método
	*/
	static void mostrarDelReves(int[] array){
		for(int i=array.length-1;i>=0;i--)
			System.out.println(array[i]);	
	}
}