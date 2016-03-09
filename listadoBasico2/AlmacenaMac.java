/** Entrega el siguiente código fuente en java.
* Añádele comentarios justificando los resultados.
*
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class AlmacenaMac{
	public static void main (String[] args){
		long broadcast = 0xFFFFFFFFFFFFl; /* Utilizamos el tipo de dato long debido al tamaño de la variable
											 que queremos almacenar. Al final de esta añadiremos "l" (o "L") 
											 para forzar a la variable a ser de tipo long, ya que por defecto
											 lo interpreta como tipo int*/
		System.out.println(broadcast);
	}
}
