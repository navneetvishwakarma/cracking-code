package tarang.designpatterns.observer;


/**
 * Subject class
 *
 * @author tdesai
 */
public interface Subject {

    void registerObserver(Observer o);
    boolean removeObserver(Observer o);
    void notifyObservers();

}
