import utiles.Teclado;
/** 
* Define la clase SumaMatrices que sume dos matrices de enteros. El usuario introducirá
* por teclado las dimensiones de las matrices (m x n). Las matrices se inicializarán de
* forma aleatoria con enteros entre 0 y 10. Se visualizarán sumandos y suma. Completa
* este esqueleto:
* import utiles.Teclado;
* public class SumaMatrices {
* public static void main(String[] args){
* 	int filas = pedirDimension("Dame las filas: ");
* 	int columnas = pedirDimension("Dame las columnas: ");
* 	int [][] sumando1= crearMatriz(filas, columnas);
* 	mostrar(sumando1, "MATRIZ 1: ");
* 	int [][] sumando2 = crearMatriz (filas, columnas);
* 	mostrar(sumando2, "MATRIZ 2: ");
* 	int [][] suma = sumar (sumando1, sumando2);
* 	mostrar(suma, "MATRIZ SUMA: ");
*/
public class SumaMatrices{
	public static void main(String[]args){
		int filas=pedirDimension("Dame las filas: ");
		int columnas=pedirDimension("Dame las columnas: ");
		int[][] sumando1=crearMatriz(filas, columnas);
		mostrar(sumando1, "MATRIZ 1: ");
		int[][] sumando2=crearMatriz(filas, columnas);
		mostrar(sumando2, "MATRIZ 2: ");
		int[][] suma=sumar(sumando1, sumando2);
		mostrar(suma, "MATRIZ SUMA: ");
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
	* Crea una matriz
	* @param filas: El número de filas que tendrá la matriz
	* @param columnas: El número de columnas que tendrá la matriz
	*/
	static int[][] crearMatriz(int filas, int columnas){
		int[][] matriz = new int[filas][columnas];
		for(int i=0;i<filas;i++){
			for(int j=0;j<columnas;j++)
				matriz[i][j]=(int)(Math.round(Math.random()*(0-10)+10));
		}
		return matriz;
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
	/**
	* Suma dos matrices
	* @param sumando1: La primera matriz
	* @param sumando2: La segunda matriz
	*/
	static int[][] sumar(int[][] sumando1, int[][] sumando2){
		int[][] suma = new int[sumando1.length][sumando1[0].length];
		for(int i=0;i<suma.length;i++){
			for(int j=0;j<suma[0].length;j++)
				suma[i][j]=sumando1[i][j] + sumando2[i][j];
		}
	return suma;
	}
}
	

