/** Define la clase DiaDelMes que pide dos enteros, que representarán un mes y un año.
* Se visualizará el número de días del mes, teniendo en cuenta que:
* a. 31 días tienen Enero, Marzo, Mayo, Julio, Agosto, Octubre, Diciembre
* b. 30 días tienen Febrero, Abril, Junio, Septiembre, Noviembre
* c. Febrero tiene 29 días si el año es bisiesto. En cualquier otro caso, tiene 28
* d. Un año es bisiesto si es divisible entre 4, a menos que sea divisible entre 100.
* Sin embargo, si un año es divisible entre 100 y además es divisible entre 400,
* también resulta bisiesto.
*
* @author Lucas Márquez Muñoz
* @version 1.0
*
*/

public class DiaDelMes{
	public static void main(String[] args){
		java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
		
		System.out.println("Introduce un mes válido (del 1 al 12): ");
		int mes = entradaPorTeclado.nextInt();
		if (mes <1 || mes >12){
			System.out.println("Mes introducido no válido. Cerrando programa");
			return;
		}
		System.out.println("Introduce un año válido (mayor que 1): ");
		int anno = entradaPorTeclado.nextInt();
		if (anno < 1){
			System.out.println("Año introducido no válido. Cerrando programa");
			return;
		}	
		switch(mes){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println("Tiene 31 días");
				break;
			case 2:
				if ((anno%4==0 && anno%100==0) || anno%4!=0)
					System.out.println("Tiene 28 días.");
				else	
					System.out.println("Tiene 29 días.");
				break;
			default:
				System.out.println("Tiene 30 días.");
		}
	}
}