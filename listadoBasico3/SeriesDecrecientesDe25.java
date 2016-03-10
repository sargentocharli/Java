/**
* Define la clase SeriesDecrecientesDe25. Utilizando las tres estructuras
* de repetición (while, do while y for) genera la serie del 1000 al 0
* con un decremento de 25 (ambos incluídos)
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class SeriesDecrecientesDe25{
	public static void main(String[] args){
		int numero = 1000;
		System.out.println("Con la estructura While: ");
		while (numero >=0){
			System.out.print(numero + "\t");
			numero-= 25;
		}
		
		numero = 1000;
		System.out.println("\n\nCon la estructura do...while");
		do{
			System.out.print(numero + "\t");
			numero-= 25;
		}
			while(numero >=0);
		
		System.out.println("\n\nCon la estructura for");
		for (numero=1000;numero>=0;numero-=25)
			System.out.print(numero + "\t");
	}
}