/** Muestra la tabla de caracteres Unicode. Utiliza el carácter tabulador
*
* @author Lucas Márquez Muñoz
* @version 1.0
*
*/

public class TablaUnicode{
	public static void main(String[] args){
		for(int i=0;i<128;i++)
			System.out.print("\t " + (char)i);
	}
}
