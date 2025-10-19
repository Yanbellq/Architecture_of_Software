package patterns.iterator_mediator;

interface Iterator<T> {
    boolean hasNext();
    T next();
}