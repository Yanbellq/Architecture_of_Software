import model.*;
import patterns.chain_command.*;
import patterns.iterator_mediator.*;
import patterns.state_strategy.*;
import patterns.memento_observer.*;
import patterns.template_visitor.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== ЛР7: Chain of Responsibility + Command ===");
        Order order = new Order("ORD001", 3200);
        OrderHandler manager = new ManagerHandler();
        OrderHandler accountant = new AccountantHandler();
        OrderHandler director = new DirectorHandler();
        manager.setNext(accountant);
        accountant.setNext(director);
        manager.handleOrder(order);

        CreateOrderCommand createCmd = new CreateOrderCommand(order);
        new OrderInvoker().executeCommand(createCmd);

        System.out.println("\n=== ЛР8: Iterator + Mediator ===");
        // Iterator
        AutoPart[] parts = {
                new AutoPart("Гальмівні колодки", 850),
                new AutoPart("Масляний фільтр", 320),
                new AutoPart("Амортизатор", 1200)
        };
        PartIterator iterator = new PartIterator(parts);
        System.out.println("Список запчастин:");
        while (iterator.hasNext()) {
            System.out.println(" - " + iterator.next());
        }

        // Mediator
        ShopMediator mediator = new ShopMediator();
        UserPanel userPanel = new UserPanel(mediator);
        CartPanel cartPanel = new CartPanel(mediator);
        mediator.setComponents(userPanel, cartPanel);
        userPanel.selectPart(new AutoPart("Свічка запалювання", 120));

        System.out.println("\n=== ЛР9: Observer + Memento ===");
        Cart cart = new Cart();
        cart.add(new AutoPart("Поршень", 450.5));
        cart.add(new AutoPart("Свічка запалювання", 120));
        CartMemento saved = cart.save();
        cart.add(new AutoPart("Фільтр", 200));
        cart.restore(saved);
        System.out.println("Відновлено початковий стан кошика.");

        OrderStatus status = new OrderStatus();
        status.addObserver(new Customer("Андрій"));
        status.addObserver(new Customer("Олена"));
        status.notifyAll("Замовлення відправлено!");

        System.out.println("\n=== ЛР10: State + Strategy ===");
        order.nextState();
        order.nextState();
        order.nextState();
        DeliveryStrategy courier = new CourierDelivery();
        courier.deliver();
        DeliveryStrategy pickup = new PickupDelivery();
        pickup.deliver();

        System.out.println("\n=== ЛР11: Template + Visitor ===");
        new OnlineOrder().processOrder();
        PriceVisitor visitor = new PriceVisitor();
        new EnginePart().accept(visitor);
        new WheelPart().accept(visitor);
    }
}
