package abstract_classes.interfaces_vs_abstract_classes;

abstract public class Toyota extends Car {
    String brandName = "toyota";

    abstract boolean isThisAToyotaCar();

    int checkToyotaWarranty() {
        return 3;
    }
}
