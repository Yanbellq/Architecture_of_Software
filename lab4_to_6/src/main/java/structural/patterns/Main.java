package main.java.structural.patterns;

import main.java.structural.patterns.bridge.*;
//import main.java.structural.patterns.model.*;
import main.java.structural.patterns.adapter.*;
import main.java.structural.patterns.bridge.*;
import main.java.structural.patterns.composite.*;
import main.java.structural.patterns.flyweight.*;
import main.java.structural.patterns.decorator.*;
import main.java.structural.patterns.model.Customer;
import main.java.structural.patterns.proxy.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Головний клас демонстрації інтернет-магазину автозапчастин
 * з використанням структурних шаблонів проектування
 *
 * @author Student
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("🚗 === ІНТЕРНЕТ-МАГАЗИН АВТОЗАПЧАСТИН ===");
        System.out.println("Демонстрація структурних шаблонів проектування\n");

        // Лабораторна робота №4
        demonstrateAdapter();
        System.out.println("\n" + "=".repeat(60) + "\n");
        demonstrateBridge();
        System.out.println("\n" + "=".repeat(60) + "\n");

        // Лабораторна робота №5
        demonstrateComposite();
        System.out.println("\n" + "=".repeat(60) + "\n");
        demonstrateFlyweight();
        System.out.println("\n" + "=".repeat(60) + "\n");

        // Лабораторна робота №6
        demonstrateDecorator();
        System.out.println("\n" + "=".repeat(60) + "\n");
        demonstrateProxy();
    }

    /**
     * Демонстрація шаблону Адаптер - інтеграція з застарілою платіжною системою
     */
    private static void demonstrateAdapter() {
        System.out.println("💳 --- ШАБЛОН АДАПТЕР: Платіжна система ---");

        // Створюємо застарілу платіжну систему
        OldPaymentSystem oldSystem = new OldPaymentSystem();

        // Використовуємо адаптер для роботи з новим інтерфейсом
        PaymentGateway paymentGateway = new PaymentAdapter(oldSystem);

        // Обробляємо платіж через адаптер
        BigDecimal amount = new BigDecimal("1250.50");
        String result = paymentGateway.processPayment(amount, "4532-1234-5678-9012");

        System.out.println("Результат: " + result);
    }

    /**
     * Демонстрація шаблону Міст - різні типи замовлень з різними способами доставки
     */
    private static void demonstrateBridge() {
        System.out.println("🌉 --- ШАБЛОН МІСТ: Замовлення та доставка ---");

        // Створюємо клієнта
        Customer customer = new Customer(1L, "Іван Петренко", "ivan@email.com",
                "+380501234567", "вул. Хрещатик, 10, Київ");

        // Створюємо різні способи доставки
        DeliveryMethod courier = new CourierDelivery();
        DeliveryMethod post = new PostDelivery();

        // Створюємо різні типи замовлень з різними способами доставки
        Order regularOrder = new RegularOrder(1001L, customer, new BigDecimal("2500"), courier);
        Order urgentOrder = new UrgentOrder(1002L, customer, new BigDecimal("3200"), post);

        // Обробляємо замовлення
        regularOrder.processOrder();
        urgentOrder.processOrder();
    }

    /**
     * Демонстрація шаблону Компонувальник - структура замовлення з групами товарів
     */
    private static void demonstrateComposite() {
        System.out.println("🏗️ --- ШАБЛОН КОМПОНУВАЛЬНИК: Структура замовлення ---");

        // Створюємо основне замовлення
        OrderComponent mainOrder = new OrderGroup("Замовлення #1003");

        // Створюємо групи запчастин
        OrderComponent brakeSystem = new OrderGroup("Гальмівна система");
        OrderComponent engineParts = new OrderGroup("Деталі двигуна");
        OrderComponent electricalParts = new OrderGroup("Електрика");

        // Додаємо конкретні запчастини до груп
        brakeSystem.add(new OrderItem("Гальмівні колодки", "BP001", new BigDecimal("850"), 2));
        brakeSystem.add(new OrderItem("Гальмівні диски", "BD002", new BigDecimal("1200"), 2));

        engineParts.add(new OrderItem("Масляний фільтр", "OF003", new BigDecimal("320"), 1));
        engineParts.add(new OrderItem("Повітряний фільтр", "AF004", new BigDecimal("280"), 1));
        engineParts.add(new OrderItem("Свічки запалювання", "SP005", new BigDecimal("180"), 4));

        electricalParts.add(new OrderItem("Акумулятор", "BT006", new BigDecimal("2500"), 1));
        electricalParts.add(new OrderItem("Генератор", "GN007", new BigDecimal("3200"), 1));

        // Будуємо ієрархічну структуру
        mainOrder.add(brakeSystem);
        mainOrder.add(engineParts);
        mainOrder.add(electricalParts);

        // Відображаємо повну структуру замовлення
        mainOrder.showDetails("");
        System.out.println("\n💰 ЗАГАЛЬНА ВАРТІСТЬ ЗАМОВЛЕННЯ: " + mainOrder.calculateTotal() + " грн");
    }

    /**
     * Демонстрація шаблону Пристосуванець - ефективне управління каталогом запчастин
     */
    private static void demonstrateFlyweight() {
        System.out.println("🪶 --- ШАБЛОН ПРИСТОСУВАНЕЦЬ: Каталог запчастин ---");

        System.out.println("Створення каталогу автозапчастин...\n");

        // Створюємо багато запчастин з повторюваними типами
        CarPart[] parts = new CarPart[12];

        // Створюємо запчастини - багато з однаковими типами для демонстрації економії пам'яті
        parts[0] = new CarPart("BP001", 10, new BigDecimal("850"),
                CarPartTypeFactory.getCarPartType("Гальмівні колодки", "Bosch", "Гальма"));
        parts[1] = new CarPart("BP002", 15, new BigDecimal("920"),
                CarPartTypeFactory.getCarPartType("Гальмівні колодки", "Bosch", "Гальма"));
        parts[2] = new CarPart("OF001", 25, new BigDecimal("320"),
                CarPartTypeFactory.getCarPartType("Масляний фільтр", "Mann", "Фільтри"));
        parts[3] = new CarPart("OF002", 30, new BigDecimal("280"),
                CarPartTypeFactory.getCarPartType("Масляний фільтр", "Mann", "Фільтри"));
        parts[4] = new CarPart("SP001", 40, new BigDecimal("180"),
                CarPartTypeFactory.getCarPartType("Свічки запалювання", "NGK", "Запалювання"));
        parts[5] = new CarPart("SP002", 35, new BigDecimal("200"),
                CarPartTypeFactory.getCarPartType("Свічки запалювання", "NGK", "Запалювання"));
        parts[6] = new CarPart("BP003", 8, new BigDecimal("1100"),
                CarPartTypeFactory.getCarPartType("Гальмівні колодки", "Brembo", "Гальма"));
        parts[7] = new CarPart("OF003", 20, new BigDecimal("350"),
                CarPartTypeFactory.getCarPartType("Масляний фільтр", "Bosch", "Фільтри"));
        parts[8] = new CarPart("SP003", 50, new BigDecimal("160"),
                CarPartTypeFactory.getCarPartType("Свічки запалювання", "Denso", "Запалювання"));
        parts[9] = new CarPart("BP004", 12, new BigDecimal("880"),
                CarPartTypeFactory.getCarPartType("Гальмівні колодки", "Bosch", "Гальма"));
        parts[10] = new CarPart("OF004", 18, new BigDecimal("310"),
                CarPartTypeFactory.getCarPartType("Масляний фільтр", "Mann", "Фільтри"));
        parts[11] = new CarPart("SP004", 45, new BigDecimal("190"),
                CarPartTypeFactory.getCarPartType("Свічки запалювання", "NGK", "Запалювання"));

        System.out.println("\n📦 КАТАЛОГ АВТОЗАПЧАСТИН:");
        System.out.println("─".repeat(80));

        // Відображаємо всі запчастини
        for (CarPart part : parts) {
            part.displayInfo();
        }

        System.out.println("─".repeat(80));
        System.out.println("📊 СТАТИСТИКА:");
        System.out.println("Загальна кількість запчастин в каталозі: " + parts.length);
        CarPartTypeFactory.showMemoryStats();
    }

    /**
     * Демонстрація шаблону Декоратор - додаткові послуги до замовлення
     */
    private static void demonstrateDecorator() {
        System.out.println("🎨 --- ШАБЛОН ДЕКОРАТОР: Додаткові послуги ---");

        // Створюємо базове замовлення
        BigDecimal baseAmount = new BigDecimal("2500");
        OrderService order = new BasicOrderService(baseAmount);

        System.out.println("Початкове замовлення:");
        System.out.println("Опис: " + order.getServiceDescription());
        System.out.println("Вартість: " + order.processOrder() + " грн\n");

        // Додаємо знижку 10%
        order = new DiscountDecorator(order, new BigDecimal("10"));
        System.out.println("Після додавання знижки:");
        System.out.println("Опис: " + order.getServiceDescription());
        System.out.println("Вартість: " + order.processOrder() + " грн\n");

        // Додаємо розширену гарантію
        order = new WarrantyDecorator(order);
        System.out.println("Після додавання гарантії:");
        System.out.println("Опис: " + order.getServiceDescription());
        System.out.println("Вартість: " + order.processOrder() + " грн\n");

        // Додаємо експрес-доставку
        order = new ExpressDeliveryDecorator(order);
        System.out.println("Фінальне замовлення з усіма послугами:");
        System.out.println("Опис: " + order.getServiceDescription());
        System.out.println("Вартість: " + order.processOrder() + " грн\n");

        // Створюємо ще одне замовлення з іншими декораторами
        OrderService premiumOrder = new BasicOrderService(new BigDecimal("5000"));
        premiumOrder = new DiscountDecorator(premiumOrder, new BigDecimal("15"));
        premiumOrder = new WarrantyDecorator(premiumOrder);
        premiumOrder = new WarrantyDecorator(premiumOrder); // Подвійна гарантія
        premiumOrder = new ExpressDeliveryDecorator(premiumOrder);

        System.out.println("Преміум замовлення:");
        System.out.println("Опис: " + premiumOrder.getServiceDescription());
        System.out.println("Вартість: " + premiumOrder.processOrder() + " грн");
    }

    /**
     * Демонстрація шаблону Заступник - кешування каталогу запчастин
     */
    private static void demonstrateProxy() {
        System.out.println("🛡️ --- ШАБЛОН ЗАСТУПНИК: Каталог з кешуванням ---");

        // Створюємо проксі каталогу
        CarPartCatalog catalog = new CarPartCatalogProxy();

        System.out.println("=== ПЕРШИЙ ПОШУК ===");
        // Перший пошук - створюється реальний каталог та завантажуються дані
        List<main.java.structural.patterns.model.CarPart> toyotaParts = catalog.searchByCarBrand("Toyota");
        System.out.println("\nЗнайдені запчастини для Toyota:");
        toyotaParts.forEach(System.out::println);

        System.out.println("\n=== ПОВТОРНИЙ ПОШУК ===");
        // Повторний пошук - використовується кеш
        List<main.java.structural.patterns.model.CarPart> toyotaPartsAgain = catalog.searchByCarBrand("Toyota");
        System.out.println("\nПовторний пошук (з кешу):");
        toyotaPartsAgain.forEach(System.out::println);

        System.out.println("\n=== ПОШУК НОВОЇ МАРКИ ===");
        // Пошук іншої марки - нові дані, але каталог вже завантажений
        List<main.java.structural.patterns.model.CarPart> hondaParts = catalog.searchByCarBrand("Honda");
        System.out.println("\nЗнайдені запчастини для Honda:");
        hondaParts.forEach(System.out::println);

        System.out.println("\n=== ОТРИМАННЯ ДЕТАЛЕЙ ЗАПЧАСТИНИ ===");
        // Отримання деталей конкретної запчастини
        main.java.structural.patterns.model.CarPart partDetails = catalog.getPartDetails(101L);
        System.out.println("\nДеталі запчастини:");
        System.out.println(partDetails);

        System.out.println("\n=== ПОВТОРНЕ ОТРИМАННЯ ДЕТАЛЕЙ ===");
        // Повторне отримання тих же деталей - з кешу
        main.java.structural.patterns.model.CarPart partDetailsAgain = catalog.getPartDetails(101L);
        System.out.println("\nПовторне отримання деталей (з кешу):");
        System.out.println(partDetailsAgain);

        System.out.println("\n💡 Завдяки шаблону Заступник:");
        System.out.println("✅ Реальний каталог створюється тільки при першому зверненні");
        System.out.println("✅ Результати пошуку кешуються для швидкого доступу");
        System.out.println("✅ Зменшується навантаження на базу даних");
        System.out.println("✅ Покращується продуктивність системи");
    }
}
