/**
* Define la clase MortadeloYFilemon que muestre 5 veces
* el mensaje "Mortadelo y Filemón". Reutilízalo usando
* el decremento y los bucles for, while y do...while.
*
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class MortadeloYFilemon{
	public static void main (String[] args){
		
		int numero = 5;
		
		//Con bucle for
		System.out.println("Con bucle for");
		for (numero = 5; numero >0; numero--)
			System.out.println("Mortadelo y Filemón");
		
		//Con bucle while
		System.out.println("Con bucle while");
		numero = 5;
		while(numero > 0){
			System.out.println("Mortadelo y Filemón");
			numero--;}
		
		//Con bucle do...while
		System.out.println("Con bucle do...while");
		numero = 5;
		do {
		System.out.println("Mortadelo y Filemón");
		numero --;
		}while (numero > 0);
		
	}
}
