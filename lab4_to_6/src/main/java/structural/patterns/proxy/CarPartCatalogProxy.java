package main.java.structural.patterns.proxy;

import main.java.structural.patterns.model.CarPart;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Заступник каталогу з кешуванням та ледачим завантаженням
 */
public class CarPartCatalogProxy implements CarPartCatalog {
    private RealCarPartCatalog realCatalog;
    private Map<String, List<CarPart>> searchCache = new HashMap<>();
    private Map<Long, CarPart> partDetailsCache = new HashMap<>();

    @Override
    public List<CarPart> searchByCarBrand(String carBrand) {
        System.out.println("🔐 Проксі: запит пошуку для марки " + carBrand);

        // Перевіряємо кеш
        if (searchCache.containsKey(carBrand)) {
            System.out.println("💾 Проксі: результати знайдено в кеші!");
            return searchCache.get(carBrand);
        }

        // Ледаче завантаження реального каталогу
        if (realCatalog == null) {
            System.out.println("🚀 Проксі: перше звернення, створення реального каталогу...");
            realCatalog = new RealCarPartCatalog();
        }

        // Отримуємо результати та кешуємо їх
        List<CarPart> results = realCatalog.searchByCarBrand(carBrand);
        searchCache.put(carBrand, results);
        System.out.println("💾 Проксі: результати збережено в кеші");

        return results;
    }

    @Override
    public CarPart getPartDetails(Long partId) {
        System.out.println("🔐 Проксі: запит деталей для ID " + partId);

        // Перевіряємо кеш
        if (partDetailsCache.containsKey(partId)) {
            System.out.println("💾 Проксі: деталі знайдено в кеші!");
            return partDetailsCache.get(partId);
        }

        // Ледаче завантаження реального каталогу
        if (realCatalog == null) {
            System.out.println("🚀 Проксі: перше звернення, створення реального каталогу...");
            realCatalog = new RealCarPartCatalog();
        }

        // Отримуємо деталі та кешуємо їх
        CarPart partDetails = realCatalog.getPartDetails(partId);
        partDetailsCache.put(partId, partDetails);
        System.out.println("💾 Проксі: деталі збережено в кеші");

        return partDetails;
    }
}
