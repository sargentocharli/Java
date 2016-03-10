import utiles.*;
/**
* Crea una clase MínimoMatriz que solicite al usuario el tamaño de una nueva matriz y
* que la inicialice con valores aleatorios (solicita al usuario el mínimo y el máximo de los
* valores). Hallará el valor mínimo de una matriz, dando exactamente su posición filacolumna.
* Utiliza los métodos pedirFila(), pedirColumna(), pedirMínimo(),
* pedirMaximo, mostrarMatriz(), mostrarMínimo() ;

*/
public class MinimoMatriz{
	public static void main(String[] args){
		double[][] matriz=new double[pedirFila()][pedirColumna()];
		double minimo=pedirMinimo();
		double maximo=pedirMaximo(minimo);
		inicializarMatrizAleatoriamente(matriz, minimo, maximo);
		mostrar(matriz, "La matriz es: ");
		mostrarMinimo(matriz);
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
	* Pide el valor mínimo que tomarán los elementos de la matriz al usuario
	* @return minimo: El valor mínimo que tomarán los elementos de la matriz
	*/
	static double pedirMinimo(){
		double minimo;		
			return minimo=Teclado.leerEntero("Introduzca el valor mínimo que pueden tener los elementos de la matriz: ");			
	}
	/**
	* Pide el valor maximo que tomarán los elementos de la matriz al usuario
	@ param minimo: El valor mínimo para comparar con el máximo e impedir que sea este último menor
	* @return maximo: El valor maximo que tomarán los elementos de la matriz
	*/
	static double pedirMaximo(double minimo){
		double maximo;
		do{
			maximo=Teclado.leerEntero("Introduzca el valor máximo que pueden tener los elementos de la matriz: ");
			if(maximo<minimo)
				System.out.println("Error. El valor máximo no puede ser inferior al mínimo");
		} while(maximo<minimo);
		return maximo;
	}
	/**
	* Crea una matriz de enteros con elementos generados aleatoriamente
	* @param matriz: La matriz que se va a generar
	*/
	static void inicializarMatrizAleatoriamente(double[][] matriz, double minimo, double maximo){
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++)
				matriz[i][j]=(Math.random()*(minimo-maximo)+maximo);
		}
	}
	/**
	* Muestra la matriz que recibe
	* @param matriz: La matriz que recibe
	* @param: msj: El nombre de la matriz
	*/
	static void mostrar(double[][] matriz, String msj){
		System.out.println(msj);
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[0].length;j++)
				System.out.printf("%-3s %1.2f %-3s","",matriz[i][j],"");		
			System.out.println("\n");
		}
	}
	/**
	* Halla el mínimo valor de la matriz
	* @param matriz: La matriz con la que va a trabajar
	*/
	static void mostrarMinimo(double[][] matriz){
		double minimo=matriz[0][0];
		int fila=0;
		int columna=0;
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++){
				if(matriz[i][j]<minimo){
					minimo=matriz[i][j];
					fila=i;
					columna=j;
				}
			}
		}
		System.out.println("El elemento de menor valor está en la posición [" + fila + "][" + columna + "] y vale " + minimo);
	}
}