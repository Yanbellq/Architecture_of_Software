package patterns.iterator_mediator;

import model.AutoPart;

public class CartPanel extends Component {
    public CartPanel(Mediator m){ super(m); }
    public void addItem(AutoPart part){ System.out.println("Додано в кошик: " + part.getName()); }
}