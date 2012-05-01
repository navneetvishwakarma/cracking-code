package tarang.designpatterns.strategy;


/**
 * Put class JavaDoc here
 *
 * @author tdesai
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        this.flyer = new FlyWithWings();
        this.quacker = new Quack();
    }
}
