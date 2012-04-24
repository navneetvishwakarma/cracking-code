package mm.chap1;


import junit.framework.TestCase;

/**
 * Put class JavaDoc here
 *
 * @author mmathuria
 */
public class Question1dot4Test extends TestCase {
    
    public void testAreAnagrams1(){
        String[] input1 =  {"hello","mihir","hello","hello","",null};
        String[] input2 =  {"ohlel","hiimr","hell", "oohel","",null};
        boolean[] output = {true,true,false,false,true,false};
        
        Question1dot4 obj = new Question1dot4();
        for(int i=0;i<input1.length;i++){
            boolean actual = obj.araAnagrams1(input1[i],input2[i]);
            assertEquals(output[i],actual);
        }
    }
    
    public void testAreAnagrams2(){
        String[] input1 =  {"hello","mihir","hello","hello","",null};
        String[] input2 =  {"ohlel","hiimr","hell", "oohel","",null};
        boolean[] output = {true,true,false,false,true,false};
        
        Question1dot4 obj = new Question1dot4();
        for(int i=0;i<input1.length;i++){
            boolean actual = obj.areAnagrams2(input1[i],input2[i]);
            assertEquals(output[i],actual);
        }
    }
    
}
