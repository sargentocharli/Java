/**
* Define la clase Mayor que pide repetidas veces dos enteros por 
* teclado e indica cuál es el mayor. En caso de ser iguales
* se sale del programa diciendo adiós. Utiliza la sentecia
* break
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class Menor{
	public static void main(String[] ags){
		int n1, n2;
		while (true){
			java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
			System.out.println("Primer número: ");
			n1 = entradaPorTeclado.nextInt();
			System.out.println("Segundo número: ");
			n2 = entradaPorTeclado.nextInt();
			if (n1 == n2){
				System.out.println("Adiós");
				break;
			}
			else if (n1 < n2)
				System.out.println(n1 + " es menor que " + n2);
			else 
				System.out.println(n2 + " es menor que " + n1);
		}
	}
}