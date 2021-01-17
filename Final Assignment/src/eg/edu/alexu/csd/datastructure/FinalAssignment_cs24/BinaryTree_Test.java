package eg.edu.alexu.csd.datastructure.FinalAssignment_cs24;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryTree_Test {

	@Test
	void test1() {
		BinaryTree tree = new BinaryTree();
		int[] elements = {10, 9, 2, 7, 6, 1, 2 };
		for (int counter = 0; counter < elements.length; counter++) {
			tree.insert(tree.Root, elements[counter]);
		}
		int sum1 = tree.sumRange(tree.Root, 2, 9);
		assertEquals(24,sum1);
		
		tree.sum = 0;
		int sum2 = tree.sumRange(tree.Root, 1, 2);
		assertEquals(3,sum2);
		
		Boolean test = tree.isValidBST(tree.Root);
		assertTrue(test);
		
		int[] result = tree.nextSmallerNumber(elements);
		int[] toCompare = {1,2,5,4,5,-1,-1};
		for (int i = 0; i < result.length; i++) {
			assertEquals(result[i],toCompare[i]);
		}
		
	}
	
	@Test
	void test2() {
		BinaryTree tree = new BinaryTree();
		int[] elements = {50,30,20,20,40,70,60,80};
		for (int counter = 0; counter < elements.length; counter++) {
			tree.insert(tree.Root, elements[counter]);
		}
		int sum1 = tree.sumRange(tree.Root, 2, 9);
		assertEquals(0,sum1);
		
		tree.sum = 0;
		int sum2 = tree.sumRange(tree.Root, 10, 20);
		assertEquals(20,sum2);
		
		Boolean test = tree.isValidBST(tree.Root);
		assertTrue(test);
		
		int[] result = tree.nextSmallerNumber(elements);
		int[] toCompare = {1,2,-1,-1,-1,6,-1,-1};
		for (int i = 0; i < result.length; i++) {
			assertEquals(result[i],toCompare[i]);
		}
		
	}
	
	@Test
	void test3() {
		BinaryTree tree = new BinaryTree();
		int[] elements = null;
		assertThrows(java.lang.RuntimeException.class,() -> tree.nextSmallerNumber(elements),"Error: Null arrays!");
	}
	
	@Test
	void test4() {
		BinaryTree tree = new BinaryTree();
		int[] elements = {};
		assertThrows(java.lang.RuntimeException.class,() -> tree.nextSmallerNumber(elements),"Error: Zero-length arrays!");
	}

}
