package main.java.structural.patterns;

import main.java.structural.patterns.adapter.*;
import main.java.structural.patterns.bridge.*;
import main.java.structural.patterns.composite.*;
import main.java.structural.patterns.flyweight.*;
import main.java.structural.patterns.decorator.*;
import main.java.structural.patterns.proxy.*;

/**
 * Головний клас для демонстрації всіх структурних шаблонів проектування
 *
 * @author Hrushko Maksym & Anton Olianyk
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦІЯ СТРУКТУРНИХ ШАБЛОНІВ ПРОЕКТУВАННЯ ===\n");

        // Лабораторна робота №4
        demonstrateAdapter();
        System.out.println();
        demonstrateBridge();
        System.out.println();

        // Лабораторна робота №5
        demonstrateComposite();
        System.out.println();
        demonstrateFlyweight();
        System.out.println();

        // Лабораторна робота №6
        demonstrateDecorator();
        System.out.println();
        demonstrateProxy();
    }

    /**
     * Демонстрація шаблону Адаптер
     */
    private static void demonstrateAdapter() {
        System.out.println("--- ШАБЛОН АДАПТЕР ---");

        // Створюємо американську вилку
        AmericanPlug americanPlug = new AmericanPlug();

        // Використовуємо адаптер для підключення до європейської розетки
        PowerSocket socket = new PowerAdapter(americanPlug);
        socket.providePower();
    }

    /**
     * Демонстрація шаблону Міст
     */
    private static void demonstrateBridge() {
        System.out.println("--- ШАБЛОН МІСТ ---");

        // Створюємо фігури з різними кольорами
        Shape redCircle = new Circle(new RedColor());
        Shape blueRectangle = new Rectangle(new BlueColor());

        redCircle.draw();
        blueRectangle.draw();
    }

    /**
     * Демонстрація шаблону Компонувальник
     */
    private static void demonstrateComposite() {
        System.out.println("--- ШАБЛОН КОМПОНУВАЛЬНИК ---");

        // Створюємо файлову структуру
        Directory root = new Directory("root");
        Directory documents = new Directory("documents");
        Directory photos = new Directory("photos");

        File readme = new File("readme.txt", 1024);
        File photo1 = new File("vacation.jpg", 2048576);
        File photo2 = new File("family.jpg", 1536000);

        // Будуємо ієрархію
        root.add(documents);
        root.add(photos);
        documents.add(readme);
        photos.add(photo1);
        photos.add(photo2);

        // Показуємо структуру та загальний розмір
        root.showInfo("");
        System.out.println("Загальний розмір: " + root.getSize() + " байт");
    }

    /**
     * Демонстрація шаблону Пристосуванець
     */
    private static void demonstrateFlyweight() {
        System.out.println("--- ШАБЛОН ПРИСТОСУВАНЕЦЬ ---");

        // Створюємо ліс з різними деревами
        Tree[] forest = new Tree[6];

        // Створюємо дерева - декілька з однаковими типами
        forest[0] = new Tree(10, 20, TreeTypeFactory.getTreeType("Дуб", "Зелений", "Грубка"));
        forest[1] = new Tree(30, 40, TreeTypeFactory.getTreeType("Сосна", "Зелений", "Гладка"));
        forest[2] = new Tree(50, 60, TreeTypeFactory.getTreeType("Дуб", "Зелений", "Грубка")); // повторний тип
        forest[3] = new Tree(70, 80, TreeTypeFactory.getTreeType("Береза", "Білий", "Гладка"));
        forest[4] = new Tree(90, 100, TreeTypeFactory.getTreeType("Сосна", "Зелений", "Гладка")); // повторний тип
        forest[5] = new Tree(110, 120, TreeTypeFactory.getTreeType("Дуб", "Зелений", "Грубка")); // повторний тип

        // Відображаємо всі дерева
        for (Tree tree : forest) {
            tree.render();
        }

        System.out.println("Загальна кількість дерев: " + forest.length);
        System.out.println("Кількість унікальних типів дерев: " + TreeTypeFactory.getCreatedTreeTypesCount());
    }

    /**
     * Демонстрація шаблону Декоратор
     */
    private static void demonstrateDecorator() {
        System.out.println("--- ШАБЛОН ДЕКОРАТОР ---");

        // Створюємо просту каву та поступово додаємо інгредієнти
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " - " + coffee.getCost() + " грн");

        // Додаємо молоко
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " - " + coffee.getCost() + " грн");

        // Додаємо цукор
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " - " + coffee.getCost() + " грн");

        // Додаємо ще молока
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " - " + coffee.getCost() + " грн");
    }

    /**
     * Демонстрація шаблону Заступник
     */
    private static void demonstrateProxy() {
        System.out.println("--- ШАБЛОН ЗАСТУПНИК ---");

        // Створюємо проксі зображення
        Image image1 = new ProxyImage("vacation_photo.jpg");
        Image image2 = new ProxyImage("family_photo.jpg");

        System.out.println("Перше звернення до зображення 1:");
        image1.display();

        System.out.println("\nДруге звернення до зображення 1 (вже завантажене):");
        image1.display();

        System.out.println("\nПерше звернення до зображення 2:");
        image2.display();
    }
}
