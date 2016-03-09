package listadoEstructurasDatosIII.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stack {
	//Stack es una clase que representa un conjunto de objetos LIFO (last-in-first-out)

	public static void main(String[] args) {
		Deque<Integer> stack = new ArrayDeque<Integer>();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println("Cima de la pila: "+stack.peek());
		
		while(!stack.isEmpty()){
			System.out.println(stack.peek());
			System.out.println("Desapilo de la pila: " + stack.pop());
		}	
	}
}
