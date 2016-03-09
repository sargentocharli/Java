package listadoEstructurasDatosIII.cola;

import utiles.*;

public class TestColaMenu {
	static boolean colaCreada=false;
	public static void main(String[] args) {
		
		String tituloMenu = "Cola";

		String[] opcionesMenu={"Crear cola", "Introducir elemento en la cola (al final)", 
				"Sacar elemento de la cola (el primero)", 
				"Mostrar cabeza de la cola (primer elemento de la lista)"};
		
		Menu menu = new Menu(tituloMenu, opcionesMenu);
		Cola<Videojuego> colaVideojuegos = null;
		int opcion;		
		
		do{
			opcion=menu.gestionarMenu();
			switch(opcion){
			case 1:
				colaVideojuegos = crear(colaVideojuegos);								
				break;
			
			case 2:
				annadir(colaVideojuegos);
				break;
				
			case 3:
				sacar(colaVideojuegos);
				break;
				
			case 4:
				head(colaVideojuegos);
				
			case 5:
				break;
				
			default:
				error();
			}
			
		}while(opcion!=5);		

	}

	/**
	 * Crea una cola de tipo Videojuego
	 */
	static Cola<Videojuego> crearCola() {
		Cola<Videojuego> colaVideojuegos = new Cola<Videojuego>();
		System.out.println("Cola creada.");
		return colaVideojuegos;		
	}

	static void error() {
		System.out.println("Error. Opción inválida.");		
	}
	
	/**
	 * Añade un elemento a la cola
	 * @param pilaVideojuegos
	 */
	static void annadir(Cola<Videojuego> colaVideojuegos){
		String tituloVideojuego;
		String generoVideojuego;
		if(!colaCreada){
			System.out.println("Primero tiene que crear la cola.");			
		} else
			try {
				colaVideojuegos.push(new Videojuego(tituloVideojuego=Teclado.leerCadena("Introduzca el título del videojuego: "), generoVideojuego=Teclado.leerCadena("Introduzca el género del videojuego (" + tituloVideojuego + "): ")));
			} catch (TituloNoValidoException | GeneroNoValidoException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
	}
	
	/**
	 * Muestra y saca el primer elemento de la cola
	 */
	static void sacar(Cola<Videojuego> colaVideojuegos){
		if (!colaCreada){
			System.out.println("Primero tiene que crear la cola.");	
			return;
		}
		else if(colaVideojuegos.head()==null)
			System.out.println("Cola vacía.");					
		else
			System.out.println(colaVideojuegos.pop());		
	}
	
	/**
	 * Muestra el primer elemento de la cola
	 */
	static void head(Cola<Videojuego> colaVideojuegos){
	if(colaVideojuegos==null)
		System.out.println("Primero tiene que crear la cola.");	
	else if(colaVideojuegos.head()==null)
		System.out.println("Cola vacía.");		
	else System.out.println(colaVideojuegos.head());
	}
	
	/**
	 * Crea la cola
	 */
	static Cola<Videojuego> crear(Cola<Videojuego> colaVideojuegos){
		colaVideojuegos = crearCola();	
		colaCreada = true;
		return colaVideojuegos;
	}

}
