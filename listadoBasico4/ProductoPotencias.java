import utiles.*;
/** 
* Define la clase ProductoPotencias que calcule y visualice el producto de las
* potencias de 2 entre 0 y 10.
*/

public class ProductoPotencias{
	public static void main(String[] args){
		long resultado, productoTotal=1;
		for (int i=0;i<11;i++){
			resultado = calcularProducto(i);
			System.out.println("2 elevado a " + i + " es igual a " + resultado);
			productoTotal*=resultado;
		}
		System.out.println("El producto total de las 10 potencias es " + productoTotal);
	}
	
	/**
	* Calcula el valor de 2 elevado al número i y lo añade al acumulador producto
	* @param i: Contador que indica el exponente de la base 2
	* @return producto: Es la variable acumulador que almacena el valor de las potencias
	*/
	static long calcularProducto(int i){
		return ((long)(Math.pow(2,i)));
	}
}