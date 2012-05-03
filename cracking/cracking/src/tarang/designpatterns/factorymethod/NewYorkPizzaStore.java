package tarang.designpatterns.factorymethod;


/**
 * Put class JavaDoc here
 *
 * @author tdesai
 */
public class NewYorkPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        if(type.equals("veggie")) {
            return new NewYorkVeggiePizza();
        } else {
            return new NewYorkCheesePizza();
        }
    }
}
