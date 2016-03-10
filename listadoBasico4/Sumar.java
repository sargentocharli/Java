import utiles.*;
/** 
* Define la clase Sumar que realice una suma y la muestre. Para ello implementa el
* método sumar que devuelva la suma de dos números, solicitados por teclado (sin 
* argumentos). Documéntalo correctamente (@return)
*/

public class Sumar{
	public static void main(String[] args){
		System.out.println("La suma de los números introducidos es " + sumar());
	}
	
	/**
	* Calcula la suma de los dos números introducidos por teclado
	* @return num1+num2: El resultado de la suma
	*/
	static int sumar(){
		int num1,num2;
		num1 = Teclado.leerEntero("Introduzca el primer número: ");
		num2 = Teclado.leerEntero("Introduzca el segundo número: ");
		return num1+num2;
	}
}