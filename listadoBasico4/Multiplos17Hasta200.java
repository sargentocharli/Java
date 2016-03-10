public class Multiplos17Hasta200{
	public static void main(String[] args){
		int i=0;
		System.out.println("Multiplos de 17 hasta 200: \n");
		for (;;){
			i++;
			if (i > 200)
				break;
			if (i % 17 != 0)
				continue;
			System.out.print("\t" + i);
		}
	}
}