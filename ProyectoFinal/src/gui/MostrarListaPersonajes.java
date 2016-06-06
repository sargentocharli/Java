package gui;

import funcionalidad.Brujo;
import funcionalidad.ClasesPersonaje;
import funcionalidad.Guerrero;
import funcionalidad.ListaPersonajes;
import funcionalidad.Mago;
import funcionalidad.Personaje;
import funcionalidad.Picaro;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Muestra un diálogo para mostrar los personajes que hay en la lista de personajes
 * @author Lucas Márquez Muñoz
 * @version 1.0
 */
public class MostrarListaPersonajes extends DialogoPadre {
	private static final long serialVersionUID = 1L;
	private int indicePersonaje = -1;
	
	public MostrarListaPersonajes(ListaPersonajes listaPersonajes){
		super();
		setTitle("Lista de personajes");
		textFieldNombre.setEnabled(false);
		cancelButton.setText("Siguiente");
		okButton.setText("Anterior");
		 
		botonesPorDefecto();		
		inicializar(listaPersonajes);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior(listaPersonajes);
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente(listaPersonajes);
			}
		});
	}

	/**
	 * Establece qué elementos serán mostrados en el diálogo y cuáles no
	 */
	private void botonesPorDefecto() {
		
		btnBuscar.setVisible(false);
		okButton.setEnabled(false);
		comboBoxClase.setEnabled(false);
		textFieldEdad.setEnabled(false);
		textFieldVida.setEnabled(false);
		comboBoxArma.setEnabled(false);
		textFieldArmadura.setEnabled(false);
	}
	
	/**
	 * Muestra el primer personaje de la lista de personajes
	 * @param listaPersonajes La lista de personajes actual
	 */
	private void inicializar(ListaPersonajes listaPersonajes){
		if(listaPersonajes.getListaPersonajes().size()==0){
			cancelButton.setEnabled(false);
			return;
		}
		indicePersonaje=0;
		comprobarBotones(listaPersonajes);
		mostrarPersonaje(listaPersonajes.getListaPersonajes().get(indicePersonaje));		
	}
	
	/**
	 * Activa/desactiva los botones "Siguiente" y "Anterior" dependiendo del personaje que se esté mostrando 
	 * @param listaPersonajes La lista de personajes actual
	 */
	private void comprobarBotones(ListaPersonajes listaPersonajes) {
		if(indicePersonaje==0)
			okButton.setEnabled(false);
		else
			okButton.setEnabled(true);
		
		if(indicePersonaje==listaPersonajes.getListaPersonajes().size()-1)
			cancelButton.setEnabled(false);
		else
			cancelButton.setEnabled(true);
	}
	
	/**
	 * Muestra el siguiente personaje de la lista de personajes
	 * @param listaPersonajes La lista de personajes actual
	 */
	private void mostrarSiguiente(ListaPersonajes listaPersonajes){
		try{
			mostrarPersonaje(listaPersonajes.getListaPersonajes().get(++indicePersonaje));
			comprobarBotones(listaPersonajes);
		} catch(IndexOutOfBoundsException e){}	
	}
	
	/**
	 * Muestra el personaje anterior de la lista de personajes
	 * @param listaPersonajes La lista de personajes actual
	 */
	private void mostrarAnterior(ListaPersonajes listaPersonajes){
		mostrarPersonaje(listaPersonajes.getListaPersonajes().get(--indicePersonaje));
		comprobarBotones(listaPersonajes);
	}
	
	/**
	 * Muestra un personaje con sus características
	 */
	protected void mostrarPersonaje(Personaje personaje) {
		textFieldNombre.setText(personaje.getNombre());
		textFieldEdad.setText(String.valueOf(personaje.getEdad()));
		textFieldVida.setText(String.valueOf(personaje.getVida()));
		comboBoxArma.setSelectedItem(personaje.getArma());
		textFieldArmadura.setText(personaje.getArmadura().name());
		
		if(personaje instanceof Brujo)
			comboBoxClase.setSelectedItem(ClasesPersonaje.BRUJO);
		if(personaje instanceof Guerrero)
			comboBoxClase.setSelectedItem(ClasesPersonaje.GUERRERO);
		if(personaje instanceof Mago)
			comboBoxClase.setSelectedItem(ClasesPersonaje.MAGO);
		if(personaje instanceof Picaro)
			comboBoxClase.setSelectedItem(ClasesPersonaje.PICARO);		
	}
}