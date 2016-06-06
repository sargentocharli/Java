package gui;

import excepciones.ArmaNoValidaException;
import excepciones.PersonajeNoExisteException;
import funcionalidad.Arma;
import funcionalidad.ListaPersonajes;
import funcionalidad.Personaje;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

/**
 * Permite modificar el arma de un personaje buscado previamente
 * en la lista de personajes por su nombre
 * @author Lucas Márquez Muñoz
 * @version 1.0
 */
public class ModificarPersonaje extends DialogoPadre {
	private static final long serialVersionUID = 1L;
	private Personaje personaje;
	public ModificarPersonaje(ListaPersonajes listaPersonajes){
		super();
		setTitle("Modificar personaje");
		cancelButton.setText("Cancelar");
		okButton.setText("Modificar");
		
		controlesPorDefecto();
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar(listaPersonajes);
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
	 * @param listaPersonajes La lista actual
	 */
	private void buscar(ListaPersonajes listaPersonajes) {
		try {
			personaje = listaPersonajes.getPersonaje(textFieldNombre.getText());
			mostrarPersonaje(personaje);			
			okButton.setEnabled(true);
		} catch (PersonajeNoExisteException e) {
			JOptionPane.showMessageDialog(contentPanel, "El personaje no existe.");
		}
	}
	
	/**
	 * Pide confirmación al usuario para modificar el personaje
	 * @param listaPersonajes La lista de personajes actual
	 */
	private void gestionarRespuesta(ListaPersonajes listaPersonajes){
		switch(JOptionPane.showOptionDialog(contentPanel,
				"¿Está seguro de que desea modificarlo?", "Confirmar",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, null, null)){

		case JOptionPane.YES_OPTION:
			try {
				personaje.setArma((Arma) comboBoxArma.getSelectedItem());
				listaPersonajes.modificar(personaje);				
				clear();
				controlesPorDefecto();
			} catch (ArmaNoValidaException e) {
				JOptionPane.showMessageDialog(contentPanel,"Arma no válida.");
			}
			break;
		default:
			clear();
			controlesPorDefecto();
		}
	}
	
	/**
	 * Establece qué elementos serán mostrados en el diálogo y cuáles no
	 */
	private void controlesPorDefecto() {
		btnBuscar.setEnabled(true);
		okButton.setEnabled(false);
		comboBoxClase.setEnabled(false);
		textFieldEdad.setEnabled(false);		
		comboBoxArma.setEnabled(true);
		textFieldArmadura.setEnabled(false);
	}	
}