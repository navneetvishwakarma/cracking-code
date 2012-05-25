package mm.amazon;


/**
 * Implement the math power function while minimizing the number of multiplications
 */
public class Q27 {
    
    //the essence is to have a loop that keeps halving the exp and squaring the base. and if for a given iteration
    //the exp is an odd number, remainingMult var is updated
    public static long power(int base, int exp){
        long remainingMult = 1;
        long result = base;
        
        while (exp > 1){
            int remainder = exp % 2;
            if(remainder > 0){
                remainingMult = remainingMult * result;
            }
            exp = (exp - remainder) / 2;
            result *= result;
        }
        return result * remainingMult;
    }

    public static void main(String[] args) {
        System.out.println(power(2,10));
    }
}
