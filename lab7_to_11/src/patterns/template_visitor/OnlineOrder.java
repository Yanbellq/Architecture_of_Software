package patterns.template_visitor;

public class OnlineOrder extends OrderProcess {
    protected void selectParts(){ System.out.println("Вибрано товари онлайн"); }
    protected void calculateTotal(){ System.out.println("Пораховано вартість"); }
    protected void makePayment(){ System.out.println("Оплата через картку"); }
}
