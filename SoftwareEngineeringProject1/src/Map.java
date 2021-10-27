import java.util.*;
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
    public static String[][] generate(int rows, int columns, int numTrucks, int numPickup, int numDelivery) {
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
            for (int i = 0; i < numTrucks + numPickup + numDelivery; i++) {
                int max = rows * columns - 1;
                int min = 0;
                int temp = (int) Math.floor(Math.random() * (max - min + 1) + min);
                set.add(temp);
            }
            //Convert set to array for easier manipulation
            System.out.println("the sizew of the set is " + set.size());
            Integer[] temp = new Integer[set.size()];
            set.toArray(temp);



            //Iterates through converted set, populates matrix
            for (int i = 0; i < temp.length; i++) {
                /*
                    Trucks have identifier from 0 to numTrucks-1 (inclusive)
                    Pickup locations have an identifier from numTrucks to  numTrucks+numPickup
                    Delivery locations have identifier from numTrucks+numPickup to numTrucks+numPickup+numDelivery
                 */
                //Trucks have identifier of String "T" in matrix
                if (i < numTrucks) {
                    completedMap[temp[i] % rows][temp[i] / rows] = "T";
                    //Create Truck object, add to list of all available trucks
                    Truck truck = new Truck(50, 100, temp[i] % rows, temp[i] / rows, 60, 0,"Truck" + i, -1);  //Arbitrary values for now
                    listTruck.add(truck);
                }
                //Pickup has identifier of String "P" in matrix
                else if (i < numTrucks + numPickup) {
                    completedMap[temp[i] % rows][temp[i] / rows] = "P";
                    PickUp pickup = new PickUp(temp[i] % rows, temp[i] / rows, 3, PickUp.packageArrayList,"Pick up point" + i);  //Arbitrary values for now
                        listPickup.add(pickup);
                    pickup.generatePackages(pickup.locationX, pickup.locationY);  //Generate packages for pickup location

                    //System.out.println(listPickup.get(i).getName());
                }
                //Delivery has identifier of String "D" in matrix
                else {
                    completedMap[temp[i] % rows][temp[i] / rows] = "D";
                    DeliveryPoint delivery = new DeliveryPoint(false, temp[i] % rows, temp[i] / rows, "Delivery point "+ i);  //Arbitrary values for now
                    listDelivery.add(delivery);
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
    public void createGraph (ArrayList<Truck> listTruck, ArrayList<PickUp> listPickup, ArrayList<DeliveryPoint> listDelivery) {
        mapGraph = new WeightedGraph.GraphWeighted();
        for (int i = 0; i < listTruck.size(); i++){
            String truckName = "Truck " + i + 1;
            WeightedGraph.NodeWeighted truck = new WeightedGraph.NodeWeighted(truckName);

            for (int j = 0; j < listPickup.size(); j++){
                int distX = listPickup.get(j).getLocationX();
                int distY = listPickup.get(j).getLocationY();
                double dist = Math.sqrt(Math.pow(distX - listTruck.get(i).getLocationX(), 2) + Math.pow(distY - listTruck.get(i).getLocationY(), 2));

                String pickupName = "Pickup " + i + 1;
                WeightedGraph.NodeWeighted pickup = new WeightedGraph.NodeWeighted(pickupName);
                mapGraph.addEdge(truck, pickup, dist);
            }
            for (int j = 0; j < listDelivery.size(); j++){
                int distX = listDelivery.get(j).getLocationX();
                int distY = listDelivery.get(j).getLocationY();
                double dist = Math.sqrt(Math.pow(distX - listTruck.get(i).getLocationX(), 2) + Math.pow(distY - listTruck.get(i).getLocationY(), 2));

                String deliveryName = "Delivery " + i + 1;
                WeightedGraph.NodeWeighted delivery = new WeightedGraph.NodeWeighted(deliveryName);
                mapGraph.addEdge(truck,delivery, dist);
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
