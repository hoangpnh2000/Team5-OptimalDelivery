import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Map {
    //Global variables
    public static String[][] completedMap;
    public static ArrayList<Truck> listTruck;
    public static ArrayList<PickUp> listPickup;
    public static ArrayList<DeliveryPoint> listDelivery;
    public static WeightedGraph.GraphWeighted mapGraph;
    public static int mapX;
    public static int mapY;

    //Creates randomized map
    public static String[][] generate(int rows, int columns, int numTrucks, int numPickup) {
        mapX = columns;
        mapY = rows;
        completedMap = new String[rows][columns];
        listTruck = new ArrayList<>();
        listPickup = new ArrayList<>();
        listDelivery = new ArrayList<>();
        for (String[] row : completedMap) {
            Arrays.fill(row, "*");
        }
        try {
            //Hashset for uniquely generated ints
            //Will be used to indicate locations in matrix of notable objects
            //Set will be unsorted
            Set<Integer> set = new HashSet<>();
            //Generates random number within range, cast to int
            for (int i = 0; i < numTrucks + numPickup ; i++) {
                int max = rows * columns - 1;
                int min = 0;
                int temp = (int) Math.floor(Math.random() * (max - min + 1) + min);
                set.add(temp);
            }
            //Convert set to array for easier manipulation
            System.out.println("the size of the set is " + set.size());
            Integer[] temp = new Integer[set.size()];
            set.toArray(temp);

            int tempTruck = 1;
            int tempPickup = 1;
            int convenientFix = 0; //Literally don't worry about it
            //Iterates through converted set, populates matrix
            for (Integer integer : temp) {
                /*
                    Trucks have identifier from 0 to numTrucks-1 (inclusive)
                    Pickup locations have an identifier from numTrucks to  numTrucks+numPickup
                    Delivery locations have identifier from numTrucks+numPickup to numTrucks+numPickup+numDelivery
                 */
                //Trucks have identifier of String "T" in matrix
                if (convenientFix == 0) {
                    completedMap[integer % rows][integer / rows] = "T";
                    //Create Truck object, add to list of all available trucks
                    Truck truck = new Truck(50, 100, integer % rows, integer / rows, 60, 0, "Truck " + tempTruck, -1);  //Arbitrary values for now
                    tempTruck++;
                    listTruck.add(truck);
                    convenientFix++;
                }
                //Pickup has identifier of String "P" in matrix
                else {
                    completedMap[integer % rows][integer / rows] = "P";
                    PickUp pickup = new PickUp(integer % rows, integer / rows, 3, PickUp.packageArrayList, "Pick up point " + tempPickup);  //Arbitrary values for now
                    tempPickup++;
                    listPickup.add(pickup);
                    PickUp.generatePackages(pickup.locationX, pickup.locationY);  //Generate packages for pickup location
                    //System.out.println(listPickup.get(i).getName());
                    convenientFix = 0;
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong. \nCheck for invalid inputs.");
        }

        //Print for debugging
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(completedMap[i][j] + " ");
            }
            System.out.println();
        }
        return completedMap;
    }

    //Creates graphical representation of Map
    public void createGraph(ArrayList<Truck> listTruck, ArrayList<PickUp> listPickup, ArrayList<DeliveryPoint> listDelivery) {
        mapGraph = new WeightedGraph.GraphWeighted();
        for (int i = 0; i < listTruck.size(); i++) {
            String truckName = "Truck " + i + 1;
            WeightedGraph.NodeWeighted truck = new WeightedGraph.NodeWeighted(truckName);

            for (PickUp pickUp : listPickup) {
                int distX = pickUp.getLocationX();
                int distY = pickUp.getLocationY();
                double dist = Math.sqrt(Math.pow(distX - listTruck.get(i).getLocationX(), 2) + Math.pow(distY - listTruck.get(i).getLocationY(), 2));

                String pickupName = "Pickup " + i + 1;
                WeightedGraph.NodeWeighted pickup = new WeightedGraph.NodeWeighted(pickupName);
                mapGraph.addEdge(truck, pickup, dist);
            }
            for (DeliveryPoint deliveryPoint : listDelivery) {
                int distX = deliveryPoint.getLocationX();
                int distY = deliveryPoint.getLocationY();
                double dist = Math.sqrt(Math.pow(distX - listTruck.get(i).getLocationX(), 2) + Math.pow(distY - listTruck.get(i).getLocationY(), 2));

                String deliveryName = "Delivery " + i + 1;
                WeightedGraph.NodeWeighted delivery = new WeightedGraph.NodeWeighted(deliveryName);
                mapGraph.addEdge(truck, delivery, dist);
            }
        }
        //Truck truck = new Truck(50, 100, temp[i] % rows, temp[i] / rows, 60, 0);  //Arbitrary values for now
    }

    /*
    //Spits out info for truck location
    public static int findTrucks (String[][] map){

    }
    */
}
