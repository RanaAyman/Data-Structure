package eg.edu.alexu.csd.datastructure.stack.cs_24;

import java.lang.Math;

public class ExpressionEvaluator implements IExpressionEvaluator {
	// function to return precedence of an operator
	// Higher returned value means higher precedence
	private static int Prec(char ch) {
		if (ch == '+' || ch == '-')
			return 1;
		else if (ch == '*' || ch == '/')
			return 2;
		else
			return -1;

	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public String infixToPostfix(String expression) {
		if (num_of_operators(expression) && last(expression) && adjacent_operators(expression)) {
			String result = new String("");                                                             // initializing empty String for result
			Stack stack = new Stack();                                                                  // initializing empty stack
			for (int i = 0; i < expression.length(); i++) {
				char c = expression.charAt(i);

				if (c == ' ') {                                                                         // To ignore spaces
					continue;
				} else {
					// If the scanned character is an operand, add it to output.
					if (Character.isLetterOrDigit(c)) {
						if (Character.isDigit(c)) {
							int n = 0;
							while (Character.isDigit(c)) {
								n = n * 10 + (int) (c - '0');
								i++;
								if (i < expression.length())
									c = expression.charAt(i);
								else
									break;
							}
							i--;
							result += n;
							result += " ";
						} else if (Character.isLetter(c)) {
							result += c;
							result += " ";
						}
					}
					// If the scanned character is an '(', push it to the stack.
					else if (c == '(')
						stack.push(c);
					// If the scanned character is an ')', pop and output from the stack
					// until an '(' is encountered.
					else if (c == ')') {
						while (!stack.isEmpty() && (char) stack.peek() != '(') {
							result += stack.pop();
							result += " "; ////// *****
						}
						if (!stack.isEmpty() && (char) stack.peek() != '(')
							return "Invalid Expression";                                                              // invalid expression
						else
							stack.pop();
					} else // an operator is encountered
					{
						if (i + 1 < expression.length() && expression.charAt(i + 1) == ' ') { 
							while (!stack.isEmpty() && Prec(c) <= Prec((char) stack.peek())) {
								if ((char) stack.peek() == '(')
									return "Invalid Expression";
								result += stack.pop();
								result += " ";
							}
							stack.push(c);
						} else if (c == '-' && expression.charAt(i + 1) != ' ') {
							result += c;
							i += 1;
							c = expression.charAt(i);
							int n = 0;
							while (Character.isDigit(c)) {
								n = n * 10 + (int) (c - '0');
								i++;
								if (i < expression.length())
									c = expression.charAt(i);
								else
									break;
							}
							i--;
							result += n;
							result += " ";
						}
					}
				}
			}
			// pop all the operators from the stack
			while (!stack.isEmpty()) {
				if ((char) stack.peek() == '(')
					return "Invalid Expression";
				result += stack.pop();
				result += " ";
			}
			result = result.substring(0, result.length() - 1);
			return result;
		} else {
			// throw new RuntimeException("Inalid Expression");
			return "Invalid Expression";
		}
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public int evaluate(String expression) {
		if (expression.contains("(") || expression.contains(")"))
			throw new RuntimeException("Invalid Expression !!");

		Stack stack = new Stack();                                                                        // create a stack
		for (int i = 0; i < expression.length(); i++)                                                     // Scan all characters one by one
		{
			char c = expression.charAt(i);
			if (expression == "Invalid Expression") {
				throw new RuntimeException("Inalid Expression");
			}
			if (Character.isLetter(c)) {
				throw new RuntimeException("Error : letters can't be evaluated !!");
			} else {
				if (c == ' ')
					continue;

				// If the scanned character is an operand
				// (number here),extract the number
				// Push it to the stack.

				else if ((i + 1 < expression.length())
						&& (Character.isDigit(c) || (c == '-' && expression.charAt(i + 1) != ' '))) {
					if (c == '-') {
						i += 1;
						c = expression.charAt(i);
						float n = 0;
						// extract the characters and store it in num
						while (Character.isDigit(c)) {
							n = n * 10 + (int) (c - '0');
							i++;
							if (i < expression.length())
								c = expression.charAt(i);
							else
								break;
						}
						i--;

						// push the number in stack
						stack.push(-n);

					} else {

						float n = 0;
						// extract the characters and store it in num
						while (Character.isDigit(c)) {
							n = n * 10 + (int) (c - '0');
							i++;
							if (i < expression.length())
								c = expression.charAt(i);
							else
								break;
						}
						i--;

						// push the number in stack
						stack.push(n);
					}
				}
				// If the scanned character is an operator, pop two
				// elements from stack apply the operator .
				else {
					Object val1;
					Object val2;
					val1 = stack.pop();
					val2 = stack.pop();
					switch (c) {
					case '+':
						stack.push((float) val2 + (float) val1);
						break;

					case '-':
						stack.push((float) val2 - (float) val1);
						break;

					case '/':
						if ((float) val1 == 0 || ((float) val1 == 0 && (float) val2 == 0)) {
							throw new RuntimeException("Error : Division by zero is not defined !");
						} else {
							stack.push(((float) val2 / (float) val1));
						}
						break;

					case '*':
						stack.push((float) val2 * (float) val1);
						break;
					}
				}
			}
		}
		int res = Math.round((float) stack.pop());
		return res;
	}

	//////////////////////////////////////
	public boolean last(String str) {                                                       // check invalid expression contains operators in the last. EX : "1 + 2 +"
		int i = str.length() - 1;
		char c = str.charAt(i);
		while (i < str.length() && i >= 0 && (c == ')' || c == ' ')) {
			i--;
		}
		if ((i < str.length() && i >= 0)
				&& (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/')) {
			return false;
		} else {
			return true;
		}

	}

	////////////////////////////////////
	public boolean adjacent_operators(String str) {                                                          // check invalid expression contains adjacent operators.
		boolean flag = false;
		boolean test = true;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == ' ') {                                                                                  // To ignore spaces
				continue;
			} else {
				if (Character.isLetterOrDigit(c)) {
					if (flag == false) {
						if (Character.isDigit(c)) {
							int n = 0;
							while (Character.isDigit(c)) {
								n = n * 10 + (int) (c - '0');
								i++;
								if (i < str.length())
									c = str.charAt(i);
								else
									break;
							}
							flag = true;
							i--;
						} else if (Character.isLetter(c)) {
							flag = true;
						}
					} else {
						test = false;
						break;
						// throw new RuntimeException("Invalid Expression");
					}
				} else if ((i + 1 < str.length()) && (c == '+' || c == '-' || c == '/' || c == '*')
						&& (!Character.isLetterOrDigit(str.charAt(i + 1)))) {
					if (flag == true) {
						flag = false;
					} else {
						test = false;
						break;
						// throw new RuntimeException("Invalid Expression");
					}
				}
			}
		}
		return test;
	}

	///////////////////////////////////
	public boolean num_of_operators(String str) {                                                         // check invalid expression.
		int num = 0;
		int operators = 0;
		int open = 0;
		int close = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == ' ') {                                                                              // To ignore spaces
				continue;
			} else {
				if (Character.isLetterOrDigit(c)) {
					if (Character.isDigit(c)) {
						int n = 0;
						while (Character.isDigit(c)) {
							n = n * 10 + (int) (c - '0');
							i++;
							if (i < str.length())
								c = str.charAt(i);
							else
								break;
						}
						num++;
						i--;
					} else if (Character.isLetter(c)) {
						num++;
					}
				} else if ((i + 1 < str.length()) && (c == '+' || c == '-' || c == '/' || c == '*')
						&& (!Character.isLetterOrDigit(str.charAt(i + 1)))) {
					operators++;
				} else if ((i + 1 == str.length()) && (c == '+' || c == '-' || c == '/' || c == '*')) {
					operators++;
				} else if (c == '(') {
					open++;
				} else if (c == ')') {
					close++;
				}

			}
		}
		if (num == operators + 1 && open == close) {
			return true;
		} else {
			return false;
		}
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String remove_spaces(String line) {
		String delims = "[\\s ]";
		String[] c = line.split(delims);
		String exp = c[0];
		for (int i = 1; i < c.length; i++) {
			exp += c[i];
		}
		return exp;
	}

