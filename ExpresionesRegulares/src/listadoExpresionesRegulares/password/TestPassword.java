package listadoExpresionesRegulares.password;

/**
 * @author Lucas Márquez Muñoz
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utiles.Teclado;

public class TestPassword {

	public static void main(String[] args) {

		do{
			password();
		} while(continuar());			

	}
	
	static boolean continuar(){
		char respuesta = Teclado.leerCaracter("¿Desea continuar? (s/n): ");
		if (respuesta == 's' || respuesta == 'S')
			return true;
		else
			return false;
	}

	private static void password(){
		boolean encontrado=false;
		Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!#$%]).{6,}$");
		Matcher matcher = pattern.matcher(Teclado.leerCadena("Introduce una contraseña: "));
		while(matcher.find()){
			System.out.println("Contraseña robusta: " + matcher.group());
			encontrado=true;
		}
		if(!encontrado)
			System.out.println("Contraseña débil.");
	}

}
