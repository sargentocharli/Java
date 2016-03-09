package concesionario;
import utiles.*;

/**
 * 
 * @author d15mamul
 *
 */

public class TestConcesionario {

	static Menu menuColor = new Menu("Lista de colores disponibles", Color.AZUL.opcionesMenu());
	static Menu menuModelo = new Menu("Lista de modelos disponibles", Modelo.CORDOBA.opcionesMenu());
	static Concesionario concesionario = new Concesionario();
	public static void main(String[] args) {		
		
		Menu menu=new Menu("Gestor del concesionario", new String[]{
				"Añadir coche",
				"Eliminar coche",
				"Buscar coche",
				"Mostrar lista",
				"Contar coches",
				"Mostrar coches de un color"
		});
		
		int opcion;
		
		do{
			opcion=menu.gestionarMenu();
			
			switch(opcion){
			case 1:
				annadirCoche();
				break;
			case 2:
				eliminarCoche();
				break;
			case 3:
				buscarCoche();
				break;
			case 4:
				System.out.println(concesionario);
				break;
			case 5:
				System.out.println("Número total de coches en el concesionario: " + concesionario.cuentaCoches());
				break;
			case 6:
				System.out.println(concesionario.getCochesMismoColor(pedirColor()));
				break;
			case 7:
				break;
			default:
				//error();
			}
		} while(opcion!=7);
	}	

	/**
	 * Comprueba si la matrícula es válida y, en caso de serla, añade el coche 
	 * al concesionario
	 */
	static void annadirCoche() {
		try {
			String matricula=Teclado.leerCadena("Introduzca la matrícula: ");						
			Coche coche=new Coche(matricula, pedirModelo(), pedirColor());
			concesionario.annadirCoche(coche);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
	
	/**
	 * Comprueba si la matrícula es válida y, en caso de serla, elimina el coche 
	 * del concesionario 
	 */
	static void eliminarCoche(){
		try {
			Coche coche = new Coche(Teclado.leerCadena("Introduzca la matrícula: "));
			concesionario.eliminarCoche(coche);
		} catch (MatriculaNoValidaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Muestra un coche según la matrícula pasada 
	 */
	static void buscarCoche(){
		try {
			Coche coche = new Coche(Teclado.leerCadena("Introduzca la matrícula: "));
			System.out.println(concesionario.buscarCoche(coche));
		} catch (MatriculaNoValidaException e) {
			System.out.println(e.getMessage());
		}
	}	
	
	/**
	 * Muestra un menú con los colores posibles y devuelve el color elegido
	 * @return null en caso de salir, el color elegido en caso de elegir un color
	 */
	static Color pedirColor(){
		int opcion=menuColor.gestionarMenu();		
		Color[] arrayColores=Color.AZUL.getValues();
		if(opcion==arrayColores.length+1)
			return null;
		return arrayColores[opcion-1];
	}
	
	/**
	 * Muestra un menú con los modelos posibles y devuelve el modelo elegido
	 * @return null en caso de salir, el modelo elegido en caso de elegir un color
	 */
	static Modelo pedirModelo(){
		int opcion=menuModelo.gestionarMenu();		
		Modelo[] arrayModelos=Modelo.CORDOBA.getValues();
		if(opcion==arrayModelos.length+1)
			return null;
		return arrayModelos[opcion-1];
	}
}