	public String add_spaces(String line) {
		String temp = new String("");
		for (int i = 0; i < line.length(); i++) {
			if (Character.isLetterOrDigit(line.charAt(i))) {
				while ((i < line.length()) && (Character.isLetterOrDigit(line.charAt(i)))) {
					temp += line.charAt(i);
					i++;
				}
				i--;
				temp += " ";
				// }else if((line.charAt(i)=='+' || line.charAt(i)=='*' || line.charAt(i)=='/'
				// )&&(Character.isLetterOrDigit(line.charAt(i+1))) || line.charAt(i)==')' ||
				// line.charAt(i)=='(') {
			} else if ((line.charAt(i) == '+' || line.charAt(i) == '*' || line.charAt(i) == '/')) {
				temp += line.charAt(i);
				temp += " ";
			} else if (line.charAt(i) == '-') {
				if (line.charAt(i + 1) == '-') {
					temp += line.charAt(i);
					temp += " ";
				} else if ((i + 1 < line.length()) && (Character.isLetterOrDigit(line.charAt(i + 1)))) {
					temp += line.charAt(i);
				}
			} else if (line.charAt(i) == '(' || line.charAt(i) == ')') {
				temp += line.charAt(i);
			}
		}
		temp = temp.substring(0, temp.length() - 1);
		return temp;
	}

}