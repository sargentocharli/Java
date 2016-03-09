package listadoEstructurasDatosIII.topMusic;
import utiles.*;

public class TestTopMusic {

	public static void main(String[] args) {
		
		String tituloMenu = "TopMusic";
		String[] opcionesMenu = {"Añadir canción en una posición específica",
								"Sacar canción del TopMusic", "Subir puesto",
								"Bajar puesto", "Mostrar TopMusic",
								"Mostrar el TOP del topMusic"};
		
		Menu menu = new Menu(tituloMenu, opcionesMenu);
		
		Lista lista = new Lista();
		lista.addLista(null);
		int opcion;
		int posicion;
		
		do{
			opcion=menu.gestionarMenu();
			
			switch(opcion){
				
			case 1:
				annadir(lista);
				break;
			
			case 2:
				sacar(lista);
				break;
			
			case 3:
				subir(lista);
				break;
				
			case 4:
				bajar(lista);
				break;
				
			case 5:
				System.out.println(lista);
				break;
				
			case 6:
				mostrarTop(lista);
				break;				
			
			case 7:
				break;
				
			default:
				error();
			}
			
		}while(opcion!=7);
	}

	
	/**
	 * Añade una canción a la lista en la posición indicada
	 * @param lista La lista en la que se añade la canción
	 */
	private static void annadir(Lista lista){
		
		try {
			String titulo;
			String artista;
			int annoGrabacion;
			int posicion;
			
			lista.annadir(titulo=Teclado.leerCadena("Título de la canción a añadir: "), 
					artista=Teclado.leerCadena("Artista/grupo de la canción a añadir: "), 
					annoGrabacion=Teclado.leerEntero("Año de grabación de la canción a añadir: "), 
					posicion=(Teclado.leerEntero("Posición en la que se introducirá la nueva canción: ")) + 1);
		} catch (TituloNoValidoException | ArtistaNoValidoException | AnnoGrabacionNoValidoException | PosicionNoValidaException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}		
	}
	
	/**
	 * Elimina una canción de la posición indicada de la lista
	 * @param lista La lista en la que se elimina la canción
	 */
	private static void sacar(Lista lista){
		int posicion;
		try {
			lista.sacar(posicion=Teclado.leerEntero("Posición de la canción que se va a eliminar: "));
		} catch (PosicionNoValidaException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}			
		}
	
	/**
	 * Sube un puesto una canción de la lista según su posición actual
	 * @param lista La lista con la que se trabaja
	 */
	private static void subir(Lista lista){				
		try {
			int posicion;
			lista.subir((posicion=Teclado.leerEntero("Posición de la canción que va a subir un puesto: ")) + 1);
		} catch (PosicionNoValidaException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Baja un puesto una canción de la lista según su posición actual
	 * @param lista La lista con la que se trabaja
	 */
	private static void bajar(Lista lista){
		try{
			int posicion;
			lista.bajar((posicion=Teclado.leerEntero("Posición de la canción que va a bajar un puesto: ")) + 1);
		} catch (PosicionNoValidaException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Muestra la canción en primera posición
	 * @param lista La lista con la que se trabaja
	 */
	private static void mostrarTop(Lista lista){		
			System.out.println(lista.mostrarTop());
	}
	
	/**
	 * Muestra un mensaje de error
	 */
	private static void error(){
		System.out.println("Error. Opción no válida.\n");
	}
}
