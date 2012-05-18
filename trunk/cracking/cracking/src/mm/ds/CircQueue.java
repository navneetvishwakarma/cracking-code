package mm.ds;

import java.util.NoSuchElementException;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class CircQueue {
    private int[] store;
    private int front, rear;
    private int currentCount;


    public CircQueue(int size) {
        store = new int[size];
        front = rear = -1;
    }

    public void insert(int i) throws IllegalStateException{
        if (isFull()) throw new IllegalStateException("Queue is full");
        if (rear == store.length - 1) rear = -1;
        store[++rear] = i;
        currentCount++;
    }
    
    
    public int remove() throws NoSuchElementException{
        if(isEmpty()) throw new NoSuchElementException("Queue is empty");
        if(front == store.length-1) front = -1;
        currentCount--;
        return store[++front];
    }

    
    public boolean isFull(){
        return (currentCount == store.length);
    }
    
    
    public boolean isEmpty(){
        return (currentCount == 0);
    }

    public int count() {
        return currentCount;
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        for (int i = front + 1; i <= rear; i++) {
            buf.append(store[i]).append("\n");
        }
        return buf.toString();
    }
}
