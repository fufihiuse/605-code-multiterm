public class B737 extends Boeing implements Warrantable{
    int numberOfEngines = 4;
    final String vehicleType = "airplane";

    public void honk() {
        System.out.println("B321 honk\n");
    }

    public String getVehicleType(){
        return vehicleType;
    }

    boolean isThisABoeing() {
        return true;
    };

    public int checkWarranty() {
        return 10;
    }

}
