package gui;

import java.awt.EventQueue;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import excepciones.NombreNoValidoException;
import excepciones.PersonajeNoExisteException;
import javax.swing.filechooser.FileFilter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import funcionalidad.Fichero;
import funcionalidad.ListaPersonajes;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Ventana principal del proyecto
 * 
 * @author Lucas Márquez Muñoz
 * @version 1.0
 */

public class Principal {

	private JFrame frame;
	private File file;
	private ListaPersonajes listaPersonajes = new ListaPersonajes();
	private JFileChooser fileChooser = new JFileChooser();
	private NuevoPersonaje nuevoPersonaje;
	private EliminarPersonaje eliminarPersonaje;
	private ModificarPersonaje modificarPersonaje;
	private MostrarListaPersonajes mostrarListaPersonajes;
	private BuscarPorNombre buscarPorNombre;
	private AcercaDe acercaDe;
	private Ayuda ayuda;
	private SeleccionPersonajes seleccionPersonajes;

	/**
	 * Launch the application.
	 * @param args Los argumentos del main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();			
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if(!comprobarCambios()) 
					return;
				System.exit(0);
			}
		});
		frame.setResizable(false);		
		actualizarTitle();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 444, 21);
		frame.getContentPane().add(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('A');
		menuBar.add(mnArchivo);

		JMenuItem mntmNuevo = new JMenuItem("Nueva lista de personajes");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevo();
			}
		});
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmNuevo);

		JSeparator separator_2 = new JSeparator();
		mnArchivo.add(separator_2);

		JMenuItem mntmAbrir = new JMenuItem("Abrir lista de personajes...");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!comprobarCambios()) return;
				
				file = obtenerFichero();
				if (file==null)
					return;
				if (file != null)
					abrir(file);

				if (!Fichero.existe(file))
					JOptionPane.showMessageDialog(frame, "No existe la lista de personajes", "Fichero no encontrado",
							JOptionPane.PLAIN_MESSAGE);

			}
		});
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmAbrir);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		mnArchivo.add(mntmGuardarComo);

		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!comprobarCambios()) return;
				System.exit(0);
			}
		});
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmSalir);

		JMenu mnCoche = new JMenu("Personajes");
		mnCoche.setMnemonic('P');
		menuBar.add(mnCoche);

		JMenuItem mntmAlta = new JMenuItem("Nuevo");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevoPersonaje();
			}
		});
		mntmAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnCoche.add(mntmAlta);

		JMenuItem mntmBaja = new JMenuItem("Eliminar");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listaPersonajes.getListaPersonajes().size() == 0)
					JOptionPane.showMessageDialog(frame, "La lista de personajes está vacía.",
							"Información", JOptionPane.PLAIN_MESSAGE);
				else{				
					eliminarPersonaje();
				}
			}
		});
		mntmBaja.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		mnCoche.add(mntmBaja);

		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listaPersonajes.getListaPersonajes().size() == 0)
					JOptionPane.showMessageDialog(frame, "La lista de personajes está vacía.",
							"Información", JOptionPane.PLAIN_MESSAGE);
				else{				
					modificarPersonaje();
				}
			}
		});
		mntmModificar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mnCoche.add(mntmModificar);

		JSeparator separator_1 = new JSeparator();
		mnCoche.add(separator_1);

		JMenuItem mntmMostrarListaDePersonajes = new JMenuItem("Mostrar lista de personajes");
		mntmMostrarListaDePersonajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(listaPersonajes.getListaPersonajes().size() == 0)
					JOptionPane.showMessageDialog(frame, "La lista de personajes está vacía.",
							"Información", JOptionPane.PLAIN_MESSAGE);
				else{					
					mostrarListaPersonajes();
				}					
			}
		});
		mntmMostrarListaDePersonajes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mnCoche.add(mntmMostrarListaDePersonajes);

		JMenu mnJugar = new JMenu("Jugar");
		mnJugar.setMnemonic('J');
		menuBar.add(mnJugar);

		JMenuItem mntmNuevaPartida = new JMenuItem("Nueva Partida");
		mntmNuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (listaPersonajes.getListaPersonajes().size() == 0) {
						JOptionPane.showMessageDialog(frame, "No se ha cargado ninguna lista de personajes",
								"Información", JOptionPane.PLAIN_MESSAGE);
					} else {
						seleccionPersonajes(listaPersonajes);
					}
				} catch (NombreNoValidoException e1) {
					JOptionPane.showMessageDialog(frame, "Nombre no válido.");
				} catch (PersonajeNoExisteException e1) {
					JOptionPane.showMessageDialog(frame, "Personaje no válido.");
				}
			}
		});
		mnJugar.add(mntmNuevaPartida);

		JMenu mnBuscar = new JMenu("Buscar");
		mnBuscar.setMnemonic('B');
		menuBar.add(mnBuscar);

		JMenuItem mntmPorNombre = new JMenuItem("Por nombre");
		mntmPorNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(listaPersonajes.getListaPersonajes().size() == 0)
					JOptionPane.showMessageDialog(frame, "La lista de personajes está vacía.",
							"Información", JOptionPane.PLAIN_MESSAGE);
				else{					
					buscarPorNombre();
				}				
			}
		});
		mntmPorNombre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		mnBuscar.add(mntmPorNombre);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('y');
		menuBar.add(mnAyuda);

		JMenuItem mntmAyuda = new JMenuItem("Ver ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verAyuda();
			}
		});
		mnAyuda.add(mntmAyuda);

		JSeparator separator_3 = new JSeparator();
		mnAyuda.add(separator_3);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				acercaDe();
			}
		});
		mnAyuda.add(mntmAcercaDe);
	}

	/**
	 * Crea y muestra la ventana Selección de personajes	 
	 * @param listaPersonajes La lista de personajes elegida
	 * @throws NombreNoValidoException Excepción nombre no válido
	 * @throws PersonajeNoExisteException Excepción personaje no existe
	 */
	private void seleccionPersonajes(ListaPersonajes listaPersonajes)
			throws NombreNoValidoException, PersonajeNoExisteException {
		seleccionPersonajes = new SeleccionPersonajes(listaPersonajes);
		seleccionPersonajes.setVisible(true);
	}

