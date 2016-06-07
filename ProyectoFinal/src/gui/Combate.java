package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import excepciones.NombreNoValidoException;
import excepciones.PersonajeNoExisteException;
import funcionalidad.Brujo;
import funcionalidad.Guerrero;
import funcionalidad.Mago;
import funcionalidad.Personaje;
import funcionalidad.Picaro;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Diálogo en el que se lleva a cabo el combate entre los dos personajes.
 * Cada personaje dispone de dos tipos de ataque, uno normal que no consume
 * su estadística secundaria y menos poderoso y uno fuerte que consume parte
 * de su estadística secundaria y más poderoso. Cuando la vida de uno de los
 * dos personajes llegue a cero el combate acabará ganando el otro personaje.
 * 
 * @author Lucas Márquez Muñoz
 * @version 1.0
 */

public class Combate extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldVidaPersonaje1;
	private JTextField textFieldVidaPersonaje2;
	private JButton btnAccion1Personaje1;
	private JButton btnAccion2Personaje1;
	private JButton btnAccion1Personaje2;
	private JButton btnAccion2Personaje2;	
	private int vidaRestantePersonaje1;
	private int vidaRestantePersonaje2;
	private int estadisticaRestantePersonaje1;
	private int estadisticaRestantePersonaje2;	
	private JLabel estadisticaPersonaje1;
	private JLabel estadisticaPersonaje2;
	private JTextField textFieldEstadisticaPersonaje1;
	private JTextField textFieldEstadisticaPersonaje2;		
	private static int auxiliar = 0;
	
	/**
	 * Create the dialog.	 
	 * @param personaje1 El personaje 1 
	 * @param personaje2 El personaje 2
	 */
	public Combate(Personaje personaje1, Personaje personaje2) {			
		
		setTitle("Combate");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, personaje1.getNombre(), 
												TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(4, 15, 204, 137);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel vidaPersonaje1 = new JLabel("Vida");
		vidaPersonaje1.setBounds(34, 27, 46, 14);
		panel.add(vidaPersonaje1);
		
		textFieldVidaPersonaje1 = new JTextField();		
		textFieldVidaPersonaje1.setEditable(false);
		textFieldVidaPersonaje1.setEnabled(false);
		textFieldVidaPersonaje1.setBounds(25, 45, 46, 20);
		panel.add(textFieldVidaPersonaje1);
		textFieldVidaPersonaje1.setColumns(10);
		
		btnAccion1Personaje1 = new JButton("");
		btnAccion1Personaje1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vidaRestantePersonaje2 -= calcularDanoNormalPersonaje(personaje1);
				textFieldVidaPersonaje2.setText(String.valueOf(vidaRestantePersonaje2));
				comprobarVictoria(personaje1);
				activarBotonesPersonaje2();				
			}				
		});
		btnAccion1Personaje1.setBounds(6, 108, 91, 23);
		panel.add(btnAccion1Personaje1);	
		
		btnAccion2Personaje1 = new JButton("");
		btnAccion2Personaje1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vidaRestantePersonaje2 -= calcularDanoFuertePersonaje1(personaje1);
				textFieldVidaPersonaje2.setText(String.valueOf(vidaRestantePersonaje2));
				comprobarVictoria(personaje1);
				activarBotonesPersonaje2();
			}		
		});
		btnAccion2Personaje1.setBounds(107, 108, 91, 23);
		panel.add(btnAccion2Personaje1);
		
		estadisticaPersonaje1 = new JLabel("New label");
		estadisticaPersonaje1.setBounds(122, 27, 46, 14);
		panel.add(estadisticaPersonaje1);
		
		textFieldEstadisticaPersonaje1 = new JTextField();
		textFieldEstadisticaPersonaje1.setEditable(false);
		textFieldEstadisticaPersonaje1.setEnabled(false);
		textFieldEstadisticaPersonaje1.setBounds(122, 45, 46, 20);
		panel.add(textFieldEstadisticaPersonaje1);
		textFieldEstadisticaPersonaje1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, personaje2.getNombre(), 
												TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(222, 15, 204, 137);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel vidaPersonaje2 = new JLabel("Vida");
		vidaPersonaje2.setBounds(37, 29, 46, 14);
		panel_1.add(vidaPersonaje2);
		
		textFieldVidaPersonaje2 = new JTextField();
		textFieldVidaPersonaje2.setBounds(27, 48, 46, 20);
		textFieldVidaPersonaje2.setEditable(false);
		textFieldVidaPersonaje2.setEnabled(false);
		panel_1.add(textFieldVidaPersonaje2);
		textFieldVidaPersonaje2.setColumns(10);
		
		btnAccion1Personaje2 = new JButton("");
		btnAccion1Personaje2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vidaRestantePersonaje1 -= calcularDanoNormalPersonaje(personaje2);
				textFieldVidaPersonaje1.setText(String.valueOf(vidaRestantePersonaje1));
				comprobarVictoria(personaje2);
				activarBotonesPersonaje1();
			}				
		});
		btnAccion1Personaje2.setBounds(6, 108, 91, 23);
		panel_1.add(btnAccion1Personaje2);
		
		btnAccion2Personaje2 = new JButton("");
		btnAccion2Personaje2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vidaRestantePersonaje1 -= calcularDanoFuertePersonaje2(personaje2);
				textFieldVidaPersonaje1.setText(String.valueOf(vidaRestantePersonaje1));
				comprobarVictoria(personaje2);
				activarBotonesPersonaje1();
			}			
		});
		btnAccion2Personaje2.setBounds(107, 108, 91, 23);
		panel_1.add(btnAccion2Personaje2);
		
		estadisticaPersonaje2 = new JLabel("New label");
		estadisticaPersonaje2.setBounds(124, 29, 46, 14);
		panel_1.add(estadisticaPersonaje2);
		
		textFieldEstadisticaPersonaje2 = new JTextField();
		textFieldEstadisticaPersonaje2.setEnabled(false);
		textFieldEstadisticaPersonaje2.setEditable(false);
		textFieldEstadisticaPersonaje2.setColumns(10);
		textFieldEstadisticaPersonaje2.setBounds(124, 48, 46, 20);
		panel_1.add(textFieldEstadisticaPersonaje2);
		
		try {
	//		establecerPersonaje1(personaje1);
	//		establecerPersonaje2(personaje2);
			establecerPersonaje(personaje1);
			establecerPersonaje(personaje2);
			activarBotonesPersonaje1();			
			
		} catch (NombreNoValidoException |PersonajeNoExisteException e) {
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setVisible(false);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	/**
	 * Calcula y devuelve el daño fuerte del personaje 1 en función
	 * de la clase que sea. Además, resta a la estadística secundaria del personaje el 
	 * coste del uso de esta habilidad.
	 * @param personaje1 El personaje 1
	 * @return El daño fuerte que realiza el personaje
	 */
	protected int calcularDanoFuertePersonaje1(Personaje personaje1) {
		
		switch(personaje1.getClass().getSimpleName()){
			
		case "Brujo":
			estadisticaRestantePersonaje1 -= 50;
			textFieldEstadisticaPersonaje1.setText(String.valueOf(estadisticaRestantePersonaje1));
			return ((Brujo) personaje1).calcularHechizoFuerte();
		
		case "Guerrero":
			estadisticaRestantePersonaje1 -= 5;
			textFieldEstadisticaPersonaje1.setText(String.valueOf(estadisticaRestantePersonaje1));
			return ((Guerrero) personaje1).calcularAtaqueFuerte();
			
		case "Mago":
			estadisticaRestantePersonaje1 -= 50;
			textFieldEstadisticaPersonaje1.setText(String.valueOf(estadisticaRestantePersonaje1));			
			return ((Mago) personaje1).calcularHechizoFuerte();
			
		default:
			estadisticaRestantePersonaje1 -= 5;
			textFieldEstadisticaPersonaje1.setText(String.valueOf(estadisticaRestantePersonaje1));
			return ((Picaro) personaje1).calcularAtaqueFuerte();
		}	
	}
		
	/**
	 * Calcula y devuelve el daño fuerte del personaje 2 en función
	 * de la clase que sea. Además, resta a la estadística secundaria del personaje el 
	 * coste del uso de esta habilidad.
	 * @param personaje2 El personaje 2
	 * @return El daño fuerte que realiza el personaje
	 */
	protected int calcularDanoFuertePersonaje2(Personaje personaje2) {
		
		switch(personaje2.getClass().getSimpleName()){
			
		case "Brujo":
			estadisticaRestantePersonaje2 -= 50;
			textFieldEstadisticaPersonaje2.setText(String.valueOf(estadisticaRestantePersonaje2));
			return ((Brujo) personaje2).calcularHechizoFuerte();
		
		case "Guerrero":
			estadisticaRestantePersonaje2 -= 5;
			textFieldEstadisticaPersonaje2.setText(String.valueOf(estadisticaRestantePersonaje2));
			return ((Guerrero) personaje2).calcularAtaqueFuerte();
			
		case "Mago":
			estadisticaRestantePersonaje2 -= 50;
			textFieldEstadisticaPersonaje2.setText(String.valueOf(estadisticaRestantePersonaje2));			
			return ((Mago) personaje2).calcularHechizoFuerte();
			
		default://picaro
			estadisticaRestantePersonaje2 -= 5;
			textFieldEstadisticaPersonaje2.setText(String.valueOf(estadisticaRestantePersonaje2));
			return ((Picaro) personaje2).calcularAtaqueFuerte();
		}
	}
	
	/**
	 * Calcula y devuelve el daño normal del personaje pasado por su posición en función
	 * de la clase que sea.
	 * @param personaje El personaje recibido
	 * @return El daño normal que realiza el personaje
	 */
	protected int calcularDanoNormalPersonaje(Personaje personaje) {
		
		switch(personaje.getClass().getSimpleName()){
			
			case "Brujo":
				return ((Brujo) personaje).calcularHechizoNormal();
			
			case "Guerrero":
				return ((Guerrero) personaje).calcularAtaqueNormal();
				
			case "Mago":
				return ((Mago) personaje).calcularHechizoNormal();
				
			default://picaro
				return ((Picaro) personaje).calcularAtaqueNormal();			
		}		
	}		

	/**
	 * Establece los botones que estarán activados del personaje 1
	 */
	private void activarBotonesPersonaje1() {
		btnAccion1Personaje1.setEnabled(true);
		btnAccion2Personaje1.setEnabled(true);
		btnAccion1Personaje2.setEnabled(false);
		btnAccion2Personaje2.setEnabled(false);
		if(estadisticaRestantePersonaje1<5)
			btnAccion2Personaje1.setEnabled(false);
	}

	/**
	 * Establece los botones que estarán activados del personaje 2
	 */
	private void activarBotonesPersonaje2() {
		btnAccion1Personaje2.setEnabled(true);
		btnAccion2Personaje2.setEnabled(true);
		btnAccion1Personaje1.setEnabled(false);
		btnAccion2Personaje1.setEnabled(false);
		if(estadisticaRestantePersonaje2<5)
			btnAccion2Personaje2.setEnabled(false);
	}	
	
	/**
	 * Establece las estadisticas y acciones que tendrá el personaje recibido
	 * dependiendo de la clase a la que pertenezca
	 * @param personaje El personaje recibido
	 * @throws PersonajeNoExisteException Excepción personaje no existe
	 * @throws NombreNoValidoException Excepción nombre no válido 
	 */
	private void establecerPersonaje(Personaje personaje) throws NombreNoValidoException, PersonajeNoExisteException{
		
		if(auxiliar%2==0){
			switch (personaje.getClass().getSimpleName()) {
			case "Brujo":
				estadisticaRestantePersonaje1 = ((Brujo)personaje).getMana();
				vidaRestantePersonaje1 = ((Brujo)personaje).getVida();		
				establecerBrujo(
								btnAccion1Personaje1,
								btnAccion2Personaje1,
								estadisticaPersonaje1,
								textFieldEstadisticaPersonaje1,							
								textFieldVidaPersonaje1,
								estadisticaRestantePersonaje1,
								vidaRestantePersonaje1);			
				break;
				
			case "Guerrero":
				estadisticaRestantePersonaje1 = ((Guerrero) personaje).getIra();
				vidaRestantePersonaje1 = personaje.getVida();		
				establecerGuerrero(
									btnAccion1Personaje1,
									btnAccion2Personaje1,
									estadisticaPersonaje1,
									textFieldEstadisticaPersonaje1,							
									textFieldVidaPersonaje1,
									estadisticaRestantePersonaje1,
									vidaRestantePersonaje1);	
				break;
				
			case "Mago":
				estadisticaRestantePersonaje1 = ((Mago) personaje).getMana();
				vidaRestantePersonaje1 = personaje.getVida();		
				establecerMago(
								btnAccion1Personaje1,
								btnAccion2Personaje1,
								estadisticaPersonaje1,
								textFieldEstadisticaPersonaje1,							
								textFieldVidaPersonaje1,
								estadisticaRestantePersonaje1,
								vidaRestantePersonaje1);
				break;
				
			default:
				estadisticaRestantePersonaje1 = ((Picaro) personaje).getEnergia();
				vidaRestantePersonaje1 = personaje.getVida();		
				establecerPicaro(
								btnAccion1Personaje1,
								btnAccion2Personaje1,
								estadisticaPersonaje1,
								textFieldEstadisticaPersonaje1,							
								textFieldVidaPersonaje1,
								estadisticaRestantePersonaje1,
								vidaRestantePersonaje1);
			}
			
		}
		else{
			
			switch (personaje.getClass().getSimpleName()) {
			case "Brujo":
				estadisticaRestantePersonaje2 = ((Brujo) personaje).getMana();
				vidaRestantePersonaje2 = personaje.getVida();		
				establecerBrujo(
								btnAccion1Personaje2,
								btnAccion2Personaje2,
								estadisticaPersonaje2,
								textFieldEstadisticaPersonaje2,							
								textFieldVidaPersonaje2,
								estadisticaRestantePersonaje2,
								vidaRestantePersonaje2);
				
				break;
				
			case "Guerrero":
				estadisticaRestantePersonaje2 = ((Guerrero) personaje).getIra();
				vidaRestantePersonaje2 = personaje.getVida();		
				establecerGuerrero(
								btnAccion1Personaje2,
								btnAccion2Personaje2,
								estadisticaPersonaje2,
								textFieldEstadisticaPersonaje2,							
								textFieldVidaPersonaje2,
								estadisticaRestantePersonaje2,
								vidaRestantePersonaje2);
					
				break;
				
			case "Mago":
				estadisticaRestantePersonaje2 = ((Mago) personaje).getMana();
				vidaRestantePersonaje2 = personaje.getVida();		
				establecerMago(
						btnAccion1Personaje2,
						btnAccion2Personaje2,
						estadisticaPersonaje2,
						textFieldEstadisticaPersonaje2,							
						textFieldVidaPersonaje2,
						estadisticaRestantePersonaje2,
						vidaRestantePersonaje2);
				break;
				
			default:
				estadisticaRestantePersonaje2 = ((Picaro) personaje).getEnergia();
				vidaRestantePersonaje2 = personaje.getVida();		
				establecerPicaro(
						btnAccion1Personaje2,
						btnAccion2Personaje2,
						estadisticaPersonaje2,
						textFieldEstadisticaPersonaje2,							
						textFieldVidaPersonaje2,
						estadisticaRestantePersonaje2,
						vidaRestantePersonaje2);
			}
			
		}
			auxiliar++;
	}	

	/**
	 * Comprueba si alguno de los dos personajes ha ganado la partida.
	 * En caso afirmativo, mostrará un diálogo informando de ello
	 * y cerrará el diálogo actual.
	 * @param personaje El personaje recibido
	 */
	private void comprobarVictoria(Personaje personaje) {
		if(vidaRestantePersonaje2 <= 0){
			JOptionPane.showMessageDialog(contentPanel, "¡Ha ganado " + personaje.getNombre() + "!", "Fin de partida",
					JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
		if(vidaRestantePersonaje1 <= 0){
			JOptionPane.showMessageDialog(contentPanel, "¡Ha ganado " + personaje.getNombre() + "!", "Fin de partida", 
					JOptionPane.INFORMATION_MESSAGE);
			dispose();
		}
	}
	
	/**
	 * Establece los botones del personaje en caso de ser un pícaro
	 * @param btnAccion1Personaje El botón de acción 1 del personaje
	 * @param btnAccion2Personaje El botón de acción 2 del personaje
	 * @param estadisticaPersonaje El nombre de la estadística del personaje
	 * @param textFieldEstadisticaPersonaje Campo de texto que contiene la estadística del personaje
	 * @param textFieldVidaPersonaje Campo de texto que contiene la vida del personaje
	 * @param estadisticaRestantePersonaje Valor de la estadística del personaje
	 * @param vidaRestantePersonaje Valor de la vida del personaje
	 */
	private void establecerPicaro(
			JButton btnAccion1Personaje,
			JButton btnAccion2Personaje,
			JLabel estadisticaPersonaje,
			JTextField textFieldEstadisticaPersonaje,
			JTextField textFieldVidaPersonaje,
			int estadisticaRestantePersonaje,
			int vidaRestantePersonaje) {
		btnAccion1Personaje.setText("Golpe");
		btnAccion2Personaje.setText("Puyazo");
		estadisticaPersonaje.setText("Energía");
		textFieldEstadisticaPersonaje.setText(String.valueOf(estadisticaRestantePersonaje));				
		textFieldVidaPersonaje.setText(String.valueOf(vidaRestantePersonaje));
	}

	/**
	 * Establece los botones del personaje en caso de ser un mago
	 * @param btnAccion1Personaje El botón de acción 1 del personaje
	 * @param btnAccion2Personaje El botón de acción 2 del personaje
	 * @param estadisticaPersonaje El nombre de la estadística del personaje
	 * @param textFieldEstadisticaPersonaje Campo de texto que contiene la estadística del personaje
	 * @param textFieldVidaPersonaje Campo de texto que contiene la vida del personaje
	 * @param estadisticaRestantePersonaje Valor de la estadística del personaje
	 * @param vidaRestantePersonaje Valor de la vida del personaje
	 */
	private void establecerMago(
				JButton btnAccion1Personaje,
				JButton btnAccion2Personaje,
				JLabel estadisticaPersonaje,
				JTextField textFieldEstadisticaPersonaje,
				JTextField textFieldVidaPersonaje,
				int estadisticaRestantePersonaje,
				int vidaRestantePersonaje) {
		btnAccion1Personaje.setText("Fuego");
		btnAccion2Personaje.setText("Piroexplosión");
		estadisticaPersonaje.setText("Mana");
		textFieldEstadisticaPersonaje.setText(String.valueOf(estadisticaRestantePersonaje));				
		textFieldVidaPersonaje.setText(String.valueOf(vidaRestantePersonaje));
	}
	
	/**
	 * Establece los botones del personaje en caso de ser un guerrero
	 * @param btnAccion1Personaje El botón de acción 1 del personaje
	 * @param btnAccion2Personaje El botón de acción 2 del personaje
	 * @param estadisticaPersonaje El nombre de la estadística del personaje
	 * @param textFieldEstadisticaPersonaje Campo de texto que contiene la estadística del personaje
	 * @param textFieldVidaPersonaje Campo de texto que contiene la vida del personaje
	 * @param estadisticaRestantePersonaje Valor de la estadística del personaje
	 * @param vidaRestantePersonaje Valor de la vida del personaje
	 */
	private void establecerGuerrero(
					JButton btnAccion1Personaje,
					JButton btnAccion2Personaje,
					JLabel estadisticaPersonaje,
					JTextField textFieldEstadisticaPersonaje,
					JTextField textFieldVidaPersonaje,
					int estadisticaRestantePersonaje,
					int vidaRestantePersonaje) {
		btnAccion1Personaje.setText("Golpe");
		btnAccion2Personaje.setText("Furia");
		estadisticaPersonaje.setText("Ira");	
		textFieldEstadisticaPersonaje.setText(String.valueOf(estadisticaRestantePersonaje));				
		textFieldVidaPersonaje.setText(String.valueOf(vidaRestantePersonaje));
		
	}
	
	/**
	 * Establece los botones del personaje en caso de ser un brujo
	 * @param btnAccion1Personaje El botón de acción 1 del personaje
	 * @param btnAccion2Personaje El botón de acción 2 del personaje
	 * @param estadisticaPersonaje El nombre de la estadística del personaje
	 * @param textFieldEstadisticaPersonaje Campo de texto que contiene la estadística del personaje
	 * @param textFieldVidaPersonaje Campo de texto que contiene la vida del personaje
	 * @param estadisticaRestantePersonaje Valor de la estadística del personaje
	 * @param vidaRestantePersonaje Valor de la vida del personaje
	 */
	private void establecerBrujo(
				JButton btnAccion1Personaje,
				JButton btnAccion2Personaje,
				JLabel estadisticaPersonaje,
				JTextField textFieldEstadisticaPersonaje,
				JTextField textFieldVidaPersonaje,
				int estadisticaRestantePersonaje,
				int vidaRestantePersonaje) {
		btnAccion1Personaje.setText("Descarga");
		btnAccion2Personaje.setText("Caos");
		estadisticaPersonaje.setText("Mana");	
		textFieldEstadisticaPersonaje.setText(String.valueOf(estadisticaRestantePersonaje));				
		textFieldVidaPersonaje.setText(String.valueOf(vidaRestantePersonaje));
		
	}
}