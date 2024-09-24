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

//    protected abstract String getVehicleType();
//    {
//        return vehicleType;
//    }
}
