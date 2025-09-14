package classes;

public abstract class PartFactory {
    public abstract Part createPart();
}

class EngineFactory extends PartFactory {
    public Part createPart() {
        return new Part("Двигун", 5000.0);
    }
}
