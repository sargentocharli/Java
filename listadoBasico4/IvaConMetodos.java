import utiles.*;
/**
* Define la clase IvaConMetodos que calcule los impuestos que se aplican a un
* precio base en función de si el iva es superreducido (4%), reducido (10%) o general
* (21%). Para ello define y usa los siguientes métodos: a. pedirIVA() b. pedirPrecio() c.
* continuar() d. calcularIva(double, char)
*/

public class IvaConMetodos{
	public static void main(String[] args){
		char tipoIVA =pedirIVA();
		double precio=pedirPrecio();
		double resultado =calcularIVA(precio,tipoIVA);
		do{
			System.out.printf("%s %s %s %.2f %s %.2f %s","El IVA de tipo ",tipoIVA," a aplicar sobre el precio ",precio," es de ",resultado,"\n");
		} while(continuar());
	}
	
	/**
	* Pregunta al usuario si desea continuar pidiendo un caracter (s/n)
	* @return True si la respuesta es "s" o "S" y false en el resto de casos
	*/
	static boolean continuar(){
		char respuesta = Teclado.leerCaracter("¿Desea continuar? (s/n): ");
		if (respuesta == 's' || respuesta == 'S')
			return true;
		else
			return false;
	}
	/**
	* Se pide el precio sobre el cual se calculará el IVA (debe ser mayor que 0)
	* @return precio: El precio introducido por el usuario
	*/
	static double pedirPrecio(){
		double precio;
		do{
			precio=Teclado.leerDecimal("Introduzca el precio base de un artículo (tiene que ser mayor que 0): ");
			if (precio<=0)
				System.out.println("Error. El valor introducido no está permitido. Introduzca un valor mayor que 0");
		} while(precio<=0);
		return precio;
	}
	/**
	* Pregunta al usuario el tipo de IVA que desea aplicar
	* return tipoIVA: El caracter que representa el tipo de iva que se va a aplicar
	*/
	static char pedirIVA(){
		char tipoIVA;
		do{
			tipoIVA=Teclado.leerCaracter("Indique el tipo de iva que desea aplicar (s = super reducido, r = reducido, g = general): ");
			if (tipoIVA != 's' && tipoIVA != 'r' && tipoIVA != 'g' && tipoIVA != 'S' && tipoIVA != 'R' && tipoIVA != 'G')
				System.out.println("Error. Introduzca un caracter válido (s/r/g)");
		} while (tipoIVA != 's' && tipoIVA != 'r' && tipoIVA != 'g' && tipoIVA != 'S' && tipoIVA != 'R' && tipoIVA != 'G');
		return tipoIVA;
	}
	/**
	* Calcula el IVA en función del precio base introducido y el tipo de IVA elegido
	* @param precio: Cantidad a la que se le aplicará el IVA, tipoIVA: El tipo de IVA
	* @return resultado: Valor del IVA una vez se ha aplicado
	*/
	static double calcularIVA(double precio, double tipoIVA){
		double resultado=0;
		if(tipoIVA=='s' || tipoIVA=='S')
			resultado=precio*0.04;
		else if(tipoIVA=='r' || tipoIVA=='R')
			resultado=precio*0.10;
		else if(tipoIVA=='g' || tipoIVA=='G')
			resultado=precio*0.21;
		return resultado;
	}
}
