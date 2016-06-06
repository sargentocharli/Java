package gui;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Muestra una pequeña descripción del programa y su licencia
 * @author Lucas Márquez Muñoz
 * @version 1.0
 */
public class AcercaDe extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();	

	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		setModal(true);
		setResizable(false);
		setTitle("Acerca de...");
		setBounds(100, 100, 629, 405);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);	
		
		JLabel lbAcercaDe = new JLabel("New label");
		lbAcercaDe.setIcon(new ImageIcon(AcercaDe.class.getResource("/imagenes/licenciaProyectoFinal.jpg")));
		lbAcercaDe.setBounds(0, 0, 621, 364);
		contentPanel.add(lbAcercaDe);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				buttonPane.setLayout(new BorderLayout(0, 0));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}