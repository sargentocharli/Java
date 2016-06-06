package funcionalidad;

import excepciones.ArmaNoValidaException;
import excepciones.FechaNoValidaException;
import excepciones.NombreNoValidoException;
import interfaces.Fisico;
import interfaces.Vida;

/**
 * Clase tipo de personaje Guerrero
 * @author Lucas Márquez Muñoz
 * @version 1.0
 */
public class Guerrero extends Personaje implements Fisico, Vida{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Cantidad de ira que tiene el guerrero
	 */
	private int ira;
	
	/**
	 * Constructor que recibe todos los parámetros
	 * @param nombre El nombre del guerrero 
	 * @param arma El arma del guerrero
	 * @param armadura La armadura del guerrero
	 * @param nacimiento El año de nacimiento del guerrero
	 * @throws NombreNoValidoException Excepción nombre no válido
	 * @throws ArmaNoValidaException Excepción arma no válida
	 * @throws FechaNoValidaException Excepción fecha no válida
	 */
	public Guerrero(String nombre, Arma arma, Armadura armadura, int nacimiento)
			throws NombreNoValidoException, ArmaNoValidaException, FechaNoValidaException {
		super(nombre, ClasesPersonaje.GUERRERO, arma, armadura, nacimiento);
		setVida(calcularVida());
		setIra();		
	}
	
	/**
	 * Constructor que no recibe parámetros
	 */	
	public Guerrero(){
		super();
	}

	/**
	 * Obtiene la ira que tiene el guerrero
	 * @return ira La ira
	 */
	public int getIra() {
		return ira;
	}

	/**
	 * Establece la ira que tiene el guerrero en base a su edad	
	 */
	void setIra() {
		if(getEdad()<18)
			this.ira = (int)(Math.random()*(1-10)+10);
		if(getEdad()>=18 && getEdad()<30)
			this.ira = (int)(Math.random()*(150-200)+200);
		if(getEdad()>=30 && getEdad()<50)
			this.ira = (int)(Math.random()*(100-150)+150);
		if(getEdad()>=50 && getEdad()<65)
			this.ira = (int)(Math.random()*(50-100)+100); 
		else
			this.ira = (int)(Math.random()*(10-25)+25);
	}

	/**
	 * Calcula la vida del guerrero en base a su edad
	 * @return La vida del guerrero
	 */
	@Override
	public int calcularVida() {	
		if(getEdad()<18)
			return (int)(Math.random()*(1-10)+10);
		if(getEdad()>=18 && getEdad()<30)
			return (int)(Math.random()*(50-100)+100);
		if(getEdad()>=30 && getEdad()<50)
			return (int)(Math.random()*(30-80)+80);
		if(getEdad()>=50 && getEdad()<65)
			return (int)(Math.random()*(20-60)+60); 
		else
			return (int)(Math.random()*(1-15)+15);				
	}

	/**
	 * Calcula el daño del ataque normal del guerrero en base a su edad
	 * @return el daño del ataque normal del guerrero
	 */
	@Override
	public int calcularAtaqueNormal() {		
		if(getEdad()<18)
			return (int)(Math.random()*(1-3)+3);
		if(getEdad()>=18 && getEdad()<30)
			return (int)(Math.random()*(5-8)+8);
		if(getEdad()>=30 && getEdad()<50)
			return (int)(Math.random()*(7-12)+12);
		if(getEdad()>=50 && getEdad()<65)
			return (int)(Math.random()*(6-11)+11); 
		else
			return (int)(Math.random()*(1-15)+15);		
	}

	/**
	 * Calcula el daño del ataque fuerte del guerrero en base a su edad
	 * @return el daño del ataque fuerte del guerrero
	 */
	@Override
	public int calcularAtaqueFuerte() {		
		if(getEdad()<18)
			return (int)(Math.random()*(1-3)+3)*2;
		if(getEdad()>=18 && getEdad()<30)
			return (int)(Math.random()*(5-8)+8)*2;
		if(getEdad()>=30 && getEdad()<50)
			return (int)(Math.random()*(7-12)+12)*2;
		if(getEdad()>=50 && getEdad()<65)
			return (int)(Math.random()*(6-11)+11)*2; 
		else
			return (int)(Math.random()*(1-15)+15)*2;	
	}
}