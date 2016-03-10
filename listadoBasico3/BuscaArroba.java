import utiles.*;
/** Define la clase BuscaArroba. Lee caracteres desde teclado hasta
* que introduzca la arroba. Una vez introducida, se mostrará el número de 
* caracteres introducidos entre la B mayúscula y la T mayúscula.
*
* @author Lucas Márquez Muñoz
* @version 1.0
*
*/
public class BuscaArroba{
	public static void main(String[] args){
		int contador = 0;
		char caracter= ' ';
		while (caracter != '@'){
			caracter = Teclado.leerCaracter("Introduce un caracter. una vez introducida la arroba mostrará el número de caracteres introducidos entre B mayúscula y T mayúscula");
			if (caracter >= 'B' && caracter <= 'T')
				contador++;
		}
		System.out.println("Se han introducido " + contador + " veces caracteres comprendidos entre B y T"); 
	}
}

