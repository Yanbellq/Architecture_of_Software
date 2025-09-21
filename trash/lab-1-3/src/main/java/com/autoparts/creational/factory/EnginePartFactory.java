package main.java.com.autoparts.creational.factory;
import main.java.com.autoparts.creational.prototype.EnginePart;
import main.java.com.autoparts.domain.Part;

import java.util.Arrays;

/**
 * Конкретна фабрика для створення деталей двигуна
 */
public class EnginePartFactory extends PartFactory {

    @Override
    public Part createPart(String partNumber, String name, String brand,
                           double price, int stockQuantity, String... additionalParams) {
        System.out.println("EnginePartFactory створює деталь двигуна");

        String engineType = additionalParams.length > 0 ? Arrays.toString(additionalParams) : "Universal";
        String compatibility = additionalParams.length > 1 ? additionalParams[1] : "All models";

        return new EnginePart(partNumber, name, brand, price, stockQuantity,
                engineType, compatibility);
    }
}
