package mm.chap2;

import mm.ds.LinkedList;
import mm.ds.Node;


/**
 * You have two numbers represented by a linked list, where each node contains a sin- gle digit	The digits are stored in
 * reverse order, such that the 1’s digit is at the head of the list	Write a function that adds the two numbers and 
 * returns the sum as a linked list
 *
 * @author mmathuria
 */
public class Question2dot4 {
    
    public LinkedList addNumbers(LinkedList list1, LinkedList list2){
        if(list1 == null && list2 == null){
            throw new IllegalArgumentException("both lists cannot be null");
        }
        
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        LinkedList resultList = new LinkedList();
        _addNumbers(list1.head, list2.head,0,resultList);
        return resultList;
    }
    
    
    private void _addNumbers(Node node1, Node node2, int carry, LinkedList resultList){
        if(node1 == null && node2==null){
            if(carry == 1){
                resultList.append(new Node(1));
            }
            return;
        }
        
        int sum = carry;
        
        if(node1 != null){
            sum += node1.iData;
        }
        
        if(node2 != null){
            sum += node2.iData;
        }
        
        carry = 0;
        if(sum >= 10){
            sum = sum % 10;
            carry = 1;
        }
        
        Node nextNode1 = (node1 == null) ? null : node1.next;
        Node nextNode2 = (node2 == null) ? null : node2.next;
        _addNumbers(nextNode1,nextNode2,carry,resultList);
        resultList.append(new Node(sum));
    }


    public static void main(String[] args) {
        Question2dot4 obj = new Question2dot4();
        
        LinkedList list1 = new LinkedList();    //9999
        list1.append(new Node(9)).append(new Node(9)).append(new Node(9)).append(new Node(9));
        
        LinkedList list2 = new LinkedList();    //  1
        list2.append(new Node(1));
        
        LinkedList outputList = obj.addNumbers(list1,list2);    //10000
        System.out.println(outputList.toString());
    }
}
