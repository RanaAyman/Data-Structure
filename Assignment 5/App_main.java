package eg.edu.alexu.csd.datastructure.stack.cs_24;

import java.util.Scanner;

public class App_main {

	public static void main(String[] args) {
		ExpressionEvaluator p = new ExpressionEvaluator();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a symbolic infix expression to convert it to postfix notation");
		String exp = scan.nextLine();
		String Postfix = p.infixToPostfix(exp) ;
		System.out.println("Postfix notation is : ");
		System.out.println(Postfix);
		System.out.println("postfix evaluation: " + p.evaluate(Postfix));

	}

	
}