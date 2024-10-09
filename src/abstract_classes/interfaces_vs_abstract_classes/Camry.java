package abstract_classes.interfaces_vs_abstract_classes;

public class Camry extends Toyota implements Warrantable, Priceable {
    String brandName = "toyota";

    boolean isThisAToyotaCar() {
        return true;
    };

    public int checkWarranty() {
        return 3;
    }

    public int checkPrice() {
        return 35000;
    }

    public void honk() {
        System.out.println("camry honk\n");
    }

}
