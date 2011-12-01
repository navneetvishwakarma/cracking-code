package mm.amazon;


/**
 * Compose a sorted array from two already sorted arrays
 *
 * @author mmathuria
 */
public class Q10 {
    
    public int[] mergeSorted(int[] a, int[] b){
        if((a == null && b == null)){
            throw new IllegalArgumentException("both input arrays are null or empty");
        }
        
        if(a == null || a.length == 0) return b;
        if(b == null || b.length == 0) return a;
        
        int[] c = new int[a.length + b.length];
        int i,j,k;
        i = j = k =0;
        
        while(i < a.length && j < b.length){
            if(a[i] < b[j]){
                c[k++] = a[i++];
            }else{
                c[k++] = b[j++];
            }
        }
        
        while(i < a.length){
            c[k++] = a[i++];
        }
        
        while(j < b.length){
            c[k++] = b[j++];
        }
        
        return c;
    }
}
