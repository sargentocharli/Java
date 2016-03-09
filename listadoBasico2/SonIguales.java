/** Define la clase SonIguales que lea dos valores numéricos,
* y determine si son iguales y, en caso de no serlo, indique
* cuál de ellos es el mayor
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class SonIguales{
	public static void main(String[] args){
		java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
		int n1, n2;
		System.out.println("Introduce el primer número: ");
		n1 = entradaPorTeclado.nextInt();
		System.out.println("Introduce ahora el segundo número: ");
		n2 = entradaPorTeclado.nextInt();
		if (n1 == n2)
			System.out.println(n1 + " y " + n2 + " son el mismo número");
		else if (n1 > n2)
			System.out.println(n1 + " es mayor que " + n2);
		else 
			System.out.println(n2 + " es mayor que " + n1);
	}
}
