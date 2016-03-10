import utiles.*;
/**
* Crea una clase CreaVector que solicite al usuario el tamaño de un nuevo vector y que
* le pida los enteros necesarios para inicializarlo. Utiliza los métodos pedirDimension() y
* pedirDatos(int[]).
*/

public class CreaVector{
	public static void main(String[] args){
		int[] vector;
		vector = new int[pedirDimension()];
		pedirDatos(vector);
		mostrar(vector, "Después de pedir los datos: ");
	}
	/**
	* Pide al usuario el tamaño del nuevo vector
	* @return dimension: El tamaño del nuevo vector
	*/
	static int pedirDimension(){
		int dimension;
		do{
			dimension = Teclado.leerEntero("Introduzca el tamaño del vector: ");	
		} while(dimension<=0);
		return dimension;
	}
	/**
	* Pide los valores necesarios para inicializar el vector y lo inicializa
	* @param dimension: El tamaño del nuevo vector
	*/
	static void pedirDatos(int [] vector){
		for(int i=0; i<vector.length;i++)
			vector[i]=Teclado.leerEntero("Valor del vector en el índice (" + i + ")");
	}
		
	/**
	* Muestra el vector recibido por pantalla
	* @param vector: El vector a mostrar
	*/
	static void mostrar(int[] vector, String msj){
	System.out.println("Valores de los elementos del vector:");
	for(int i=0; i<vector.length;i++)
		System.out.println(vector[i]);
	}
}