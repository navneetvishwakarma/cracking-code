package tarang.designpatterns.decorator;


/**
 * Abstract beverage class
 *
 * @author tdesai
 */
public abstract class Bevarage {

    abstract double cost();

    String getDescription() {
        return "just a beverage";
    }
}
