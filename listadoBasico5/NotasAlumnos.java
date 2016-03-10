import utiles.*;
/**
* Crea la clase NotasAlumnos. Declara y crea un tipo de variable que sea capaz de
* contener la nota que han obtenido 4 alumnos en los diferentes módulos en los que
* están matriculados. Sabemos que el primer alumno está matriculado en 4 módulos; el
* segundo en 7, el tercero en 3 módulos y el cuarto en dos módulos. Genera
* aleatoriamente las notas de los alumnos y muéstralos. Utiliza métodos de la forma
*más eficiente y clara.
*/
public class NotasAlumnos{
	public static void main(String[] args){
		double[][] notas=new double[4][];
		notas[0]=new double[4];
		notas[1]=new double[7];
		notas[2]=new double[3];
		notas[3]=new double[2];
		inicializarMatrizAleatoriamente(notas);
		mostrar(notas, "Las notas de los alumnos en sus diferentes módulos son: ");
	}
	/**
	* Crea una matriz de decimales con elementos generados aleatoriamente
	* @param matriz: La matriz que se va a generar
	*/
	static void inicializarMatrizAleatoriamente(double[][] matriz){
		double minimo=0;
		double maximo=10;
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++)
				matriz[i][j]=(Math.random()*(minimo-maximo)+maximo);
		}
	}
	/**
	* Muestra la matriz que recibe
	* @param matriz: La matriz que recibe
	* @param: msj: El nombre de la matriz
	*/
	static void mostrar(double[][] matriz, String msj){
		System.out.println(msj);
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[i].length;j++)
				System.out.printf("%-3s %1.2f %-3s","",matriz[i][j],"");		
			System.out.println("\n");
		}
	}
}	