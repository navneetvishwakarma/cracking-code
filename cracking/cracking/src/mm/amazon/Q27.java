package mm.amazon;


/**
 * Implement the math power function while minimizing the number of multiplications
 */
public class Q27 {
    
    //the essence is to have a loop that keeps halving the exp and squaring the base. and if for a given iteration
    //the exp is an odd number the variable 'remainder' is updated
    public static long power(int base, int exp){
        long remainder = 1;
        
        while (exp > 1){
            if(exp % 2 ==  1){
                remainder = remainder * base;
                exp--;
            }
            exp = exp / 2;
            base *= base;
        }
        return base * remainder;
    }

    public static void main(String[] args) {
        System.out.println(power(2,11));
    }
}
