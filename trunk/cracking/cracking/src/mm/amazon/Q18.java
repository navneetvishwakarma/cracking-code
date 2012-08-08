package mm.amazon;


/**
 * Given an unsorted Array find maximum value of A[j] - A[i] where j>i..in O(n) time
 * OR
 * Given an array of stock prices for each day's closing price find the highest Profit possible in O(n)
 */
public class Q18 {
    public static void highestProfit(int[] prices){
        int min = prices[0];
        int diff = 0;
        int num1=-1;
        int num2=-1;

        for(int i=1; i<prices.length;i++){
            if(prices[i] < min){  //if the number is min, no point in comparing it with anything on the left. 
                min = prices[i];  //assign to min and continue
            }else if ( (prices[i] - min) > diff){
                diff = (prices[i] - min); //if the diff of this num and the min is greater than existing diff
                num1 = min;             //we have found a new max and greater a diff
                num2 = prices[i];
            }
        }
        System.out.println(num2 + "-" + num1 + "=" + diff);
    }

    //same as above but no if-else
    public static void findMaxDiff2(int[] data){
        int min = data[0];
        int diff = 0;

        for(int i=1; i<data.length;i++){
            min = Math.min(data[i],min);
            diff = Math.max(data[i]-min,diff);
        }
        System.out.println(diff);
    }

    public static void main(String[] args){
        Q18.highestProfit(new int[]{8, 7, 18, 2, 3, 1, 0, 4, 5});
        Q18.highestProfit(new int[]{8, 7, 6, 2, 1, 3, 8, 2, 5});
        Q18.highestProfit(new int[]{22, 8, 16, 4, 2, 7, 18, 6, 1});
    }
}
