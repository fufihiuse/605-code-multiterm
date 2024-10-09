package abstract_classes.interfaces_vs_abstract_classes;

abstract public class Car implements Honkable, Driveable {
    int numberOfWheels = 4;

    final String vehicleType = "car";

    public void honk() {
        System.out.println("car honk");
    }

    protected String getVehicleType()
    {
        return vehicleType;
    }
}
