package eg.edu.alexu.csd.datastructure.stack.cs_24;

import java.util.Scanner;

public class Stack_main {
	public static void main(String[] args) {
		Stack stack = new Stack();
		String choice;
		do {
			System.out.println("Select the number of the operation from the five above : ");
			System.out.println("1 - Push\n" + "2 - Pop\n" + "3 - Peek\n" + "4 - Get size\n" + "5 - Check if empty");
			System.out.println("\" To exit enter -1 \"");
			Scanner scan = new Scanner(System.in);
			choice = scan.next();
			switch (choice) {
			case "1":
				System.out.println("Enter the element to push to the stack ");
				Object element = scan.next();
				stack.push(element);
				stack.show(stack.top);
				break;
			case "2":
				System.out.println(stack.pop() + "  is popped");
				stack.show(stack.top);
				break;
			case "3":
				System.out.println("Peek is > " + stack.peek());
				stack.show(stack.top);
				break;
			case "4":
				System.out.println("Size of stack = " + stack.size());
				break;
			case "5":
				if (stack.isEmpty()) {
					System.out.println("Stack is empty");
				} else if (!stack.isEmpty()) {
					System.out.println("Stack is not empty");
				}
				break;
			case "-1" :
				choice = "-1" ;
				break ;
			default:
				System.out.println("Invalid choice !! ");
			}
		} while (choice != "-1");

	}
}
