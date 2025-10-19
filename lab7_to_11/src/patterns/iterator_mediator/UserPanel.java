package patterns.iterator_mediator;

import model.AutoPart;

public class UserPanel extends Component {
    private AutoPart selected;
    public UserPanel(Mediator m){ super(m); }
    public void selectPart(AutoPart p){ selected = p; mediator.notify(this, "addToCart"); }
    public AutoPart getSelectedPart(){ return selected; }
}