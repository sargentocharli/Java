package listadoEstructurasDatosIII.topMusic;

public class Cancion {
	
	String titulo;
	String artista;
	int annoGrabacion;
	
	Cancion(String titulo, String artista, int annoGrabacion) 
			throws TituloNoValidoException, ArtistaNoValidoException, 
			AnnoGrabacionNoValidoException{
		setTitulo(titulo);
		setArtista(artista);
		setAnnoGrabacion(annoGrabacion);
		
	}

	String getTitulo() {
		return titulo;
	}

	private void setTitulo(String titulo) throws TituloNoValidoException {
		if(titulo.length()!=0)
			this.titulo = titulo;
		else
			throw new TituloNoValidoException("El título no es válido.");
	}

	String getArtista() {
		return artista;
	}

	private void setArtista(String artista) throws ArtistaNoValidoException {
		if(artista.length()!=0)
			this.artista=artista;
		else
			throw new ArtistaNoValidoException("El artista no es válido.");
	}

	int getAnnoGrabacion() {
		return annoGrabacion;
	}

	private void setAnnoGrabacion(int annoGrabacion) throws AnnoGrabacionNoValidoException {
		if(annoGrabacion>1877 || annoGrabacion<2016)
			this.annoGrabacion=annoGrabacion;
		else
			throw new AnnoGrabacionNoValidoException("El año de grabación no es válido.");
	}

	@Override
	public String toString() {
		return "Cancion [titulo=" + titulo + ", artista=" + artista + ", annoGrabacion=" + annoGrabacion + "\n]";
	}
}
