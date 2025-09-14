package classes;

public class BrakeFactory extends PartFactory {
    public Part createPart() {
        return new Part("Гальмо", 120.0);
    }
}
