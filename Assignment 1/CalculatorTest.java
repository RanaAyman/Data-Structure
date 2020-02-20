package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	public void test1() {
		Calculator calc = new Calculator() ;
		assertThrows(java.lang.RuntimeException.class,()-> calc.divide(1,0),"can not divide by zero!");
	}
	@Test
	public void test2() {
		Calculator calc = new Calculator() ;
		assertThrows(java.lang.RuntimeException.class,()-> calc.divide(0,0),"Undefined!");
	}

	@Test
	public void test3() {
		Calculator calc = new Calculator() ;
	    assertEquals(0, calc.divide(0, 55), 0);
	}
	@Test
	public void test4() {
		Calculator calc = new Calculator() ;
		assertEquals(100,calc.add(40,60));
	}
	@Test
	public void test5() {
		Calculator calc = new Calculator() ;
		assertEquals(0,calc.add(-45, 45));
	}
	@Test
	public void test6() {
		Calculator calc = new Calculator() ;
		assertEquals(70,calc.add(75, -5));
	}

}
