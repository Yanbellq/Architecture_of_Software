package main.java.com.autoparts.creational.factory;

import main.java.com.autoparts.creational.prototype.BrakePart;
import main.java.com.autoparts.domain.Part;

import java.util.Arrays;

/**
 * Конкретна фабрика для створення гальмівних деталей
 */
public class BrakePartFactory extends PartFactory {

    @Override
    public Part createPart(String partNumber, String name, String brand,
                           double price, int stockQuantity, String... additionalParams) {
        System.out.println("BrakePartFactory створює гальмівну деталь");

        String brakeSystem = additionalParams.length > 0 ? Arrays.toString(additionalParams) : "Disc";
        String vehicleModel = additionalParams.length > 1 ? additionalParams[1] : "Universal";

        return new BrakePart(partNumber, name, brand, price, stockQuantity,
                brakeSystem, vehicleModel);
    }
}
