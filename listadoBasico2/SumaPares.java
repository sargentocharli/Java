/**
* Define la clase SumaPares que sume los números pares
* comprendidos entre 7 y 101.
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class SumaPares{
	public static void main(String[] args){
		int suma = 0;
		for (int n=8; n <101; n=n+2){
			suma = suma +n;
		}
		System.out.println("La suma es " + suma);
	}
}
