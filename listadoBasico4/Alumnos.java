import utiles.*;
/**
* Define la clase Alumnos que obtenga aleatoriamente las notas de 30 alumnos. La
* nota será un número decimal comprendido entre 0 y 10, ambos inclusive. Utiliza
* métodos. Al finalizar el programa deberá mostrar:
* a. Total de notas
* b. Número de aprobados
* c. Número de suspensos
* d. Nota máxima
* e. Nota mínima
* f. Media
*/
 public class Alumnos{
	 public static void main(String[] args){
		 int i, aprobados = 0, suspensos = 0;
		 double maxima = 0, minima = 9, media = 0;
		 double[] notas = new double[pedirNumeroNotas()];
		 
		 for(i=0;i<notas.length;i++){
			 notas[i]=generarAleatorio();
			 mostrarNota(notas[i]);
			  if(comprobarNota(notas[i]))
				 aprobados++;
			 else
				 suspensos++;
			 maxima = comprobarNotaMaxima(notas[i], maxima);
			 minima = comprobarNotaMinima(notas[i], minima);
			 media+=notas[i];
		 }
		 media = media/i;
		 mostrarResultados(i, aprobados, suspensos, maxima, minima, media);
	 }
	 /**
	 * Pide al usuario que introduzca el número de notas
	 * @return numeroNotas El número de notas que se van a introducir
	 */
	 static int pedirNumeroNotas(){
		 int numeroNotas = Teclado.leerEntero("Introduzca el número de notas que se van a introducir: ");
		 return numeroNotas;
	 }
	 /**
	 * Genera un número aleatorio entre 0 y 10 simulando la nota
	 * @return El número aleatorio generado
	 */
	 static double generarAleatorio(){
		 return (Math.random()*10 //Preguntar en clase fórmula para incluir en el número generado los límites
	 }
	 /**
	 * Muestra en pantalla la nota generada aleatoriamente
	 * @param El número que va a mostrar
	 */
	 static void mostrarNota(double nota){
		 System.out.printf("%.2f %s",nota,"\t");
	 }
	 /** 
	 * Comprueba si la nota pasada como parámetro está aprobada o suspensa.
	 * @param nota: La nota pasada para comprobar
	 * @return True en caso de que la nota esté aprobada, false en caso de que esté suspensa
	 */
	 static boolean comprobarNota(double nota){
		 if(nota>=5)
			 return true;
		 else
			 return false;
	 }
	 /**
	 * Comprueba si la nota es mayor que maxima. Sustituye el valor de maxima en caso afirmativo
	 * @param nota: La nota a comprobar, @maxima: La nota máxima actual
	 * @ return maxima: La nota máxima actual
	 */
	 static double comprobarNotaMaxima(double nota, double maxima){
		 if(nota>maxima)
			 maxima=nota;
		 return maxima;
	 }
	 /** Comprueba si la nota es menor que minima. Sustituye el valor de minima en caso afirmativo
	 * @param nota: La nota a comprobar, @minima: La nota mínima actual
	 * @return mínima: La nota mínima actual
	 */
	 static double comprobarNotaMinima(double nota, double minima){
		 if(nota<minima)
			 minima=nota;
		 return minima;
	 }
	 /**
	 * Muestra por pantalla todos los datos calculados
	 * @param i: Número total de notas
	 * @param aprobados: Número total de aprobados
	 * @param suspensos: Número total de suspensos
	 * @param maxima: Nota máxima 
	 * @param minima: Nota mínima
	 * @param media: Nota media
	 */
	 static void mostrarResultados(int i, int aprobados, int suspensos, double maxima, double minima, double media){
		 System.out.printf("%s %s %s","Número total de notas: ",i,"\n");
		 System.out.printf("%s %s %s","Número total de alumnos aprobados: ",aprobados,"\n");
		 System.out.printf("%s %s %s","Número total de alumnos suspensos: ",suspensos,"\n");
		 System.out.printf("%s %.2f %s","Nota máxima: ",maxima,"\n");
		 System.out.printf("%s %.2f %s","Nota mínima: ",minima,"\n");
		 System.out.printf("%s %.2f %s","Nota media: ",media,"\n");
	 }
 }