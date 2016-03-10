import utiles.*;
/** 
* Define la clase Sumar2 que realice una suma y la muestre. Para ello implementa
* el método sumar con los dos argumentos que sean los sumandos. Ha de devolver su 
* suma. Documéntalo correctamente (@param y @return).
*/

public class Sumar2{
	public static void main(String[] args){
		int num1,num2;
		num1 = Teclado.leerEntero("Introduzca el primer número: ");
		num2 = Teclado.leerEntero("Introduzca el segundo número: ");
		System.out.println("La suma de los dos números vale " + sumar(num1,num2));
	}
	
	/**
	* Calcula la suma de los dos números que se le han pasado por parámetro
	* @param num1: El primer número introducido, num2: El segundo número introducido
	* @return num1+num2: La suma de los dos números
	*/
	static int sumar(int num1, int num2){
		return num1+num2;
	}
}