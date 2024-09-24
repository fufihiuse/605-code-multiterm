abstract public class Toyota extends Car {
    String brandName = "toyota";

    abstract boolean isThisAToyotaCar();

    int checkToyotaWarranty() {
        return 3;
    }
}
