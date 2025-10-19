package patterns.template_visitor;

public class EnginePart implements Visitable {
    public void accept(PartVisitor v){ v.visit(this); }
}