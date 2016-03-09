package utiles;

public class Menu {
	
	//Atributos de la clase Menu
	
	/**
	 * Título del menú
	 */
	private String titulo;
	
	/**
	 * Opciones del menú 
	 */
	private String[] opciones;
	
	/**
	 * Número opciones del menú
	 */
	private int numeroOpciones;
	
	//Constructor	
	
	/**
	 * Constructor que recibe el título y las opciones posibles
	 * @param titulo El título del menú
	 * @param opciones Las opciones del menú
	 */
	public Menu(String titulo, String[] opciones){
		this.titulo=titulo;
		setNumeroOpciones(opciones);
		setOpciones(opciones);
		
	}
	
	//Comportamiento de la clase Menu
	
	/**
	 * Reasigna los elementos del vector recibido en el vector de la clase
	 * @param opciones El vector recibido
	 */
	private void setOpciones(String[] opciones){
		int i=0;                                        
		this.opciones= new String[opciones.length+1]; //Creamos vector para las opciones
		for(String opcion : opciones)                 //Recorremos el vector recibido para recoger sus elementos
			this.opciones[i++]=opcion;                //Asignamos el elemento recogido al vector creado
		this.opciones[i]="Salir";                     //Asignamos el elemento final Salir			
	}
	
	private void setNumeroOpciones(String[] opciones){
		this.numeroOpciones=opciones.length+1;		
	}
	
	/**
	 * Muestra el menú con un número antes de cada opción, comenzando por 1
	 */
	private void mostrar(){
		System.out.println(titulo);
		for(int i=1; i<numeroOpciones;i++)
			System.out.println("(" + i + ")" + opciones[i-1]);
		System.out.println("(" + numeroOpciones + ") Salir");		
	}
	
	/**
	 * Recoge una opción válida introducida por el usuario
	 * @return opcionElegida La opción válida introducida por el usuario
	 */
	private int recogeOpcionValida(){
		int opcionElegida;
		do{
			opcionElegida=Teclado.leerEntero("Elige una opción válida: ");
			if(opcionElegida<1 || opcionElegida>numeroOpciones+1)
				System.out.println("Error. Esa opción no existe.");
		} while(opcionElegida<1 || opcionElegida>numeroOpciones+1);	
		return opcionElegida;
	}
	
	public int gestionarMenu(){
		mostrar();
		return recogeOpcionValida();		
	}
}
	

