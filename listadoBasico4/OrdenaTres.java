import utiles.*;
/**
* Define la clase OrdenaTres que ordene tres números enteros introducidos por
* teclado y los muestre por pantalla de forma decreciente. Se le preguntará al usuario
* si quiere repetir el programa. Utiliza métodos (deseaContinuar, leerTresEnteros,
* mostrarResultados…)
*/
public class OrdenaTres{
	public static void main(String[] args){
		do{
			mostrarInstrucciones();
			leerTresEnteros();
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
		System.out.println("Introduzca los valores de tres números y serán mostrados de mayor a menor.");
	}
	/**
	* Recoge los 3 valores introducidos por teclado y los pasa a mostrarResultados
	*/
	static void leerTresEnteros(){
		int num1,num2,num3;
		num1=Teclado.leerEntero("Introduzca el primer número: ");
		num2=Teclado.leerEntero("Introduzca el segundo número: ");
		num3=Teclado.leerEntero("Introduzca el tercer número: ");
		mostrarResultados(num1,num2,num3);
	}
	/**
	* Ordena los números y los muestra por pantalla
	*/
	static void mostrarResultados(int num1, int num2, int num3){
		if(num1>num2 && num1>num3 && num2>num3)
			System.out.println("Los números ordenados de mayor a menor son: " + num1 + " > " + num2 + " > " + num3);
		else if(num1>num2 && num1>num3 && num2<num3)
			System.out.println("Los números ordenados de mayor a menor son: " + num1 + " > " + num3 + " > " + num2);
		else if(num2>num1 && num2>num3 && num1>num3)
			System.out.println("Los números ordenados de mayor a menor son: " + num2 + " > " + num1 + " > " + num3);
		else if(num2>num1 && num2>num3 && num1<num3)
			System.out.println("Los números ordenados de mayor a menor son: " + num2 + " > " + num3 + " > " + num1);
		else if(num3>num1 && num3>num2 && num1>num2)
			System.out.println("Los números ordenados de mayor a menor son: " + num3 + " > " + num1 + " > " + num2);
		else if(num3>num1 && num3>num2 && num1<num2)
			System.out.println("Los números ordenados de mayor a menor son: " + num3 + " > " + num2 + " > " + num1);
	}
}