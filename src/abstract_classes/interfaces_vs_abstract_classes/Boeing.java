abstract public class Boeing extends Plane {
    int numberOfEngines = 2;
    final String vehicleType = "airplane";

    public void honk() {
        System.out.println("airplane honk");
    }

    public String getVehicleType(){
        return vehicleType;
    }

    abstract boolean isThisABoeing();

}
