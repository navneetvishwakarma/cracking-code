package mm.amazon;


/**
 * Find the min element in a rotated sorted array
 */
public class Q35 {
    
    public int minElement(int[] a, int lower, int upper) throws Exception {
        if(lower > upper){
            throw new Exception("lower > upper, something went horribly wrong");
        }
        
        if(upper - lower == 1){
            return Math.min(a[lower],a[upper]);
        }
        
        int middle = (lower + upper) / 2;
        int middleEl = a[middle];
        
        int minLeftEl = Math.min(a[lower],a[middle-1]);
        int minRightEl = Math.min(a[middle+1],a[upper]);
        
        if(middleEl < minLeftEl && middleEl < minRightEl){
            return middleEl;
        }
        
        boolean leftHalfHasMin = minLeftEl < minRightEl;
        if(leftHalfHasMin){
            return minElement(a,lower,middle-1);
        }else{
            return minElement(a,middle+1,upper);
        }
    }

    public static void main(String[] args) throws Exception {
        //int[] a = {3,7,8,9,11,12,14,15,16,18}
        Q35 obj = new Q35();
        int[] a = {8,9,11,12,14,15,16,18,3,7};
        System.out.println(obj.minElement(a,0,a.length-1));
        
        a = new int[]{16,18,3,7,8,9,11,12,14,15};
        System.out.println(obj.minElement(a,0,a.length-1));
        
        a = new int[]{12,14,15,16,18,3,7,8,9,11};
        System.out.println(obj.minElement(a,0,a.length-1));

        a = new int[]{14,15,16,18,3,7,8,9,11,12};
        System.out.println(obj.minElement(a,0,a.length-1));
        
        a = new int[]{7,8,9,11,12,14,15,16,18,3};
        System.out.println(obj.minElement(a,0,a.length-1));
    }
}
