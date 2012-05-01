package tarang.designpatterns.strategy;


/**
 * Put class JavaDoc here
 *
 * @author tdesai
 */
public class FlyWithWings implements FlyingBehavior {
    public void fly() {
        System.out.print("flying with wings!");
    }
}
