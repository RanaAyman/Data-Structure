package eg.edu.alexu.csd.datastructure.linkedList.cs24cs28;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PolynomialSolverTest {
	PolynomialSolver test = new PolynomialSolver();
	SinglyLinkedList test2 = new SinglyLinkedList() ;
	int[][] A = {
            {1,2},
            {2,3},
            {4,0}
    };
    int[][] B = {
            {3,2},
            {6,3},
            {7,7}
    };
    int[][] C = {
            {-1,-1},
            {5,-4},
            {2,7}
    };
    
    @Test
    void add1() {
        int[][] answer = {
                {7,7},
                {8,3},
                {4,2},
                {4,0}
        };
        test.A =test.arraytolist(A);
        test.B =test.arraytolist(B);
       int[][] actual = test.add('A','B');
        assertArrayEquals(answer,actual);
    }

    @Test
    void subtract1() {
    	int[][] answer = {
                {-7,7},
                {-4,3},
                {-2,2},
                {4,0}
        };
        test.A =test.arraytolist(A);
        test.B =test.arraytolist(B);
       int[][] actual = test.subtract('A','B');
        assertArrayEquals(answer,actual);
    }

    @Test
    void multiply1() {
    	int[][] answer = {
                {14,10},
                {7,9},
                {28,7},
                {12,6},
                {12,5},
                {3,4},
                {24,3},
                {12,2}
        };
        test.A =test.arraytolist(A);
        test.B =test.arraytolist(B);
       int[][] actual = test.multiply('A','B');
        assertArrayEquals(answer,actual);
    }
    @Test
    void add2() {
        int[][] answer = {
                {9,7},
                {6,3},
                {3,2},
                {-1,-1},
                {5,-4}
        };
        test.B =test.arraytolist(B);
        test.C =test.arraytolist(C);
       int[][] actual = test.add('B','C');
        assertArrayEquals(answer,actual);
    }
    @Test
    void subtract2() {
    	int[][] answer = {
                {5,7},
                {6,3},
                {3,2},
                {1,-1},
                {-5,-4}
        };
        test.B =test.arraytolist(B);
        test.C =test.arraytolist(C);
       int[][] actual = test.subtract('B','C');
        assertArrayEquals(answer,actual);
    }
    @Test
    void multiply2() {
    	int[][] answer = {
                {14,14},
                {12,10},
                {6,9},
                {-7,6},
                {35,3},
                {-6,2},
                {-3,1},
                {30,-1},
                {15,-2}
        };
        test.B =test.arraytolist(B);
        test.C =test.arraytolist(C);
       int[][] actual = test.multiply('B','C');
        assertArrayEquals(answer,actual);
    }

}
