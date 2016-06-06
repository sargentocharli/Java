package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import excepciones.NombreNoValidoException;
import excepciones.PersonajeNoExisteException;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import funcionalidad.ClasesPersonaje;
import funcionalidad.Guerrero;
import funcionalidad.ListaPersonajes;
import funcionalidad.Mago;
import funcionalidad.Personaje;
import funcionalidad.Picaro;
import javax.swing.JTextField;
import funcionalidad.Brujo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * Diálogo para elegir los personajes que van a luchar
 * @author Lucas Márquez Muñoz
 * @version 1.0 
 */
public class SeleccionPersonajes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<Personaje> comboBoxNombrePersonaje1;
	private JTextField textFieldClasePersonaje1;
	private JTextField textFieldEdadPersonaje1;
	private JTextField textFieldVidaPersonaje1;
	private JTextField textFieldArmaPersonaje1;
	private JTextField textFieldArmaduraPersonaje1;
	private JComboBox<Personaje> comboBoxNombrePersonaje2;
	private JTextField textFieldClasePersonaje2;
	private JTextField textFieldEdadPersonaje2;
	private JTextField textFieldVidaPersonaje2;
	private JTextField textFieldArmaPersonaje2;
	private JTextField textFieldArmaduraPersonaje2;
	private JLabel estadisticaPersonaje1;
	private JLabel estadisticaPersonaje2;
	private JTextField textFieldEstadisticaPersonaje1;
	private JTextField textFieldEstadisticaPersonaje2;	
	private Personaje personaje1;
	private Personaje personaje2;
	private Personaje aux1;
	private Personaje aux2;
	private int pos1;
	private int pos2;	

	/**
	 * Create the dialog.
	 * @param listaPersonajes La lista de personajes
	 * @throws NombreNoValidoException Excepción nombre no válido
	 * @throws PersonajeNoExisteException Excepción personaje no existe
	 */
	public SeleccionPersonajes(ListaPersonajes listaPersonajes) throws NombreNoValidoException, PersonajeNoExisteException {
		setModal(true);
		setResizable(false);
		setTitle("Selecci\u00F3n de personajes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		comboBoxNombrePersonaje1 = new JComboBox<Personaje>();
		
		String[] cadena1 = listaPersonajes.generarListaPersonajes();
		for(int i=0; i<cadena1.length;i++)
			comboBoxNombrePersonaje1.addItem(new Personaje(cadena1[i]));
		comboBoxNombrePersonaje1.setSelectedItem(null);
		comboBoxNombrePersonaje1.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent arg0) {
				
					try {						
						aux1 = new Personaje(comboBoxNombrePersonaje1.getSelectedItem().toString());							
						pos1=listaPersonajes.getPersonajePosicion(aux1.getNombre());
						
						switch(listaPersonajes.getPersonajeIndice(pos1).getClass().getSimpleName()){
						
						case "Brujo":
							personaje1 = new Brujo();
							personaje1 = (Brujo)listaPersonajes.getPersonajeIndice(pos1);							
							textFieldClasePersonaje1.setText(ClasesPersonaje.BRUJO.toString());
							estadisticaPersonaje1.setText("Mana");
							estadisticaPersonaje1.setVisible(true);
							textFieldEstadisticaPersonaje1.setText(String.valueOf(((Brujo) personaje1).getMana()));
							textFieldEstadisticaPersonaje1.setVisible(true);	
							break;
							
						case "Guerrero":
							personaje1 = new Guerrero();
							personaje1 = (Guerrero)listaPersonajes.getPersonajeIndice(pos1);							
							textFieldClasePersonaje1.setText(ClasesPersonaje.GUERRERO.toString());
							estadisticaPersonaje1.setText("Ira");
							estadisticaPersonaje1.setVisible(true);
							textFieldEstadisticaPersonaje1.setText(String.valueOf(((Guerrero) personaje1).getIra()));
							textFieldEstadisticaPersonaje1.setVisible(true);
							break;
							
						case "Mago":
							personaje1 = new Mago();
							personaje1 = (Mago)listaPersonajes.getPersonajeIndice(pos1);							
							textFieldClasePersonaje1.setText(ClasesPersonaje.MAGO.toString());
							estadisticaPersonaje1.setText("Mana");
							estadisticaPersonaje1.setVisible(true);
							textFieldEstadisticaPersonaje1.setText(String.valueOf(((Mago) personaje1).getMana()));
							textFieldEstadisticaPersonaje1.setVisible(true);
							break;
							
						default:
							personaje1 = new Picaro();
							personaje1 = (Picaro)listaPersonajes.getPersonajeIndice(pos1);							
							textFieldClasePersonaje1.setText(ClasesPersonaje.PICARO.toString());
							estadisticaPersonaje1.setText("Energía");
							estadisticaPersonaje1.setVisible(true);
							textFieldEstadisticaPersonaje1.setText(String.valueOf(((Picaro) personaje1).getEnergia()));
							textFieldEstadisticaPersonaje1.setVisible(true);
							break;
						}
						
						textFieldVidaPersonaje1.setText(String.valueOf(listaPersonajes.getPersonaje(personaje1.getNombre()).getVida()));
						textFieldArmaPersonaje1.setText(listaPersonajes.getPersonaje(personaje1.getNombre()).getArma().name());
						textFieldArmaduraPersonaje1.setText(listaPersonajes.getPersonaje(personaje1.getNombre()).getArmadura().name());
						textFieldEdadPersonaje1.setText(String.valueOf(listaPersonajes.getPersonaje(personaje1.getNombre()).getEdad()));

					} catch (NombreNoValidoException | PersonajeNoExisteException e1) {
						JOptionPane.showMessageDialog(contentPanel, "Error al seleccionar personajes.");
					}
			}			
		});			
		
		comboBoxNombrePersonaje1.setBounds(120, 25, 86, 22);
		contentPanel.add(comboBoxNombrePersonaje1);		
		
		JLabel clasePersonaje1 = new JLabel("Clase");
		clasePersonaje1.setBounds(44, 61, 66, 14);
		contentPanel.add(clasePersonaje1);
		
		textFieldClasePersonaje1 = new JTextField();		
		textFieldClasePersonaje1.setEnabled(false);
		textFieldClasePersonaje1.setEditable(false);
		textFieldClasePersonaje1.setBounds(120, 57, 86, 22);
		contentPanel.add(textFieldClasePersonaje1);
		
		JLabel edadPersonaje1 = new JLabel("Edad");
		edadPersonaje1.setBounds(44, 86, 66, 14);
		contentPanel.add(edadPersonaje1);
		
		textFieldEdadPersonaje1 = new JTextField();			
		textFieldEdadPersonaje1.setEnabled(false);
		textFieldEdadPersonaje1.setEditable(false);
		textFieldEdadPersonaje1.setBounds(120, 83, 86, 20);
		contentPanel.add(textFieldEdadPersonaje1);
		
		JLabel vidaPersonaje1 = new JLabel("Vida");
		vidaPersonaje1.setBounds(44, 111, 66, 14);
		contentPanel.add(vidaPersonaje1);
		
		textFieldVidaPersonaje1 = new JTextField();		
		textFieldVidaPersonaje1.setEditable(false);
		textFieldVidaPersonaje1.setEnabled(false);
		textFieldVidaPersonaje1.setBounds(120, 108, 86, 20);
		contentPanel.add(textFieldVidaPersonaje1);
		
		JLabel armaPersonaje1 = new JLabel("Arma");
		armaPersonaje1.setBounds(44, 136, 66, 14);
		contentPanel.add(armaPersonaje1);
		
		textFieldArmaPersonaje1 = new JTextField();		
		textFieldArmaPersonaje1.setEnabled(false);
		textFieldArmaPersonaje1.setEditable(false);
		textFieldArmaPersonaje1.setBounds(120, 132, 86, 22);
		contentPanel.add(textFieldArmaPersonaje1);
		
		JLabel armaduraPersonaje1 = new JLabel("Armadura");
		armaduraPersonaje1.setBounds(44, 161, 66, 14);
		contentPanel.add(armaduraPersonaje1);
		
		textFieldArmaduraPersonaje1 = new JTextField();		
		textFieldArmaduraPersonaje1.setEditable(false);
		textFieldArmaduraPersonaje1.setEnabled(false);
		textFieldArmaduraPersonaje1.setBounds(120, 158, 86, 20);
		contentPanel.add(textFieldArmaduraPersonaje1);
		
		JLabel nombrePersonaje2 = new JLabel("Nombre");
		nombrePersonaje2.setBounds(238, 29, 46, 14);
		contentPanel.add(nombrePersonaje2);
		
		comboBoxNombrePersonaje2 = new JComboBox<Personaje>();		
		String[] cadena2 = listaPersonajes.generarListaPersonajes();
		for(int i=0; i<cadena2.length;i++)
			comboBoxNombrePersonaje2.addItem(new Personaje(cadena2[i]));
		comboBoxNombrePersonaje2.setSelectedItem(null);
		comboBoxNombrePersonaje2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg1) {					
					try {						
						aux2 = new Personaje(comboBoxNombrePersonaje2.getSelectedItem().toString());						
						pos2=listaPersonajes.getPersonajePosicion(aux2.getNombre());
						
						switch(listaPersonajes.getPersonajeIndice(pos2).getClass().getSimpleName()){
						
						case "Brujo":
							personaje2 = new Brujo();
							personaje2 = (Brujo)listaPersonajes.getPersonajeIndice(pos2);							
							textFieldClasePersonaje2.setText(ClasesPersonaje.BRUJO.toString());
							estadisticaPersonaje2.setText("Mana");
							estadisticaPersonaje2.setVisible(true);
							textFieldEstadisticaPersonaje2.setText(String.valueOf(((Brujo) personaje2).getMana()));
							textFieldEstadisticaPersonaje2.setVisible(true);	
							break;
							
						case "Guerrero":
							personaje2 = new Guerrero();
							personaje2 = (Guerrero)listaPersonajes.getPersonajeIndice(pos2);							
							textFieldClasePersonaje2.setText(ClasesPersonaje.GUERRERO.toString());
							estadisticaPersonaje2.setText("Ira");
							estadisticaPersonaje2.setVisible(true);
							textFieldEstadisticaPersonaje2.setText(String.valueOf(((Guerrero) personaje2).getIra()));
							textFieldEstadisticaPersonaje2.setVisible(true);
							break;
							
						case "Mago":
							personaje2 = new Mago();
							personaje2 = (Mago)listaPersonajes.getPersonajeIndice(pos2);							
							textFieldClasePersonaje2.setText(ClasesPersonaje.MAGO.toString());
							estadisticaPersonaje2.setText("Mana");
							estadisticaPersonaje2.setVisible(true);
							textFieldEstadisticaPersonaje2.setText(String.valueOf(((Mago) personaje2).getMana()));
							textFieldEstadisticaPersonaje2.setVisible(true);
							break;
							
						default:
							personaje2 = new Picaro();
							personaje2 = (Picaro)listaPersonajes.getPersonajeIndice(pos2);							
							textFieldClasePersonaje2.setText(ClasesPersonaje.PICARO.toString());
							estadisticaPersonaje2.setText("Energía");
							estadisticaPersonaje2.setVisible(true);
							textFieldEstadisticaPersonaje2.setText(String.valueOf(((Picaro) personaje2).getEnergia()));
							textFieldEstadisticaPersonaje2.setVisible(true);
							break;
					}
						
						textFieldVidaPersonaje2.setText(String.valueOf(listaPersonajes.getPersonaje(personaje2.getNombre()).getVida()));
						textFieldArmaPersonaje2.setText(listaPersonajes.getPersonaje(personaje2.getNombre()).getArma().name());
						textFieldArmaduraPersonaje2.setText(listaPersonajes.getPersonaje(personaje2.getNombre()).getArmadura().name());
						textFieldEdadPersonaje2.setText(String.valueOf(listaPersonajes.getPersonaje(personaje2.getNombre()).getEdad()));

					} catch (NombreNoValidoException | PersonajeNoExisteException e1) {
						JOptionPane.showMessageDialog(contentPanel, "Error al seleccionar personajes.");
					}
			}			
		});
		
		comboBoxNombrePersonaje2.setBounds(314, 25, 86, 22);
		contentPanel.add(comboBoxNombrePersonaje2);		
		
		JLabel clasePersonaje2 = new JLabel("Clase");
		clasePersonaje2.setBounds(238, 58, 66, 14);
		contentPanel.add(clasePersonaje2);
		
		textFieldClasePersonaje2 = new JTextField();		
		textFieldClasePersonaje2.setEnabled(false);
		textFieldClasePersonaje2.setEditable(false);
		textFieldClasePersonaje2.setBounds(314, 54, 86, 22);
		contentPanel.add(textFieldClasePersonaje2);
		
		JLabel edadPersonaje2 = new JLabel("Edad");
		edadPersonaje2.setBounds(238, 83, 66, 14);
		contentPanel.add(edadPersonaje2);
		
		textFieldEdadPersonaje2 = new JTextField();
		textFieldEdadPersonaje2.setEnabled(false);
		textFieldEdadPersonaje2.setEditable(false);
		textFieldEdadPersonaje2.setBounds(314, 80, 86, 20);
		contentPanel.add(textFieldEdadPersonaje2);
		
		JLabel vidaPersonaje2 = new JLabel("Vida");
		vidaPersonaje2.setBounds(238, 108, 66, 14);
		contentPanel.add(vidaPersonaje2);
		
		textFieldVidaPersonaje2 = new JTextField();
		textFieldVidaPersonaje2.setEnabled(false);
		textFieldVidaPersonaje2.setEditable(false);
		textFieldVidaPersonaje2.setBounds(314, 105, 86, 20);
		contentPanel.add(textFieldVidaPersonaje2);
		
		JLabel armaPersonaje2 = new JLabel("Arma");
		armaPersonaje2.setBounds(238, 133, 66, 14);
		contentPanel.add(armaPersonaje2);
		
		textFieldArmaPersonaje2 = new JTextField();
		textFieldArmaPersonaje2.setEnabled(false);
		textFieldArmaPersonaje2.setEditable(false);
		textFieldArmaPersonaje2.setBounds(314, 129, 86, 22);
		contentPanel.add(textFieldArmaPersonaje2);
		
		JLabel armaduraPersonaje2 = new JLabel("Armadura");
		armaduraPersonaje2.setBounds(238, 158, 66, 14);
		contentPanel.add(armaduraPersonaje2);
		
		textFieldArmaduraPersonaje2 = new JTextField();
		textFieldArmaduraPersonaje2.setEnabled(false);
		textFieldArmaduraPersonaje2.setEditable(false);
		textFieldArmaduraPersonaje2.setBounds(314, 155, 86, 20);
		contentPanel.add(textFieldArmaduraPersonaje2);
		
		JLabel nombrePersonaje1 = new JLabel("Nombre");
		nombrePersonaje1.setBounds(44, 29, 46, 14);
		contentPanel.add(nombrePersonaje1);
		
		estadisticaPersonaje1 = new JLabel("New label");
		estadisticaPersonaje1.setVisible(false);
		estadisticaPersonaje1.setBounds(44, 186, 46, 14);
		contentPanel.add(estadisticaPersonaje1);
		
		textFieldEstadisticaPersonaje1 = new JTextField();
		textFieldEstadisticaPersonaje1.setEditable(false);
		textFieldEstadisticaPersonaje1.setEnabled(false);
		textFieldEstadisticaPersonaje1.setVisible(false);
		textFieldEstadisticaPersonaje1.setBounds(120, 183, 86, 20);
		contentPanel.add(textFieldEstadisticaPersonaje1);
		textFieldEstadisticaPersonaje1.setColumns(10);
		
		estadisticaPersonaje2 = new JLabel("New label");
		estadisticaPersonaje2.setVisible(false);
		estadisticaPersonaje2.setBounds(238, 186, 46, 14);
		contentPanel.add(estadisticaPersonaje2);
		
		textFieldEstadisticaPersonaje2 = new JTextField();
		textFieldEstadisticaPersonaje2.setEditable(false);
		textFieldEstadisticaPersonaje2.setEnabled(false);
		textFieldEstadisticaPersonaje2.setVisible(false);
		textFieldEstadisticaPersonaje2.setColumns(10);
		textFieldEstadisticaPersonaje2.setBounds(314, 183, 86, 20);
		contentPanel.add(textFieldEstadisticaPersonaje2);		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Jugar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {						
						Combate combate = new Combate(personaje1, personaje2);
						combate.setVisible(true);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
