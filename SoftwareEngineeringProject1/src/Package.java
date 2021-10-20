public class Package {
    //Fields
    public boolean onTruck;
    public boolean delivered;
    public int originX;
    public int originY;

    //Constructor
    public Package(boolean onTruck, boolean delivered, int originX, int originY) {
        this.onTruck = onTruck;
        this.delivered = delivered;
        this.originX = originX;
        this.originY = originY;
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
}
