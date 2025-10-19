package patterns.template_visitor;

interface Visitable {
    void accept(PartVisitor visitor);
}