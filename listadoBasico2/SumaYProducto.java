/** Define la clase SumaYProducto que obtenga la suma
* y el producto de los números del 1 al 100.
* 
* @author Lucas Márquez Muñoz
* @version 1.0
*/

public class SumaYProducto{
	public static void main(String[] args){
		int suma = 1;
		double producto = 1d; //Utilizamos double porque no entra en int o long
		int i;
		for (i=2;i<101;i++){
			suma = suma + i;
			producto = producto * i;
		}
		System.out.println(suma);	
		System.out.println(producto); 
	}
}
