/** Define la clase IndicaMesIf que muestre el nombre del mes
* en función del número obtenido por teclado (del 1 al 12). 
* Utiliza la estructura condicional If. Ha de mostrar 10 resultados
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/
public class IndicaMesIf{
	public static void main(String[] args){
		java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
		for(int i=0;i<10;i++){
			System.out.println("Introduzca el mes que desea conocer: ");
			int mes = entradaPorTeclado.nextInt();
			if (mes == 1){
				System.out.println("El mes 1 es enero (" + i+1 + ")");
				}
			else if (mes == 2){
				System.out.println("El mes 2 es febrero (" + i+1 + ")");
			}	
			else if (mes == 3){
				System.out.println("El mes 3 es marzo (" + i+1 + ")");
			}
			else if (mes == 4){
				System.out.println("El mes 4 es abril (" + i+1 + ")");
			}
			else if (mes == 5){
				System.out.println("El mes 5 es mayo (" + i+1 + ")");
			}
			else if (mes == 6){
				System.out.println("El mes 6 es junio (" + i+1 + ")");
			}
			else if (mes == 7){
				System.out.println("El mes 7 es julio (" + i+1 + ")");
			}
			else if (mes == 8){
				System.out.println("El mes 8 es agosto (" + i+1 + ")");
			}
			else if (mes == 9){
				System.out.println("El mes 9 es septiembre (" + i+1 + ")");
			}
			else if (mes == 10){
				System.out.println("El mes 10 es octubre (" + i+1 + ")");
			}
			else if (mes == 11){
				System.out.println("El mes 11 es noviembre (" + i+1 + ")");
			}
			else if (mes == 12){
				System.out.println("El mes 12 es diciembre (" + i+1 + ")");
			}
		}
	}
}	
