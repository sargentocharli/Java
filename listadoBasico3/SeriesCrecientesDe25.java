/**
* Define la clase SeriesCrecientesDe25. Utilizando las tres estructuras
* de repetición (while, do while y for) genera la serie del 0 al 1000
* con un incremento de 25 (ambos incluídos)
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class SeriesCrecientesDe25{
	public static void main(String[] args){
		int numero = 0;
		System.out.println("Con la estructura While: ");
		while (numero < 1001){
			System.out.print(numero + "\t");
			numero+= 25;
		}
		
		numero = 0;
		System.out.println("\n\nCon la estructura do...while");
		do{
			System.out.print(numero + "\t");
			numero+= 25;
		}
			while(numero <1001);
		
		System.out.println("\n\nCon la estructura for");
		for (numero=0;numero<1001;numero+=25)
			System.out.print(numero + "\t");
	}
}