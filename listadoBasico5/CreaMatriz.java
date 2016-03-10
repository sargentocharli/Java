import utiles.*;
/**
* Crea una clase CreaMatriz que solicite al usuario el tamaño de una nueva matriz y que
* le pida los enteros necesarios para inicializarlo. Utiliza los métodos pedirFila(),
* pedirColumna() y pedirDatos(int[])
*/
public class CreaMatriz{
	public static void main(String[] args){
		int[][] matriz=new int[pedirFila()][pedirColumna()];
		pedirDatos(matriz);
		mostrar(matriz, "La matriz con los datos introducidos por el usuario es: ");
	}
	/**
	* Pide el número de filas que tendrá la matriz al usuario
	* @return el número de filas
	*/
	static int pedirFila(){
		int fila;
		do{
			fila=Teclado.leerEntero("Introduzca el número de filas que tendrá la matriz: ");
			if(fila<1)
				System.out.println("Error. El número menor de filas que puede tener una matriz es 1.");
		} while(fila<=1);
		return fila;
	}
	/**
	* Pide el número de columnas que tendrá la matriz al usuario
	* @return el número de columnas
	*/
	static int pedirColumna(){
		int columna;
		do{
			columna=Teclado.leerEntero("Introduzca el número de columnas que tendrá la matriz: ");
			if(columna<1)
				System.out.println("Error. El número menor de columnas que puede tener una matriz es 1.");
		} while(columna<=1);
		return columna;
	}
	/**
	* Introduce los elementos dados por el usuario en la matriz
	* @param matriz: La matriz que se va a rellenar de elementos
	*/
	static void pedirDatos(int[][] matriz){
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++)
				matriz[i][j]=Teclado.leerEntero("Introduzca el valor del elemento [" + i + "][" + j + "]: ");
		}
	}
	/**
	* Muestra la matriz que recibe
	* @param matriz: La matriz que recibe
	* @param: msj: El nombre de la matriz
	*/
	static void mostrar(int[][] matriz, String msj){
		System.out.println(msj);
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[0].length;j++)
				System.out.print("\t" + matriz[i][j]);			
			System.out.println("\n");
		}
	}
}