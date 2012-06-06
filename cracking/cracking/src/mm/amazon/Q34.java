package mm.amazon;


import java.util.Arrays;
import java.util.List;

/**
 There are two methods:
 void process(int[] A) and void enumerate(int base, int digits);
 call process with an array for given values of base and digit params:
 base = 2, digits = 3. Call process() for the following arrays:
 A = {0, 0, 0}
 A = {0, 0, 1}
 A = {0, 1, 0}
 A = {0, 1, 1}
 A = {1, 0, 0}
 A = {1, 0, 1}
 A = {1, 1, 0}
 A = {1, 1, 1}

 base = 10, digits = 2. Call process() for all possible numbers with length 2 in base 10. There will be 100 of them. 
 So implement enumerate to call process. Cannot change signatures but can create your own methods.
 */
public class Q34 {

    public void enumerate(int base, int digits) {
        int[] a = new int[digits];

        int count = 0;
        process(a);
        while (count < getMaxCount(base, digits)) {
            int i = digits - 1;
            while (i >= 0) {
                a[i] = next(base,a[i]);
                if (a[i] != getMin()) {
                    process(a);
                    count++;
                    break;
                }
                i--;
            }
        }
    }

    public void process(int[] a) {
        StringBuilder buf = new StringBuilder();
        for (int i : a) {
            buf.append(i);
        }
        System.out.print(buf + "  ");
    }

    //returns the next sequential number.
    //0 if i is max
    public int next(int base, int i) {
        int max = base - 1;
        if (i == max) return 0;
        else return ++i;
    }

    //gets the max possible number for given base-digit pair
    //999 for (10,3); 99 for (10,2) 
    public int getMaxCount(int base, int digits){
        int maxCount = 0;
        int maxNum = base - 1;
        while (digits >= 0){
            maxCount += maxNum * Math.pow(base,digits-1);
            digits--;
        }
        return maxCount;
    }

    public int getMin(){
        return 0;
    }
    public static void main(String[] args) {
        new Q34().enumerate(10, 1);

        System.out.println("\n");
        new Q34().enumerate(10, 2);

        System.out.println("\n");
        new Q34().enumerate(2, 3);
    }
}
