/**
* Define la clase LeeEnteros. Lee 10 enteros e indica al final
* si se ha introducido algún 0.
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class LeeEnteros{
	public static void main(String[] args){
		int entero;
		int contador = 0;
		java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
		for (int n=1;n<11;n++){
			System.out.println("Introduce un entero (" + n + "): ");
			entero = entradaPorTeclado.nextInt();
			if (entero == 0)
				contador++;
		}
		System.out.println("El número de ceros introducido es: " + contador);
	}
}