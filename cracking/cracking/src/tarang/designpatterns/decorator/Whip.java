package tarang.designpatterns.decorator;


/**
 * Condiment Whip
 *
 * @author tdesai
 */
public class Whip extends CondimentDecorator {

    public Whip(Bevarage bevarage) {
        this.bevarage = bevarage;
    }

    @Override
    double cost() {
        return this.bevarage.cost() + 0.10;
    }

    @Override
    String getDescription() {
        return super.getDescription() + ", Whip";
    }
}
