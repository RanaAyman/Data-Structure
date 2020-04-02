package eg.edu.alexu.csd.datastructure.stack.cs_24;

import java.util.Scanner;

public class App_main {

	public static void main(String[] args) {
		ExpressionEvaluator p = new ExpressionEvaluator();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a symbolic infix expression to convert it to postfix notation & evaluate its value.");
		System.out.println("Enter the expression with spaces between the numbers \" With parentheses or not ....\" \nFor Example :   (6 / 2 - 3) + (2 * 4)    <<<OR>>>    a * (b + c) * d");
		System.out.println("NOTE : Expressions with letters will give you postfix notation only and will throw an error message for evaluating the value.");
		String exp = scan.nextLine();
		String Postfix = p.infixToPostfix(exp) ;
		System.out.println("Postfix notation is : ");
		System.out.println(Postfix);
		System.out.println("postfix evaluation: " + p.evaluate(Postfix));

	}

	
}
