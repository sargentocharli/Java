package listadoEstructurasDatosII.testListaPersonas;

public class Persona {

	String nombre;
	String primerApellido;
	String segundoApellido;
	
	Persona(String nombre, String primerApellido, String segundoApellido){
		this.nombre=nombre;
		this.primerApellido=primerApellido;
		this.segundoApellido=segundoApellido;		
	}

	@Override
	public String toString() {
		return nombre + " " + primerApellido + " " + segundoApellido;
	}
}
