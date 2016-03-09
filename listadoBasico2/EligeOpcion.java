/** Define la clase EligeOpcion que permita visualizar
* los siguientes mensajes, dependiendo del número
* que pulsamos. Ha de mostrar 10 resultados.
* a. (1) Procesador de textos
* b. (2) Hoja de cálculo
* c. (3) Base de datos
* d. otro número, la tecla pulsada es errónea.
*
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class eligeOpcion{
	public static void main (String[] args){
		int opcion;
		int contador = 0;
		java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
				
		for (contador=0;contador<11;contador++){
			System.out.println("Elija una opción: ");
			opcion = entradaPorTeclado.nextInt();
				switch(opcion){
					case 1:
					System.out.println("a. (1) Procesador de textos");
					break;
					case 2:
					System.out.println("b. (2) Hoja de cálculo");
					break;
					case 3:
					System.out.println("c. (3) Base de datos");
					break;
					default:
					System.out.println("d. otro número. La tecla usada es errónea");
				}
		}
	}
}
