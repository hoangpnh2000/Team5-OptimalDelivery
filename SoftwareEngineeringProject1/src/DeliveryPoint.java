public class DeliveryPoint {

    private boolean delivered = false;
    private int locationX;
    private int locationY;
    private String deliveryPoint = "P";
    private String name;


    public DeliveryPoint(boolean delivered, int locationX, int locationY, String name) {
        this.delivered = delivered;
        this.locationX = locationX;
        this.locationY = locationY;
        this.name = name;
    }

    public static void main(String[] args) {
        DeliveryPoint pick1 = new DeliveryPoint(true, 420, 6969, "Idk");
        System.out.println(pick1.delivered);
        System.out.println(pick1.deliveryPoint);
    }

    //Set methods
    public void setLocation(int x, int y) {
        this.locationX = x;
        this.locationY = y;
    }

    public void setIsPickedUp(boolean n) {
        this.delivered = n;
    }

    //Get methods
    public int getLocationX() {
        return this.locationX;
    }

    public int getLocationY() {
        return this.locationY;
    }

    public boolean isPickedUp() {
        return this.delivered;
    }

    public String toString(){
        return("Delivery point at " + this.locationX + this.locationY);
    }


}