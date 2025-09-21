package main.java.com.autoparts;

import main.java.com.autoparts.creational.singleton.InventoryManager;
import main.java.com.autoparts.creational.prototype.EnginePart;
import main.java.com.autoparts.creational.prototype.BrakePart;
import main.java.com.autoparts.creational.factory.EnginePartFactory;
import main.java.com.autoparts.creational.factory.BrakePartFactory;
import main.java.com.autoparts.creational.abstractfactory.ToyotaPartsKitFactory;
import main.java.com.autoparts.creational.abstractfactory.EngineComponent;
import main.java.com.autoparts.creational.abstractfactory.BrakeComponent;
import main.java.com.autoparts.creational.abstractfactory.SuspensionComponent;
import main.java.com.autoparts.creational.builder.OrderBuilder;
import main.java.com.autoparts.creational.objectpool.DatabaseConnectionPool;
import main.java.com.autoparts.creational.objectpool.DatabaseConnection;
import main.java.com.autoparts.domain.Order;
import main.java.com.autoparts.domain.Part;

/**
 * Демонстрація всіх породжувальних шаблонів в контексті інтернет-магазину автозапчастин
 */
public class AutoPartsStoreDemo {

    public static void main(String[] args) {
        System.out.println("=== ІНТЕРНЕТ-МАГАЗИН АВТОЗАПЧАСТИН ===");
        System.out.println("Демонстрація породжувальних шаблонів проектування\n");

        // 1. Singleton Pattern - Управління інвентарем
        demonstrateSingletonPattern();

        // 2. Prototype Pattern - Клонування запчастин
        demonstratePrototypePattern();

        // 3. Factory Method Pattern - Створення різних типів запчастин
        demonstrateFactoryMethodPattern();

        // 4. Abstract Factory Pattern - Створення комплектів запчастин
        demonstrateAbstractFactoryPattern();

        // 5. Builder Pattern - Створення складних замовлень
        demonstrateBuilderPattern();

        // 6. Object Pool Pattern - Управління з'єднаннями БД
        demonstrateObjectPoolPattern();

        System.out.println("\n=== ДЕМОНСТРАЦІЯ ЗАВЕРШЕНА ===");
    }

    /**
     * Демонстрація Singleton Pattern - Управління інвентарем
     */
    private static void demonstrateSingletonPattern() {
        System.out.println("=== 1. SINGLETON PATTERN - Управління інвентарем ===");

        // Отримуємо екземпляри менеджера інвентарю
        InventoryManager inventory1 = InventoryManager.getInstance();
        InventoryManager inventory2 = InventoryManager.getInstance();

        // Перевіряємо, що це один і той же об'єкт
        System.out.println("Чи один і той же об'єкт InventoryManager? " + (inventory1 == inventory2));

        // Додаємо запчастини до інвентарю
        EnginePart enginePart = new EnginePart("ENG001", "Поршневі кільця", "Mahle",
                450.50, 25, "1.6L DOHC", "VW Golf, Audi A3");
        inventory1.addPart(enginePart);

        // Резервуємо товар
        inventory1.reservePart("ENG001", 5);
        inventory1.displayInventoryStatus();

        System.out.println();
    }

    /**
     * Демонстрація Prototype Pattern - Клонування запчастин
     */
    private static void demonstratePrototypePattern() {
        System.out.println("=== 2. PROTOTYPE PATTERN - Клонування запчастин ===");

        // Створюємо оригінальну деталь двигуна
        EnginePart originalEnginePart = new EnginePart("ENG002", "Клапан впускний",
                "Bosch", 125.00, 50, "2.0L TDI", "VW Passat, Audi A4");

        System.out.println("Оригінальна деталь:");
        originalEnginePart.displayPartInfo();

        // Клонуємо деталь для модифікації
        EnginePart clonedEnginePart = originalEnginePart.clone();
        clonedEnginePart.setPartNumber("ENG002-MOD");
        clonedEnginePart.setName("Клапан впускний (модифікований)");
        clonedEnginePart.setPrice(135.00);

        System.out.println("\nКлонована та модифікована деталь:");
        clonedEnginePart.displayPartInfo();

        // Створюємо та клонуємо гальмівну деталь
        BrakePart originalBrakePart = new BrakePart("BRK001", "Гальмівний диск",
                "Brembo", 280.00, 30, "Вентильований", "BMW 3 Series");

        BrakePart clonedBrakePart = originalBrakePart.clone();
        clonedBrakePart.setVehicleModel("BMW 5 Series");

        System.out.println("\nОригінальна гальмівна деталь:");
        originalBrakePart.displayPartInfo();
        System.out.println("\nКлонована гальмівна деталь:");
        clonedBrakePart.displayPartInfo();

        System.out.println();
    }

