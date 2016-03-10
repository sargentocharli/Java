import utiles.*;
/** 
* Define la clase Multiplica que realice de forma repetitiva multiplicaciones y las
* muestre, siempre y cuando el usuario responda afirmativamente a la pregunta:
* "¿Desea continuar?(s/n)". Para ello utiliza un método continuar (ejercicio anterior)
* e implementa también el método multiplicar con los dos argumentos que sean los
factores. Ha de devolver su producto. Documéntalo correctamente ("@param y @return").
*/

public class Multiplica{
	public static void main(String[] args){
		int num1,num2;
		do{
			num1 = Teclado.leerEntero("Introduzca el primer número: ");
			num2 = Teclado.leerEntero("Introduzca el segundo número: ");
			System.out.println("El producto de los dos números introducidos vale " + multiplicar(num1,num2));
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
	* Calcula el producto de dos números pasados como parámetros
	* @param num1: El primer número, num2: El segundo número
	* @return num1*num2: El producto de la multiplicación
	*/
	static int multiplicar(int num1, int num2){
		return num1*num2;
	}
}