/**
/* Crea la siguiente clase y justifica por qué el sufijo float (f ó F) es necesario
/*
/* @author Lucas Márquez Muñoz
*/

public class PotenciaConversion 
	{
		public static void main (String[] args)
		{
			//float f = (float)1e-39; Porque por defecto interpreta que es un double
			float f = 1e-39f;   
			double d = 1e-39;
			
			System.out.println("float: " + f);
			System.out.println("double: " + d);
		}
	}
