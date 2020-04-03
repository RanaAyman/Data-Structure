package eg.edu.alexu.csd.datastructure.stack.cs_24;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Stack_Test {

	@Test
	void test1() {

		// initialize an empty stack
		// push > 'a' > 'b' > 'c'
		Stack p = new Stack();
		p.push('a');
		p.push('b');
		p.push('c');

		// in stack > 'a' > 'b' > 'c'
		// test that : peek = 'c' , isEmpty = false , size = 3
		assertEquals('c', p.peek());
		assertFalse(p.isEmpty());
		assertEquals(3, p.size());
		assertEquals('c', p.pop());

		// in stack > 'a' > 'b'
		// test after pop 'c' : peek = 'b' , isEmpty = false , size = 2
		assertFalse(p.isEmpty());
		assertEquals('b', p.peek());
		assertEquals(2, p.size());
		assertEquals('b', p.pop());

		// in stack > 'a'
		// test after pop 'b' : peek = 'a' , isEmpty = false , size = 1
		assertFalse(p.isEmpty());
		assertEquals('a', p.peek());
		assertEquals(1, p.size());
		assertEquals('a', p.pop());

		// in stack > null
		// test after pop 'a' : peek => RuntimeException"!! Stack underflow !!" ,
		// isEmpty = true , size = 0 , pop => RuntimeException"!! Stack underflow !!"
		assertEquals(0, p.size());
		assertTrue(p.isEmpty());
		assertThrows(java.lang.RuntimeException.class, () -> p.peek(), "!! Stack underflow !!");
		assertThrows(java.lang.RuntimeException.class, () -> p.pop(), "!! Stack underflow !!");
	}

//**********************************************************************************************************************************************************************
	@Test
	void test2() {
		// initialize an empty stack
		// push > 10 > 20 > 30 > 40 > 50
		Stack p = new Stack();
		p.push(10);
		p.push(20);
		p.push(30);
		p.push(40);
		p.push(50);

		// in stack > 10 > 20 > 30 > 40 > 50
		// test that : peek = 50 , isEmpty = false , size = 5
		assertEquals(50, p.peek());
		assertFalse(p.isEmpty());
		assertEquals(5, p.size());
		assertEquals(50, p.pop());

		// in stack > 10 > 20 > 30 > 40
		// test after pop 50 : peek = 40 , isEmpty = false , size = 4
		assertFalse(p.isEmpty());
		assertEquals(40, p.peek());
		assertEquals(4, p.size());
		assertEquals(40, p.pop());

		// in stack > 10 > 20 > 30
		// test after pop 40 : peek = 30 , isEmpty = false , size = 3
		assertFalse(p.isEmpty());
		assertEquals(30, p.peek());
		assertEquals(3, p.size());
		assertEquals(30, p.pop());

		// in stack > 10 > 20
		// test after pop 30 : peek = 20 , isEmpty = false , size = 2
		assertFalse(p.isEmpty());
		assertEquals(20, p.peek());
		assertEquals(2, p.size());
		assertEquals(20, p.pop());

		// in stack > 10
		// test after pop 20 : peek = 10 , isEmpty = false , size = 1
		assertFalse(p.isEmpty());
		assertEquals(1, p.size());
		assertEquals(10, p.peek());
		assertEquals(10, p.pop());

		// in stack > null
		// test after pop 10 : peek => RuntimeException"!! Stack underflow !!" , isEmpty
		// = true , size = 0 , pop => RuntimeException"!! Stack underflow !!"
		assertTrue(p.isEmpty());
		assertEquals(0, p.size());
		assertThrows(java.lang.RuntimeException.class, () -> p.peek(), "!! Stack underflow !!");
		assertThrows(java.lang.RuntimeException.class, () -> p.pop(), "!! Stack underflow !!");
	}

}
