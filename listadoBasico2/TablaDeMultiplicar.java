/** Define la clase TablaDeMultiplicar. Muestra la tabla de multiplicar.
* Para ello, solicita el factor al usuario. Solo se admite la tabla
* de multiplicar de los números 1,2...12 (solicitud repetitiva)
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class TablaDeMultiplicar{
	public static void main(String[] args){
		int tabla = 0;
		java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
		
		while(true){
			System.out.println("Introduce un número (0 para salir del programa): ");
			tabla = entradaPorTeclado.nextInt();
			if (tabla <0 || tabla >12)
				System.out.println("Nope");
			else if (tabla == 0)
				break;
			else {
				for(int repetidor = 1; repetidor < 11; repetidor++){
					System.out.println(tabla + "x" + repetidor +"=" + repetidor*tabla);}
			}
		}
	}
}
		
