public class PickUp {
    public PickUp() {
    }
    public boolean PickedUp = false;
    public String PickUpPoint = "P";

    public static void main(String args[]) {
        PickUp pick1 = new PickUp();
        System.out.println(pick1.PickedUp);
        System.out.println(pick1.PickUpPoint);
    }
}