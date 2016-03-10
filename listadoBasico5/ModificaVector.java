import utiles.*;
/**
* Define la clase ModificaVector. Realizará las siguientes opciones:
* a. Creará un vector con la dimensión indicada por el usuario.
* b. Inicializará con valores consecutivos (1, 2, 3…).
* c. Después se solicitará al usuario un elemento del array (entre 1 y longitud) y su
* nuevo valor para modificarlo.
* d. Este proceso de modificación de un elemento se repetirá tantas veces como
* quiera el usuario (¿quiere modificar otro(s/n)?)
* e. Al acabar, se visualizarán el array ya modificado.
*/
public class ModificaVector{
	public static void main(String[] args){
	int[] vector=new int[pedirDimension()];
	inicializarVector(vector);
	mostrar(vector, "Valores iniciales del vector: ");
		do{
			pedirElemento(vector);
		} while (continuar());
	mostrar(vector, "Valores del vector tras las modificaciones: ");	
	}
	/**
	* Pregunta al usuario si desea continuar pidiendo un caracter (s/n)
	* @return True si la respuesta es "s" o "S" y false en el resto de casos
	*/
	static boolean continuar(){
		char respuesta = Teclado.leerCaracter("¿Desea continuar? (s/n): ");
		if (respuesta == 's' || respuesta == 'S')
			return true;
		else
			return false;
	}
	/**
	* Pide al usuario el tamaño del nuevo vector
	* @return longitudVector: El tamaño del nuevo vector
	*/
	static int pedirDimension(){
	int longitudVector = Teclado.leerEntero("Introduzca el tamaño del vector: ");
	return longitudVector;
	 }
	/**
	* Inicializa un vector con valores consecutivos
	* @param vector: El vector con el que trabaja el método
	*/
	static void inicializarVector(int[] vector){
		for(int i=0;i<vector.length;i++)
			vector[i]=i+1;
	}
	/**
	* Pide al usuario un elemento del vector y el valor nuevo de dicho elemento
	* @param vector: El vector con el que trabaja el método
	*/
	static void pedirElemento(int[] vector){
		int elemento;
		int auxiliar=0;
		do{
			elemento=Teclado.leerEntero("Indique el elemento del vector que desea modificar: ");
			auxiliar=elemento;
		} while(auxiliar<0 || auxiliar>vector.length);
		int nuevoValor=Teclado.leerEntero("Indique el nuevo valor de la posición " + elemento + " del vector");
		vector[elemento-1]=nuevoValor;
	}
	static void mostrar(int[] vector, String msj){
		System.out.println(msj);
		for(int i=0; i<vector.length;i++)
			System.out.println(vector[i]);
	}
}
		