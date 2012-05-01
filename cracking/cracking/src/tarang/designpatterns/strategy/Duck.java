package tarang.designpatterns.strategy;


/**
 * Put class JavaDoc here
 *
 * @author tdesai
 */
public abstract class Duck {

    FlyingBehavior flyer;
    QuackBehavior quacker;

    void performFly() {
        flyer.fly();
    }

    void performQuack() {
        quacker.quack();
    }

    public FlyingBehavior getFlyer() {
        return flyer;
    }

    public void setFlyer(FlyingBehavior flyer) {
        this.flyer = flyer;
    }

    public QuackBehavior getQuacker() {
        return quacker;
    }

    public void setQuacker(QuackBehavior quacker) {
        this.quacker = quacker;
    }
}
