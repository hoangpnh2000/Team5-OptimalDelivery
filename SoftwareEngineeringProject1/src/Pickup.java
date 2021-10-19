public class Pickup {
    public Pickup() {
    }
    public boolean delivered = false;
    public String deliverypoint = "P";

    public static void main(String args[]) {
        Pickup pick1 = new Pickup();
        System.out.println(pick1.delivered);
        System.out.println(pick1.deliverypoint);
    }
}