public class Package {
    //Fields
    public boolean isPickedUp;
    public boolean isDelivered;
    public int originX;
    public int originY;

    //Constructor
    public Package(boolean isPickedUp, boolean isDelivered, int originX, int originY) {
        this.isPickedUp = isPickedUp;
        this.isDelivered = isDelivered;
        this.originX = originX;
        this.originY = originY;
    }

    public boolean isPickedUp() {
        return this.isPickedUp;
    }

    public boolean isDelivered() {
        return this.isDelivered;
    }

    public int getOriginX() {
        return this.originX;
    }

    public int getOriginY() {
        return this.originY;
    }

    public void setOriginX(int x) {
        this.originX = x;
    }

    public void setOriginY(int y) {
        this.originY = y;
    }
}
