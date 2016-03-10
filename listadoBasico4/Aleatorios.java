import utiles.*;
/**
* Define la clase Aleatorios que de forma repetitiva muestre un número aleatorio
* entre un mínimo y un máximo. Define el método generarAleatorio(min, max)
*/

public class Aleatorios{
	public static void main(String[] args){
		int min, max;
		do{
			min = Teclado.leerEntero("Introduzca el valor mínimo: ");
			max = Teclado.leerEntero("Introduzca el valor máximo: ");
			System.out.println("El número aleatorio es " + generarAleatorio(min,max));
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
	* Genera un número aleatorio entre dos valores dados por parámetro
	* @param min: El valor mínimo, max: El valor máximo
	* @return El número aleatorio entre el valor min y el valor max
	*/
	static int generarAleatorio(int min, int max){
		return(int)(Math.random()*(min-(max+1))+(max+1));
	}
}