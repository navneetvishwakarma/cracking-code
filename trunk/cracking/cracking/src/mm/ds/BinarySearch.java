

package mm.ds;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class BinarySearch {
    private int[] store;

    public BinarySearch(int[] store) {
        this.store = store;
    }

    public int doBinarySearch(int itemToFind){
        return recursiveBinarySearch(0,store.length-1,itemToFind);
    }
    
    private int recursiveBinarySearch(int start, int end, int itemToFind){
        if(start > end){
            System.out.println("nope, didnt find " + itemToFind + " for " + start + " and " + end);
            return -1;
        }
        
        int middle = (start + end) / 2;
        //System.out.println("store[middle]=" + store[middle]);

        int itemAtMiddle = store[middle];
        if(itemAtMiddle == itemToFind){
            System.out.println("found " + itemToFind + " at index " + middle);
            return middle;
        }
        else if(itemToFind <= itemAtMiddle){
            return recursiveBinarySearch(start, middle-1,itemToFind);
        }else   {   
            return recursiveBinarySearch(middle+1, end, itemToFind);
        }
    }


    public static void main(String[] args) {
        int[] items = {32, 56, 79, 101, 123, 450, 789, 800};
        BinarySearch bs = new BinarySearch(items);
        bs.doBinarySearch(800);
        bs.doBinarySearch(32);
        bs.doBinarySearch(71);
        bs.doBinarySearch(789);
    }
}
