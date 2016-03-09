package cuentaCorrienteYTitulares;

import java.util.ArrayList;
import java.util.Iterator;

public class Banco {
	
	private ArrayList<Cuenta> banco = null;
	
	Banco(){
		banco=new ArrayList<Cuenta>();
	}
	
	
	/**
	 * añade cuenta al banco
	 * @param cuenta La cuenta que se va a añadir
	 */
	void anadirCuenta(Cuenta cuenta){
		if(!banco.contains(cuenta))
			banco.add(cuenta);
		
	}
	
	/**
	 * elimina cuenta del banco
	 * @param cuenta La cuenta que se va a eliminar
	 */
	void eliminarCuenta(Cuenta cuenta){
		banco.remove(cuenta);
	}
	
	/**
	 * ingresar dinero en cuenta
	 * @param cuenta La cuenta en la que se va a ingresar
	 * @throws SaldoNoValidoException 
	 * @throws CuentaNoExistenteException 
	 */
	void ingresar(Cuenta cuenta, double ingreso) throws SaldoNoValidoException, CuentaNoExistenteException{
		try{
		cuenta = banco.get(banco.indexOf(cuenta));
		cuenta.ingresar(ingreso);
		} catch (ArrayIndexOutOfBoundsException e){
			throw new CuentaNoExistenteException("Error. La cuenta no existe.");
		}		
	}
	
	/**
	 * reintegro en cuenta
	 * @param cuenta La cuenta en la que se va a reintegrar
	 * @param cantidad La cantidad a reintegrar
	 * @throws ReintegroNoValidoException 
	 * @throws CuentaNoExistenteException 
	 * @throws SaldoNoValidoException 
	 */
	void reintegro(Cuenta cuenta, double cantidad) throws ReintegroNoValidoException, CuentaNoExistenteException, SaldoNoValidoException{
		try{
		cuenta = banco.get(banco.indexOf(cuenta));
		cuenta.reintegro(cantidad);
		} catch (ArrayIndexOutOfBoundsException e){
			throw new CuentaNoExistenteException("Error. La cuenta no existe.");
		}
	}
	
	/**
	 * transferencia de cuentas
	 * @param cuentaOrigen La cuenta de la que se va a sacar dinero
	 * @param cuentaDestino la cuenta en la que se va a ingresar dinero
	 * @throws ReintegroNoValidoException 
	 * @throws SaldoNoValidoException 
	 * @throws CuentaNoExistenteException 
	 */
	void transferencia(Cuenta cuentaOrigen, Cuenta cuentaDestino, double cantidad) throws ReintegroNoValidoException, SaldoNoValidoException, CuentaNoExistenteException{
		try{
		cuentaOrigen = banco.get(banco.indexOf(cuentaOrigen));
		cuentaDestino = banco.get(banco.indexOf(cuentaDestino));
		cuentaOrigen.reintegro(cantidad);
		cuentaDestino.ingresar(cantidad);
		} catch (ArrayIndexOutOfBoundsException e){
			throw new CuentaNoExistenteException("Error. La cuenta no existe.");
		}
	}
	
	/**
	 * Comprueba si existe un cliente con el DNI dado
	 */
	Persona comprobarCliente(Persona persona){
		Cuenta cuenta=null;
		Iterator<Cuenta> iterator = banco.iterator();
		while(iterator.hasNext()){
			cuenta = (Cuenta)iterator.next();
			if(cuenta.getPersona().equals(persona))
				return cuenta.getPersona();
		}
		return null;
	}

	@Override
	public String toString() {
		return "Banco [banco=" + banco + "]";
	}
	
	

}
