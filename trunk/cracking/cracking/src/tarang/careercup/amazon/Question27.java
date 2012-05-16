package tarang.careercup.amazon;


/**
 * Implement the math power function while minimizing the number of multiplications
 *
 * @author tdesai
 */
public class Question27 {

    public static double pow(double base, int exp) {
        int count = 0;
        double result = 1;
        boolean neg = false;
        if(exp < 0) {
            exp *= -1;
            neg = true;
        }
        while(exp > 0) {
            if((exp & 1) > 0) {
                count++;
                result = result * base;

            }
            exp >>= 1;
            count++;
            base = base * base;
        }
        System.out.println(count + " multiplications");
        if(neg) {
            return 1 / result;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(pow(2, 10));
    }
}
