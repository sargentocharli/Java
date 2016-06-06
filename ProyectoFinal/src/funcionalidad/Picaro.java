package funcionalidad;

import excepciones.ArmaNoValidaException;
import excepciones.FechaNoValidaException;
import excepciones.NombreNoValidoException;
import interfaces.Fisico;
import interfaces.Vida;

/**
 * Clase tipo de personaje Pícaro
 * @author Lucas Márquez Muñoz
 * @version 1.0
 */
public class Picaro extends Personaje implements Fisico, Vida {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Energía del pícaro
	 */
	private int energia;
	
	/**
	 * Constructor que recibe todos los parámetros
	 * @param nombre El nombre del pícaro
	 * @param arma El arma del pícaro
	 * @param armadura La armadura del pícaro
	 * @param nacimiento El año de nacimiento del pícaro
	 * @throws NombreNoValidoException Excepción nombre no válido
	 * @throws ArmaNoValidaException Excepción arma no válida
	 * @throws FechaNoValidaException Excepción fecha no válida
	 */
	public Picaro(String nombre, Arma arma, Armadura armadura, int nacimiento) throws NombreNoValidoException, ArmaNoValidaException, FechaNoValidaException {
		super(nombre, ClasesPersonaje.PICARO, arma, armadura, nacimiento);
		setVida(calcularVida());
		setEnergia();
	}
	
	/**
	 * Cosntructor que no recibe parámetros
	 */
	public Picaro(){
		super();
	}
	
	/**
	 * Obtiene la energía que tiene el pícaro
	 * @return energía La energía del pícaro
	 */
	public int getEnergia() {
		return energia;
	}

	/**
	 * Establece la energía que tiene el pícaro en base a su edad	 
	 */
	void setEnergia() {
		if(getEdad()<18)
			this.energia = (int)(Math.random()*(1-10)+10);
		if(getEdad()>=18 && getEdad()<30)
			this.energia = (int)(Math.random()*(150-200)+200);
		if(getEdad()>=30 && getEdad()<50)
			this.energia = (int)(Math.random()*(100-150)+150);
		if(getEdad()>=50 && getEdad()<65)
			this.energia = (int)(Math.random()*(50-100)+100); 
		else
			this.energia = (int)(Math.random()*(10-25)+25);		
	}

	/**
	 * Calcula la vida del pícaro en base a su edad
	 * @return La vida del pícaro
	 */
	@Override
	public int calcularVida() {	
		if(getEdad()<18)
			return (int)(Math.random()*(1-10)+10);
		if(getEdad()>=18 && getEdad()<30)
			return (int)(Math.random()*(50-95)+95);
		if(getEdad()>=30 && getEdad()<50)
			return (int)(Math.random()*(30-75)+75);
		if(getEdad()>=50 && getEdad()<65)
			return (int)(Math.random()*(20-65)+65); 
		else
			return (int)(Math.random()*(1-15)+15);
	}

	/**
	 * Calcula el daño del ataque normal del pícaro en base a su edad
	 * @return el daño del ataque normal del pícaro
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
	 * Calcula el daño del ataque fuerte del pícaro en base a su edad
	 * @return el daño del ataque fuerte del pícaro
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