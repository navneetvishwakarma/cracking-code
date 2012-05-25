package tarang.careercup.amazon;


/**
 * Write an algorithm to find F(n) the number of bits set to 1, in all numbers from 1 to n for any given value of n.

 For example:

 1: 001
 2: 010
 3: 011
 4: 100
 5: 101
 6: 110
 So

 F(1) = 1,
 F(2) = F(1) + 1 = 2,
 F(3) = F(2) + 2 = 4,
 F(4) = F(3) + 1 = 5,
 etc.
 *
 * @author tdesai
 */
public class Question14 {

    public int find1Count(int input) {
        input += 1;
        int count = 0;
        int k = (int) Math.log(input) + 1;
        int bitlevel = 1;
        for(int i = 0; i <= k; i++) {
            bitlevel <<= 1;  // 2, 4, 8, 16, 32...
            int quotient = input / bitlevel;
            count += quotient * bitlevel/2;
            int mod = input % bitlevel - bitlevel/2;
            if(mod > 0) {
                count += mod;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.print(new Question14().find1Count(12));
    }
}
