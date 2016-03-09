package cuentaCorrienteYTitulares;

import utiles.*;

public class TestBanco {

	static Banco banco = new Banco();
	
	public static void main(String[] args) {
		
		Menu menu = new Menu("Gestión del banco",new String[] {"Crear cuenta", 
																"Eliminar cuenta",
																"Realizar ingreso",
																"Sacar dinero",
																"Transferencia",
																"Mostrar lista de cuentas"});
		
int opcion;
		
		do{
			opcion=menu.gestionarMenu();
			
			switch(opcion){
			case 1:
				crearCuenta();
				break;
			case 2:
				eliminarCuenta();
				break;
			case 3:
				ingresar();
				break;
			case 4:
				reintegro();
				break;
			case 5:
				transferencia();
				break;
			case 6:	
				System.out.println(banco);
				break;
			case 7:				
				break;
			
			default:
				System.out.println("\nError. Opcion incorrecta");
			}		
		}while(opcion!=7);
	}		

	static void crearCuenta() {		
		
		try {
			Cuenta cuenta=null;
			Persona persona=null;
			char continuar;
			double saldoInicial;
			
			String dni=Teclado.leerCadena("Instroduzca el DNI del titular: ");
			persona=banco.comprobarCliente(new Persona(dni));
			
			if(persona!=null){
				System.out.println("El DNI introducido ya está en nuestro sistema.");
				continuar=Teclado.leerCaracter("¿Reutilizar los datos personales de este titular?(s/n): ");
				if(continuar=='s' || continuar=='S'){
					cuenta = new Cuenta(persona,saldoInicial=Teclado.leerDecimal("Introduzca el saldo inicial: "));
					banco.anadirCuenta(cuenta);
					return;
				}
			}
				
			String nombre=Teclado.leerCadena("Introduzca el nombre del titular: ");			
			String direccion=Teclado.leerCadena("Introduzca la dirección del titular: ");
			saldoInicial=Teclado.leerDecimal("Introduzca el saldo inicial de la cuenta: ");			
			cuenta=new Cuenta(new Persona(nombre, dni, direccion), saldoInicial);
			banco.anadirCuenta(cuenta);			
			
		} catch (DniNoValidoException | NombreNoValidoException | SaldoNoValidoException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	static void eliminarCuenta(){
		int numeroCuenta=Teclado.leerEntero("Introduzca el código de la cuenta a eliminar: ");
		
		Cuenta cuenta= new Cuenta(numeroCuenta);
		banco.eliminarCuenta(cuenta);
	}
	
	static void ingresar(){		
		try {
			double ingreso=Teclado.leerEntero("Escriba la cantidad a ingresar: ");
			int numeroCuenta=Teclado.leerEntero("Escriba la cuenta en la que se va a ingresar: ");
			Cuenta cuenta = new Cuenta(numeroCuenta);
			banco.ingresar(cuenta, ingreso);
		} catch (SaldoNoValidoException | CuentaNoExistenteException e) {
			System.out.println(e.getMessage());
		}		
	}
	
	static void reintegro(){		
		try {
			int numeroCuenta=Teclado.leerEntero("Introduzca el código de la cuenta a la que se le realizará el reintegro: ");
			double cantidad=Teclado.leerDecimal("Introduzca la cantidad a reintegrar: ");
			Cuenta cuenta = new Cuenta(numeroCuenta);
			banco.reintegro(cuenta, cantidad);
		} catch (ReintegroNoValidoException | CuentaNoExistenteException | SaldoNoValidoException e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void transferencia(){		
		try {
			int numeroCuentaOrigen=Teclado.leerEntero("Introduzca el código de la cuenta origen de la transferencia: ");
			int numeroCuentaDestino=Teclado.leerEntero("Introduzca el código de la cuenta destino de la transferencia: ");
			double cantidad=Teclado.leerDecimal("Introduzca la cantidad a transferir: ");
			Cuenta cuentaOrigenTransferencia = new Cuenta(numeroCuentaOrigen);
			Cuenta cuentaDestinoTransferencia = new Cuenta(numeroCuentaDestino);
			banco.transferencia(cuentaOrigenTransferencia, cuentaDestinoTransferencia, cantidad);
		} catch (ReintegroNoValidoException | SaldoNoValidoException | CuentaNoExistenteException e) {
			System.out.println(e.getMessage());
		}		
	}

}
