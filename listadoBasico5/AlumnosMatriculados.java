import utiles.*;
/**
* Crea la clase AlumnosMatriculados. Queremos guardar en la memoria del ordenador el
* número de alumnos matriculados en cada grupo del ciclo de "Desarrollo de
* Aplicaciones Web" (por módulos). Existen dos grupos y se imparten seis módulos
* distintos en cada grupo. Utiliza métodos en la medida de lo posible. Sabemos que:
* a. En el primer grupo hay:
* i. 30 alumnos matriculados en Sistemas informáticos
* ii. 27 alumnos matriculados en Bases de datos
* iii. 25 alumnos matriculados en Programación
* iv. 21 alumnos matriculados en Lenguaje de marcas
* v. 19 alumnos matriculados en Entornos de desarrollo
* vi. 16 alumnos matriculados en FOL
* b. En el segundo grupo hay:
* i. 15 alumnos matriculados en Desarrollo Web en entorno cliente
* ii. 14 alumnos matriculados en Desarrollo Web en entorno servidor
* iii. 15 alumnos matriculados en Despliegue de aplicaciones Web
* iv. 15 alumnos matriculados en Diseño de interfaces Web
* v. 15 alumnos matriculados en Desarrollo Web en entorno cliente
*/
public class AlumnosMatriculados{
	public static void main(String[] args){
		int[][]alumnos={{30,27,25,21,19,16},{15,14,15,15,15,15}};
		String[][]modulos={{"S.I.","BB.DD","PGN","L.M.","E.D.","F.O.L."},{"D.W.C.","D.W.S.","D.A.W.","D.I.W.","Proy","Pract"}};
		mostrar(alumnos, modulos, "Alumnos matriculados en el ciclo Desarrollo de Aplicaciones Web: ");
	}
	/**
	* Muestra las matrices recibidas de forma bonita
	* @param alumnos: La matriz alumnos a mostrar de forma bonita
	* @param modulos: La matriz modulos a mostrar de forma bonita
	* @param msj: El mensaje a mostrar
	*/
	static void mostrar(int[][] alumnos, String[][] modulos, String msj){
		System.out.println(msj + "\n");
		for(int i=0;i<alumnos.length;i++){
			for(int j=0;j<modulos[0].length;j++)
			System.out.print("\t" + modulos[i][j]);
		System.out.println();
			for(int j=0;j<alumnos[0].length;j++)
			System.out.print("\t" + alumnos[i][j]);
		System.out.println("\n");
		}
	}
}