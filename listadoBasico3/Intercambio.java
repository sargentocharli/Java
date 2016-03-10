/**
* Define la clase Intercambio que pide dos enteros por teclado
* e intercambia el valor de ambas variables. Muestra el valor
* antes y después del intercambio.
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class Intercambio{
	public static void main(String[] args){
		int n1,n2,aux = 0;
		java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
		System.out.println("Introduce el primer entero: ");
		n1 = entradaPorTeclado.nextInt();
		System.out.println("Introduce el segundo entero: ");
		n2 = entradaPorTeclado.nextInt();
		System.out.println("n1 vale " + n1 + " y n2 vale " + n2);
		aux = n1;
		n1 = n2;
		n2 = aux;
		System.out.println("Ahora n1 vale " + n1 + " y n2 vale " + n2);
	}
}
