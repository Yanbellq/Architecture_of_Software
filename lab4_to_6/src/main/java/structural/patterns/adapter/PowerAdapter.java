package main.java.structural.patterns.adapter;

/**
 * Адаптер для підключення американської вилки до європейської розетки
 */
public class PowerAdapter implements PowerSocket {
    private AmericanPlug americanPlug;

    /**
     * Конструктор адаптера
     * @param americanPlug американська вилка для адаптації
     */
    public PowerAdapter(AmericanPlug americanPlug) {
        this.americanPlug = americanPlug;
    }

    @Override
    public void providePower() {
        System.out.println("Адаптер перетворює напругу з 110V на 220V");
        americanPlug.provideAmericanPower();
        System.out.println("Електроенергія успішно адаптована для європейського стандарту");
    }
}
