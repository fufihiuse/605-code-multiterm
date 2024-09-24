public class A321 extends Airbus implements Warrantable {
    public int checkWarranty() {
        return 4;
    }

    public void honk() {
        System.out.println("A321 honk\n");
    }

    boolean isThisAnAirbus() {
        return true;
    };


}
