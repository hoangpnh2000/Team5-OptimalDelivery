package Team5-OptimalDelivery;

public class Truck {
    //Fields
    public int currentFuel;
    public int fuelCapacity;
    public int location;
    public int speed;
    public int speedIncrement;

    //Constructor
    public Truck (int type, int model, int color) {
        this.currentFuel = currentFuel;
        this.fuelCapacity = fuelCapacity;
        this.location = location;
        this.speed = speed;
        this.speedIncrement = speedIncrement;
    }

    //Methods
    public int getCurrentFuel(){
        return this.currentFuel;
    }
    public int getFuelCapacity(){
        return this.fuelCapacity;
    }
    public int getLocation(){
        return this.location;
    }
    public int getSpeed(){
        return this.speed;
    }

    public void incrementSpeed (int n) {
        this.speed = this.speed + n;
    }
    public void refuel() {
        this.currentFuel = fuelCapacity;
    }
}
