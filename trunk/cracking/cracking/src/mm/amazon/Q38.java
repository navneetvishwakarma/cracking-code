package mm.amazon;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. 
 * You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. Following is an example:
 * The array is [1 3 -1 -3 5 3 6 7], and w is 3.
 */
public class Q38 {
    
    public ArrayList<Integer> maxSlidingWindow(int[] a, int w){
        ArrayList<Integer> c = new ArrayList<Integer>();

        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        for(int i=0; i<w; i++){
            while (!q.isEmpty() && a[q.getLast()] < a[i]){
                q.removeLast();
            }
            q.addLast(i);
        }
        
        for(int i = w; i<a.length;i++){
            c.add(a[q.getFirst()]);
            
            if(q.getFirst() <= i-w){
                q.removeFirst();
            }

            while (!q.isEmpty() && a[q.getLast()] < a[i]){
                q.removeLast();
            }
            q.addLast(i);
        }
        c.add(a[q.getFirst()]);
        return c;
    }

    public static void main(String[] args) {
        Q38 obj = new Q38();
        
        System.out.println(obj.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7},3));
        System.out.println(obj.maxSlidingWindow(new int[] {8,3,4,5,-1,7,6,9,5},3));
    }
}
