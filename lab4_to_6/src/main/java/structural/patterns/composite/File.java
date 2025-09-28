package main.java.structural.patterns.composite;

/**
 * Листковий компонент - файл
 */
public class File extends FileComponent {
    private long size;

    /**
     * Конструктор файлу
     * @param name ім'я файлу
     * @param size розмір файлу
     */
    public File(String name, long size) {
        super(name);
        this.size = size;
    }

    @Override
    public void showInfo(String indent) {
        System.out.println(indent + "📄 Файл: " + name + " (" + size + " байт)");
    }

    @Override
    public long getSize() {
        return size;
    }
}
