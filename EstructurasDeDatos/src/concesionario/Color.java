package concesionario;

/**
 * 
 * @author d15mamul
 *
 */

public enum Color {	
	PLATA,
	ROJO,
	AZUL;

	
	/**
	 * Array que almacena los colores posibles 
	 */
	private static final Color[] VALUES = Color.values();
	
	/**
	 * Genera un menú con los colores posibles
	 */
	public String[] opcionesMenu(){
		int i=0;
		String[] opcionesMenuColores=new String[VALUES.length];
		for(i=0;i<VALUES.length;i++){
			opcionesMenuColores[i]=VALUES[i].name();
		}	
		
		return opcionesMenuColores;
	}
	
	/**
	 * Devuelve VALUES de la enumeración
	 */
	public Color[] getValues(){
		return VALUES;
	}
}
