package listadoEstructurasDatosII.lista;
import java.util.ArrayList;

import utiles.*;

public class TestLista {

	public static void main(String[] args) {
		// Creación del menú
		String[] opcionesMenu = {"Añadir videojuego al final de la lista", "Insertar videojuego en una determinada posición",
				"Modificar videojuego", "Ver tamaño de la lista", "Eliminar videojuego", "Buscar videojuego","Mostrar lista",
				"Copiar lista", "Mostrar lista copiada"};
				
		Menu menu = new Menu("Lista de videojuegos", opcionesMenu);
		Lista lista = new Lista();
		ArrayList<Videojuego> listaCopiada = new ArrayList<Videojuego>();
		
		int opcion;
		String titulo;
		String genero;
		String busqueda;
		int posicion;
		
		do{
			opcion = menu.gestionarMenu();
			switch(opcion){
			case 1:				
				lista.annadirAlFinal(titulo=Teclado.leerCadena("Introduzca el título del videojuego: "), genero=Teclado.leerCadena("Introduzca el género del videojuego (" + titulo + ") :"));
				break;
			case 2:
				lista.insertarEnPosicion(titulo=Teclado.leerCadena("Introduzca el título del videojuego: "), genero=Teclado.leerCadena("Introduzca el género del videojuego (" + titulo + ") :"), posicion=Teclado.leerEntero("Introduzca la posición de la lista en la que desea introducir el videojuego: "));
				break;
			case 3:
				lista.modificar(titulo=Teclado.leerCadena("Introduzca el título del videojuego: "), genero=Teclado.leerCadena("Introduzca el género del videojuego (" + titulo + ") :"), posicion=Teclado.leerEntero("Introduzca la posición de la lista en la que desea introducir el videojuego: "));
				break;
			case 4:
				System.out.println(lista.size());
				break;
			case 5:
				lista.eliminar(posicion=Teclado.leerEntero("Introduzca la posición que desea eliminar: "));
				break;
			case 6:
				lista.buscar(busqueda=Teclado.leerCadena("Introduzca el nombre a buscar"));
				break;
			case 7:
				System.out.println(lista);				
				break;
			case 8:
				listaCopiada = lista.copiar();
				break;
			case 9:				
				System.out.println(listaCopiada);
				break;				
			case 10:
				break;
			default:
			//	error();
				break;
			}
		}while(opcion != 10);
	}

}
