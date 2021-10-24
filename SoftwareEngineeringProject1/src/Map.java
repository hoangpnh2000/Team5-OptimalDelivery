import java.util.*;


public class Map {
    //Global variables
    public static String[][] completedMap;
    public static ArrayList<Truck> listTruck;
    public static ArrayList<PickUp> listPickup;
    public static ArrayList<DeliveryPoint> listDelivery;
    public static WeightedGraph.Graph mapGraph;


    //Creates randomized map
    public static String[][] generate(int rows, int columns, int numTrucks, int numPickup, int numDelivery) {
        completedMap = new String[rows][columns];
        listTruck = new ArrayList<Truck>();
        listPickup = new ArrayList<PickUp>();
        listDelivery = new ArrayList<DeliveryPoint>();
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
            Integer[] temp = set.toArray(new Integer[0]);

            //Iterates through converted set, populates matrix
            for (int i = 0; i < rows; i++) {

                //Trucks have identifier of String "T" in matrix
                if (i < numTrucks) {
                    completedMap[temp[i] % rows][temp[i] / rows] = "T";
                    //Create Truck object, add to list of all available trucks
                    Truck truck = new Truck(50, 100, temp[i] % rows, temp[i] / rows, 60, 0);  //Arbitrary values for now
                    listTruck.add(truck);
                }
                //Pickup has identifier of String "P" in matrix
                else if (i < numPickup + numTrucks) {
                    completedMap[temp[i] % rows][temp[i] / rows] = "P";
                    PickUp pickup = new PickUp(temp[i] % rows, temp[i] / rows, 3);  //Arbitrary values for now

                    listPickup.add(pickup);
                }
                //Delivery has identifier of String "D" in matrix
                else {
                    completedMap[temp[i] % rows][temp[i] / rows] = "D";
                    DeliveryPoint delivery = new DeliveryPoint(false, temp[i] % rows, temp[i] / rows);  //Arbitrary values for now
                    listDelivery.add(delivery);
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong. \nCheck for invalid inputs.");
        }

        //Print for debugging
        for (int i = 0; i < rows; i++) {
            System.out.println();
            for (int j = 0; j < columns; j++) {
                System.out.print(completedMap[i][j] + " ");
            }
        }
        return completedMap;
    }

    //Creates graphical representation of Map
    public void createGraph (int numVertices, ArrayList<Truck> listTruck) {
        mapGraph = new WeightedGraph.Graph(numVertices);
        for (int i = 0; i < listTruck.size(); i++){
            for (int j = 0; j < listPickup.size(); j++){
                int distX = listPickup.get(j).locationX;
                int distY = listPickup.get(j).locationY;
                double dist = Math.sqrt(Math.pow(distX - listTruck.get(i).locationX, 2) + Math.pow(distY - listTruck.get(i).locationY, 2));
                mapGraph.addEdge(i,listTruck.size() + j, dist);
            }
            for (int j = 0; j < listDelivery.size(); j++){
                int distX = listDelivery.get(j).locationX;
                int distY = listDelivery.get(j).locationY;
                double dist = Math.sqrt(Math.pow(distX - listTruck.get(i).locationX, 2) + Math.pow(distY - listTruck.get(i).locationY, 2));
                mapGraph.addEdge(i,listTruck.size() + listPickup.size() + j, dist);
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
