package patterns.state_strategy;

public class PickupDelivery implements DeliveryStrategy {
    public void deliver(){ System.out.println("Самовивіз з магазину"); }
}