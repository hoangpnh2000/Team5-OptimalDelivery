
public class DeliveryPoint {

    public boolean delivered = false;
    public int locationX;
    public int locationY;
    public String deliveryPoint = "P";


    public DeliveryPoint(boolean delivered, int locationX, int locationY) {
        this.delivered = delivered;
        this.locationX = locationX;
        this.locationY = locationY;
    }


    //Set methods
    public void setLocation(int x, int y){
        this.locationX = x;
        this.locationY = y;
    }
    public void setIsPickedUp(boolean n){
        this.delivered = n;
    }

    //Get methods
    public int getLocationX(){
        return this.locationX;
    }
    public int getLocationY(){
        return this.locationY;
    }
    public boolean isPickedUp(){
        return this.delivered;
    }

    public static void main(String args[]) {
        DeliveryPoint pick1 = new DeliveryPoint(true, 420, 6969);
        System.out.println(pick1.delivered);
        System.out.println(pick1.deliveryPoint);
    }
}