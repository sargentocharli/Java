/**
* Define la clase EsPositivo que pide un entero por
* teclado e indica si es positivo.
*
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class EsPositivo{
	public static void main (String[] args){
		java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
		int numero;
		System.out.println("Introduce un número: ");
		numero = entradaPorTeclado.nextInt();
		
		if (numero > 0)
			System.out.println(numero + " es positivo");
		else
			System.out.println(numero + " no es positivo");
	}
}
