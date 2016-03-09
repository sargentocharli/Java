/** Define la clase SumaMientrasNoSeaNegativo que sume todos aquellos
* números leídos mientras no sean negativos.
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class SumaMientrasNoSeaNegativo{
	public static void main (String[] args){
		java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
		int suma = 0;
		System.out.println("Introduce un número: ");
		int numeroIntroducido = entradaPorTeclado.nextInt();
		
		while (numeroIntroducido > 0){
			suma = suma + numeroIntroducido;
			System.out.println("La suma actual vale: " + suma);
			numeroIntroducido = entradaPorTeclado.nextInt();
			}	
		System.out.println("La suma total asciende a: " + suma);			
	}
}
