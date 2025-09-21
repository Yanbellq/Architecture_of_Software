package main.java.com.autoparts.creational.abstractfactory;

/**
 * Конкретна фабрика для комплектів Toyota
 */
public class ToyotaPartsKitFactory implements AutoPartsKitFactory {

    @Override
    public EngineComponent createEngineComponent() {
        System.out.println("Створення компонента двигуна Toyota");
        return new ToyotaEngineComponent();
    }

    @Override
    public BrakeComponent createBrakeComponent() {
        System.out.println("Створення гальмівного компонента Toyota");
        return new ToyotaBrakeComponent();
    }

    @Override
    public SuspensionComponent createSuspensionComponent() {
        System.out.println("Створення компонента підвіски Toyota");
        return new ToyotaSuspensionComponent();
    }

    /**
     * Конкретний компонент двигуна Toyota
     */
    private static class ToyotaEngineComponent extends EngineComponent {
        public ToyotaEngineComponent() {
            super("Поршень Toyota", "2.0L DOHC VVT-i");
        }

        @Override
        public void install() {
            System.out.println("Встановлення поршня Toyota з VVT-i технологією");
        }

        @Override
        public void performTest() {
            System.out.println("Тестування компонента двигуна Toyota - OK");
        }
    }

    /**
     * Конкретний гальмівний компонент Toyota
     */
    private static class ToyotaBrakeComponent extends BrakeComponent {
        public ToyotaBrakeComponent() {
            super("Гальмівні колодки Toyota", "Ceramic Premium");
        }

        @Override
        public void install() {
            System.out.println("Встановлення керамічних гальмівних колодок Toyota");
        }

        @Override
        public void performTest() {
            System.out.println("Тестування гальмівного компонента Toyota - OK");
        }
    }

    /**
     * Конкретний компонент підвіски Toyota
     */
    private static class ToyotaSuspensionComponent extends SuspensionComponent {
        public ToyotaSuspensionComponent() {
            super("Амортизатор Toyota", "Gas-filled KYB");
        }

        @Override
        public void install() {
            System.out.println("Встановлення газового амортизатора Toyota KYB");
        }

        @Override
        public void performTest() {
            System.out.println("Тестування компонента підвіски Toyota - OK");
        }
    }
}
