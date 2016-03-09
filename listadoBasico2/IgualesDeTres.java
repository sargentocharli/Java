/** Define la clase IgualesDeTres que lea tres números de teclado
* y determine si la suma de cualquier pareja de ellos es igual
* al tercer número. Si se cumple esta condición, escribir "iguales"
* y en caso contrario escribir "Distintos".
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class IgualesDeTres{
	public static void main(String[] args){
		int n1, n2, n3;
		java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
		System.out.println("Introduce el primer número: ");
		n1 = entradaPorTeclado.nextInt();
		System.out.println("Introduce el segundo número: ");
		n2 = entradaPorTeclado.nextInt();
		System.out.println("Introduce ahora el tercer número: ");
		n3 = entradaPorTeclado.nextInt();
		
		if (n1 + n2 == n3 || n1 + n3 == n3 || n2 + n3 == n3)
			System.out.println("Iguales");
		else
			System.out.println("Distintos");
	}
}
