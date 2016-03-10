import utiles.*;
/** 
* Define la clase MediaPositivos que calcule la media de una serie de números
* positivos, introducidos por teclado. Dejará de leer cuando el usuario introduzca el
* 0. Utiliza métodos.
*/
public class MediaPositivos{
	public static void main(String[]args){
		mostrarInstrucciones();
		System.out.println("La media vale " + calcularMedia());
	}
	/**
	* Imprime por pantalla las instrucciones del programa
	*/
	static void mostrarInstrucciones(){
		System.out.println("Introduzca números positivos para calcular su media. Introduzca 0 para terminar.");
	}
	/**
	* Pide un números positivos por teclado hasta que se introduce un cero. Tras esto, 
	* calcula y muestra la media de los números introducidos
	* @return La media de los números introducidos
	*/
	static float calcularMedia(){
		int i=0, numeroIntroducido =1;
		float media=0;
		for(i=0;numeroIntroducido!=0;i++){
			numeroIntroducido=Teclado.leerEntero("Introduzca un número positivo: ");
			while(numeroIntroducido<0){
				System.out.println("Error. El número introducido es negativo.");
				numeroIntroducido=Teclado.leerEntero("Introduzca un número positivo: ");
			}
			media+=numeroIntroducido;
		}
		return (media/(i-1));
	}
}