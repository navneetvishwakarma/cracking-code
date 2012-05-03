package tarang.designpatterns.factorymethod;


/**
 * Put class JavaDoc here
 *
 * @author tdesai
 */
public abstract class PizzaStore {

    abstract Pizza createPizza(String type);

    Pizza orderPizza(String type) {

        Pizza pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();

        return pizza;
    }
}