	/**
	 * Crea y muestra la ventana nuevo
	 */

	private void nuevoPersonaje() {
		nuevoPersonaje = new NuevoPersonaje(listaPersonajes);
		nuevoPersonaje.setVisible(true);
	}

	/**
	 * Crea y muestra la ventana baja
	 */
	private void eliminarPersonaje() {
		eliminarPersonaje = new EliminarPersonaje(listaPersonajes);
		eliminarPersonaje.setVisible(true);
	}

	/**
	 * Crea y muestra la ventana modificar
	 */
	private void modificarPersonaje() {
		modificarPersonaje = new ModificarPersonaje(listaPersonajes);
		modificarPersonaje.setVisible(true);
	}

	/**
	 * Crea y muestra la ventana buscarPorNombre
	 */
	private void buscarPorNombre() {
		buscarPorNombre = new BuscarPorNombre(listaPersonajes);
		buscarPorNombre.setVisible(true);
	}

	/**
	 * Crea y muestra la ventana mostrarListaPersonajes
	 */
	private void mostrarListaPersonajes() {
		mostrarListaPersonajes = new MostrarListaPersonajes(listaPersonajes);
		mostrarListaPersonajes.setVisible(true);
	}

	/**
	 * Crea y muestra la ventana Alta acercaDe
	 */
	private void acercaDe() {
		acercaDe = new AcercaDe();
		acercaDe.setVisible(true);
	}

	/**
	 * Crea y muestra la ventana verAyuda
	 */
	private void verAyuda() {
		ayuda = Ayuda.getInstance();
		ayuda.setVisible(true);
	}

