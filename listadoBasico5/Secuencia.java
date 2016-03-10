import utiles.*;
/**
* Define la clase Secuencia que busque la secuencia en orden creciente (<=) más larga
* dentro de un vector de enteros inicializado aleatoriamente (Math.random()). Se
* mostrará tanto la posición de la primera componente de la secuencia como el tamaño
* de la misma.
*/
public class Secuencia{
	public static void main(String[] args){
		int longitudSecuenciaPosible=1;
		int posicionInicialPosible;
		int longitudSecuenciaDefinitiva=1;
		int posicionInicialDefinitiva=0;
		int vector[]=new int[pedirDimension()];
		inicializarVectorAleatoriamente(vector);
		mostrar(vector, "El vector tiene los siguientes elementos: ");
		for(int i=1;i<vector.length-1;i++){
			if(vector[i-1]==vector[i]){
				posicionInicialPosible=i-1;
				longitudSecuenciaPosible++;
				if(longitudSecuenciaPosible>longitudSecuenciaDefinitiva){
					posicionInicialDefinitiva=posicionInicialPosible;
					longitudSecuenciaDefinitiva=longitudSecuenciaPosible;
				}
			}
			else
				longitudSecuenciaPosible=1;				
		}
		if(longitudSecuenciaDefinitiva>1){
			System.out.println("La longitud de la secuencia más larga es de: " + longitudSecuenciaDefinitiva);
			System.out.println("La posición del primer componente es: " + posicionInicialDefinitiva);
		}
		else
			System.out.println("No hay ninguna secuencia en el vector.");
	}
	/**
	* Pide al usuario el tamaño que va a tener el vector
	* @return dimension: El tamaño del vector
	*/
	static int pedirDimension(){
		int dimension;
		do{
			dimension=Teclado.leerEntero("Introduzca el tamaño del vector: ");
			if (dimension<1)
				System.out.println("Error. El tamaño tiene que ser mayor de cero.");
		} while(dimension<1);
		return dimension;
	}
	/**
	* Inicializa el vector recibido con valores enteros aleatorios
	* @param vector: El vector que recibe
	*/
	static void inicializarVectorAleatoriamente(int[] vector){
		int minimo=0;
		int maximo=10;
		for(int i=0;i<vector.length;i++)
			vector[i]=(int)((Math.random()*(minimo-maximo))+maximo);
	}
	/**
	* Muestra el vector recibido por pantalla
	* @param vector: El vector a mostrar
	* @param msj: El mensaje a mostrar
	*/
	static void mostrar(int[] vector, String msj){
	System.out.println(msj);
	for(int i=0; i<vector.length;i++)
		System.out.println(vector[i]);
	}
}
