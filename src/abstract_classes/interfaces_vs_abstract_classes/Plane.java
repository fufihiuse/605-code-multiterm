package abstract_classes.interfaces_vs_abstract_classes;

abstract public class Plane implements Honkable, Pilotable {
    final String vehicleType = "airplane";

    public void honk() {
        System.out.println("airplane honk");
    }

    protected String getVehicleType(){
        return vehicleType;
    }
}
