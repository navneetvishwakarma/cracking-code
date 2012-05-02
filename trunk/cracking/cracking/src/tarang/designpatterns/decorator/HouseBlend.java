package tarang.designpatterns.decorator;


/**
 * Base component. Regular coffee
 *
 * @author tdesai
 */
public class HouseBlend extends Bevarage {
    @Override
    double cost() {
        return 0.99;
    }

    @Override
    String getDescription() {
        return "HouseBlend";
    }
}
