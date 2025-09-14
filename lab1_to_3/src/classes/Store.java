package classes;

public class Store {
    private static Store instance;
    private Store() {}
    public static Store getInstance() {
        if (instance == null) instance = new Store();
        return instance;
    }
    public void info() {
        System.out.println("Єдиний магазин автозапчастин");
    }
}

