package gui;

import excepciones.NombreNoValidoException;
import excepciones.PersonajeNoExisteException;
import funcionalidad.ListaPersonajes;
import funcionalidad.Personaje;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;

/**
 * Elimina un personaje de la lista de personajes buscándolo
 * por su nombre
 * @author Lucas Márquez Muñoz
 * @version 1.0
 */
public class EliminarPersonaje extends DialogoPadre {
	private static final long serialVersionUID = 1L;

	public EliminarPersonaje(ListaPersonajes listaPersonajes) {
		super();
		cancelButton.setText("Cancelar");
		okButton.setText("Eliminar");
		setTitle("Eliminar personaje");
		
		botonesPorDefecto();		
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscar(listaPersonajes);
				} catch (PersonajeNoExisteException e1) {
					JOptionPane.showMessageDialog(contentPanel, "El personaje no existe.");
				} catch (NombreNoValidoException e1) {
					
				}
			}			
		});
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionarRespuesta(listaPersonajes);
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				clear();
			}
		});
	}

	/**
	 * Muestra el personaje según el nombre introducido
	 * @param listaPersonajes La lista de personajes actual
	 * @throws NombreNoValidoException Excepción nombre no válido
	 * @throws PersonajeNoExisteException Excepción personaje no existe
	 */
	private void buscar(ListaPersonajes listaPersonajes) throws PersonajeNoExisteException, NombreNoValidoException {
		
		Personaje personaje = new Personaje(listaPersonajes.getPersonaje(textFieldNombre.getText()).getNombre());		
		mostrarPersonaje(listaPersonajes.getPersonaje(personaje.getNombre()));		
		okButton.setEnabled(true);
	}
	
	/**
	 * Pide confirmación al usuario para eliminar el personaje
	 * @param listaPersonajes La lista de personajes actual
	 */
	private void gestionarRespuesta(ListaPersonajes listaPersonajes){
		switch(JOptionPane.showOptionDialog(contentPanel,
							"¿Está seguro de que desea eliminarlo?", "Confirmar",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, null, null)){
		
		case JOptionPane.YES_OPTION:
			try {
				listaPersonajes.eliminar(textFieldNombre.getText());				
				clear();
			} catch (NombreNoValidoException e) {
				JOptionPane.showMessageDialog(contentPanel, "El nombre introducido no es válido.");
			}
			break;
		default:
			clear();
			botonesPorDefecto();
		}
	}
	
	/**
	 * Establece qué elementos serán mostrados en el diálogo y cuáles no
	 */
	private void botonesPorDefecto() {
		btnBuscar.setEnabled(true);
		okButton.setEnabled(false);
		comboBoxClase.setEnabled(false);
		textFieldEdad.setEnabled(false);
		textFieldVida.setEnabled(false);
		comboBoxArma.setEnabled(false);
		textFieldArmadura.setEnabled(false);
	}	
}
