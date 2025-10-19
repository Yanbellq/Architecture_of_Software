package patterns.iterator_mediator;

interface Mediator {
    void notify(Component sender, String event);
}