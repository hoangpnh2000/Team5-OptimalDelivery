public class PickUp {

    public boolean pickedUp = false;
    public int locationX;
    public int locationY;
    public String pickUpPoint = "P";


    public PickUp(boolean pickedUp, int locationX, int locationY) {
        this.pickedUp = pickedUp;
        this.locationX = locationX;
        this.locationY = locationY;
    }


    //Set methods
    public void setLocation(int x, int y){
        this.locationX = x;
        this.locationY = y;
    }
    public void setIsPickedUp(boolean n){
        this.pickedUp = n;
    }

    //Get methods
    public int getLocationX(){
        return this.locationX;
    }
    public int getLocationY(){
        return this.locationY;
    }
    public boolean isPickedUp(){
        return this.pickedUp;
    }

    public static void main(String args[]) {
        PickUp pick1 = new PickUp(true, 69, 96);
        System.out.println(pick1.pickedUp);
        System.out.println(pick1.pickUpPoint);
    }
}