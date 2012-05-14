package mm.chap8;


import java.util.ArrayList;

/**
 * Write a method that returns all subsets of a set
 *
 * @author mmathuria
 */
public class Question8dot3 {

    /**
     * Recursive approach. time:O(n) where n is the genereated subsets
     * 
     * Initial input: {1,2,3}
     * 1st recursion: hang on to "1". call generatSubsets on {2,3}
     * 2nd recursion: hang on to "2". call generatSubsets on {3}
     * 3rd recursion: hang on to "3". call generatSubsets on {}
     * Base case is empty set: return {{}}
     * 3rd return: recd {{}}; duplicate recd set and add the "3" to get {{},{3}}
     * 2nd return: recd {{},{3}}; duplicate recd set and add the "2" to get {{},{3},{2},{3,2}}
     * 1st return: recd {{},{3},{2},{3,2}}; duplicate recd set and add the "1" to get {{},{3},{2},{3,2},{1},{1,3},{1,2},{1,3,2}}
     * @param set
     * @return
     */
    public ArrayList<ArrayList<Integer>> generateSubsetsRecursive(ArrayList<Integer> set){
        if(set.isEmpty()){
            ArrayList<Integer> emptySet = new ArrayList<Integer>();
            ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(emptySet);
            return allSubsets;
        }
        
        Integer head = set.remove(0);
        ArrayList<ArrayList<Integer>> allSubsets = generateSubsetsRecursive(set);
        ArrayList<ArrayList<Integer>> allSubsets2 = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> eachSubset : allSubsets){
            ArrayList<Integer> newSubset = new ArrayList<Integer>(eachSubset);
            newSubset.add(head);
            allSubsets2.add(newSubset);
        }
        allSubsets.addAll(allSubsets2);
        return allSubsets;
    }

    /**
     * A binary counter is maintained to create the subsets
     * If there are 3 elements in the set, there will be pow(2,3) = 8 subsets. They correspond to 000-111
     * 1 means an element at the index is present. 0 means absent 
     * 000={}, 001={1}, 010={2}, 011={2,1}, 111={1,2,3}
     * @param set
     * @return
     */
    public ArrayList<ArrayList<Integer>> generateSubsetsIterative(ArrayList<Integer> set){
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i< Math.pow(2,set.size());i++){
            int bitCounter = i;
            ArrayList<Integer> subset = new ArrayList<Integer>();
            for(int j=0; j<set.size(); j++){
                int bit = (bitCounter & 1);
                if(bit == 1){
                    subset.add(set.get(j));
                }
                bitCounter = bitCounter >> 1;
            }
            allSubsets.add(subset);
        }
        return allSubsets;
    }
}
