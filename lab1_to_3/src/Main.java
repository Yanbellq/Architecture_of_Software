import classes.*;

//TIP Чтобы <b>запустить</b> код, нажмите <shortcut actionId="Run"/> или
// нажмите на значок <icon src="AllIcons.Actions.Execute"/> на полях.
public class Main {
    public static void main(String[] args) {
        Store store = Store.getInstance();
        store.info();

        // Prototype
        Part original = new Part("Battery", 150);
        Part copy = original.clone();
        original.info();
        copy.info();

        // Factory Method
        PartFactory brakeFactory = new BrakeFactory();
        Part brake = brakeFactory.createPart();
        brake.info();

        // Abstract Factory
        AbstractCarFactory bmwFactory = new BMWFactory();
        Part bmwEngine = bmwFactory.createEngine();
        bmwEngine.info();

        // Builder
        Order order = new OrderBuilder()
                .setCustomer("Іван")
                .addPart(bmwEngine)
                .addPart(brake)
                .build();
        order.showOrder();

        // Object Pool
        PartPool pool = new PartPool();
        Part pooledPart = pool.acquire();
        pooledPart.info();
        pool.release(pooledPart);
    }
}