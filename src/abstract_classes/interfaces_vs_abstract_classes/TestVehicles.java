public class TestVehicles {
    static public void main (String ...args) {
        Camry myCamry = new Camry();
        System.out.println("what vehicle is this? "+ myCamry.getVehicleType());
        System.out.println("is this a toyota? "+ myCamry.isThisAToyotaCar());
        System.out.println("how much is it? " + myCamry.checkPrice());
        myCamry.honk();

        Accord myAccord = new Accord();
        System.out.println("what vehicle is this? "+ myAccord.getVehicleType());
        System.out.println("is this a honda? " + myAccord.isThisAHondaCar());
        System.out.println("how much is it? " + myAccord.checkPrice());
        myAccord.honk();

        B737 myB737 = new B737();
        System.out.println("what vehicle is this? "+ myB737.getVehicleType());
        System.out.println("is this a boeing? "+ myB737.isThisABoeing());
        System.out.println("how much warranty? " + myB737.checkWarranty());
        myB737.honk();

        A321 myA321 = new A321();
        System.out.println("what vehicle is this? "+ myA321.getVehicleType());
        System.out.println("is this a boeing? "+ myA321.isThisAnAirbus());
        System.out.println("how much warranty? " + myA321.checkWarranty());
        myA321.honk();

    }

}
