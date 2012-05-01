package tarang.designpatterns.observer;


import java.util.ArrayList;
import java.util.List;

/**
 * Put class JavaDoc here
 *
 * @author tdesai
 */
public class WeatherData implements Subject{

    private List<Observer> observers = new ArrayList<Observer>();

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public boolean removeObserver(Observer o) {
        return observers.remove(o);
    }

    public void notifyObservers() {
        for(Observer o : observers) {
            o.update("");
        }
    }

    public void measurementChanges(String changes) {
        notifyObservers();
    }
}
