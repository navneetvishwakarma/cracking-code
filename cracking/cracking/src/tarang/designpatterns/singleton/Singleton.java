package tarang.designpatterns.singleton;


/**
 * The perfect implementation of Singleton
 *
 * @author tdesai
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if(singleton == null) {
            synchronized (Singleton.class) {
                if(singleton == null) {
                    return new Singleton();
                }
            }
        }
        return singleton;
    }
}
