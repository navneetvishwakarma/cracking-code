package mm.amazon;


import java.util.ArrayList;

/**
 * See Q34
 */
public class Q34a {
    
    public ArrayList<ArrayList<Integer>> enumerate(int base, int digits){
        if(digits == 1){
            ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<ArrayList<Integer>>();
            for(int i=0; i<base; i++){
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                arrayList.add(i);
                listOfLists.add(arrayList);
            }
            return listOfLists;
        }

        ArrayList<ArrayList<Integer>> subsets = enumerate(base, --digits);
        ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < base; i++) {
            for (ArrayList<Integer> subset : subsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>(subset);
                newsubset.add(i);
                allsubsets.add(newsubset);
            }
        }
        return allsubsets;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> listofLists = new Q34a().enumerate(2, 3);
        for(ArrayList<Integer> list : listofLists){
            System.out.println(list);
        }

/*
        System.out.println("\n");
        new Q34a().enumerate(10, 2);

        System.out.println("\n");
        new Q34a().enumerate(2, 3);
*/
    }

}
