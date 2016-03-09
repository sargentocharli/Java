package listadoEstructurasDatosIII.pila;

public class TestPila {

	public static void main(String[] args) {
		Pila<Videojuego> pila=new Pila<Videojuego>();
		
		try {
			pila.push(new Videojuego("Dark Souls", "Action RPG"));
			pila.push(new Videojuego("Resident Evil","Survival Horror"));
			pila.push(new Videojuego("Batman: Arkham Asylum","Acción"));
		} catch (TituloNoValidoException | GeneroNoValidoException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		while(!pila.pila.isEmpty()){
			System.out.println(pila.top());
			System.out.println("Desapilo de la pila: " + pila.pop());
		}
	}
}
