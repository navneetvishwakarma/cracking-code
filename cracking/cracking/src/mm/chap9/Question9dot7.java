package mm.chap9;

import java.util.ArrayList;


/**
 * A circus is designing a tower routine consisting of people standing atop one anoth- er’s shoulders For practical and 
 * aesthetic reasons, each person must be both shorter and lighter than the person below him or her Given the heights 
 * and weights of each person in the circus, write a method to compute the largest possible number of peo- ple in such a
 *  tower
 EXAMPLE: Input (ht, wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
 Output: The longest tower is length 6 and includes from top to bottom: (56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)
 *
 * @author mmathuria
 */
public class Question9dot7 {
    
    public ArrayList<HtWt> findMaxSequence(ArrayList<HtWt> originalSeq){
        ArrayList<HtWt> maxSequence = new ArrayList<HtWt>();
        int currentUnfitItem = 0;
        while(currentUnfitItem < originalSeq.size()){
            ArrayList<HtWt> subSeq = new ArrayList<HtWt>();
            int nextUnfitItem = fillSequence(currentUnfitItem,originalSeq,subSeq);
            
            if(maxSequence.size() < subSeq.size()){
                maxSequence = subSeq;
            }
            
            if(currentUnfitItem == nextUnfitItem){
                break;
            }else{
                currentUnfitItem = nextUnfitItem;
            }
        }
        return maxSequence;
    }
    
    
    private int fillSequence(int startFrom, ArrayList<HtWt> originalSeq, ArrayList<HtWt> filler){
        int firstUnfitItem = startFrom;
        boolean firstUnfitItemSet = false;
        
        if(startFrom < originalSeq.size()){
            for(int i=0; i<originalSeq.size(); i++){
                if(i==0 || originalSeq.get(i-1).isBefore(originalSeq.get(i))){
                    filler.add(originalSeq.get(i));
                }else if(!firstUnfitItemSet){
                    firstUnfitItem = i;
                    firstUnfitItemSet = true;
                }
            }
        }
        return firstUnfitItem;
    }
    
}


class HtWt {
    int ht;
    int wt;
    
    public HtWt(int ht, int wt){
        this.ht = ht;
        this.wt= wt;
    }
    
    public boolean isBefore(HtWt htwt){
       return (this.ht < htwt.ht && this.wt < htwt.wt); 
    }
            
}
