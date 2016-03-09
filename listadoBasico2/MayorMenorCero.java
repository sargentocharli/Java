/** Define la clase MayorMenorCero que permita saber si un número
* leído por teclado es mayor, menor o igual a cero, mostrando
* en pantalla las diferentes salidas. Ha de mostrar 10 resultados
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class MayorMenorCero{
	public static void main (String[] args){
		java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
		int numero;
		
		for (int i=1;i<11;i++){
			System.out.println("Introduce un número: ");
			numero = entradaPorTeclado.nextInt();
			if (numero > 0)
				System.out.println(numero + " es mayor que 0 (" + i + ")");
			else if (numero <0)
				System.out.println(numero + " es menor que 0 (" + i + ")");
			else
				System.out.println(numero + " es igual a 0 (" + i + ")");
		}
	}
}
