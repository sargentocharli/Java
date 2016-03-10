/**
* Define la clase Notas que almacene en un array 15 notas. Las notas se inicializarán de
* forma aleatoria con enteros entre 0 y 10. Se visualizarán las notas resultantes.
*/
public class Notas{
	public static void main(String[]args){
		int[] vector= new int[15];
		inicializarVector(vector);
		mostrarNotas(vector);
	}
	/**
	* Inicializa el vector con valores aleatorios enteros entre 0 y 10
	* @param vector: El vector a inicializarVector
	*/
	static void inicializarVector(int[] vector){
		int minimo=0;
		int maximo=10;
		for( int i=0;i<vector.length;i++){
			
			vector[i]=(int)((Math.random()*(minimo-maximo)+maximo));
		}
	}
	
	static void mostrarNotas(int[]vector){
		for(int i=0;i<vector.length;i++){
			System.out.println("Valor del elemento en el índice [" + i + "]" + " es " + vector[i]);
		}
	}
	
}