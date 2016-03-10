import utiles.*;
/**
* Define la clase Pares que de forma repetitiva indique si un número es par o
*impar. Define el método esPar(int)
*/

public class Pares{
public static void main(String[] args){
	int numeroIntroducido;
	boolean par;
	do{
		numeroIntroducido = Teclado.leerEntero("Introduzca un número: ");
		par = esPar(numeroIntroducido);
		if(par)
			System.out.println("El número introducido es par.");
		else
			System.out.println("El número introducido es impar.");
	} while(continuar());
}

/**
	* Pregunta al usuario si desea continuar pidiendo un caracter (s/n)
	* @return True si la respuesta es "s" o "S" y false en el resto de casos
	*/
	static boolean continuar(){
		char respuesta = Teclado.leerCaracter("¿Desea continuar? (s/n): ");
		if (respuesta == 's' || respuesta == 'S')
			return true;
		else
			return false;
	}
/**
* Comprueba si el número pasado como parámetro es par. En caso afirmativo devuelve true
* @param numeroIntroducido: El número a comprobar
* @return true en caso de que el número sea par. False en caso contrario
*/
	static boolean esPar(int numeroIntroducido){
		if (numeroIntroducido%2==0)
			return true;
		else
			return false;
	}
}