/** Define la clase DosNumeros. Lee dos enteros hasta que sean distintos.
* Si no lo son, se mostrará el mensaje "Son iguales". Una vez introducidos
* ambos de forma correcta se mostrará el menor de ellos. Utiliza el operador ?
*
* @author Lucas Márquez Muñoz
* @version 1.0
*
*/

public class DosNumeros{
	public static void main(String[] Args){
		int n1,n2,menor;
		java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
		
		do {
			System.out.println("Introduce el primer número: ");
			n1 = entradaPorTeclado.nextInt();
			System.out.println("Introduce el segundo número: ");
			n2 = entradaPorTeclado.nextInt();
		} while (n1==n2);
		menor = (n1<n2)?n1:n2;
		System.out.println("El menor es: " + menor);
	}
}
	