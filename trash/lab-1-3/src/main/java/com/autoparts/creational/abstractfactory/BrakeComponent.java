package main.java.com.autoparts.creational.abstractfactory;

/**
 * Абстрактний гальмівний компонент
 */
public abstract class BrakeComponent {
    protected String componentName;
    protected String specification;

    public BrakeComponent(String componentName, String specification) {
        this.componentName = componentName;
        this.specification = specification;
    }

    public abstract void install();
    public abstract void performTest();

    public void displayInfo() {
        System.out.println("Гальмівний компонент: " + componentName + " - " + specification);
    }
}
