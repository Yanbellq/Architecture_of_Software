package main.java.structural.patterns.composite;

/**
 * Базовий компонент файлової системи
 */
public abstract class FileComponent {
    protected String name;

    public FileComponent(String name) {
        this.name = name;
    }

    /**
     * Показує інформацію про компонент
     * @param indent відступ для ієрархії
     */
    public abstract void showInfo(String indent);

    /**
     * Отримує розмір компонента
     * @return розмір у байтах
     */
    public abstract long getSize();

    /**
     * Додає дочірній компонент (за замовчуванням не підтримується)
     */
    public void add(FileComponent component) {
        throw new UnsupportedOperationException("Операція не підтримується");
    }

    /**
     * Видаляє дочірній компонент (за замовчуванням не підтримується)
     */
    public void remove(FileComponent component) {
        throw new UnsupportedOperationException("Операція не підтримується");
    }
}
