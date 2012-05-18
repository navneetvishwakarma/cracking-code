package mm.amazon;


import java.util.*;

/**
 * You have an infinite set of coordinates, find out the 10 points closest to the origin
 */
public class Q11 {
    
    final int CLOSEST_NUM = 10;
    
    public PriorityQueue<Integer> closestToN(ArrayList<Integer> data, int n){
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(data.size(),new DistanceComparatorDesc(n));
        
        for(int i : data){
            if(queue.size() < CLOSEST_NUM){
                queue.add(i);
            }else{
                int distHead = Math.abs(n-queue.peek());
                int distI = Math.abs(n-i);
                if (distHead > distI){
                    queue.poll();
                    queue.add(i);
                }
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        Set<Integer> set = randomDataSet();

        ArrayList<Integer> randomData = new ArrayList<Integer>(set);
        PriorityQueue<Integer> closestPoints = new Q11().closestToN(randomData, 25);
        System.out.println(closestPoints);
    }

    //random ints 0 to 49
    private static Set<Integer> randomDataSet() {
        Set<Integer> set = new HashSet<Integer>();
        Random randomGen = new Random(System.currentTimeMillis());

        while(set.size() < 50){
            set.add(randomGen.nextInt(50));
        }
        return set;
    }

}

class DistanceComparatorDesc implements Comparator<Integer>{
    int base;
    DistanceComparatorDesc(int base) {
        this.base = base;
    }

    public int compare(Integer i1, Integer i2) {
        int dist1 = Math.abs(base-i1);
        int dist2 = Math.abs(base-i2);
        
        if(dist1 > dist2) return -1;
        else if (dist2 > dist1) return 1;
        else return 0;
    }
}

