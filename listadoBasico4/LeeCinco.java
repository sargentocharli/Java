import utiles.*;
/**
* Define la clase LeeCinco que lea cinco valores numéricos y calcule su producto.
* Se le preguntará al usuario si quiere repetir el programa. Utiliza métodos
* (deseaContinuar, leerCincoNumeros, System.out.println(El producto es:  +
* calcularResultado()…)
*/

public class LeeCinco{
	public static void main(String[] args){
		do{
			System.out.println("El producto de los 5 números vale " + calcularResultado());
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
	* Llama a leerCincoNumeros y devuelve su producto
	*/
	static int calcularResultado(){
		return leerCincoNumeros();
	}
	/**
	* Lee cinco números introducidos por el usuario y calcula su producto
	* @return resultado: El resultado de la operación
	*/
	static int leerCincoNumeros(){
		int numeroIntroducido, resultado=1;
		for (int i=0;i<5;i++){
			numeroIntroducido=Teclado.leerEntero("Introduzca un número: ");
			resultado*=numeroIntroducido;
		}
		return resultado;
	}
}