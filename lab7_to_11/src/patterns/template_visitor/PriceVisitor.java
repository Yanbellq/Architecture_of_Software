package patterns.template_visitor;

public class PriceVisitor implements PartVisitor {
    public void visit(EnginePart p){ System.out.println("Обробка двигуна"); }
    public void visit(WheelPart p){ System.out.println("Обробка колеса"); }
}