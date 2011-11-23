package mm.amazon;


/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Q08 {

    public static void main(String[] args) {
        Q08 q08 = new Q08();
        
        int[] nums = {532, 5004, 1000};
        for(int num : nums){
            System.out.print(num + "\t");
            q08.printDigits(num);
            System.out.println("");
        }

    }
    
    
    public void printDigits(int num){
        if(num <= 0){
            return;
        }
        
        int digit = num  % 10;
        num = num / 10;
        printDigits(num);
        System.out.print(digit + " ");
    }
    
}
