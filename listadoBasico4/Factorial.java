import utiles.*;
/**
* Define la clase Factorial que muestre el factorial de un número introducido por
* teclado. (Factorial (4) = 4*3*2*1; Factorial (0) = 1) Realízalo con los tres bucles
* (factorialFor(), factorialDoWhile(), factorialWhile())
*/
public class Factorial{
	public static void main(String[]args){
		int numeroIntroducido;
		mostrarInstrucciones();
		numeroIntroducido=Teclado.leerEntero("Introduzca un número: ");
		System.out.println("El factorial de " + numeroIntroducido + " con el método for es: " + factorialFor(numeroIntroducido));
		System.out.println("El factorial de " + numeroIntroducido + " con el método while es: " + factorialWhile(numeroIntroducido));
		System.out.println("El factorial de " + numeroIntroducido + " con el método DoWhile es: " + factorialDoWhile(numeroIntroducido));
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
	* Muestra en pantalla las instrucciones del programa
	*/
	static void mostrarInstrucciones(){
		System.out.println("Introduzca un número para calcular su factorial.");
	}
	/**
	* Calcula el factorial con un bucle for
	* @param numeroIntroducido: El número del que se va a calcular su factorial
	* @return factorial: El factorial del número recibido como parámetro
	*/
	static int factorialFor(int numeroIntroducido){
		int resultado = 1;
		for (;numeroIntroducido>0;numeroIntroducido--)
			resultado*=numeroIntroducido;
		return resultado;
	}
	/**
	* Calcula el factorial con un bucle while
	* @param numeroIntroducido: El número del que se va a calcular su factorial
	* @return factorial: El factorial del número recibido como parámetro
	*/
	static int factorialWhile(int numeroIntroducido){
		int resultado = 1;
		while(numeroIntroducido>0){
			resultado*=numeroIntroducido;
			numeroIntroducido--;
		}
		return resultado;
	}
	/**
	* Calcula el factorial con un bucle do-while
	* @param numeroIntroducido: El número del que se va a calcular su factorial
	* @return factorial: El factorial del número recibido como parámetro
	*/
	static int factorialDoWhile(int numeroIntroducido){
		int resultado = 1;
		do{
			resultado*=numeroIntroducido;
			numeroIntroducido--;
		} while(numeroIntroducido>0);
		return resultado;
	}
}
	