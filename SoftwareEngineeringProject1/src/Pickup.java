public class Pickup {
    public Pickup() {
    }
    public boolean PickedUp = false;
    public String PickUpPoint = "P";

    public static void main(String args[]) {
        Pickup pick1 = new Pickup();
        System.out.println(pick1.PickedUp);
        System.out.println(pick1.PickUpPoint);
    }
}