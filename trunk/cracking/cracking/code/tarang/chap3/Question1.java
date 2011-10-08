package cracking.code.tarang.chap3;

import cracking.code.tarang.chap2.LinkedList;


/**
 * Describe how you could use a single array to implement three stacks
 *
 * @author tdesai
 */
public class Question1 {

    public static void main(String[] args) {
        Stacks stacks = new Stacks(3);
        stacks.push(4, 1);
        stacks.push(5, 1);
        stacks.push(6, 1);
        stacks.push(8, 1);
        System.out.println(stacks);

        stacks.push(29, 2);
        stacks.push(32, 2);
        System.out.println();
        System.out.println(stacks);

        stacks.pop(1);
        stacks.pop(1);
        stacks.pop(1);
        System.out.println();
        System.out.println(stacks);

        stacks.push(42, 3);
        stacks.push(91, 3);
        stacks.push(12, 3);
        System.out.println();
        System.out.println(stacks);

        stacks.pop(2);
        stacks.pop(2);
        System.out.println();
        System.out.println(stacks);

        stacks.push(31, 3);
        stacks.push(912, 3);
        stacks.push(19, 3);
        stacks.push(32, 3);
        stacks.push(57, 3);
        stacks.push(56, 3);
        stacks.push(81, 3);
        stacks.push(22, 3);
        stacks.push(111, 3);
        System.out.println();
        System.out.println(stacks);

        stacks.pop(3);
        stacks.pop(1);
        System.out.println();
        System.out.println(stacks);

    }
}


class Stacks {
    private StackNode[] arr;
    private LinkedList freelist;
    private int[] tops;

    public Stacks(int numOfStacks) {
        tops = new int[numOfStacks];
        for(int i = 0; i < tops.length; i++) {
            tops[i] = -1;
        }
        arr = new StackNode[numOfStacks * 5];
        // create the freelist
        freelist = new LinkedList();
        for(int i = numOfStacks * 5 - 1; i >= 0; i--) {
            freelist.add(i);
        }
    }

    public void push(int value, int stacknumber) {
        stacknumber -= 1;
        StackNode node = new StackNode(value);
        if(tops[stacknumber] != -1) {
            // had a top so set next to the current top
            node.setNext(tops[stacknumber]);
        }
        // make the new node a new top
        int index = freelist.remove();
        arr[index] = node;
        tops[stacknumber] = index;
    }

    public int pop(int stacknumber) {
        stacknumber -= 1;
        int index = tops[stacknumber];
        if(index == -1) {
            throw new IllegalArgumentException("Nothing left to pop");
        }
        StackNode node = arr[index];
        freelist.add(index);
        tops[stacknumber] = node.getNext();
        return node.getValue();

    }

    @Override
    public String toString() {
        String str = "";
        if(arr != null && arr.length > 0) {
            int stacknumber = 1;
            for (int topIndex : tops) {
                if(topIndex < 0) {
                    str += "stack " + stacknumber + " empty\n";
                } else {
                    int index = topIndex;
                    str += "stack " + stacknumber + ": ";
                    while(index >= 0) {
                        str += arr[index].getValue() + " ";
                        index = arr[index].getNext();
                    }
                    str += "\n";
                }
                stacknumber++;
            }
            for(StackNode node : arr) {
                str += node + " ";
            }
            str += "\n";
        }
        return str;
    }
}

class StackNode {
    private int value;
    private int next = -1;

    StackNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value + ":" + next;
    }
}