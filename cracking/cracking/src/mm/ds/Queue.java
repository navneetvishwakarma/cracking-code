package mm.ds;

import java.util.NoSuchElementException;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Queue {
    private int[] store;
    private int front, rear;


    public Queue(int size) {
        store = new int[size];
        front = -1;
        rear = -1;
    }

    public void insert(int i) throws IllegalStateException{
        if(isFull()) throw new IllegalStateException("Queue full");
        store[++rear] = i;
    }
    
    public int remove() throws NoSuchElementException{
        if(isEmpty()) throw new NoSuchElementException("Queue empty");
        return store[++front];
    }


    public boolean isEmpty(){
        return (front == rear);
    }


    public boolean isFull(){
        return (rear == (store.length-1) );
    }
    
    public int count(){
        return (rear - front);
    }
    
    
    @Override
    public String toString(){
        StringBuffer buf = new StringBuffer();
        for(int i = front+1; i<=rear;i++){
            buf.append(store[i]).append("\n");
        }
        return buf.toString();
    }
}
