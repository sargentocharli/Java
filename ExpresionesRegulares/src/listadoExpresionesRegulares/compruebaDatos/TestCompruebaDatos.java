package listadoExpresionesRegulares.compruebaDatos;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utiles.*;

public class TestCompruebaDatos {

	static Pattern pattern;
	static Matcher matcher;
	
	public static void main(String[] args) {
	
		Menu menu = new Menu("Comprueba Datos", new String[]{
				"Dirección MAC", 
				"Dirección IP", 
				"Correo Electrónico", 
				"Código Postal",
				"Número de cuenta corriente", 
				"DNI"});
		
		int opcion;
		
		do{
			opcion=menu.gestionarMenu();
			switch(opcion){
			case 1:
				direccionMAC();
				break;
			case 2:
				direccionIP();
				break;
			case 3:
				correoElectronico();
				break;
			case 4:
				codigoPostal();
				break;
			case 5:
				numeroCuentaCorriente();
				break;
			case 6:
				dni();
				break;
			case 7:
				break;
			default:
				error();
				break;
			} 
		}while(opcion!=7);
		
	}
	
	/**
	 * Muestra un mensaje de error
	 */
	static void error(){
		System.out.println("Error. Opción inválida.");
	}
	
	/**
	 * Comprueba el patrón de una dirección MAC con una dirección MAC pedida al usuario
	 */
	static void direccionMAC(){
		boolean encontrado=false;
		pattern = Pattern.compile("^([0-9A-Fa-f]{2}:){5}([0-9A-Fa-f]{2})$");
		matcher = pattern.matcher(Teclado.leerCadena("Introduce una dirección MAC (XX:XX:XX:XX:XX:XX): "));
		while(matcher.find()){
			System.out.println("Dirección MAC correcta " + matcher.group());
			encontrado=true;
		}
		if(!encontrado)
			System.out.println("Dirección MAC incorrecta.");
	}
	
	/**
	 * Comprueba el patrón de una dirección IP con una dirección IP pedida al usuario
	 */
	static void direccionIP(){
		boolean encontrado=false;
		pattern = Pattern.compile("^(([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]).){3}([1-9]?[0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
		matcher = pattern.matcher(Teclado.leerCadena("Introduce una dirección IP (XXX.XXX.XXX.XXX): "));
		while(matcher.find()){
			System.out.println("Dirección IP correcta " + matcher.group());
			encontrado=true;
		}
		if(!encontrado)
			System.out.println("Dirección IP incorrecta.");
	}
	
	/**
	 * Comprueba el patrón de un correo electrónico con un correo electrónico pedido al usuario
	 */
	static void correoElectronico(){
		boolean encontrado=false;
		pattern = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$");
		matcher = pattern.matcher(Teclado.leerCadena("Introduce un correo electrónico (dominio.subdominio@dominio.subdominio.extensión): "));
		while(matcher.find()){
			System.out.println("Correo electrónico correcto " + matcher.group());
			encontrado=true;
		}
		if(!encontrado)
			System.out.println("Correo electrónico incorrecto.");
	}
	
	/**
	 * Comprueba el patrón de un código postal con un código postal pedido al usuario
	 */
	static void codigoPostal(){
		boolean encontrado=false;
		pattern = Pattern.compile("^([0-4][1-9][0-9][0-9][1-9])|([0-4][1-9][0-9][1-9][0-9])|([0-4][1-9][1-9][0-9][0-9])|(5[0-2][0-9][0-9][1-9])|(5[0-2][0-9][1-9][0-9])|(5[0-2][1-9][0-9][0-9])$");
		matcher = pattern.matcher(Teclado.leerCadena("Introduce un código postal (XXXX): "));
		while(matcher.find()){
			System.out.println("Código postal correcto " + matcher.group());
			encontrado=true;
		}
		if(!encontrado)
			System.out.println("Código postal incorrecto.");
	}
	
	/**
	 * Comprueba el patrón de un número de cuenta corriente con un número de cuenta corriente pedido al usuario
	 */
	static void numeroCuentaCorriente(){
		boolean encontrado=false;
		pattern = Pattern.compile("^ES\\d{2}[ ]\\d{4}[ ]\\d{4}[ ]\\d{4}[ ]\\d{4}[ ]\\d{4}|ES\\d{22}$");
		matcher = pattern.matcher(Teclado.leerCadena("Introduce un número de cuenta corriente (ESXX XXXX XXXX XXXX XXXX XXXX | ESXXXXXXXXXXXXXXXXXXXXXX): "));
		while(matcher.find()){
			System.out.println("Número de cuenta corriente correcto " + matcher.group());
			encontrado=true;
		}
		if(!encontrado)
			System.out.println("Número de cuenta corriente incorrecto.");
	}
	
	/**
	 * Comprueba el patrón de un DNI con un DNI pedido al usuario
	 */
	static void dni(){
		boolean encontrado=false;
		pattern = Pattern.compile("(\\d{8})([-]?)([A-Z]{1})");
		matcher = pattern.matcher(Teclado.leerCadena("Introduce un DNI (XXXXXXXXA): "));
		while(matcher.find()){
			System.out.println("DNI correcto " + matcher.group());
			encontrado=true;
		}
		if(!encontrado)
			System.out.println("DNI incorrecto.");
	}
}
