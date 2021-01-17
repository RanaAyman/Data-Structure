package eg.edu.alexu.csd.datastructure.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AQueue_Test {
	AQueue queue = new AQueue(5);
    @Test
    void Test(){
        assertTrue(queue.isEmpty());
        for (int i = 1; i < 6; i++) {
            queue.enqueue(i);
        }
        assertEquals(5,queue.size());
        for (int i = 1; i < 6; i++) {
            assertEquals(i,queue.dequeue());
        }
        assertThrows(java.lang.RuntimeException.class, () -> queue.dequeue(), "Queue is empty!!");
    }
}
