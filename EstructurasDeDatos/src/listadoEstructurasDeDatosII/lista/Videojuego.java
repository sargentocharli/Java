package listadoEstructurasDatosII.lista;

public class Videojuego {
	 String titulo;
	 String genero;	
	
	Videojuego(String titulo, String genero){
	this.titulo=titulo;
	this.genero=genero;
	}

	String getTitulo() {
		return titulo;
	}

	void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	String getGenero() {
		return genero;
	}

	void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Videojuego [titulo=" + titulo + ", genero=" + genero + "]";
	}
	

}
