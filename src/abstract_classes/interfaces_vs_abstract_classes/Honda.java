package abstract_classes.interfaces_vs_abstract_classes;

abstract public class Honda extends Car {
    String brandName = "honda";

    abstract boolean isThisAHondaCar();

    int checkHondaWarranty() {
        return 3;
    }
}
