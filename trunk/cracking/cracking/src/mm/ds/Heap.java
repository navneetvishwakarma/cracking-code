package mm.ds;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Heap {
    private int[] store;
    private int ptr;        // ptr --> next avaialable open position
                            // (ptr-1) --> the last element    

    public Heap() {
        store = new int[20];
        ptr = 0;
    }

    //non-recursive
    public void insert2(int key){
        int currentIdx = ptr++;
        int parentIdx = (currentIdx - 1)/2;
        
        while(parentIdx >= 0 && key > store[parentIdx]){
            store[currentIdx] = store[parentIdx];
            currentIdx = parentIdx;
            parentIdx = (currentIdx == 0) ? -1 : (currentIdx - 1) / 2;
        }
        store[currentIdx] = key;
    }
    
    public void insert(int key){
        store[ptr] = key;
        trickleUp(ptr++);
    }
    
    private void trickleUp(int currentIdx){
        int parentIdx = (currentIdx - 1) / 2;
        if(parentIdx == currentIdx){
            return;
        }
        if(store[parentIdx] > store[currentIdx]){
            return;
        }
        swap(currentIdx,parentIdx);
        trickleUp(parentIdx);
    }
    
    public int remove(){
        int removedKey = store[0];
        int lastKey = store[ptr-1];
        store[--ptr] = 0;
        int finalIndex = trickleDown(lastKey,0);
        store[finalIndex] = lastKey;
        return removedKey;
    }
    
    
    private int trickleDown(int key, int currentIdx){
        int leftChildIdx = (2 * currentIdx) + 1;
        int rightChildIdx = (2 * currentIdx) + 2;
        
        int greaterChildIdx = store[leftChildIdx] > store[rightChildIdx] ? leftChildIdx : rightChildIdx;
        
        if(key >= store[greaterChildIdx]){
            return currentIdx;
        }
        
        store[currentIdx] = store[greaterChildIdx];
        return trickleDown(key,greaterChildIdx);
    }
    
    public int remove2(){
        //get the root
        int removedKey = store[0];
        
        //get the last key and delete it
        int newRoot = store[ptr-1];
        store[--ptr] = 0;
        
        
        int currentIdx = 0;
        
        while(true){
            int leftChildIdx = (2 * currentIdx) + 1;
            int rightChildIdx = (2 * currentIdx) + 2;

            int greaterChildIdx = (store[leftChildIdx] > store[rightChildIdx]) ? leftChildIdx : rightChildIdx;
            if(newRoot > store[greaterChildIdx]){
                break;
            }
            
            store[currentIdx] = store[greaterChildIdx];
            currentIdx = greaterChildIdx;
        }
        store[currentIdx] = newRoot;
        return removedKey;
    }


    private void swap(int src, int dest) {
        int tmp = store[src];
        store[src] = store[dest];
        store[dest] = tmp;
    }
    
    @Override
    public String toString(){
        StringBuffer buf = new StringBuffer();
        buf.append("[");
        for(int i=0;i<store.length;i++){
            buf.append(store[i]).append(",");
        }
        buf.append("]");
        return buf.toString();
    }
}
