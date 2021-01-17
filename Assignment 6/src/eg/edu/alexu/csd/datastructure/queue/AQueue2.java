package eg.edu.alexu.csd.datastructure.queue;

public class AQueue2 implements IQueue, IArrayBased {
	private int capacity;
	private Object queue[];
	private int front;
	private int rear;
	private int currentSize = 0;

	//////////////////////////////// above variables must be private or not ??
	public AQueue2(int sizeOfQueue) {
		this.capacity = sizeOfQueue;
		front = 0;
		rear = 0;
		queue = new Object[this.capacity];
	}

	public static void main(String[] args) {
		AQueue2 queue = new AQueue2(5);
//        queue.enqueue(20);
//        queue.enqueue(25);
//        queue.enqueue(30);
//        queue.enqueue(35);
//        queue.enqueue(40);
//        queue.dequeue();
//        queue.dequeue();
//        queue.print();
//        queue.enqueue(20);
//        queue.print();
//        queue.dequeue();
//        queue.print();
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());

//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
	}

	@Override
	public void enqueue(Object item) {
		if (rear == capacity) {
			System.out.println("Queue is full!! Can not add more elements");
			throw new RuntimeException("Queue is full!!");
		} else {
			queue[rear] = item;
			rear++;
			currentSize++;
			System.out.println(item + " added to the queue");
		}
	}

	@Override
	public Object dequeue() {
		Object item;
		if (isEmpty()) {
			System.out.println("Queue is empty!! Can not dequeue element");
			throw new RuntimeException("Queue is empty!!");
		} else {
			item = queue[front];
			System.out.println(item + " removed from the queue");
			for (int i = 0; i < rear - 1; i++) {
				queue[i] = queue[i + 1];
			}
			rear--;
			queue[rear] = null;
			currentSize--;
		}
		return item;
	}

	@Override
	public boolean isEmpty() {
		if (front == rear) // OR >>> if(currentSize == 0)
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		return currentSize;
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			for (int i = 0; i < capacity; i++) { // rear not capacity && front not 0
				System.out.println(queue[i]);
			}
		}
	}

}
