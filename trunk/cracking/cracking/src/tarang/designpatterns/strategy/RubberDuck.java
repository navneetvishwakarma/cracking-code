package tarang.designpatterns.strategy;


/**
 * Put class JavaDoc here
 *
 * @author tdesai
 */
public class RubberDuck extends Duck {

    public RubberDuck() {
        this.flyer = new FlyNoWay();
        this.quacker = new QuackNoWay();
    }
}
