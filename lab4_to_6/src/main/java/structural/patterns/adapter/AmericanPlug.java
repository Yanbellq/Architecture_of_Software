package main.java.structural.patterns.adapter;

/**
 * Американська вилка (110V) - потребує адаптації
 */
public class AmericanPlug {
    /**
     * Подає електроенергію 110V
     */
    public void provideAmericanPower() {
        System.out.println("Подається електроенергія 110V через американську вилку");
    }
}
