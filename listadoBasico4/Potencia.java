import utiles.*;
/**
* Define la clase Potencia que calcule y visualice la potencia de un número dada la
* base y el exponente. Se le preguntará al usuario si quiere repetir el programa. Utiliza
* métodos (deseaContinuar, mostrarInstrucciones…)
*/

public class Potencia{
	public static void main(String[]args){
		int base,exponente;
		do{
			mostrarInstrucciones();
			base=Teclado.leerEntero("Introduzca la base: ");
			exponente=Teclado.leerEntero("Introduzca el exponente: ");
			System.out.println("El resultado de " + base + " elevado a " + exponente + " es de: " + calcularPotencia(base,exponente));
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
	* Mostramos las instrucciones del programa
	*/
	static void mostrarInstrucciones(){
		System.out.println("Introduzca la base y el exponente para calcular el resultado.");
	}
	/**
	* Calcula el resultado de elevar la base al exponente, ambos pasados por parámetros
	* @param base: La base de la potencia, exponente: El exponente de la potencia
	* @return El resultado de elevar la base a la potencia
	*/
	static long calcularPotencia(int base, int exponente){
		return (long)(Math.pow(base,exponente));
	}
}
