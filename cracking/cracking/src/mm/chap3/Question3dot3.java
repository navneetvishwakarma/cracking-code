package mm.chap3;


import java.util.ArrayList;

/**
 * Implement a data structure SetOfStacks that mimics this SetOf- Stacks should be composed of several stacks, and 
 * should create a new stack once the previous one exceeds capacity 
 *
 * Here, instead of creating a wrapper SetOfStacks, I have modified the Stack itself to handle multiple stacks internally 
 * @author mmathuria
 */
public class Question3dot3 {
    ArrayList<int[]> store = new ArrayList<int[]>();
    private static final int MAX = 3;
    private  int top = -1;

    public Question3dot3() {
        int[] ns = new int[MAX];
        store.add(ns);
    }

    public void push(int data){
        if(isFull()){
            //create a new stack
            int[] ns = new int[MAX];
            store.add(ns);
            top = -1;
        }
        
        store.get(store.size()-1)[++top] = data;
    }
    
    public int pop() throws Exception {
        if(store.size() == 0){
            throw new Exception("stack underflow");
        }
        
        int value = store.get(store.size()-1)[top--];
        if(top == -1){  //if last element 
            //delete the stack and reset the top pointer
            store.remove(store.size()-1);
            if(store.size() >= 1){
                top = (MAX -1);
            }
        }
        
        return value;
    }
    
    public int size(){
        if(store.size() == 0){
            return 0;
        }
        return ((store.size() -1) * MAX) + (top + 1);
    }
    
    private boolean isFull(){
        return (top+1) == MAX;        
    }
    
    
    private boolean isEmpty(){
        return top == -1;
    }
    
}
