/**
* Define la clase EsPositivoNegativo que pide repetidas veces
* un entero por teclado e indica si es positivo o negativo. En
* caso de ser cero, se sale del programa diciendo adiós.
* Crea tres versiones con las tres estructuras repetitivas y 
* utilizando la sentencia break.
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class EsPositivoNegativo{
	public static void main(String[] args){
		java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
		int numero;
		/*System.out.println("Introduce un número: ");
		numero = entradaPorTeclado.nextInt();*/
		
		// Con estructura for
		System.out.println("Con estructura for:");
		for (;;){
			System.out.println("Introduce un número: ");
			numero = entradaPorTeclado.nextInt();
			if (numero == 0)
				break;
			else if (numero > 0)
				System.out.println(numero + " es positivo");
			else 
				System.out.println(numero + " es negativo");
		}
		
		// Con estructura while
		System.out.println("Con estructura while:");
		while (true){
			System.out.println("Introduce un número: ");
			numero = entradaPorTeclado.nextInt();
			if (numero == 0)
				break;
			else if (numero > 0)
				System.out.println(numero + " es positivo");
			else 
				System.out.println(numero + " es negativo");
		}
		
		// Con estructura do...while
		System.out.println("Con estructura do...while:");
		do{
			System.out.println("Introduce un número: ");
			numero = entradaPorTeclado.nextInt();
			if (numero == 0)
				break;
			else if (numero > 0)
				System.out.println(numero + " es positivo");
			else 
				System.out.println(numero + " es negativo");
		} while (true);
		
		
	}
}