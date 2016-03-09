package listadoEstructurasDatosIII.listaDeLaCompra;

public class Articulo {
	/**
	 * Nombre del artículo
	 */
	private String nombre;
	
	/**
	 * Cantidad de artículos 
	 */
	private int existencias;
	
	/**
	 * Cantidad mínima de artículos
	 */
	private int minimo;
	
	/**
	 * Constructor que recibe el nombre, las existencias y el mínimo
	 * @param nombre del artículo
	 * @param existencias cantidad de artículos
	 * @param minimo cantidad mínima
	 * @throws NombreNoValidoException 
	 * @throws ExistenciasNoValidasException 
	 * @throws MinimoNoValidoException 
	 */
	public Articulo(String nombre,int existencias,int minimo) throws NombreNoValidoException, 
	ExistenciasNoValidasException, MinimoNoValidoException{
		setNombre(nombre);
		setExistencias(existencias);
		setMinimo(minimo);
	}
	
	/**
	 * Constructor que recibe el nombre del artículo
	 * @param nombre
	 * @throws NombreNoValidoException 
	 */
	public Articulo(String nombre) throws NombreNoValidoException{
		setNombre(nombre);
	}
	
	/**
	 * Incrementa las existencias del artículo en la cantidad indicada
	 * @param incremento
	 * @throws ExistenciasNoValidasException 
	 */
	void incrementar(int incremento) throws IncrementoNoValidoException, ExistenciasNoValidasException{
		if(incremento>=0)
			setExistencias(getExistencias() + incremento);
		else
			throw new IncrementoNoValidoException("El incremento no puede ser negativo.");
	}
	
	/**
	 * Decrementa las existencias del artículo en la cantidad indicada
	 * @param decremento
	 * @throws ExistenciasNoValidasException 
	 */
	void decrementar(int decremento) throws DecrementoNoValidoException, ExistenciasNoValidasException{
		if(decremento>=0)
			setExistencias(getExistencias() - decremento);
		else
			throw new DecrementoNoValidoException("El decremento no puede ser negativo.");
	}
	
	/**
	 * Devuelve true si el artículo tiene el número de existencias por
	 * debajo del mínimo y false en caso contrario
	 * @return true o false
	 */
	public boolean porDebajoDelMinimo() {
		if(getExistencias()<getMinimo())
			return true;
		return false;
	}

	/**
	 * Lee el nombre del artículo
	 * @return nombre
	 */
	String getNombre() {
		return nombre;
	}

	/**
	 * Escribe el nombre del artículo
	 * @param nombre
	 */
	private void setNombre(String nombre) throws NombreNoValidoException{
		if(nombre.length()!=0)
			this.nombre = nombre;
		else
			throw new NombreNoValidoException("Error. Nombre no válido.");
	}

	/**
	 * Lee el número de existencias del artículo
	 * @return
	 */
	int getExistencias() {
		return existencias;
	}

	/**
	 * Escribe el número de existencias
	 * @param existencias
	 */
	private void setExistencias(int existencias) throws ExistenciasNoValidasException{
		if(existencias>=0)
			this.existencias = existencias;
		else
			throw new ExistenciasNoValidasException("Error. Número de existencias no válido.");
	}

	/**
	 * Lee el mínimo
	 * @return minimo
	 */
	int getMinimo() {
		return minimo;
	}

	/**
	 * Escribe el mínimo
	 * @param minimo
	 */
	void setMinimo(int minimo) throws MinimoNoValidoException{
		if(minimo>=0)
			this.minimo=minimo;
		else
			throw new MinimoNoValidoException("Error. Número mínimo no válido.");
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + "\nExistencias: " + existencias + "\nMinimo: " + minimo + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Articulo other = (Articulo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
}
