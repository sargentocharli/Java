/**
* Define la clase LeeEnteros. Lee 10 enteros e indica
* al final si se ha introducido algún cero.
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class LeeEnteros{
	public static void main(String[] args){
		int n = entrada = cuentaCeros = 0;
		java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
				
		for(n=1;n<11;n++){
			System.out.println("Introduce un número ("+ n +")");
			entrada = entradaPorTeclado.nextInt();
			if (entrada == 0)
				cuentaCeros = cuentaCeros + 1;
		}
		System.out.println("Has introducido "+ cuentaCeros +" veces el número 0	");
	}
}
