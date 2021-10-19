
public class Truck {
    //Fields
    public int currentFuel;
    public int fuelCapacity;
    public int locationX;
    public int locationY;
    public int speed;
    public boolean hasPackage;

    //Constructor
    public Truck(int currentFuel, int fuelCapacity, int locationX, int locationY, int speed) {
        this.currentFuel = currentFuel;
        this.fuelCapacity = fuelCapacity;
        this.locationX = locationX;
        this.locationY = locationY;
        this.speed = speed;
    }

    //Get Methods
    public int getCurrentFuel() {
        return this.currentFuel;
    }

    public int getFuelCapacity() {
        return this.fuelCapacity;
    }

    public int getLocationX() {
        return this.locationX;
    }
    public int getLocationY() {
        return this.locationY;
    }

    public int getSpeed() {
        return this.speed;
    }

    //Set methods
    public void setCurrentFuel(int n) {
        this.currentFuel = n;
    }

    public void setFuelCapacity(int n) {
        this.fuelCapacity = n;
    }

    public void setLocationX(int x) {
        this.locationX = x;
    }
    public void setLocationY(int y) {
        this.locationY = y;
    }

    public void setSpeed(int n) {
        this.speed = n;
    }


    //Might be redundant depending on how we want to do refueling
    public void refuel(int n) {
        this.currentFuel += n;
        //Check for overflow
        if (this.currentFuel > this.fuelCapacity) {
            this.currentFuel = this.fuelCapacity;
        }
    }
}
