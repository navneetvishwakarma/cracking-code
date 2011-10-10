package cracking.code.tarang.chap3;

import java.util.HashMap;
import java.util.Map;


/**
 * Imagine a (literal) stack of plates	If the stack gets too high, it might topple	There- fore, in real life, we would
 * likely start a new stack when the previous stack exceeds some threshold	Implement a data structure SetOfStacks that
 * mimics this	SetOf- Stacks should be composed of several stacks, and should create a new stack once the previous one
 * exceeds capacity	SetOfStacks push() and SetOfStacks pop() should behave identically to a single stack (that is, pop()
 * should return the same values as it would if there were just a single stack)
 *
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack
 *
 * @author tdesai
 */
public class Question3 {

    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.push(29);
        setOfStacks.push(81);
        setOfStacks.push(8);
        setOfStacks.push(13);
        setOfStacks.push(1);

        System.out.println(setOfStacks);

        setOfStacks.push(4);
        setOfStacks.push(15);
        setOfStacks.push(19);

        System.out.println(setOfStacks);

        setOfStacks.popAt(1);
        setOfStacks.popAt(1);

        System.out.println(setOfStacks);

        setOfStacks.push(29);
        setOfStacks.push(31);

        System.out.println(setOfStacks);
    }
}

class SetOfStacks {

    private static final int MAX_ELEMENTS = 3;

    private SetOfStacksNode top;
    private Map<Integer, SetOfStacksNode> stacks;
    private int numOfStacks = 0;


    SetOfStacks() {
        top = new SetOfStacksNode();
        stacks = new HashMap<Integer, SetOfStacksNode>();
        stacks.put(numOfStacks, top);
    }

    public void push(int value) {
        Stack currStack = top.getStack();
        if(top.getStack().getSize() == MAX_ELEMENTS) {
            // new stack
            SetOfStacksNode node = new SetOfStacksNode();
            node.setPrev(top);
            stacks.put(++numOfStacks, node);
            top = node;
            currStack = node.getStack();
        }
        currStack.push(value);
    }

    public int pop() {
        Stack currStack = top.getStack();
        if(currStack.getSize() == 0) {
            throw new IllegalArgumentException("Stack is empty");
        }
        int pop_value = currStack.pop();
        if(currStack.getSize() == 0 && top.getPrev() != null) {
            // make the prev a top stack
            stacks.remove(numOfStacks--);
            top = top.getPrev();
        }
        return pop_value;
    }

    public int popAt(int index) {
        SetOfStacksNode node = stacks.get(index);
        if(node == null) {
            throw new IllegalArgumentException("No stack at index: " + index);
        }
        return node.getStack().pop();
    }

    @Override
    public String toString() {
        String str = "";
        for(int key : stacks.keySet()) {
            str += key + ": " + stacks.get(key).getStack() + "\n";
        }
        return str;
    }
}

class SetOfStacksNode {
    private Stack stack;
    private SetOfStacksNode prev;

    SetOfStacksNode() {
        stack = new Stack();
    }

    public Stack getStack() {
        return stack;
    }

    public void setStack(Stack stack) {
        this.stack = stack;
    }

    public SetOfStacksNode getPrev() {
        return prev;
    }

    public void setPrev(SetOfStacksNode prev) {
        this.prev = prev;
    }
}