/**
* Entrega un programa que muestre:
* A la de 1...
* A la de 2...
* A la de 3...
* Utilizando el bucle while, el do...while y el for
*
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class ALaDeUno{
	public static void main (String[] args){
		int i = 1;
		System.out.println("\nCon bucle tipo while");
		while (i<4){
			System.out.println("A la de " + i++ +"...");
		}
		
		i = 1;
		System.out.println("\nCon bucle tipo do...while");
		do
		System.out.println("A la de " + i++ +"...");
			while(i<4);
			
		System.out.println("\nCon bucle tipo for");
		for (i = 1; i<4; i++)
			System.out.println("A la de " + i +"...");
	}
}
			
