/**
* Define la clase CuentaNegativos. Lee 10 enteros y visualiza
* cuántos son negativos
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class CuentaNegativos{
	public static void main(String[] args){
		int n = entrada = sumaNegativos = 0;
		java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
		
		for(n=1;n<11;n++){
			System.out.println("Introduce un número ("+ n +")");
			entrada = entradaPorTeclado.nextInt();
			if (entrada < 0)
				sumaNegativos = sumaNegativos + 1;
		}
		System.out.println("Has introducido "+ sumaNegativos +" números negativos");
	}
}
