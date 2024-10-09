package abstract_classes.interfaces_vs_abstract_classes;

public class Accord extends Honda implements Warrantable, Priceable {
    String brandName = "honda";

    boolean isThisAHondaCar() {
        return true;
    };

    public int checkWarranty() {
        return 4;
    }

    public int checkPrice() {
        return 40000;
    }

    public void honk() {
        System.out.println("accord honk\n");
    }

}
