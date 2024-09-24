abstract public class Airbus extends Plane {
    int numberOfEngines = 2;
    final String vehicleType = "airplane";

    public void honk() {
        System.out.println("airplane honk");
    }

    public String getVehicleType(){
        return vehicleType;
    }

    public int checkWarranty() {
        return 6;
    }

    abstract boolean isThisAnAirbus();

}
