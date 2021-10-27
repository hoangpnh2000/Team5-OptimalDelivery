public class Truck {
    //Fields
    private int currentFuel;
    private int fuelCapacity;
    private int locationX;
    private int locationY;
    private int speed;
    private final int numPackages;
    private final String name;
    private int partition;

    //Constructor
    public Truck(int currentFuel, int fuelCapacity, int locationX, int locationY, int speed, int numPackages, String name, int partition) {
        this.currentFuel = currentFuel;
        this.fuelCapacity = fuelCapacity;
        this.locationX = locationX;
        this.locationY = locationY;
        this.speed = speed;
        this.numPackages = numPackages;
        this.name = name;
        this.partition = partition;
    }

    //Get Methods
    public int getCurrentFuel() {
        return this.currentFuel;
    }

    //Set methods
    public void setCurrentFuel(int n) {
        this.currentFuel = n;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int n) {
        this.speed = n;
    }

    public int getFuelCapacity() {
        return this.fuelCapacity;
    }

    public void setFuelCapacity(int n) {
        this.fuelCapacity = n;
    }

    public int getLocationX() {
        return this.locationX;
    }

    public void setLocationX(int x) {
        this.locationX = x;
    }

    public int getLocationY() {
        return this.locationY;
    }

    public void setLocationY(int y) {
        this.locationY = y;
    }

    public int getPartition() {
        return this.partition;
    }

    public void setPartition(int n) {
        this.partition = n;
    }

    public String getName() {
        return this.name;
    }

    //Might be redundant depending on how we want to do refueling
    public void refuel(int n) {
        this.currentFuel += n;
        //Check for overflow
        if (this.currentFuel > this.fuelCapacity) {
            this.currentFuel = this.fuelCapacity;
        }
    }

    public String toString() {
        return ("Truck at " + this.locationX + this.locationY);
    }
}
