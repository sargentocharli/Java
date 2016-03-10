import utiles.*;
/** 
* Define la clase CerosYUnos que lea una secuencia de ceros y unos. Mostrará el
* número de ceros de la secuencia. Dejará de leer cuando el usuario introduzca el
* número 2.
*/

public class CerosYUnos{
	public static void main(String[] args){
		int numeroIntroducido, contador = 0;
		do{
			numeroIntroducido = Teclado.leerEntero("Introduzca 0 o 1 (2 para salir del programa: ");
			if (numeroIntroducido <0 || numeroIntroducido > 2){
				System.out.println("Error. El número introducido no es válido.");
			}
			else
				contador = cuentaCeros(numeroIntroducido, contador);
		} while(numeroIntroducido!=2);
		System.out.println("Se han introducido en total " + contador + " ceros");
	}
	
	/**
	* Comprueba si el número introducido es 0. En caso afirmativo, incrementa el contador
	* @param numeroIntroducido: Número introducido por teclado, contador: Variable que almacena el número de ceros introducidos
	* @return contador: El número de ceros almacenados
	*/
	static int cuentaCeros(int numeroIntroducido, int contador){
		if (numeroIntroducido==0)
			contador++;
		return contador;
	}
}