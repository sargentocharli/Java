package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import funcionalidad.Personaje;
import funcionalidad.Picaro;
import funcionalidad.Arma;
import funcionalidad.Brujo;
import funcionalidad.ClasesPersonaje;
import funcionalidad.Guerrero;
import funcionalidad.Mago;

/**
 * Ventana padre con todos los posibles elementos que habrá en el resto 
 * de diálogos de la lista de personajes
 * @author Lucas Márquez Muñoz
 * @version 1.0 *
 */
public class DialogoPadre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final JPanel contentPanel = new JPanel();
	protected JTextField textFieldNombre; 
	protected JTextField textFieldEdad;
	protected JTextField textFieldVida;
	protected JTextField textFieldArmadura;
	protected JLabel lblNombre;
	protected JLabel lblClase;
	protected JLabel lblEdad;
	protected JLabel lblVida;
	protected JLabel lblArma;
	protected JLabel lblArmadura;
	protected JComboBox<ClasesPersonaje> comboBoxClase;
	protected JComboBox<Arma> comboBoxArma;	
	protected JPanel buttonPane;
	protected JButton btnBuscar;
	protected JButton okButton;
	protected JButton cancelButton;	

	/**
	 * Launch the application.
	 * @param args Los argumentos del main
	 */
	public static void main(String[] args) {
		try {
			DialogoPadre dialog = new DialogoPadre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoPadre() {
		super();
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(79, 40, 66, 14);
			contentPanel.add(lblNombre);
		}
		{
			lblClase = new JLabel("Clase");
			lblClase.setBounds(79, 65, 66, 14);
			contentPanel.add(lblClase);
		}
		{
			lblEdad = new JLabel("Edad");
			lblEdad.setBounds(79, 90, 66, 14);
			contentPanel.add(lblEdad);
		}
		{
			lblVida = new JLabel("Vida");
			lblVida.setBounds(79, 115, 66, 14);
			contentPanel.add(lblVida);
		}
		{
			lblArma = new JLabel("Arma");
			lblArma.setBounds(79, 140, 66, 14);
			contentPanel.add(lblArma);
		}
		{
			lblArmadura = new JLabel("Armadura");
			lblArmadura.setBounds(247, 64, 66, 14);
			contentPanel.add(lblArmadura);
		}
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(155, 37, 86, 20);
		contentPanel.add(textFieldNombre);
		
		comboBoxClase = new JComboBox<ClasesPersonaje>();
		comboBoxClase.setModel(new DefaultComboBoxModel<ClasesPersonaje>(ClasesPersonaje.values()));
		comboBoxClase.setSelectedItem(null);
		comboBoxClase.setBounds(155, 61, 86, 22);
		contentPanel.add(comboBoxClase);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setBounds(155, 87, 86, 20);
		contentPanel.add(textFieldEdad);
		
		textFieldVida = new JTextField();
		textFieldVida.setBounds(155, 112, 86, 20);
		contentPanel.add(textFieldVida);
		
		comboBoxArma = new JComboBox<Arma>();
		comboBoxArma.setModel(new DefaultComboBoxModel<Arma>(Arma.values()));	
		comboBoxArma.setSelectedItem(null);
		comboBoxArma.setBounds(155, 136, 86, 22);
		contentPanel.add(comboBoxArma);
		
		textFieldArmadura = new JTextField();
		textFieldArmadura.setEditable(false);
		textFieldArmadura.setBounds(323, 61, 86, 20);
		contentPanel.add(textFieldArmadura);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(251, 36, 91, 23);
		contentPanel.add(btnBuscar);		
		
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	/**
	 * Limpia los campos
	 */
	protected void clear() {
		textFieldNombre.setText("");
		textFieldEdad.setText("");
		textFieldVida.setText("");
		textFieldArmadura.setText("");
		comboBoxClase.setSelectedItem(null);
		comboBoxArma.setSelectedItem(null);	
	}
	
	/**
	 * Establece los valores en los campos según el personaje recibido
	 * @param personaje El personaje recibido
	 */
	protected void mostrarPersonaje(Personaje personaje) {
		
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