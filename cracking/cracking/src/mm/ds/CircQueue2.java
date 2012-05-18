package mm.ds;

import java.util.NoSuchElementException;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class CircQueue2 {


    private int[] store;
    private int front, rear;
    private int currentCount;


    public CircQueue2(int size) {
        store = new int[size];
        front = rear = -1;
    }

    public void insert(int i) throws IllegalStateException {
        if (isFull()) throw new IllegalStateException("Queue is full");
        if (rear == store.length - 1) rear = -1;
        store[++rear] = i;
        currentCount++;
    }


    public int remove() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        if (front == store.length - 1) front = -1;
        currentCount--;
        int tmp =  store[++front];
        store[front] = -1;
        return tmp;
    }

    public boolean isEmpty() {
        return (rear == front || (front + store.length == rear));
        //return (rear + 1 == front || (front + maxSize - 1 == rear));
    }

    public boolean isFull() {
        return (rear + 1 == front || (front + store.length - 1 == rear));
        //return (rear + 2 == front || (front + maxSize - 2 == rear));
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
