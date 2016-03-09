/**
* Define la clase EnteroPorDiez que pide un entero por teclado
* y lo multiplica por 10
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class EnteroPorDiez{
	public static void main(String[] args){
		java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
		int numero = entradaPorTeclado.nextInt();
		System.out.println("Multiplicado por 10 = "+ numero*10);
	}
}
