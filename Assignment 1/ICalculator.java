package calculator;

public interface ICalculator {
	/**
	 * Adds given two numbers 
	 * @param xfirst number 
	 * @param ysecond number
	 * @return the sum of the two numbers
	 */
	int add(int x, int y);

	/**
	 * Divides two numbers 
	 * @param xfirst number 
	 * @param ysecond number
	 * @return the division result
	 */
	float divide(int x, int y) throws RuntimeException;

}
