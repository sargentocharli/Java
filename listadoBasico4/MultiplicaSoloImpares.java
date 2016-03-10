import utiles.*;
/**
* Define la clase MultiplicaSoloImpares que multiplique 20 números impares
* leídos desde teclado y muestre el resultado en pantalla. Define al menos los métodos
* mostrarInstrucciones y leerImpar
*/

public class MultiplicaSoloImpares{
	public static void main(String[] args){
		int numeroIntroducido, producto=1;
		mostrarInstrucciones();
		for(int i=0;i<20;i++){
			numeroIntroducido=leerImpar();
			while(numeroIntroducido%2==0){
				System.out.println("Error. El número introducido es par.");
				numeroIntroducido=leerImpar();
			}
			producto*=numeroIntroducido;
		}
		System.out.println("El producto total vale "+ producto);
	}
	/**
	* Muestra por pantalla las instrucciones del programa.
	*/
	static void mostrarInstrucciones(){
		System.out.println("Introduzca 20 números impares para calcular su producto: ");
	}
	/**
	* Recoge por teclado un número introducido
	* @return El número introducido por teclado
	*/
	static int leerImpar(){
		return Teclado.leerEntero("Introduzca un número impar: ");
	}
}
				