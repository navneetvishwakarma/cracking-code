package tarang.datastructures;

import java.util.HashMap;
import java.util.Map;


/**
 * Set of stacks with a limit on the number of elements in each stack. Externally this is a single stack.
 *
 * @author tdesai
 */
public class SetOfStacks {

    private static final int MAX_ELEMENTS = 3;

    private SetOfStacksNode top;
    private Map<Integer, SetOfStacksNode> stacks;
    private int numOfStacks = 0;


    public SetOfStacks() {
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
            top = node;
            stacks.put(++numOfStacks, top); // new top for this stack number
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
