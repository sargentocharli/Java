import utiles.*;
/**
* Crea una clase MediaDelVector que cree un vector con enteros aleatorios y muestre la
* media del vector. Para ello, implementa los métodos pedirDimension(),
* inicializarVectorAleatoriamente(int[], min, max) y hallarMedia(int[]).
*/
public class MediaDelVector{
	public static void main(String[] args){
		int[] vector;
		vector = new int[pedirDimension()];
		pedirDatos(vector);
		mostrar(vector, "Después de pedir los datos: ");
		hallarMedia(vector);
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
		int minimo,maximo;
		do{
			minimo = Teclado.leerEntero("Introduzca el valor mínimo que pueden tomar los elementos del vector: ");
			maximo = Teclado.leerEntero("Introduzca el valor máximo que pueden tomar los elementos del vector: ");
		} while(maximo < minimo);
		for(int i=0; i<vector.length;i++)
			vector[i]=(int)((Math.random()*(minimo-maximo))+maximo);
	}
		
	/**
	* Muestra el vector recibido por pantalla
	* @param vector: El vector a mostrar
	* @param msj: El mensaje a mostrar
	*/
	static void mostrar(int[] vector, String msj){
	System.out.println("Valores de los elementos del vector:");
	for(int i=0; i<vector.length;i++)
		System.out.println(vector[i]);
	}
	/**
	* Halla la media del vector recibido
	* @param vector: El vector con el que trabaja el métodos
	*/
	static void hallarMedia(int[] vector){
		double acumulador=0;
		for(int i=0;i<vector.length;i++)
			acumulador+=vector[i];
			double media=acumulador/vector.length;
		System.out.println("La media del vector vale " + media);
	}
}