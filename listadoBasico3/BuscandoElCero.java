/**
* Define la clase BuscandoElCero. Utilizando el método Math.random() que
* devuelve un número aleatorio entre 0 y 1 [0, 1) comprueba mediante un
* bucle infinito si el resultado en algún momento da el valor 0. Utiliza
* la sentencia break para salir del bucle
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class BuscandoElCero{
	public static void main(String[] args){
		while (true){
			double random = Math.random();
			System.out.println(random);
			if (random == 0)
				break;
		}
	}
}