package patterns.memento_observer;

import java.util.ArrayList;
import java.util.List;

public class OrderStatus {
    private List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer o){ observers.add(o); }
    public void notifyAll(String status){
        for (Observer o : observers) o.update(status);
    }
}