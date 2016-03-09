/**
* Define la clase SumaImpares. Visualiza la suma de los números
* impares del 1 al 75, ambos inclusive.
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class SumaImpares{
	public static void main(String[] args){
		int suma = 0;
		for (int n=1; n <76; n=n+2){
			suma = suma +n;
		}
		System.out.println("La suma es " + suma);
	}
}
