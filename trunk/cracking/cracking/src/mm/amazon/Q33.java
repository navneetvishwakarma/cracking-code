package mm.amazon;


import mm.ds.LinkedList;
import mm.ds.Node;

/**
 * Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
 */
public class Q33 {
    
    public LinkedList reverseForK(LinkedList list, int k){
        Node a = null;
        Node b = list.head;
        Node c = b.next;
        Node tmp = null;    //tmp points to the kth node in the current loop (if k=3, tmp=3,6,9 etc)
        int i = 0;
        boolean flag = true;
        
        while (b != null){
            //reverse
            b.next = a;
            a = b;
            b = c;
            if(c != null) c = c.next;
            i++;

            if(i == k){
                if(flag){   //first time we reverse k-nodes, update the head 
                    list.head = a;
                    flag = false;
                }
                i = 0;

                //last node of previous batch of k-nodes points to first node of current batch of k-nodes
                if(tmp != null) tmp.next = a;   
                
                //point tmp to last node in the reversed batch
                while(a.next != null) a= a.next;    
                tmp = a;
                
                a = null;
            }
        }
        if(flag){   //for lists with no.of nodes less than k
            list.head = a;
            flag = false;
        }
        if(tmp != null) tmp.next = a;
        return list;
    } 
    

    public static void main(String[] args) {
        Q33 obj = new Q33();
        LinkedList list = new LinkedList();

        list.append(1).append(2);
        System.out.println("\n" + list);
        obj.reverseForK(list,3);
        System.out.println(list);

        list = new LinkedList();
        list.append(1).append(2).append(3);
        System.out.println("\n" + list);
        obj.reverseForK(list,3);
        System.out.println(list);

        list = new LinkedList();
        list.append(1).append(2).append(3).append(4);
        System.out.println("\n" + list);
        obj.reverseForK(list,3);
        System.out.println(list);

        list = new LinkedList();
        list.append(1).append(2).append(3).append(4).append(5);
        System.out.println("\n" + list);
        obj.reverseForK(list,3);
        System.out.println(list);

        list = new LinkedList();
        list.append(1).append(2).append(3).append(4).append(5).append(6);
        System.out.println("\n" + list);
        obj.reverseForK(list,3);
        System.out.println(list);
    }
}
