package main.java.com.autoparts.creational.factory;
import main.java.com.autoparts.domain.Part;

/**
 * Абстрактна фабрика для створення автозапчастин
 */
public abstract class PartFactory {

    /**
     * Фабричний метод для створення запчастин
     */
    public abstract Part createPart(String partNumber, String name, String brand,
                                    double price, int stockQuantity, String... additionalParams);

    /**
     * Бізнес-логіка обробки створення запчастини
     */
    public Part processPartCreation(String partNumber, String name, String brand,
                                    double price, int stockQuantity, String... additionalParams) {
        System.out.println("Обробка створення запчастини: " + name + " (" + partNumber + ")");
        Part part = createPart(partNumber, name, brand, price, stockQuantity, additionalParams);

        // Бізнес-логіка валідації
        validatePart(part);

        System.out.println("Запчастина успішно створена та перевірена");
        return part;
    }

    /**
     * Валідація створеної запчастини
     */
    private void validatePart(Part part) {
        System.out.println("Валідація запчастини: " + part.getName());
        if (part.getPrice() <= 0) {
            System.out.println("Попередження: Ціна повинна бути більше 0");
        }
        if (part.getStockQuantity() < 0) {
            System.out.println("Попередження: Кількість не може бути від'ємною");
        }
        System.out.println("Валідація завершена");
    }
}
