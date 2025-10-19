package patterns.state_strategy;

public class CourierDelivery implements DeliveryStrategy {
    public void deliver(){ System.out.println("Доставка кур'єром"); }
}