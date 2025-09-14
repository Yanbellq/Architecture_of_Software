package classes;

public interface AbstractCarFactory {
    Part createEngine();
    Part createBrake();
}

class ToyotaFactory implements AbstractCarFactory {
    public Part createEngine() { return new Part("Toyota Engine", 4000); }
    public Part createBrake() { return new Part("Toyota Brake", 200); }
}
