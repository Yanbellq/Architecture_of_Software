package main.java.com.autoparts.creational.abstractfactory;

/**
 * Абстрактний компонент двигуна
 */
public abstract class EngineComponent {
    protected String componentName;
    protected String specification;

    public EngineComponent(String componentName, String specification) {
        this.componentName = componentName;
        this.specification = specification;
    }

    public abstract void install();
    public abstract void performTest();

    public void displayInfo() {
        System.out.println("Компонент двигуна: " + componentName + " - " + specification);
    }
}
