import utiles.*;
/**
* Define la clase EcuacionSegundoGrado que muestre las soluciones de una
* ecuación de segundo grado ax2 + bx + c = 0. Se le preguntará al usuario si quiere
* repetir el programa. Utiliza métodos (deseaContinuar, leerCoeficientes,
* mostrarResultados…)
*/

public class EcuacionSegundoGrado{
	public static void main(String[]args){
		do{
			mostrarInstrucciones();
			leerCoeficientes();
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
	* Muestra por pantalla las instrucciones del programa
	*/
	static void mostrarInstrucciones(){
		System.out.println("Una ecuación de segundo grado tiene la siguiente forma: ax2 + bx + c = 0\nIntroduzca los valores de a, b y c para calcular el valor de x");
	}
	/**
	* Pide al usuario el valor de a,b y c y los pasa al método mostrarResultados
	*/
	static void leerCoeficientes(){
		int a,b,c;
		a=Teclado.leerEntero("Introduzca el valor de a: ");
		b=Teclado.leerEntero("Introduzca el valor de b: ");
		c=Teclado.leerEntero("Introduzca el valor de c: ");
		mostrarResultados(a,b,c);
	}
	/**
	* Calcula el discriminante y realiza los cálculos necesarios en función de este
	* @param a,b,c: Coeficientes dados pro el usuario
	*/
	static void mostrarResultados(int a,int b,int c){
		double x1,x2,discriminante;
		discriminante=(Math.pow(b,2)) - (4*a*c);
		if (a==0){
			System.out.println("La ecuación introducida no es una ecuación de segundo grado.");
		}
		else if(discriminante>0){
			x1=(-b+Math.sqrt(discriminante)) / (2*a);
			x2=(-b-Math.sqrt(discriminante)) / (a*a);
			System.out.println("Resultados de la ecuación:\nx1 = " + x1 + "x2 = " + x2);
		}
		else if (discriminante==0){
			x1=-b/(2*a);
			System.out.println("La solucion es doble. x = " + x1);
		}
		else
			System.out.println("El discriminante es " + discriminante + " (menor que 0), por lo que la ecuación no tiene solución real.");
	}
}
	