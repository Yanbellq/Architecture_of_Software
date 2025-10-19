package patterns.template_visitor;

public class WheelPart implements Visitable {
    public void accept(PartVisitor v){ v.visit(this); }
}