package tarang.topcoder;


/**
 * Put class JavaDoc here
 *
 * @author tdesai
 */
public class SquareDigits {

    public static int smallestResult(int x) {
        int res1 = x;
        int res2 = Sx(res1);
        while(res2 != x) {
            res1 = res2;
            res2 = Sx(res1);
        }
        return res1;
    }

    private static int Sx(int x) {
        int total = 0;
        while(x > 0) {
            int temp = x % 10;
            total += temp*temp;
            x -= temp;
            x /= 10;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(smallestResult(37));
    }
}

