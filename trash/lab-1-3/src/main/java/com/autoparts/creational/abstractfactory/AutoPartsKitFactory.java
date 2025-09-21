package main.java.com.autoparts.creational.abstractfactory;

/**
 * Абстрактна фабрика для створення комплектів автозапчастин
 */
public interface AutoPartsKitFactory {
    EngineComponent createEngineComponent();
    BrakeComponent createBrakeComponent();
    SuspensionComponent createSuspensionComponent();
}
