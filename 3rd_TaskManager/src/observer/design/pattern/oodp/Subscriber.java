package observer.design.pattern.oodp;

import java.util.*;
import java.util.ArrayList;

public class Subscriber implements Subject {

    List<Observer> observerList = new ArrayList<>();

    private boolean register;

    public boolean isRegister() {
        return register;
    }

    public void renew() {
        register = true;
        alarm();
    }

    @Override
    public void subscribe(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unSubscribe(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void alarm() {
        observerList.forEach(Observer::Notify);
    }
}
