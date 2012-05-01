package tarang.designpatterns.strategy;


/**
 * Put class JavaDoc here
 *
 * @author tdesai
 */
public class Quack implements QuackBehavior {

    public void quack() {
        System.out.print("Quack quack...");
    }
}
