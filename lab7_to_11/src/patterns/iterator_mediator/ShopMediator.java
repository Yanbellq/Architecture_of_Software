package patterns.iterator_mediator;

public class ShopMediator implements Mediator {
    private UserPanel userPanel;
    private CartPanel cartPanel;
    public void setComponents(UserPanel u, CartPanel c) { userPanel = u; cartPanel = c; }
    public void notify(Component sender, String event) {
        if (event.equals("addToCart")) cartPanel.addItem(((UserPanel)sender).getSelectedPart());
    }
}