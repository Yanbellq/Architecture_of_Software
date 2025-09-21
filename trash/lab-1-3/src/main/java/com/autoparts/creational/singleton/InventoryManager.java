package main.java.com.autoparts.creational.singleton;

import main.java.com.autoparts.domain.Part;
import java.util.HashMap;
import java.util.Map;

/**
 * Singleton для управління інвентарем автозапчастин
 * Забезпечує централізоване управління складом
 */
public class InventoryManager {
    private static volatile InventoryManager instance;
    private Map<String, Part> inventory;
    private Map<String, Integer> reservedStock;

    /**
     * Приватний конструктор для реалізації Singleton
     */
    private InventoryManager() {
        this.inventory = new HashMap<>();
        this.reservedStock = new HashMap<>();
        System.out.println("InventoryManager ініціалізовано - централізоване управління складом");
    }

    /**
     * Thread-safe отримання єдиного екземпляра
     * @return єдиний екземпляр InventoryManager
     */
    public static InventoryManager getInstance() {
        if (instance == null) {
            synchronized (InventoryManager.class) {
                if (instance == null) {
                    instance = new InventoryManager();
                }
            }
        }
        return instance;
    }

    /**
     * Додавання запчастини до інвентарю
     */
    public void addPart(Part part) {
        inventory.put(part.getPartNumber(), part);
        System.out.println("Додано до складу: " + part.getName() + " (" + part.getPartNumber() + ")");
    }

    /**
     * Резервування товару для замовлення
     */
    public boolean reservePart(String partNumber, int quantity) {
        Part part = inventory.get(partNumber);
        if (part != null && part.getStockQuantity() >= quantity) {
            int currentReserved = reservedStock.getOrDefault(partNumber, 0);
            reservedStock.put(partNumber, currentReserved + quantity);
            System.out.println("Зарезервовано: " + part.getName() + " x" + quantity);
            return true;
        }
        System.out.println("Недостатньо товару на складі: " + partNumber);
        return false;
    }

    /**
     * Перевірка наявності товару
     */
    public int getAvailableQuantity(String partNumber) {
        Part part = inventory.get(partNumber);
        if (part != null) {
            int reserved = reservedStock.getOrDefault(partNumber, 0);
            return part.getStockQuantity() - reserved;
        }
        return 0;
    }

    /**
     * Отримання інформації про товар
     */
    public Part getPart(String partNumber) {
        return inventory.get(partNumber);
    }

    /**
     * Відображення стану складу
     */
    public void displayInventoryStatus() {
        System.out.println("=== Стан складу ===");
        for (Part part : inventory.values()) {
            int reserved = reservedStock.getOrDefault(part.getPartNumber(), 0);
            int available = part.getStockQuantity() - reserved;
            System.out.println(part.getName() + " - Всього: " + part.getStockQuantity() +
                    ", Доступно: " + available + ", Зарезервовано: " + reserved);
        }
    }
}
