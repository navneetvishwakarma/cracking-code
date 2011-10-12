package tarang.chap3;

import tarang.datastructures.Stacks;


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


