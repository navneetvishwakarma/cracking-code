package cracking.code.mm;

import java.util.EmptyStackException;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Stack {
    
    private int[] store;
    private int topPtr;


    public Stack(int size) {
        store = new int[size];
        topPtr = -1;
    }
    
    public void push(int i){
        if(isFull())    return;
        store[++topPtr] = i;
    }
    
    
    public int pop() throws EmptyStackException{
        if(isEmpty())   throw new EmptyStackException();
        return store[topPtr--];
    }

    public boolean isFull(){
        return (topPtr == store.length-1);    
    }
    
    
    public boolean isEmpty(){
        return (topPtr == -1);
    }

    public int count(){
        return (topPtr + 1);
    }
    
    @Override
    public String toString() {
        StringBuffer sbuf = new StringBuffer();
        for(int i=store.length-1;i>=0;i--){
            sbuf.append(store[i]).append("\n");
        }
        return sbuf.toString();
    }
}
