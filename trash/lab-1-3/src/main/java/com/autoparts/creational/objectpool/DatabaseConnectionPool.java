package main.java.com.autoparts.creational.objectpool;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton пул з'єднань з базою даних для автомагазину
 */
public class DatabaseConnectionPool {
    private static volatile DatabaseConnectionPool instance;
    private List<DatabaseConnection> availableConnections;
    private List<DatabaseConnection> usedConnections;
    private final int MAX_POOL_SIZE = 10;
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/autoparts_store";

    /**
     * Приватний конструктор для Singleton
     */
    private DatabaseConnectionPool() {
        availableConnections = new ArrayList<>();
        usedConnections = new ArrayList<>();
        initializePool();
    }

    /**
     * Отримання єдиного екземпляра пулу
     */
    public static DatabaseConnectionPool getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnectionPool.class) {
                if (instance == null) {
                    instance = new DatabaseConnectionPool();
                }
            }
        }
        return instance;
    }

    /**
     * Ініціалізація пулу з'єднань
     */
    private void initializePool() {
        System.out.println("Ініціалізація пулу з'єднань з БД автомагазину...");
        for (int i = 1; i <= MAX_POOL_SIZE; i++) {
            DatabaseConnection connection = new DatabaseConnection("AutoParts-DB-" + i, DATABASE_URL);
            availableConnections.add(connection);
        }
        System.out.println("Пул ініціалізовано з " + MAX_POOL_SIZE + " з'єднаннями");
    }

    /**
     * Отримання з'єднання з пулу
     */
    public synchronized DatabaseConnection getConnection() {
        if (availableConnections.isEmpty()) {
            System.out.println("Всі з'єднання зайняті! Очікуйте...");
            return null;
        }

        DatabaseConnection connection = availableConnections.remove(0);
        connection.setInUse(true);
        usedConnections.add(connection);

        System.out.println("Видано з'єднання з пулу. Доступно: " + availableConnections.size());
        return connection;
    }

    /**
     * Повернення з'єднання в пул
     */
    public synchronized void returnConnection(DatabaseConnection connection) {
        if (usedConnections.remove(connection)) {
            connection.setInUse(false);
            availableConnections.add(connection);
            System.out.println("З'єднання повернено в пул. Доступно: " + availableConnections.size());
        } else {
            System.out.println("Помилка: з'єднання не знайдено в списку використовуваних");
        }
    }

    /**
     * Відображення стану пулу
     */
    public void displayPoolStatus() {
        System.out.println("=== Стан пулу з'єднань БД ===");
        System.out.println("Всього з'єднань: " + MAX_POOL_SIZE);
        System.out.println("Доступно: " + availableConnections.size());
        System.out.println("Використовується: " + usedConnections.size());
    }

    /**
     * Закриття всіх з'єднань при завершенні роботи
     */
    public synchronized void closeAllConnections() {
        System.out.println("Закриття всіх з'єднань пулу...");
        availableConnections.clear();
        usedConnections.clear();
        System.out.println("Всі з'єднання закрито");
    }
}
