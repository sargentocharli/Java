package cuentaCorrienteYTitulares;

/**
* @author Lucas Márquez Muñoz
*/
public class Cuenta {	
	
	static int ultimoCodigo;	
	int codigo;
	double saldo;
	Persona persona;
	
	/**
	 * Constructor que recibe persona y saldoInicial
	 * @param persona La persona titular de la cuenta
	 * @param saldoInicial El saldo inicial de la cuenta
	 * @throws SaldoNoValidoException 
	 */
	Cuenta(Persona persona, double saldoInicial) throws SaldoNoValidoException {
		codigo = ++ultimoCodigo;
		setSaldo(saldoInicial);
		this.persona = persona;
	}
	
	/**
	 * Constructor que recibe el código
	 */
	Cuenta(int codigo){
		this.codigo=codigo;
	}	
	
	/**
	 * Constructor que recibe la persona titular
	 */
	Cuenta(Persona persona){
		setPersona(persona);
	}
	

	/**
	 * Elimina de la cuenta la cantidad pasada
	 * @param cantidad La cantidad a eliminar
	 * @throws ReintegroNoValidoException
	 * @throws SaldoNoValidoException 
	 */
	public void reintegro(double cantidad) throws ReintegroNoValidoException, SaldoNoValidoException{
		if (cantidad > saldo) 		
			throw new ReintegroNoValidoException("Error. No hay saldo suficiente en la cuenta para realizar el reintegro.");
		setSaldo(getSaldo()-cantidad);			
	}
	
	/**
	 * Ingresa en la cuenta la cantidad pasada
	 * @param cantidad La cantidad a ingresar
	 * @throws SaldoNoValidoException 
	 */
	public void ingresar(double cantidad) throws SaldoNoValidoException {
		setSaldo(getSaldo()+cantidad);
	}	
	
	
	Persona getPersona() {
		return persona;
	}

	void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * Obtiene el saldo de la cuenta
	 * @return saldo El saldo de la cuenta
	 */
	public double getSaldo() {
		return saldo;
	}	
	
	void setSaldo(double d) throws SaldoNoValidoException{
		if(saldo<0)
			throw new SaldoNoValidoException("Error. Saldo insuficiente.");
		this.saldo = d;			
	}

	@Override
	public String toString() {
		return "\nCuenta :" + codigo + ", saldo=" + saldo + " " + persona;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Cuenta other = (Cuenta) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
}
