public class PickUp {

    public boolean pickedUp = false;
    public int location;
    public String pickUpPoint = "P";


    public PickUp(boolean pickedUp, int location) {
        this.pickedUp = pickedUp;
        this.location = location;
    }


    //Set methods
    public void setLocation(int n){
        this.location = n;
    }
    public void setIsPickedUp(boolean n){
        this.pickedUp = n;
    }

    //Get methods
    public int getLocation(){
        return this.location;
    }
    public boolean isPickedUp(){
        return this.pickedUp;
    }

    public static void main(String args[]) {
        PickUp pick1 = new PickUp(true, 69);
        System.out.println(pick1.pickedUp);
        System.out.println(pick1.pickUpPoint);
    }
}