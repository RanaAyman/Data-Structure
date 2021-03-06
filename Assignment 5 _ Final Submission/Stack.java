package eg.edu.alexu.csd.datastructure.stack.cs_24;

public class Stack implements IStack {
	Node top;                                   // top of stack
	//private Node top;                         // top of stack
	private int size;                           // size of the stack
 
	private class Node {                        // linked list class
		private Object data;
		private Node next;
	}

	Stack() {                                   // Initializes an empty stack
		top = null;
		size = 0;
	}

	@Override
	public Object pop() {
		if (isEmpty()) {
			throw new RuntimeException("!! Stack underflow !!");
		}
		Object item = top.data;                  // save item to return
		top = top.next;                          // delete first node
		size--;
		return item;                             // return the saved item
	}

	@Override
	public Object peek() {
		if (isEmpty())
			throw new RuntimeException("!! Stack underflow !!");
		return top.data;                          // return the peek of stack
	}

	@Override
	public void push(Object element) {            // Add the item to the stack.
		Node oldfirst = top;
		top = new Node();
		top.data = element;
		top.next = oldfirst;
		size++;                                   // increase the size of stack

	}

	@Override
	public boolean isEmpty() {
		return (top == null);                      // return true if stack is empty & false otherwise
	}

	@Override
	public int size() {
		return size;                               // return size of stack
	}

	public void show(Node top) {
		if(!isEmpty()) {
		System.out.print("Stack Stating from Top >>> ");
		while (top.next != null) {
			System.out.print(top.data + " > ");
			top = top.next;
		}
		System.out.print(top.data);
		System.out.println();
		}else {
			System.out.println("Stack is empty , you should push elements ");
			System.out.println();
		}
		
	}

}
