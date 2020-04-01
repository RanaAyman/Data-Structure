package eg.edu.alexu.csd.datastructure.stack.cs_24;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExpressionEvaluator_Test {

	@Test
	void test1() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String result = "2 3 4 * +";
		String exp = "2 + 3 * 4";
		assertEquals(test.infixToPostfix(exp), result);
		assertEquals(test.evaluate(result), 14);
	}

	@Test
	void test2() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String result = "a b * 5 +";
		String exp = "a * b + 5";
		assertEquals(test.infixToPostfix(exp), result);
		assertThrows(java.lang.RuntimeException.class, () -> test.evaluate(result),
				"Error : letters can't be evaluated !!");
	}

	@Test
	void test3() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String result = "1 2 + 7 *";
		String exp = "(1 + 2) * 7";
		assertEquals(test.infixToPostfix(exp), result);
		assertEquals(test.evaluate(result), 21);
	}

	@Test
	void test4() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String result = "a b * c /";
		String exp = "a * b / c";
		assertEquals(test.infixToPostfix(exp), result);
		assertThrows(java.lang.RuntimeException.class, () -> test.evaluate(result),
				"Error : letters can't be evaluated !!");
	}

	@Test
	void test5() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String result = "a b c - d + / e a - * c *";
		String exp = "(a / (b - c + d)) * (e - a) * c";
		assertEquals(test.infixToPostfix(exp), result);
		assertThrows(java.lang.RuntimeException.class, () -> test.evaluate(result),
				"Error : letters can't be evaluated !!");
	}

	@Test
	void test6() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String result = "a b / c - d e * + a c * -";
		String exp = "a / b - c + d * e - a * c";
		assertEquals(test.infixToPostfix(exp), result);
		assertThrows(java.lang.RuntimeException.class, () -> test.evaluate(result),
				"Error : letters can't be evaluated !!");
	}

	@Test
	void test7() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String result = "a b c + * d *";
		String exp = "a * (b + c) * d";
		assertEquals(test.infixToPostfix(exp), result);
		assertThrows(java.lang.RuntimeException.class, () -> test.evaluate(result),
				"Error : letters can't be evaluated !!");
	}

	@Test
	void test8() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String result = "6 2 / 3 - 2 4 * +";
		String exp = "(6 / 2 - 3) + (2 * 4)";
		assertEquals(test.infixToPostfix(exp), result);
		assertEquals(test.evaluate(result), 8);

	}

	@Test
	void test9() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String result = "2 3 1 * + 9 -";
		String exp = "2 + 3 * 1 - 9";
		assertEquals(test.infixToPostfix(exp), result);
		assertEquals(test.evaluate(result), -4);
	}

	@Test
	void test10() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String result = "100 200 + 2 / 5 * 7 +";
		String exp = "(100 + 200) / 2 * 5 + 7";
		assertEquals(test.infixToPostfix(exp), result);
		assertEquals(test.evaluate(result), 757);

	}

	@Test
	void test11() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String exp1 = "0 0 / 5 +";
		assertThrows(java.lang.RuntimeException.class, () -> test.evaluate(exp1),
				"Error : Division by zero is not defined !");

	}

	@Test
	void test12() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String exp1 = "5 0 / 7 +";
		assertThrows(java.lang.RuntimeException.class, () -> test.evaluate(exp1),
				"Error : Division by zero is not defined !");

	}

	@Test
	void test13() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String result = "0 5 / 8 +";
		String exp = "0 / 5 + 8";
		assertEquals(test.infixToPostfix(exp), result);
		assertEquals(test.evaluate(result), 8);

	}

	@Test
	void test14() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String result = "4 -4 - 8 +";
		String exp = "4 - -4 + 8";
		assertEquals(test.infixToPostfix(exp), result);
		assertEquals(test.evaluate(result), 16);

	}

	@Test
	void test15() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String result = "400 -40 - 85 -";
		String exp = "400 - -40 - 85";
		assertEquals(test.infixToPostfix(exp), result);
		assertEquals(test.evaluate(result), 355);

	}

	@Test
	void test16() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String exp = "40 + 3 ((";
		assertEquals(test.infixToPostfix(exp), "Invalid Expression");
		assertThrows(java.lang.RuntimeException.class, () -> test.evaluate(exp), "Invalid Expression !!");

	}

	@Test
	void test17() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String result = "3 2 / 3 2 / +";
		String exp = "3 / 2 + 3 / 2";
		assertEquals(test.infixToPostfix(exp), result);
		assertEquals(test.evaluate(result), 3);
	}

	@Test
	void test18() {
		ExpressionEvaluator test = new ExpressionEvaluator();
		String result = "-3 2 / -3 2 / -";
		String exp = "-3 / 2 - -3 / 2";
		assertEquals(test.infixToPostfix(exp), result);
		assertEquals(test.evaluate(result), 0);
	}
}
