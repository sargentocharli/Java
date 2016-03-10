import utiles.*;
/**
* Define la clase MatrizDecimales que cree una matriz de decimales. Pide las
* dimensiones (filas y columnas). Se inicializa con valores aleatorios entre 1 y 100 y
* visualiza el array
*/
public class MatrizDecimales{
	public static void main(String[] args){
		double[][] matriz = new double[pedirDimension("Dame las filas: ")][pedirDimension("Dame las columnas: ")]; 
		inicializarMatrizAleatoriamente(matriz);
		mostrarMatriz(matriz);
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
	* Crea una matriz de decimales con elementos generados aleatoriamente
	* @param matriz: La matriz que se va a generar
	*/
	static void inicializarMatrizAleatoriamente(double[][] matriz){
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++)
				matriz[i][j]=(Math.random()*100);
		}
	}
	/**
	* Muestra la matriz
	* @param matriz: La matriz que se va a mostrarMatriz
	*/
	static void mostrarMatriz(double[][] matriz){
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++)
				System.out.printf("%-3s %1.2f %-3s","",matriz[i][j],"");
		System.out.println("\n");
		}
	}
}
		