import utiles.*;
/**
* Define la clase AccesoDenegado que simule el acceso a un sitio
* en función de dos valores introducidos por el usuario: edad
* del usuario y autorización paterna. Solo aparecerá el mensaje
* "Bienvenido" si el usuario es mayor de edad o si siendo menor
* de edad tiene la autorización paterna. En cualquier otro caso,
*  que muestre "Acceso denegado".
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class AccesoDenegado{
	public static void main(String[] args){
		java.util.Scanner entradaPorTeclado = new java.util.Scanner(System.in);
		System.out.println("Introduzca su edad: ");
		int edad = entradaPorTeclado.nextInt();
		if (edad > 17)
			System.out.println("Bienvenido.");
		else{
			char autorizacion = ' ';
			autorizacion = Teclado.leerCaracter("¿Tiene autorización paterna? (S/N)");
			if (autorizacion == 'S' || autorizacion == 's'){
			System.out.println("Bienvenido.");}
			else{
			System.out.println("Acceso denegado.");}
		}
	}
}