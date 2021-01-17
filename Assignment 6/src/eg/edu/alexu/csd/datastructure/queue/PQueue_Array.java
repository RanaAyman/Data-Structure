package eg.edu.alexu.csd.datastructure.queue;

public class PQueue_Array {

	public static void main(String[] args) {
		PQueue_Array PQueue = new PQueue_Array(5);
		PQueue.print();
		PQueue.isEmpty();
//		PQueue.min();
//		PQueue.removeMin();
		PQueue.insert(1);
		PQueue.insert(2);
		PQueue.insert(3);
		PQueue.insert(4);
		PQueue.insert(5);
		PQueue.print();	
		System.out.println(PQueue.isEmpty());
		System.out.println(PQueue.min());
		PQueue.print();
		System.out.println(PQueue.removeMin());
		PQueue.print();
		PQueue.removeMin();
		PQueue.removeMin();
		PQueue.removeMin();
		PQueue.print();
		PQueue.removeMin();
		PQueue.print();
	}
    private int maxSize;
    private Object[] queueA;
    private int nItems;
    public PQueue_Array(int s) {
    	maxSize = s ;
    	queueA = new Object [maxSize];
    	nItems = 0 ;
    }
    
    public void insert(Object item) {
        if(nItems<maxSize) {
    	int j;
    	if(nItems == 0)
    		queueA[nItems++]=item;
    	else {
    		for(j=nItems-1 ; j>=0; j--) {
    			if((int)item < (int)queueA[j])      /// cast int ??
    				queueA[j+1]=queueA[j];
    			else {
    				break;
         		}
    		}
    		queueA[j+1]=item;
    		nItems++;
    	}
        }else {
        	throw new RuntimeException("Full Priority queue !!");
        }
    		
    }
    
    
    public Object removeMin() {
    	if(!isEmpty()) {
    	Object temp= queueA[nItems-1];
    	queueA[nItems-1]=null;
    	nItems--;
    	return temp;
    	}else {
   			throw new RuntimeException("Empty Priority queue !!");
   		}
    }

   	public Object min() {
   		if(!isEmpty()) {
     	return queueA[nItems-1];
   		}else {
   			throw new RuntimeException("Empty Priority queue !!");
   		}
   	}

   	public boolean isEmpty() {	
    	return (nItems == 0);	
   	}
   	public int size() {
    	return nItems;
    }
   	
   	public void print() {
   		if(!isEmpty()) {
   		for(int i=0;i<5;i++) {
   			System.out.print(queueA[i]+" ");
   		}
   		System.out.println();
   		}else {
   			System.out.println("Empty Priority queue !!");
   		}
   	}

}
