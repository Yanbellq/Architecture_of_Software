package patterns.iterator_mediator;

import model.AutoPart;

public class PartIterator implements Iterator<AutoPart> {
    private AutoPart[] parts;
    private int index;
    public PartIterator(AutoPart[] parts) { this.parts = parts; }
    public boolean hasNext() { return index < parts.length; }
    public AutoPart next() { return parts[index++]; }
}