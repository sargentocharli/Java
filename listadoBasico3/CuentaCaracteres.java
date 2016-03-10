import utiles.*;
/** Define la clase BuscaArroba. Lee caracteres desde teclado hasta
* que introduzca la arroba. Una vez introducida, se mostrará el número de 
* caracteres introducidos entre la B mayúscula y la T mayúscula.
*
* @author Lucas Márquez Muñoz
* @version 1.0
*
*/
public class CuentaCaracteres{
	public static void main(String[] args){
		int contadorDigitos = 0;
		int contadorMinusculas = 0;
		int contadorMayusculas = 0;
		char caracter= ' ';
		while (caracter != '*'){
			caracter = Teclado.leerCaracter("Introduce un caracter. una vez introducido el asterisco mostrará 3 recuentos: 1- [0-9], 2- [a-z] y 3- [A-Z]");
			if (caracter >= '0' && caracter <= '9')
				contadorDigitos++;
			else if (caracter >= 'a' && caracter <= 'z')
				contadorMinusculas++;
			else if (caracter >= 'A' && caracter <= 'Z')
				contadorMayusculas++;
		}
		System.out.println("Recuentos\n[0-9]\t [a-z]\t [A-Z]\n" + contadorDigitos + "\t" + contadorMinusculas + "\t" + contadorMayusculas); 
		
	}
}