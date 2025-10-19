package patterns.memento_observer;

import model.AutoPart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<AutoPart> items = new ArrayList<>();
    public void add(AutoPart p){ items.add(p); }
    public CartMemento save(){ return new CartMemento(items); }
    public void restore(CartMemento m){ items = m.getState(); }
}