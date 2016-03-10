/**
* Define la clase Tiempo que dada una medida de tiempo expresada en horas,
* minutos y segundos con valores arbitrarios, elabore un programa que transforme
* dicha medida en una expresión correcta. Por ejemplo, dada la medida 3h 118m 195s,
* se deberá obtener como resultado 5h 1m 15s
*/

public class Tiempo{
	public static void main(String[] args){
		int horas, minutos, segundos, segundosTotales;
		horas=generarAleatorio(10);
		minutos=generarAleatorio(500);
		segundos=generarAleatorio(500);
		mostrarTiempo(horas,minutos,segundos);
		segundosTotales=calcularSegundosTotales(horas,minutos,segundos);
		calcularHorasMinutosSegundos(segundosTotales);
	}
	/**
	* Genera un número aleatorio entre 0 y el factor indicado
	* @return el número aleatorio generado
	*/
	static int generarAleatorio(int factor){
		return (int)(Math.random()*factor);
	}
	/**
	* Calcula el total de segundos a partir de las horas, minutos y segundos
	* @param horas, minutos, segundos
	* @return El número total de segundos
	*/
	static int calcularSegundosTotales(int horas, int minutos, int segundos){
		return ((horas*3600)+(minutos*60)+segundos);
	}
	/**
	* Calcula la nueva hora, minutos y segundos partiendo del número de segundos totales
	* @param segundosTotales: El número de segundos totales
	*/
	static void calcularHorasMinutosSegundos(int segundosTotales){
		int horas,minutos,segundos;
		horas=segundosTotales/3600;
		segundosTotales=segundosTotales%3600;
		minutos=segundosTotales/60;
		segundosTotales=segundosTotales%60;
		segundos=segundosTotales;
		 System.out.println("El tiempo bien expresado es ");
		 mostrarTiempo(horas,minutos,segundos);
	}
	/**
	* Muestra por pantalla las horas, los minutos y los segundos que se le pasan por parámetro
	* @param horas, minutos, segundos
	*/
	static void mostrarTiempo(int horas, int minutos, int segundos){
		System.out.println(horas + "h " + minutos + "m " + segundos + "s");
	}
}