package gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;
import excepciones.ArmaNoValidaException;
import excepciones.FechaNoValidaException;
import excepciones.NombreNoValidoException;
import excepciones.PersonajeYaExisteException;
import funcionalidad.Arma;
import funcionalidad.Armadura;
import funcionalidad.ClasesPersonaje;
import funcionalidad.ListaPersonajes;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Pide los datos de un personaje al usuario para
 * introducirlo en la lista de personajes
 * @author Lucas Márquez Muñoz
 * @version 1.0
 */
public class NuevoPersonaje extends DialogoPadre {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ })
	public NuevoPersonaje(ListaPersonajes listaPersonajes) {
		super();
		setTitle("Nuevo Personaje");
		
		cancelButton.setText("Cancelar");
		okButton.setText("Nuevo");
		btnBuscar.setVisible(false);		
		lblVida.setVisible(false);
		textFieldVida.setVisible(false);
		lblEdad.setText("Año nacimiento");
		
		comboBoxClase.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				establecerArmadura(); 
			}
			
			/**
			 * Establece la armadura según la clase elegida
			 */
			private void establecerArmadura() {
				if(comboBoxClase.getSelectedItem()==ClasesPersonaje.BRUJO || comboBoxClase.getSelectedItem()==ClasesPersonaje.MAGO)
					textFieldArmadura.setText(Armadura.TELA.name());
				if(comboBoxClase.getSelectedItem()==ClasesPersonaje.GUERRERO)
					textFieldArmadura.setText(Armadura.PLACAS.name());
				if(comboBoxClase.getSelectedItem()==ClasesPersonaje.PICARO)
					textFieldArmadura.setText(Armadura.CUERO.name());				
			}
		});
		
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadir(listaPersonajes);
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
	 * Informa al usuario de que el personaje ha sido introducido en la lista de personajes
	 * @param listaPersonajes La lista de personajes actual
	 */
	private void anadir(ListaPersonajes listaPersonajes) {
		
			try {
				listaPersonajes.annadir(textFieldNombre.getText(), (ClasesPersonaje)comboBoxClase.getSelectedItem(),
						(Arma)comboBoxArma.getSelectedItem(), Armadura.valueOf(textFieldArmadura.getText()), 
						Integer.valueOf(textFieldEdad.getText()));
					JOptionPane.showMessageDialog(contentPanel,
								"Se ha añadido el personaje");
					clear();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(contentPanel, "No se ha introducido ninguna fecha.", 
						"Advertencia", JOptionPane.WARNING_MESSAGE);		
			} catch (PersonajeYaExisteException e) {
				JOptionPane.showMessageDialog(contentPanel, "Ya existe un personaje con ese nombre.", 
															"Advertencia", JOptionPane.WARNING_MESSAGE);				
			} catch (NombreNoValidoException e) {
				JOptionPane.showMessageDialog(contentPanel, "El nombre introducido no es válido.\n(Nombres válidos: "
										+ "2-12 caracteres alfabéticos)", "Advertencia", JOptionPane.WARNING_MESSAGE);
			} catch (ArmaNoValidaException e) {
				JOptionPane.showMessageDialog(contentPanel, "No se ha elegido ningún arma.", 
						"Advertencia", JOptionPane.WARNING_MESSAGE);
			} catch (FechaNoValidaException e) {
				JOptionPane.showMessageDialog(contentPanel, "El año de nacimiento introducido no es válido.", 
						"Advertencia", JOptionPane.WARNING_MESSAGE);
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(contentPanel, "No se ha escogido el tipo de personaje.", 
						"Advertencia", JOptionPane.WARNING_MESSAGE);
			}		
	}	
}