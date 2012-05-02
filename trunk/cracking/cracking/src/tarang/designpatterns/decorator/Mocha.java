package tarang.designpatterns.decorator;


/**
 * Condiment Mocha
 *
 * @author tdesai
 */
public class Mocha extends CondimentDecorator {
    public Mocha(Bevarage bevarage) {
        this.bevarage = bevarage;
    }

    @Override
    double cost() {
        return this.bevarage.cost() + 0.25;
    }

    @Override
    String getDescription() {
        return super.getDescription() + ", Mocha";
    }
}
