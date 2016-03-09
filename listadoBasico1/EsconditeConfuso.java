/**
* Crea la clase EsconditeConfuso con las siguientes sentencias.
* Interprétalas y coméntalas en el código
*
* @author: Lucas Márquez Muñoz
*/

public class EsconditeConfuso 
	{
	public static void main (String[] args)
		{
		int x = 17; //Definimos la variable "x"
			{
			int x = 77; /*Como la variable "x" ya fue definida en el ámbito anterior, 
						al intentar compilar nos da un error indicando que "x" ya fue 
						definida anteriormente en el método main*/
			}
		}
	}
