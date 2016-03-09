package concesionario;

/**
 * 
 * @author d15mamul
 *
 */

public enum Modelo {
	SERIE1(Marca.BMW),
	SERIE2(Marca.BMW),
	SERIE3(Marca.BMW),
	SERIE5(Marca.BMW),
	
	CORDOBA(Marca.SEAT),
	IBIZA(Marca.SEAT),
	TOLEDO(Marca.SEAT);
	
	/**
	 * Array que almacena todos los modelos
	 */
	private static final Modelo[] VALUES = Modelo.values();
	
	/**
	 * Genera un menú con los modelos posibles
	 */
	public String[] opcionesMenu(){
		int i=0;
		String[] opcionesMenuModelos=new String[VALUES.length];
		for(i=0;i<VALUES.length;i++){
			opcionesMenuModelos[i]=VALUES[i].name();
		}	
		
		return opcionesMenuModelos;
	}
	
	/**
	 * Atributo que nos indica la marca del modelo
	 */
	private Marca marca;
	
	/**
	 * Constructor que recibe una marca de coche
	 * @param marca La marca de coche
	 */
	private Modelo (Marca marca){
		this.marca=marca;
	}
	
	/**
	 * Obtiene la marca
	 * @return marca La marca del coche
	 */
	public Marca getMarca(){
		return marca;
	}
	
	/**
	 * Devuelve VALUES del modelo
	 */
	public Modelo[] getValues(){
		return VALUES;
	}
}



