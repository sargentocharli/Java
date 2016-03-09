/**
* Crea la siguiente clase y justifica los resultados
*
*@author Lucas Márquez Muñoz
*/

public class ConversionExplicitaExtensora
	{
		public static void main (String[] args)
			{
				byte b1=100, b2=100, b3;
				
				//conversión explícita
				b3 = (byte)(b1 * b2 * b1/100);
				System.out.println ("Con conversion Explicita: " + b3);
				
				//conversión extensora
				int n;
				n = b1 * b2 * b1/100;
				System.out.println ("Con conversion Extensora: " + n);
			}
	}
