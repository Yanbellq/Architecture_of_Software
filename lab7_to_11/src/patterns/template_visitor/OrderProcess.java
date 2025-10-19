package patterns.template_visitor;

abstract class OrderProcess {
    public final void processOrder() {
        selectParts();
        calculateTotal();
        makePayment();
        confirm();
    }
    protected abstract void selectParts();
    protected abstract void calculateTotal();
    protected abstract void makePayment();
    protected void confirm(){ System.out.println("Замовлення підтверджено."); }
}