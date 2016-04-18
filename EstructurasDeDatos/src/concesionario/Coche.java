package concesionario;

//Comentario Miguel Angel

import java.util.regex.Pattern;

/**
 * 
 * @author d15mamul
 *
 */

public class Coche {
	
	/**
	 * Atributos del coche
	 */
	
	/**
	 * Matrícula del coche
	 */
	private String matricula;
	
	/**
	 * Modelo del coche
	 */
	private Modelo modelo;	
	
	/**
	 * Color del coche
	 */
	private Color color;
	
	/**
	 * Constructor que recibe la matrícula, el modelo y el color del coche
	 * @param matricula La matrícula del coche
	 * @param modelo El modelo del coche
	 * @param color El color del coche
	 */	
	Coche (String matricula, Modelo modelo, Color color) throws Exception{
		setMatricula(matricula);
		setModelo(modelo);
		setColor(color);
	}
	
	/**
	 * Constructor que recibe la matrícula del coche
	 * @param matricula La matrícula del coche
	 */
	Coche (String matricula) throws MatriculaNoValidaException{
		setMatricula(matricula);
	}
	
	/**
	 * Comprueba la matrícula recibida, lanzando una excepción en caso de no ser válida
	 * y aceptándola en caso de ser válida
	 * @param matricula La matrícula del coche
	 * @throws MatriculaNoValidaException
	 */
	void setMatricula(String matricula) throws MatriculaNoValidaException{
		if(!comprobarMatricula(matricula))
				throw new MatriculaNoValidaException("Error. Matrícula no válida.");
		this.matricula = matricula;
	}

	/**
	 * Comprueba si la matrícula recibida coincide con la expresión regular
	 * @param matricula La matrícula recibida
	 * @return true si coincide, false si no coincide
	 */
	private boolean comprobarMatricula(String matricula) {
		Pattern pattern = Pattern.compile("^(?i)\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$");
		return pattern.matcher(matricula).matches();
		
	}

	/**
	 * Comprueba que el modelo recibido sea válido
	 * @param modelo El modelo recibido
	 * @throws ModeloNoValidoException
	 */
	void setModelo(Modelo modelo) throws ModeloNoValidoException{
		if(modelo==null)
			throw new ModeloNoValidoException("Error. El modelo no es válido.");
		this.modelo = modelo;
	}

	/**
	 * Comprueba que el color recibido sea válido
	 * @param color El color recibido
	 * @throws ColorNoValidoException
	 */
	void setColor(Color color) throws ColorNoValidoException{
		if(color==null)
			throw new ColorNoValidoException("Error. El color no es válido.");
		this.color = color;
	}
	
	/**
	 * Devuelve el color del coche
	 * @return El color del coche
	 */
	Color getColor(){
		return color;
	}
	
	@Override
	public String toString() {
		return "\nCoche [matricula=" + matricula + ", modelo=" + modelo + ", color=" + color + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
	
}
