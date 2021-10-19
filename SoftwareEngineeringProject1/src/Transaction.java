public class Transaction {
    private final DeliveryPoint deliveryPoint;
    private final PickUp pickupPoint;

    public Transaction(PickUp p, DeliveryPoint d) {
        this.pickupPoint = p;
        this.deliveryPoint = d;
    }

    public PickUp getPickupPoint() {
        return this.pickupPoint;
    }

    public DeliveryPoint getDeliveryPoint() {

        return this.deliveryPoint;
    }
}
