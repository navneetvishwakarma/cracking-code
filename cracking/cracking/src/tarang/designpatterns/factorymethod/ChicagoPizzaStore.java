package tarang.designpatterns.factorymethod;


/**
 * Put class JavaDoc here
 *
 * @author tdesai
 */
public class ChicagoPizzaStore extends PizzaStore {

    @Override
    Pizza createPizza(String type) {
        if(type.equals("veggie")) {
            return new ChicagoVeggiePizza();
        } else {
            return new ChicagoCheesePizza();
        }
    }
}
