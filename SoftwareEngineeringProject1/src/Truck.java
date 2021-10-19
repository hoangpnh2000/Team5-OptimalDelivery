package Team5-OptimalDelivery;

public class Truck {
    //Fields
    public int currentFuel;
    public int fuelCapacity;
    public int location;
    public int speed;

    //Constructor
    public Truck (int currentFuel, int fuelCapacity, int location, int speed) {
        this.currentFuel = currentFuel;
        this.fuelCapacity = fuelCapacity;
        this.location = location;
        this.speed = speed;
    }

    //Get Methods
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

    //Set methods
    public void setCurrentFuel(int n) {
        this.currentFuel = n;
    }
    public void setFuelCapacity(int n) {
        this.fuelCapacity = n;
    }
    public void setLocation(int n){
        this.location = n;
    }
    public void setSpeed(int n){
        this.speed = n;
    }


    //Might be redundant depending on how we want to do refueling
    public void refuel(int n) {
        this.currentFuel += n;
        //Check for overflow
        if (this.currentFuel > this.fuelCapacity){
            this.currentFuel = this.fuelCapacity;
        }
    }
}
