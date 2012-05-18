package mm.amazon;


/**
 * If there is a n-digit, print the digits one by one without using temporary storage and how will you do it efficiently? 
 * Example: if the number is 1054 print: 1 0 5 4
 *
 * @author mmathuria
 */
public class Q08 {

    public static void main(String[] args) {
        Q08 q08 = new Q08();
        
        int[] nums = {5, 5004, -1000};
        for(int num : nums){
            System.out.print(num + "\t");
            q08.printDigitsNoRecursion(num);
            q08.printDigits(num);
            System.out.println("");
        }

    }
    
    
    public void printDigits(int num){
        if(num < 0){
            System.out.print("-");
            num *= -1;
        }
        _printDigits(num);
        
    }
    public void _printDigits(int num){
        if(num <= 0){
            return;
        }
        
        int digit = num  % 10;
        num = num / 10;
        printDigits(num);
        System.out.print(digit + " ");
    }

    //for a given num (say 1024) find x such that it a multiple of 10 and of the same length as num (here, x=1000)
    //from then on, we divide num by x; print the quotient, reduce num and x by a factor of 10 and repeat.
    //note: special case reqd for trailing zeros (if num == 0)
    public void printDigitsNoRecursion(int num){
        if(num < 0){
            num *= -1;
            System.out.print("-");
        }
        
        int x = 1;
        while(x <= num){
            x *= 10;
        }
        x /= 10;
        
        while(x >= 10){
            if(num == 0){
                System.out.print("0");
            }else{
                int q = num / x;
                System.out.print(q);
                num = num - (q*x);
            }
            x /= 10;
        }
        System.out.print(num);
    }
}
