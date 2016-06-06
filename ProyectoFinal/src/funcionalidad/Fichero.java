package funcionalidad;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase Fichero utilizada para el control de flujos
 * @author Lucas Márquez Muñoz
 * @version 1.0
 */

public class Fichero {
	
	/**
	 * Abre un fichero, devolviendo la lista de personajes almacenada en él y se asegura de que la extensión de este sea .prj
	 * @param file El fichero a leer
	 * @return La lista de personajes almacenada en el fichero
	 * @throws IOException Excepción entrada/salida
	 * @throws FileNotFoundException Excepción archivo no encontrado
	 * @throws ClassNotFoundException Excepción clase no encontrada
	 */
	public static ListaPersonajes leer(File file) throws FileNotFoundException, IOException, ClassNotFoundException{
		file = comprobarExtension(file);
		try(ObjectInputStream in = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(file)))){
			return (ListaPersonajes) in.readObject();
		}
	}
	
	/**
	 * Guarda la lista de personajes recibida en un fichero y se asegura de que la extensión de este sea .prj
	 * @param listaPersonajes La lista de personajes a guardar
	 * @param file el fichero en el que se guardará la lista de personajes
	 * @throws IOException Excepción entrada/salida
	 * @throws FileNotFoundException Excepción archivo no encontrado
	 */
	public static void escribir(ListaPersonajes listaPersonajes, File file) throws FileNotFoundException, IOException{
		file = comprobarExtension(file);
		try(ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file)))){
			out.writeObject(listaPersonajes);
		}
	}
	
	/**
	 * Comprueba si la extensión del fichero es .prj
	 * En caso de serlo de vuelve el nombre del fichero. En caso de no serlo, devuelve el nombre 
	 * del fichero con la extensión .prj añadida
	 * @param file El fichero a comprobar
	 * @return file nombre del fichero en caso de que tenga la extensión .prj o el nombre del fichero con la extensión .prj añadida
	 */
	static File comprobarExtension(File file){
		String path = file.getPath();
		if(!path.endsWith(".prj"))
			return new File(path + ".prj");
		return file;		
	}
	
	/**
	 * Comprueba si existe el fichero recibido por parámetro.
	 * @param file El fichero a comprobar.
	 * @return true Si existe el fichero, false si no existe.
	 */
	public static boolean existe(File file){
		try{
			if(file==null)
				//file = comprobarExtension(file);
				return false;
		}finally{};
		
		return file.exists();
	}
}