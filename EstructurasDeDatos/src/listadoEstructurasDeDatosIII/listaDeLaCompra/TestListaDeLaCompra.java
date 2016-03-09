package listadoEstructurasDatosIII.listaDeLaCompra;

import utiles.Menu;
import utiles.Teclado;

public class TestListaDeLaCompra {
	static ListaDeLaCompra lista=new ListaDeLaCompra();
	static Menu menu=new Menu("\nLista de la compra",new String[]{
			"Añadir elemento",
			"Eliminar elemento",
			"Incrementar existencias",
			"Decrementar existencias",
			"Modificar cantidad mínima",
			"Mostrar todos los artículos",
			"Mostrar lista de la compra"});
	
	public static void main(String[] args) {
		int opcion;
		
		do{
			opcion=menu.gestionarMenu();
			
			switch(opcion){
			case 1:
				anadirArticulo();
				break;
			case 2:
				eliminarArticulo();
				break;
			case 3:
				incrementarExistencias();
				break;
			case 4:
				decrementarExistencias();
				break;
			case 5:
				modificarCantidadMinima();
				break;
			case 6:
				System.out.println(lista);
				break;
			case 7:
				try {
					System.out.println(lista.generarListaDeLaCompra());
				} catch (ListaVaciaException e) {
					System.out.println(e.getMessage());					
				}
				break;
			case 8:
				break;
			default:
				System.out.println("\nError. Opcion incorrecta");
			}		
		}while(opcion!=8);
	}
	
	private static void anadirArticulo(){
		
		try {
			String nombre=Teclado.leerCadena("Introduzca el nombre del artículo: ");
			int existencias=Teclado.leerEntero("Introduzca las existencias del artículo: ");
			int minimo=Teclado.leerEntero("Introduzca la cantidad mínima: ");
			
			Articulo articulo;			
			articulo = new Articulo(nombre,existencias,minimo);
			lista.anadir(articulo);
			
		} catch (NombreNoValidoException | ExistenciasNoValidasException | MinimoNoValidoException | YaExisteArticuloException e) {
			System.out.println(e.getMessage());			
		}		
	}
	
	private static void eliminarArticulo(){
		
		try {
			String nombre=Teclado.leerCadena("Introduzca el nombre del artículo: ");
			
			Articulo articulo;
			articulo = new Articulo(nombre);
			lista.eliminar(articulo);
			
		} catch (NombreNoValidoException e) {
			System.out.println(e.getMessage());
			
		}		
	}
	
	private static void incrementarExistencias(){
		
		try {
			String nombre=Teclado.leerCadena("Introduzca el nombre del artículo: ");
			int incremento=Teclado.leerEntero("Introduzca el incremento del artículo: ");
			
			Articulo articulo;
			articulo = new Articulo(nombre);
			lista.incrementarExistencias(articulo,incremento);				
			
		} catch (NombreNoValidoException | ExistenciasNoValidasException | NoExisteArticuloException | IncrementoNoValidoException e) {
			System.out.println(e.getMessage());
			
		} 
	}
	
	private static void decrementarExistencias(){
		
		try {
			String nombre=Teclado.leerCadena("Introduzca el nombre del artículo: ");
			int incremento=Teclado.leerEntero("Introduzca el decremento del artículo: ");
			
			Articulo articulo;
			articulo = new Articulo(nombre);
			lista.decrementarExistencias(articulo,incremento);				
	
		} catch (NombreNoValidoException | ExistenciasNoValidasException | NoExisteArticuloException | DecrementoNoValidoException e) {
			System.out.println(e.getMessage());
			
		}
		
	}
	
	private static void modificarCantidadMinima(){
		
		try {
			String nombre=Teclado.leerCadena("Introduzca el nombre del artículo: ");
			int cantidad=Teclado.leerEntero("Introduzca la cantidad mínima del artículo: ");
			
			Articulo articulo;
			articulo = new Articulo(nombre);			
			lista.setCantidadMinima(articulo,cantidad);				
			
		} catch (NombreNoValidoException | MinimoNoValidoException | NoExisteArticuloException e) {
			System.out.println(e.getMessage());
			
		}
	
	}

}
