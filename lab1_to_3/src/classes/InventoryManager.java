package classes;

import java.util.HashMap;
import java.util.Map;

/**
 * InventoryManager - Singleton для керування запасами деталей
 */
public class InventoryManager {
    private final Map<String, Integer> stock = new HashMap<>();

    // lazy initialization holder idiom - thread-safe
    private InventoryManager() {}

    private static class Holder {
        static final InventoryManager INSTANCE = new InventoryManager();
    }

    public static InventoryManager getInstance() {
        return Holder.INSTANCE;
    }

    public synchronized void addStock(String partId, int qty) {
        stock.put(partId, stock.getOrDefault(partId, 0) + qty);
        System.out.println("[InventoryManager] Додано " + qty + " одиниць для " + partId);
    }

    public synchronized boolean removeStock(String partId, int qty) {
        int available = stock.getOrDefault(partId, 0);
        if (available >= qty) {
            stock.put(partId, available - qty);
            System.out.println("[InventoryManager] Списано " + qty + " одиниць для " + partId);
            return true;
        } else {
            System.out.println("[InventoryManager] Недостатньо на складі для " + partId);
            return false;
        }
    }

    public synchronized int checkAvailability(String partId) {
        int avail = stock.getOrDefault(partId, 0);
        System.out.println("[InventoryManager] Перевірка запасу для " + partId + ": " + avail);
        return avail;
    }
}