	/**
	 * Comprueba si se han realizado cambios en la lista de personajes actual.
	 * Tras esto, crea una lista de personajes nueva
	 */
	void nuevo() {
		if(!comprobarCambios()) return;
		inicializar();
		file = null;
	}

	/**
	 * Crea una lista de personajes nueva y actualiza el estado modificado a
	 * false
	 */
	private void inicializar() {
		listaPersonajes = new ListaPersonajes();
		listaPersonajes.setModificado(false);
		actualizarTitle();		
	}

	private void actualizarTitle() {
		frame.setTitle("LucasManía: Nueva lista de personajes");
	}

	/**
	 * Comprueba si se han realizado cambios en la lista de jugadores, mostrando
	 * una ventana en la que se pide al usuario si desea guardarlos en caso
	 * afirmativo
	 * 
	 * @return False si se ha abortado la acción (cancelar o cruz). true si se
	 *         continúa (yes o no)
	 */
	private boolean comprobarCambios() {
		if (!listaPersonajes.estaModificado())
			return true;// Se continúa

		// hay que guardar
		switch ((JOptionPane.showOptionDialog(frame, "¿Desea guardar los cambios?", "Confirmar",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null))) {
		case JOptionPane.YES_OPTION:
			guardar();			
			// return true;
		case JOptionPane.NO_OPTION:
			return true;
		default://  JOptionPane.OK_CANCEL_OPTION
			return false;
		}

	}

	/**
	 * Guarda en un fichero ls lista de jugadores actual. Pide el nombre del
	 * fichero al usuario si no se ha establecido ya.
	 */
	void guardar() {
		if (file == null)
			guardarComo();
		else {
			try {
				Fichero.escribir(listaPersonajes, file);
				actualizarTitle(file.getName());				
				listaPersonajes.setModificado(false);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame, "Clase no encontrada.");
			}
		}
	}

	private void actualizarTitle(String name) {
		frame.setTitle("LucasManía: " + name);
	}

	/**
	 * Guarda en un fichero la lista de personajes actual pidiendo un nombre
	 * para esta al usuario
	 */
	void guardarComo() {
		try {
			file = guardarFichero();
			if(file==null)
				return;
			if (Fichero.existe(file)) {
				switch (JOptionPane.showOptionDialog(frame, "Está seguro de que desea sobreescribir el fichero?",
						"Confirmar", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null,
						null)) {
				case JOptionPane.CANCEL_OPTION:
				case JOptionPane.NO_OPTION:
					return;
				}
			}

			Fichero.escribir(listaPersonajes, file);
			actualizarTitle(file.getName());			
			listaPersonajes.setModificado(false);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "Error de lectura/escritura del fichero.");
		}
	}

	/**
	 * Lee una lista de personajes guardada en un fichero
	 * @param file El archivo recibido
	 */
	public void abrir(File file) {
		try {
			listaPersonajes = Fichero.leer(file);
			actualizarTitle(file.getName());			
			listaPersonajes.setModificado(false);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(frame, "Clase no encontrada.");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "Error de lectura/escritura.");
		}
	}

	/**
	 * fileChooser para abrir un fichero de tipo .prj 
	 * @return El fichero elegido en caso de elegir la opción APPROVE, null en caso contrario
	 */
	private File obtenerFichero() {
		FileFilter filter = new FileNameExtensionFilter("Archivos de objeto (*.prj)", "prj");
		fileChooser.setFileFilter(filter);

		int returnVal = fileChooser.showOpenDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION)
			return fileChooser.getSelectedFile();	

		return null;
	}

	/**
	 * fileChooser para guardar un fichero de tipo .prj 
	 * @return El fichero elegido en caso de elegir la opción APPROVE, null en caso contrario
	 */
	private File guardarFichero() {
		FileFilter filter = new FileNameExtensionFilter(("Archivos de objeto (*.prj"), "prj");
		fileChooser.setFileFilter(filter);

		int returnVal = fileChooser.showSaveDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION)
			return file = fileChooser.getSelectedFile();
		return null;
	}
}