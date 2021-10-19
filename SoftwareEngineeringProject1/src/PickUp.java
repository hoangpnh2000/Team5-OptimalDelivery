public class PickUp {

    public int locationX;
    public int locationY;
    public int numPackages;
    public String pickUpPoint = "P";


    public PickUp(int locationX, int locationY, int numPackages) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.numPackages = numPackages;
    }

    public static void main(String[] args) {
        PickUp pick1 = new PickUp(69, 96, 3);
        System.out.println(pick1.pickUpPoint);
    }

    //Set methods
    public void setLocation(int x, int y) {
        this.locationX = x;
        this.locationY = y;
    }

    //Get methods
    public int getLocationX() {
        return this.locationX;
    }

    public int getLocationY() {
        return this.locationY;
    }
}