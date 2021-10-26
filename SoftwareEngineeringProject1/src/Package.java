public class Package {
    //Fields
    public boolean onTruck;
    public boolean delivered;
    public int originX;
    public int originY;
    public int destinationX;
    public int destinationY;

    //Constructor
    public Package(boolean onTruck, boolean delivered, int originX, int originY, int destinationX, int destinationY) {
        this.onTruck = onTruck;
        this.delivered = delivered;
        this.originX = originX;
        this.originY = originY;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
    }

    public int getOriginX() {
        return this.originX;
    }

    public void setOriginX(int x) {
        this.originX = x;
    }

    public int getOriginY() {
        return this.originY;
    }

    public void setOriginY(int y) {
        this.originY = y;
    }
    public int getDestinationX() {
        return this.destinationX;
    }

    public void setDestinationX(int x) {
        this.destinationX = x;
    }

    public int getDestinationY() {
        return this.destinationY;
    }

    public void setDestinationY(int y) {
        this.destinationY = y;
    }

    public static void main(String[] args) {
        //Package whatever = new Package(false, false, 10, 20);
    }
    public String toString(){
        return("Package being delivered to " + this.originX + this.originY);
    }
}
