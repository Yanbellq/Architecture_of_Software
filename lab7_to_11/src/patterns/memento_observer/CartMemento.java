package patterns.memento_observer;

import model.AutoPart;

import java.util.ArrayList;
import java.util.List;

public class CartMemento {
    private List<AutoPart> items;
    public CartMemento(List<AutoPart> items){ this.items = new ArrayList<>(items); }
    public List<AutoPart> getState(){ return items; }
}