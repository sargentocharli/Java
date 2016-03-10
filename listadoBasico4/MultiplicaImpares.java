/**
* Define la clase MultiplicaImpares que multiplique los 20 primeros números
*impares y muestre el resultado en pantalla.
*/
public class MultiplicaImpares{
	public static void main(String[] args){
		System.out.println("El resultado de multiplicar los 20 primeros números impares es " + multiplicarImpares());
	}
	/**
	* Muestra por pantalla el resultado de multiplicar los 20 primeros números impares
	* @return producto: El producto de la multiplicación
	*/
	static int multiplicarImpares(){
		int producto=1;
		for(int i=1;i<40;i+=2)
			producto*=i;
		return producto;
	}
}