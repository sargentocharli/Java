package listadoEstructurasDatosIII.cola;

public class Videojuego {
	 String titulo;
	 String genero;	
	
	Videojuego(String titulo, String genero) throws TituloNoValidoException, GeneroNoValidoException{
	setTitulo(titulo);
	setGenero(genero);
	}

	String getTitulo() {
		return titulo;
	}

	void setTitulo(String titulo)throws TituloNoValidoException {
		if(titulo.length()!=0)
			this.titulo = titulo;
		else
			throw new TituloNoValidoException("El título no es válido.");
	}

	String getGenero() {
		return genero;
	}

	void setGenero(String genero)throws GeneroNoValidoException {
		if(genero.length()!=0)
			this.genero = genero;
		else
			throw new GeneroNoValidoException("El género no es válido.");
	}

	@Override
	public String toString() {
		return "Videojuego [titulo=" + titulo + ", genero=" + genero + "]";
	}
	
}
