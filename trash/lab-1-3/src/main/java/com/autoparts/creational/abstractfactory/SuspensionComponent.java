package main.java.com.autoparts.creational.abstractfactory;

/**
 * Абстрактний компонент підвіски
 */
public abstract class SuspensionComponent {
    protected String componentName;
    protected String specification;

    public SuspensionComponent(String componentName, String specification) {
        this.componentName = componentName;
        this.specification = specification;
    }

    public abstract void install();
    public abstract void performTest();

    public void displayInfo() {
        System.out.println("Компонент підвіски: " + componentName + " - " + specification);
    }
}
