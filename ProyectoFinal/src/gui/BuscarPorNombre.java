package gui;

import excepciones.PersonajeNoExisteException;
import funcionalidad.ListaPersonajes;
import funcionalidad.Personaje;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;

/**
 * Muestra las características de un personaje buscado 
 * en la lista de personajes por su nombre
 * @author Lucas Márquez Muñoz
 * @version 1.0
 */
public class BuscarPorNombre extends DialogoPadre {
	private static final long serialVersionUID = 1L;
	
	public BuscarPorNombre(ListaPersonajes listaPersonajes){
		super();
		setTitle("Buscar por nombre");
		cancelButton.setText("Salir");
		okButton.setText("Ok");
		okButton.setVisible(false);
		textFieldVida.setEditable(false);
		textFieldVida.setEnabled(false);
		textFieldEdad.setEditable(false);
		textFieldEdad.setEnabled(false);
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				clear();
			}
		});
		
		botonesPorDefecto();
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar(listaPersonajes);
			}
			
			/**
			 * Busca un personaje de la lista pasada por su nombre
			 * @param listaPersonajes La lista pasada
			 */
			private void buscar(ListaPersonajes listaPersonajes) {
				try {
					Personaje personaje = listaPersonajes.getPersonaje(textFieldNombre.getText());
					mostrarPersonaje(personaje);
				} catch (PersonajeNoExisteException e) {
					JOptionPane.showMessageDialog(contentPanel,
							e.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Establece qué elementos serán mostrados en el diálogo y cuáles no
	 */
	private void botonesPorDefecto() {
		btnBuscar.setEnabled(true);
		okButton.setEnabled(false);
		comboBoxClase.setEnabled(false);
		textFieldEdad.setEnabled(false);		
		comboBoxArma.setEnabled(false);
		textFieldArmadura.setEnabled(false);
	}
}
