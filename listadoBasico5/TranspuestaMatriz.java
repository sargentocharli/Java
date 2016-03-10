import utiles.*;
/**
* Define la clase TraspuestaMatriz que invierta una matriz de enteros. Se piden las
* dimensiones y toma valores aleatorios entre 1 y 10.
* Matriz:
*  1 2 10 9 7 7 9
*  7 5 4 4 1 1 6
*  8 6 7 8 10 6 1
*  5 7 8 9 6 2 2
* Resultado:
*  1 7 8 5
*  2 5 6 7
*  10 4 7 8
*  9 4 8 9
*  7 1 10 6
*  7 1 6 2
*  9 6 1 2
*/
public class TranspuestaMatriz{
	public static void main(String[]args){
	
	int filas=pedirDimension("Dame las filas: ");
	int columnas=pedirDimension("Dame las columnas: ");
	int[][] matriz=new int[filas][columnas];	
	mostrar(matriz, "La matriz inicial sin valores es: ");
	int[][] matrizInvertida=new int[columnas][filas];
	mostrar(matrizInvertida, "La matriz invertida sin valores es: ");
	inicializarMatrizAleatoriamente(matriz);
	mostrar(matriz, "La matriz inicial con valores es: ");
	matrizTraspuesta(matriz, matrizInvertida);
	mostrar(matrizInvertida, "La matriz invertida es: ");
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
	* Traspone una matriz (cambia filas por columnas)
	* @param matriz: La matriz con la que va a trabajar
	*/
	static void matrizTraspuesta(int[][] matriz, int[][]matrizInvertida){
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++)
				matrizInvertida[j][i]=matriz[i][j];
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
	