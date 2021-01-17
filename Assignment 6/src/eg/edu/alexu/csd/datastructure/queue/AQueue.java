package eg.edu.alexu.csd.datastructure.queue;

public class AQueue implements IQueue, IArrayBased {
	private int capacity;
	private Object queue[];
	private int front;
	private int rear;
	private int currentSize = 0;
	
	public AQueue(int sizeOfQueue) {
		this.capacity = sizeOfQueue;
		front = -1;
		rear = -1;
		queue = new Object[this.capacity];
	}

	public static void main(String[] args) {
		AQueue queue = new AQueue(5);
        queue.enqueue(20);
        queue.enqueue(25);
//        queue.enqueue(30);
//        queue.enqueue(35);
//        queue.enqueue(40);
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.isEmpty());
//        queue.print();
//        queue.enqueue(20);
//        queue.print();
//        queue.dequeue();
//        queue.print();
//		System.out.println(queue.size());
//		System.out.println(queue.isEmpty());

//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        System.out.println(queue.size());
//		System.out.println(queue.isEmpty());
//        queue.dequeue();
//        System.out.println(queue.size());
//		System.out.println(queue.isEmpty());
	}

	@Override
	public void enqueue(Object item) {
		if((front == rear + 1) || (front == 0 && rear == capacity-1)) {
			System.out.println("Queue is full!! Can not add more elements");
			throw new RuntimeException("Queue is full!!");
		} else {
			if(front == -1) front = 0;
	        rear = (rear + 1) % capacity;
	        queue[rear] = item;
			System.out.println(item + " added to the queue");
			currentSize ++;
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
			queue[front] = null ;
			if (front == rear){
	            front = -1;
	            rear = -1;
			}else {
			front = (front+1)%capacity ; 
		    }
			System.out.println(item + " removed from the queue");
			currentSize --; 
		return item;
		}
	}

	@Override
	public boolean isEmpty() {
		if (front == -1 && rear == -1) 
			return true;
		else
			return false;
	}

	@Override
	public int size() {                              //currentSize <<<<<<<<<<<
		if((capacity-front+rear)%capacity ==0)
		return (capacity-front+rear)%capacity;
		else
			return (capacity-front+rear)%capacity+1 ;
	}

	public void print() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			int i = front ;
			System.out.println("Queue is : ");
			while(i!=rear) { 
				System.out.println(queue[i]);
				i=(i+1)%capacity;
			}
			System.out.println(queue[rear]);
		}
	}

}
