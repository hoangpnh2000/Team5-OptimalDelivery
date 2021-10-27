public class Truck {
    //Fields
    private int currentFuel;
    private int fuelCapacity;
    private int locationX;
    private int locationY;
    private int speed;
    private int numPackages;
    private String name;
    private double partitionAngle1;
    private double partitionAngle2;

    //Constructor
    public Truck(int currentFuel, int fuelCapacity, int locationX, int locationY, int speed, int numPackages, String name, double partitionAngle1, double partitionAngle2) {
        this.currentFuel = currentFuel;
        this.fuelCapacity = fuelCapacity;
        this.locationX = locationX;
        this.locationY = locationY;
        this.speed = speed;
        this.numPackages = numPackages;
        this.name = name;
        this.partition = -1;
    }

    //Get Methods
    public int getCurrentFuel() {
        return this.currentFuel;
    }

    public int getSpeed() {
        return this.speed;
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

    public double getPartitionAngle2() {
        return this.partitionAngle2;
    }

    public double getPartitionAngle1() {
        return this.partitionAngle1;
    }

    public String getName() {return this.name;}

    //Set methods
    public void setCurrentFuel(int n) {
        this.currentFuel = n;}

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

    public void setPartitionAngle1 (double angle1){
        this.partitionAngle1 = angle1;
    }

    public void setPartitionAngle2 (double angle2) {
        this.partitionAngle2 = angle2;
    }

=    public void setPartition(int partition) {
        this.partition;
    }

    //Might be redundant depending on how we want to do refueling
    public void refuel(int n) {
        this.currentFuel += n;
        //Check for overflow
        if (this.currentFuel > this.fuelCapacity) {
            this.currentFuel = this.fuelCapacity;
        }
    }
    public String toString(){
        return("Truck at " + this.locationX + this.locationY);
    }
}
