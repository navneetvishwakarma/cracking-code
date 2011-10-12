package tarang.chap3;

import tarang.datastructures.SetOfStacks;


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

