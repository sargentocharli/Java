package listadoEstructurasDatosIII.pila;
import utiles.*;

public class TestPilaMenu {
	static boolean pilaCreada=false;
	public static void main(String[] args) {
		
		String tituloMenu = "Pila";

		String[] opcionesMenu={"Crear pila", "Introducir elemento en la pila (al final)", 
				"Sacar elemento de la pila (el último)", 
				"Mostrar cima de la lista (último elemento de la lista)"};
		
		Menu menu = new Menu(tituloMenu, opcionesMenu);
		Pila<Videojuego> pilaVideojuegos = null;
		int opcion;
		//boolean pilaCreada=false;
		
		do{
			opcion=menu.gestionarMenu();
			switch(opcion){
			case 1:
				pilaVideojuegos = crear(pilaVideojuegos);								
				break;
			
			case 2:
				annadir(pilaVideojuegos);
				break;
				
			case 3:
				sacar(pilaVideojuegos);
				break;
				
			case 4:
				cima(pilaVideojuegos);
				
			case 5:
				break;
				
			default:
				error();
			}
			
		}while(opcion!=5);		

	}

	/**
	 * Crea una pila de tipo Videojuego
	 */
	static Pila<Videojuego> crearPila() {
		Pila<Videojuego> pilaVideojuegos = new Pila<Videojuego>();
		System.out.println("Pila creada.");
		return pilaVideojuegos;		
	}

	static void error() {
		System.out.println("Error. Opción inválida.");		
	}
	
	/**
	 * Añade un elemento a la pila
	 * @param pilaVideojuegos
	 */
	static void annadir(Pila<Videojuego> pilaVideojuegos){
		String tituloVideojuego;
		String generoVideojuego;
		if(!pilaCreada){
			System.out.println("Primero tiene que crear la pila.");			
		} else
			try {
				pilaVideojuegos.push(new Videojuego(tituloVideojuego=Teclado.leerCadena("Introduzca el título del videojuego: "), generoVideojuego=Teclado.leerCadena("Introduzca el género del videojuego (" + tituloVideojuego + "): ")));
			} catch (TituloNoValidoException | GeneroNoValidoException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
	}
	
	/**
	 * Muestra y saca el último elemento de la pila
	 */
	static void sacar(Pila<Videojuego> pilaVideojuegos){
		if (!pilaCreada){
			System.out.println("Primero tiene que crear la pila.");	
			return;
		}
		else if(pilaVideojuegos.top()==null)
			System.out.println("Pila vacía.");					
		else
			System.out.println(pilaVideojuegos.pop());		
	}
	
	/**
	 * Muestra el último elemento de la pila
	 */
	static void cima(Pila<Videojuego> pilaVideojuegos){
	if(pilaVideojuegos==null)
		System.out.println("Primero tiene que crear la pila.");	
	else if(pilaVideojuegos.top()==null)
		System.out.println("Pila vacía.");		
	else System.out.println(pilaVideojuegos.top());
	}
	
	/**
	 * Crea la pila
	 */
	static Pila<Videojuego> crear(Pila<Videojuego> pilaVideojuegos){
		pilaVideojuegos = crearPila();	
		pilaCreada = true;
		return pilaVideojuegos;
	}

}
