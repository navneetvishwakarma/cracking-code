package tarang.designpatterns.strategy;


/**
 * Put class JavaDoc here
 *
 * @author tdesai
 */
public class FlyNoWay implements FlyingBehavior {
    public void fly() {
        System.out.print("No way I am gonna fly, got no wings!");
    }
}
