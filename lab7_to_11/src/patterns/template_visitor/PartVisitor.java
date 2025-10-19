package patterns.template_visitor;

interface PartVisitor {
    void visit(EnginePart p);
    void visit(WheelPart p);
}