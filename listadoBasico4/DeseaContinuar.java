import utiles.*;
/** 
* Define la clase DeseaContinuar que realice la siguiente pregunta: "¿Desea
* continuar? (s/n)". En caso de que el usuario indique una "s" (minúscula o 
* mayúscula) el programa seguirá preguntando. En otro caso, que se salga del
* programa. Para ello, implementa el método continuar que devuelva true en caso de
* introducir una s, y false en caso contrario. Documéntalo correctamente (@return)
*/

public class DeseaContinuar{
	public static void main(String[] args){
		do{
			
		} while (continuar());
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
}