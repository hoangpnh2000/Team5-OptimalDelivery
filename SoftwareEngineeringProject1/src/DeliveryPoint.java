
public class DeliveryPoint {

    public boolean delivered = false;
    public int location;
    public String deliveryPoint = "P";


    public DeliveryPoint(boolean delivered, int location) {
        this.delivered = delivered;
        this.location = location;
    }


    //Set methods
    public void setLocation(int n){
        this.location = n;
    }
    public void setIsPickedUp(boolean n){
        this.delivered = n;
    }

    //Get methods
    public int getLocation(){
        return this.location;
    }
    public boolean isPickedUp(){
        return this.delivered;
    }

    public static void main(String args[]) {
        DeliveryPoint pick1 = new DeliveryPoint(true, 420);
        System.out.println(pick1.delivered);
        System.out.println(pick1.deliveryPoint);
    }
}