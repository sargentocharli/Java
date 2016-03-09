package listadoEstructurasDatosIII.cola;
import utiles.*;

public class TestCola {

	public static void main(String[] args) {
		Cola<Videojuego> cola=new Cola<Videojuego>();
		
		try {
			cola.push(new Videojuego("Dark Souls","Action RPG"));
			cola.push(new Videojuego("Resident Evil","Survival Horror"));
			cola.push(new Videojuego("Batman: Arkham Asylum","Acción"));
		} catch (TituloNoValidoException | GeneroNoValidoException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		while(!cola.cola.isEmpty()){			
			System.out.println("Descolo de la cola: " + cola.cola.remove(cola.cola.size()-1));
		}
	}

}
