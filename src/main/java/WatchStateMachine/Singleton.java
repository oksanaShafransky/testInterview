package WatchStateMachine;

public class Singleton<T> {
    private static final Singleton<?> instance = new Singleton<Object>();
    T variable;

    private Singleton() {

    }

    public static Singleton<?> getInstance() {
        return instance;
    }
}
