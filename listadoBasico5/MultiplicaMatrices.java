import utiles.*;
/**
* Define la clase MultiplicaMatrices que multiplique dos matrices de enteros. El usuario
* introducirá por teclado las dimensiones de las matrices (m x n, n x o). Las matrices se
* inicializarán de forma aleatoria con enteros entre 1 y 10. Se visualizarán factores y
* resultado.
*/
public class MultiplicaMatrices{
	public static void main(String[] args){
		int filasMatriz1=pedirDimension("Dame las filas de la matriz 1: ");
		int columnasMatriz1FilasMatriz2=pedirDimension("Dame las filas de la matriz 1(para poder multiplicar matrices, esta dimensión será la misma que la del número de filas de la matriz 2): ");
		int columnasMatriz2=pedirDimension("Dame las columnas de la matriz 2: ");
		int[][] matriz1=new int[filasMatriz1][columnasMatriz1FilasMatriz2];
		int[][] matriz2=new int[columnasMatriz1FilasMatriz2][columnasMatriz2];
		int[][] matrizResultado=new int[filasMatriz1][columnasMatriz2];
		inicializarMatrizAleatoriamente(matriz1);
		mostrar(matriz1, "La primera matriz es: ");
		inicializarMatrizAleatoriamente(matriz2);
		mostrar(matriz2, "La segunda matriz es: ");
		multiplicarMatrices(matriz1, matriz2, matrizResultado);
		mostrar(matrizResultado, "La matriz resultado de multiplicar las dos matrices anteriores es: ");
	}
	/**
	* Pide las dimensiones de la matriz al usuario
	* @param msj: Un mensaje especificando la dimensión que se pide
	* @return dimension: La dimensión introducida por el usuario
	*/
	static int pedirDimension(String msj){
		int dimension;
		do{
			dimension=Teclado.leerEntero(msj);
			if(dimension<=0)
				System.out.println(" Error. La dimensión mínima aceptada es 1.");
		} while(dimension<=0);
		return dimension;
	}
	/**
	* Crea una matriz de enteros con elementos generados aleatoriamente
	* @param matriz: La matriz que se va a generar
	*/
	static void inicializarMatrizAleatoriamente(int[][] matriz){
		int minimo=0;
		int maximo=10;
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++)
				matriz[i][j]=(int)((Math.random()*(minimo-maximo)+maximo));
		}
	}
	/**
	* Multiplica las dos matrices recibidas
	* @param matriz1: La primera matriz a multiplicar
	* @param matriz2: La segunda matriz a multiplicar
	* @param matrizResultado: La matriz en la que se almacenará el resultado de la multiplicación
	*/
	static void multiplicarMatrices(int[][] matriz1, int[][] matriz2, int[][] matrizResultado){
		for(int i=0;i<matrizResultado.length;i++){
			for(int j=0;j<matrizResultado[i].length;j++){
				for(int k=0;k<matriz1[0].length;k++)
					matrizResultado[i][j]+=matriz1[i][k]*matriz2[k][j];
			}
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