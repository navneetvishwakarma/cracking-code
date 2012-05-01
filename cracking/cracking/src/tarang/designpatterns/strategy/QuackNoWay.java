package tarang.designpatterns.strategy;


/**
 * Put class JavaDoc here
 *
 * @author tdesai
 */
public class QuackNoWay implements QuackBehavior {

    public void quack() {
        System.out.print("Not gonna quack");
    }
}
