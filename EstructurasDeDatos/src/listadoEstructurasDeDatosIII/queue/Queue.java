package listadoEstructurasDatosIII.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Queue {
// clase que suele ordenar elementos en formato FIFO (first-in-first-out)
	
	public static void main(String[] args) {
		Deque<Integer> queue = new ArrayDeque<Integer>();
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		
		System.out.println("Primer elemento: "+queue.peek());
		
		while(!queue.isEmpty()){
			System.out.println(queue.peek());
			System.out.println("Saco de la cola: " + queue.poll());
		}	

	}
}
