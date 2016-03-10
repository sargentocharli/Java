import utiles.*;
/** 
* Define la clase Resta que realice de forma repetitiva restas y las muestre, siempre
* y cuando el usuario responda afirmativamente a la pregunta: ¿Desea continuar?
* (s/n). Para ello utiliza un método continuar (ejercicio anterior) e implementa
* también el método restar con los dos argumentos que sean los operandos. Ha de
* devolver su diferencia. Documéntalo correctamente (@param y @return)
*/

public class Resta{
	public static void main(String[] args){
		int num1,num2;
		do{
			num1 = Teclado.leerEntero("Introduzca el primer número: ");
			num2 = Teclado.leerEntero("Introduzca el segundo número: ");
			System.out.println("La resta de los dos números introducidos vale " + restar(num1,num2));
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
	* Calcula la resta de dos números pasados como parámetros
	* @param num1: El primer número, num2: El segundo número
	* @return num1-num2: El resultado de la resta
	*/
	static int restar(int num1, int num2){
		return num1-num2;
	}
}