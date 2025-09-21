package main.java.com.autoparts.creational.objectpool;

/**
 * Об'єкт з'єднання з базою даних для пулу
 */
public class DatabaseConnection {
    private String connectionId;
    private boolean inUse;
    private String databaseUrl;

    public DatabaseConnection(String connectionId, String databaseUrl) {
        this.connectionId = connectionId;
        this.databaseUrl = databaseUrl;
        this.inUse = false;
        System.out.println("Створено з'єднання з БД: " + connectionId + " -> " + databaseUrl);
    }

    /**
     * Виконання SQL запиту
     */
    public void executeQuery(String query) {
        System.out.println("Виконання запиту через з'єднання " + connectionId + ": " + query);
    }

    /**
     * Виконання оновлення даних
     */
    public void executeUpdate(String updateQuery) {
        System.out.println("Виконання оновлення через з'єднання " + connectionId + ": " + updateQuery);
    }

    /**
     * Початок транзакції
     */
    public void beginTransaction() {
        System.out.println("Початок транзакції на з'єднанні " + connectionId);
    }

    /**
     * Підтвердження транзакції
     */
    public void commitTransaction() {
        System.out.println("Підтвердження транзакції на з'єднанні " + connectionId);
    }

    /**
     * Встановлення статусу використання
     */
    public void setInUse(boolean inUse) {
        this.inUse = inUse;
        System.out.println("З'єднання " + connectionId +
                (inUse ? " використовується" : " повернено в пул"));
    }

    // Геттери
    public String getConnectionId() { return connectionId; }
    public boolean isInUse() { return inUse; }
    public String getDatabaseUrl() { return databaseUrl; }
}
