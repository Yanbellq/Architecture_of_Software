package main.java.structural.patterns.proxy;

/**
 * Заступник - проксі зображення з ледачим завантаженням
 */
public class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    /**
     * Конструктор проксі зображення
     * @param filename ім'я файлу зображення
     */
    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        System.out.println("Проксі: Запит на відображення зображення " + filename);

        // Ледаче завантаження - створюємо реальний об'єкт тільки при потребі
        if (realImage == null) {
            System.out.println("Проксі: Створення реального зображення...");
            realImage = new RealImage(filename);
        }

        realImage.display();
    }
}
