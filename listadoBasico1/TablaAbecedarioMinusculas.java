/*
* Crea la clase TablaAbecedarioMinusculas que muestre la siguiente salida.
* Para ello utiliza el método +) con los caracteres \n y \t.
* Utiliza una variable char con el código Unicode para mostrar la letra ñ 
* (no uses \udddd)
*
*@author Lucas Márquez Muñoz
*/

public class TablaAbecedarioMinusculas{
	public static void main (String[] args){
		char enye = 241; // Almacenamos el código Unicode de "ñ" en variable
		System.out.println("Esto es una tabla con el abecedario en minúsculas: \n"
		+"\t a \t b \t c \t d \n"
		+"\t e \t f \t g \t h \n"
		+"\t i \t j \t k \t l \n"
		+"\t m \t n \t " + enye+ "\t o \n"
		+"\t p \t q \t r \t s \n"
		+"\t t \t u \t v \t w \n"
		+"\t x \t y \t z \n");
		}
	}
