package main.java.structural.patterns.proxy;

import main.java.structural.patterns.model.CarPart;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Реальний каталог автозапчастин з важкими операціями завантаження
 */
public class RealCarPartCatalog implements CarPartCatalog {

    public RealCarPartCatalog() {
        // Симуляція важкого завантаження каталогу
        loadCatalogFromDatabase();
    }

    private void loadCatalogFromDatabase() {
        System.out.println("🔄 Завантаження каталогу автозапчастин з бази даних...");
        try {
            Thread.sleep(2000); // Симуляція важкої операції
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("✅ Каталог успішно завантажено з бази даних");
    }

    @Override
    public List<CarPart> searchByCarBrand(String carBrand) {
        System.out.println("🔍 Пошук запчастин для марки: " + carBrand);

        // Симуляція пошуку в базі даних
        List<CarPart> results = new ArrayList<>();
        results.add(new CarPart(1L, "Гальмівні колодки", "Bosch", carBrand,
                "BP001", new BigDecimal("850"), 15));
        results.add(new CarPart(2L, "Масляний фільтр", "Mann", carBrand,
                "OF002", new BigDecimal("320"), 25));
        results.add(new CarPart(3L, "Свічки запалювання", "NGK", carBrand,
                "SP003", new BigDecimal("180"), 40));

        System.out.println("Знайдено " + results.size() + " запчастин");
        return results;
    }

    @Override
    public CarPart getPartDetails(Long partId) {
        System.out.println("📋 Завантаження деталей запчастини ID: " + partId);

        // Симуляція завантаження з бази даних
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return new CarPart(partId, "Амортизатор передній", "KYB", "Toyota",
                "AM" + partId, new BigDecimal("1250"), 8);
    }
}
