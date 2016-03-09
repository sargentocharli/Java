/** Define la clase MenorDeTres que lea tres números y calcule
* cuál de ellos es el menor. Suponemos que los tres números
* son distintos
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class MenorDeTres{
	public static void main(String[] args){
		int n1, n2, n3;
		java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
		System.out.println("Introduce el primer número: ");
		n1 = entradaPorTeclado.nextInt();
		System.out.println("Introduce el segundo número: ");
		n2 = entradaPorTeclado.nextInt();
		System.out.println("Introduce ahora el tercer número: ");
		n3 = entradaPorTeclado.nextInt();
		
		if (n1 < n2 && n1 < n3)
			System.out.println(n1 + " es el más pequeño de los tres");
		else if (n2 < n1 & n2 <n3)
			System.out.println(n2 + " es el más pequeño de los tres");
		else
			System.out.println(n3 + " es el más pequeño de los tres");
	}
}
