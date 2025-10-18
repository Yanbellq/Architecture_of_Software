package main.java.structural.patterns.proxy;

import main.java.structural.patterns.model.CarPart;
import java.util.List;

/**
 * Інтерфейс каталогу автозапчастин
 */
public interface CarPartCatalog {
    /**
     * Пошук запчастин за маркою автомобіля
     * @param carBrand марка автомобіля
     * @return список запчастин
     */
    List<CarPart> searchByCarBrand(String carBrand);

    /**
     * Отримує деталі запчастини за ID
     * @param partId ідентифікатор запчастини
     * @return деталі запчастини
     */
    CarPart getPartDetails(Long partId);
}
