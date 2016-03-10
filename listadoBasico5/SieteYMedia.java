import utiles.*;
/**
* Define la clase SieteYMedia que permita al usuario jugar a las siete y media. Para ello,
* has de almacenar las 40 cartas en un array bidimensional. Utiliza el método
* Math.random() para seleccionar una de ellas. Recuerda que no pueden seleccionarse
* dos veces. El jugador decide si seguir arriesgando o no mediante una pregunta.
*/
public class SieteYMedia{
	public static void main(String[] args){
		int elemento,valor;
		double carta=0,acumulado=0;
		double[][] mazo = { 							// palos de la baraja elemental
							{1,2,3,4,5,6,7,0.5,0.5,0.5}, // tierras
							{1,2,3,4,5,6,7,0.5,0.5,0.5}, // aguas
							{1,2,3,4,5,6,7,0.5,0.5,0.5}, // fuegos
							{1,2,3,4,5,6,7,0.5,0.5,0.5}};// vientos
		do{
			do{
				elemento=(int)(Math.round(Math.random()*(0-3)+3));
				valor=(int)(Math.round(Math.random()*(0-9)+9));
				carta=mazo[elemento][valor];
			} while(carta==-1);
			mostrarCarta(elemento,valor);
			if(carta>0&&carta<8)
				acumulado+=mazo[elemento][valor];
			else if(carta>9&&carta<13)
				acumulado+=0.5;
			if(acumulado<7.5){
				System.out.print("\nTotal = " + acumulado);
			}
			else if(acumulado==7.5){
				System.out.print("\nTotal = " + acumulado);
				System.out.print("\nHas ganado!");
				break;
			}
			else if(acumulado>7.5){
				System.out.print("\nTotal = " + acumulado);
				System.out.print("\nTe has pasado... Qué pena, has perdido!");
				break;
			}
			mazo[elemento][valor]=-1;
		} while(continuar());
	}
	/**
	* Muestra el elemento y su valor
	* @param elemento: Número que indica el elemento
	* @param valor: Número que indica el valor
	*/
	static void mostrarCarta(int elemento, int valor){
		mostrarValor(valor);
		mostrarElemento(elemento);	
	}
	/**
	* Muestra el valor según el número que eliga el usuario
	* @param valor: El número de cada valor
	*/
	static void mostrarValor(int valor){
		switch(valor){
			case 0:
				System.out.print("El As ");
				break;
			case 1:
				System.out.print("El Dos ");
				break;
			case 2:
				System.out.print("El Tres ");
				break;
			case 3:
				System.out.print("El Cuatro ");
				break;
			case 4:
				System.out.print("El Cinco ");
				break;
			case 5:
				System.out.print("El Seis ");
				break;
			case 6:
				System.out.print("El Siete ");
				break;
			case 7:
				System.out.print("La Dama ");
				break;
			case 8:
				System.out.print("El Caballero ");
				break;
			default:
				System.out.print("El Rey ");
				break;
		}
	}
	/**
	* Muestra el elemento
	* @param elemento: El elemento elegido
	*/
	static void mostrarElemento(int elemento){
		switch(elemento){
			case 0:
				System.out.print(" de la Tierra.");
				break;
			case 1:
				System.out.print(" de las Aguas.");
				break;
			case 2:
				System.out.print(" del Fuego.");
				break;
			default:
				System.out.print(" de los Vientos.");
				break;
		}
	}
	/**
	* Pregunta al usuario si desea continuar pidiendo un caracter (s/n)
	* @return True si la respuesta es "s" o "S" y false en el resto de casos
	*/
	static boolean continuar(){
		char respuesta = Teclado.leerCaracter("\n¿Desea continuar? (s/n): ");
		if (respuesta == 's' || respuesta == 'S')
			return true;
		else
			return false;
	}
}

				
		