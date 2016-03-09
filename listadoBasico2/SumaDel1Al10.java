/** Define la clase SumaDel1Al10 que calcule la suma
* de los enteros entre 1 y 10, es decir
* 1+2+3+4+5...
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class SumaDel1Al10{
	public static void main(String[] args){
		int suma = 1;
		for (int i=2;i<11;i++)
			suma = suma + +i;
		System.out.println(suma);	
	}
}
