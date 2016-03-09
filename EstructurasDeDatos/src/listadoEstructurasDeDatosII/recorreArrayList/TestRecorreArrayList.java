package listadoEstructurasDatosII.recorreArrayList;


public class TestRecorreArrayList {

	public static void main(String[] args) {
		RecorreArrayList arrayList = new RecorreArrayList();
		
		System.out.println("ArrayList: \n");
		arrayList.show();
		
		System.out.println("\nArrayList mostrado mediante un iterador con bucle while: ");
		arrayList.showWithIterator();
		
		System.out.println("\nArrayList mostrado mediante un iterador con bucle for: ");
		arrayList.showWithIterator2();
		
		System.out.println("\nArrayList mostrado mediante un for clásico, accediento mediante la posición (índices): ");
		arrayList.showWithGet();
		
		System.out.println("\nArrayList mostrado mediante un for mejorado: ");
		arrayList.showWithForEach();
		
		System.out.println("\nArrayList mostrado de fin a inicio mediante un for clásico, accediendo mediante la posición (índices): ");
		arrayList.showInverseWithGet();
	}
	
	

}
