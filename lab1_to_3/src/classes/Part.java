package classes;

/**
 * Part - прототип
 */
public abstract class Part implements Cloneable {
    protected String id;
    protected String name;
    protected String brand;
    protected double price;
    protected String category;

    public Part(String id, String name, String brand, double price, String category) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.category = category;
    }

    public String getInfo() {
        return String.format("Part[id=%s,name=%s,brand=%s,price=%.2f,category=%s]",
                id, name, brand, price, category);
    }

    @Override
    public Part clone() {
        try {
            Part cloned = (Part) super.clone(); // shallow copy is OK for primitives/immutable
            System.out.println("[Prototype] Клоновано: " + cloned.getInfo());
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}

/** Конкретні частини */
public class EnginePart extends Part {
    private String engineModel;

    public EnginePart(String id, String name, String brand, double price, String engineModel) {
        super(id, name, brand, price, "Engine");
        this.engineModel = engineModel;
    }
}

/* Аналогічно можна створити BodyPart, ElectricalPart */
