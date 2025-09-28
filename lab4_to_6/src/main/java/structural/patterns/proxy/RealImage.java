package main.java.structural.patterns.proxy;

/**
 * Реальний суб'єкт - справжнє зображення
 */
public class RealImage implements Image {
    private String filename;

    /**
     * Конструктор реального зображення
     * @param filename ім'я файлу зображення
     */
    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    /**
     * Завантажує зображення з диску (важка операція)
     */
    private void loadFromDisk() {
        System.out.println("Завантаження зображення з диску: " + filename);
        // Симуляція важкої операції завантаження
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Зображення " + filename + " завантажено");
    }

    @Override
    public void display() {
        System.out.println("Відображається зображення: " + filename);
    }
}