    /**
     * Демонстрація Factory Method Pattern - Створення різних типів запчастин
     */
    private static void demonstrateFactoryMethodPattern() {
        System.out.println("=== 3. FACTORY METHOD PATTERN - Створення запчастин ===");

        // Створення деталей двигуна через фабрику
        EnginePartFactory engineFactory = new EnginePartFactory();
        Part turboPart = engineFactory.processPartCreation("TRB001", "Турбокомпресор",
                "Garrett", 1250.00, 10, "2.0L TSI", "Audi, VW, Skoda");

        System.out.println("Створена деталь через EnginePartFactory:");
        turboPart.displayPartInfo();

        // Створення гальмівних деталей через фабрику
        BrakePartFactory brakeFactory = new BrakePartFactory();
        Part brakeCaliper = brakeFactory.processPartCreation("BRK002", "Гальмівний супорт",
                "AP Racing", 520.00, 15, "4-поршневий", "BMW M3");

        System.out.println("\nСтворена деталь через BrakePartFactory:");
        brakeCaliper.displayPartInfo();

        System.out.println();
    }

    /**
     * Демонстрація Abstract Factory Pattern - Створення комплектів запчастин
     */
    private static void demonstrateAbstractFactoryPattern() {
        System.out.println("=== 4. ABSTRACT FACTORY PATTERN - Комплекти запчастин ===");

        // Створюємо комплект запчастин Toyota
        ToyotaPartsKitFactory toyotaFactory = new ToyotaPartsKitFactory();

        System.out.println("Створення повного комплекту запчастин Toyota:");

        EngineComponent engineComponent = toyotaFactory.createEngineComponent();
        BrakeComponent brakeComponent = toyotaFactory.createBrakeComponent();
        SuspensionComponent suspensionComponent = toyotaFactory.createSuspensionComponent();

        System.out.println("\nІнформація про створені компоненти:");
        engineComponent.displayInfo();
        brakeComponent.displayInfo();
        suspensionComponent.displayInfo();

        System.out.println("\nВстановлення комплекту:");
        engineComponent.install();
        brakeComponent.install();
        suspensionComponent.install();

        System.out.println("\nТестування комплекту:");
        engineComponent.performTest();
        brakeComponent.performTest();
        suspensionComponent.performTest();

        System.out.println();
    }

    /**
     * Демонстрація Builder Pattern - Створення складних замовлень
     */
    private static void demonstrateBuilderPattern() {
        System.out.println("=== 5. BUILDER PATTERN - Створення замовлень ===");

        // Створюємо запчастини для замовлення
        EnginePart oilFilter = new EnginePart("FLT001", "Масляний фільтр", "Mann",
                85.00, 100, "Universal", "Most cars");
        BrakePart brakePads = new BrakePart("BRK003", "Гальмівні колодки", "Ferodo",
                320.00, 40, "Ceramic", "Mercedes C-Class");

        // Створюємо складне замовлення через Builder
        Order complexOrder = new OrderBuilder()
                .setOrderNumber("ORD-2025-001")
                .setCustomerEmail("customer@email.com")
                .addPart(oilFilter, 2)
                .addPart(brakePads, 1)
                .setShippingAddress("вул. Хрещатик, 1, Київ")
                .applyDiscount(10.0)
                .addExpressDelivery()
                .addInsurance()
                .setStatus("CONFIRMED")
                .build();

        System.out.println("\nСтворене замовлення:");
        complexOrder.displayOrderInfo();

        System.out.println();
    }

    /**
     * Демонстрація Object Pool Pattern - Управління з'єднаннями БД
     */
    private static void demonstrateObjectPoolPattern() {
        System.out.println("=== 6. OBJECT POOL PATTERN - Пул з'єднань БД ===");

        // Отримуємо пул з'єднань
        DatabaseConnectionPool connectionPool = DatabaseConnectionPool.getInstance();
        connectionPool.displayPoolStatus();

        // Отримуємо з'єднання для роботи з замовленнями
        DatabaseConnection conn1 = connectionPool.getConnection();
        DatabaseConnection conn2 = connectionPool.getConnection();
        DatabaseConnection conn3 = connectionPool.getConnection();

        connectionPool.displayPoolStatus();

        // Виконуємо операції з БД
        if (conn1 != null) {
            conn1.beginTransaction();
            conn1.executeQuery("SELECT * FROM parts WHERE category = 'ENGINE'");
            conn1.executeUpdate("UPDATE inventory SET quantity = quantity - 1 WHERE part_number = 'ENG001'");
            conn1.commitTransaction();
        }

        if (conn2 != null) {
            conn2.executeQuery("SELECT * FROM orders WHERE status = 'PENDING'");
            conn2.executeUpdate("INSERT INTO order_items (order_id, part_id, quantity) VALUES (1, 'BRK001', 2)");
        }

        if (conn3 != null) {
            conn3.executeQuery("SELECT customer_email, COUNT(*) FROM orders GROUP BY customer_email");
        }

        // Повертаємо з'єднання в пул
        connectionPool.returnConnection(conn1);
        connectionPool.returnConnection(conn2);
        connectionPool.displayPoolStatus();

        // Отримуємо ще одне з'єднання (повинно повторно використати звільнене)
        DatabaseConnection conn4 = connectionPool.getConnection();
        if (conn4 != null) {
            conn4.executeQuery("SELECT * FROM suppliers WHERE active = 1");
            connectionPool.returnConnection(conn4);
        }

        connectionPool.returnConnection(conn3);
        connectionPool.displayPoolStatus();

        System.out.println();
    }
}
