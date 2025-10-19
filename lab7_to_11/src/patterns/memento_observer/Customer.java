package patterns.memento_observer;

public class Customer implements Observer {
    private String name;
    public Customer(String name){ this.name = name; }
    public void update(String status){ System.out.println(name + " отримав оновлення: " + status); }
}