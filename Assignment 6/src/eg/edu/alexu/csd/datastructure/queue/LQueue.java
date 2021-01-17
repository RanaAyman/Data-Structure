package eg.edu.alexu.csd.datastructure.queue;

public class LQueue implements IQueue, ILinkedBased {
	private Node front, rear;
	private int currentSize;

	private class Node {
		private Object data;
		private Node next;
	}

	public LQueue() {
		front = null;
		rear = null;
		currentSize = 0;
	}

	public static void main(String[] args) {
		LQueue queue = new LQueue();
		queue.enqueue(20);
		queue.enqueue(25);
//		queue.enqueue(30);
//		queue.enqueue(35);
//		queue.enqueue(40);
//		queue.dequeue();
//		queue.dequeue();
//		queue.show();
//		queue.enqueue(20);
//		queue.show();
//		queue.dequeue();
//		queue.show();
//		queue.dequeue();
//		queue.dequeue();
		queue.enqueue(35);
		queue.dequeue();
		queue.show();
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
	    queue.dequeue();

	}

	@Override
	public void enqueue(Object item) {
		Node oldRear = rear;
		rear = new Node();
		rear.data = item;
		rear.next = null;
		if (isEmpty()) {
			front = rear;
		} else {
			oldRear.next = rear;
		}
		currentSize++;
		System.out.println(item + " added to the queue");
	}

	@Override
	public Object dequeue() {
		if (isEmpty()) { /// rear = null ; ????????
			throw new RuntimeException("Queue is empty!!");
		} else {
			Object item = front.data;
			front = front.next;
			currentSize--;
			System.out.println(item + " removed from the queue");
			return item;
		}
	}

	@Override
	public boolean isEmpty() {
		return (currentSize == 0);
	}

	@Override
	public int size() {
		return currentSize;
	}

	public void show() {
		if (currentSize > 0) {
			Node node = front;
			while (node.next != null) {
				System.out.println(node.data);
				node = node.next;
			}
			System.out.println(node.data);
		} else {
			System.out.println("list is empty");
		}
	}
}
