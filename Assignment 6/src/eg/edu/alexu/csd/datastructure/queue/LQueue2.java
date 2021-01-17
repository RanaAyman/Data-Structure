package eg.edu.alexu.csd.datastructure.queue;

import eg.edu.alexu.csd.datastructure.linkedList.cs24cs28.DoublyLinkedList;

public class LQueue2 implements IQueue, ILinkedBased {
	DoublyLinkedList p = new DoublyLinkedList();
	public static void main(String[] args) {
		LQueue2 queue = new LQueue2();
		queue.enqueue(20);
		queue.enqueue(25);
		queue.enqueue(30);
		queue.enqueue(35);
		queue.enqueue(40);
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(20);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.enqueue(35);
		queue.dequeue();
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		queue.p.print();
	}

	@Override
	public void enqueue(Object item) {
		p.add(item);
		System.out.println(item + " added to the queue");
	}

	@Override
	public Object dequeue() {
		    Object item = p.get(0);
		    p.remove(0);
			System.out.println(item + " removed from the queue");
			return item;
	}

	@Override
	public boolean isEmpty() {
		return p.isEmpty();
	}

	@Override
	public int size() {
		return p.size();
	}

}
