import utiles.*;
/**
* Define la clase MatrizDecimales2 basada en la clase anterior. Se ha de inicializar con
* valores aleatorios (solicita al usuario el mínimo y el máximo de los valores). Ha de
* localizar los valores máximo, mínimo y media de la matriz. Que muestre tanto los
* valores como la posición que ocupan en la matriz. Utiliza los métodos pedirFila(),
* pedirColumna(), pedirMínimo(), pedirMaximo(), crearMatriz(),
* mostrarMatriz(double[][]), hallarMedia(double[][]) ;
*/
public class MatrizDecimales2{
	public static void main(String[] args){
		double[][] matriz = new double[pedirDatos("Dame las filas: ")][pedirDatos("Dame las columnas: ")]; 
		inicializarMatrizAleatoriamente(matriz, pedirDatos("Dame el valor mínimo posible: "), pedirDatos("Dame el valor máximo posible: "));
		mostrarMatriz(matriz);
		hallarMaximo(matriz);
		hallarMinimo(matriz);
		hallarMedia(matriz);
	}
	/**
	* Pide datos al usuario para que los introduzca por teclado
	* @param msj: Un mensaje especificando el dato que se pide
	* @return dato: El valor del dato introducido por el usuario
	*/
	static int pedirDatos(String msj){
		int dato;
		do{
			dato=Teclado.leerEntero(msj);
			if(dato<=0)
				System.out.println(" Error. La dimensión mínima aceptada es 1.");
		} while(dato<=0);
		return dato;
	}
	/**
	* Crea una matriz de decimales con elementos generados aleatoriamente
	* @param matriz: La matriz que se va a generar
	*/
	static void inicializarMatrizAleatoriamente(double[][] matriz, int minimo, int maximo){
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++)
				matriz[i][j]=(Math.random()*(minimo-maximo)+maximo);
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
	/**
	* Halla el máximo valor de la matriz
	* @param matriz: La matriz con la que va a trabajar
	*/
	static void hallarMaximo(double[][] matriz){
		double maximo=matriz[0][0];
		int fila=0;
		int columna=0;
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++){
				if(matriz[i][j]>maximo)
					maximo=matriz[i][j];{
					fila=i;
					columna=j;
					}
			}
		}
		System.out.println("El elemento de mayor valor está en la posición [" + fila + "][" + columna + "] y vale " + maximo);
	}
	/**
	* Halla el mínimo valor de la matriz
	* @param matriz: La matriz con la que va a trabajar
	*/
	static void hallarMinimo(double[][] matriz){
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
	/**
	* Halla la media de los valores de la matriz
	* @param matriz: La matriz con la que va a trabajar
	*/
	static void hallarMedia(double[][] matriz){
		double media=0;
		int contador=0;
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++){
				media+=matriz[i][j];
				contador++;
			}
		}
		System.out.println("La media de la matriz vale " + media/contador);
	}
}