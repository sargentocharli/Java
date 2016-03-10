/**
* Define la clase AsignandoArrays tal y como muestra la captura. Indica en un
* comentario lo que almacenaría la referencia a1 tras modificarse a2. Añade también los
* siguientes comentarios en las líneas correspondientes:
* a. se referencia al mismo objeto
* b. modificación de los elementos
* c. declaración de un array
* d. se muestran los elementos del objeto array
* e. declaración, construcción e inicialización de un array
*/
public class AsignandoArrays{
	/**
	* Declara, construye, inicializa y muestra arrays.
	*/
	public static void main(String[] args){
		int[] a1 = {3, 5, 7, 11, 13}; // Declaración, construcción e inicialización de un array
		int [] a2; // Declaración del array
		int i;
		a2=a1; // Se referencia al mismo objeto
		for(i=0;i<a2.length;i++)
			a2[i]++; // Modificación de los elementos
		for(i=0;i<a1.length;i++)
			System.out.println("a1 [" + i + "] = " + a1[i]); // Se muestran los elementos del objeto array
	}
}
		