package classes;

public class BMWFactory implements AbstractCarFactory {
    public Part createEngine() { return new Part("BMW Engine", 6000); }
    public Part createBrake() { return new Part("BMW Brake", 300); }
}
