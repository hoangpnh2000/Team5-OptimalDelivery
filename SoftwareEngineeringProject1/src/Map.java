import java.util.ArrayList;
import java.util.*;
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
        int stupid = numTrucks;

        try {
            //Hashset for uniquely generated ints
            //Will be used to indicate locations in matrix of notable objects
            //Set will be unsorted
            Set<Integer> set = new HashSet<>();
            //Generates random number within range, cast to int
            //System.out.println("numTrucks is of size " + numTrucks);
            //System.out.println("numPickup is of size " + numPickup);
            int max = rows * columns - 1;
            int min = 0;
            while (set.size() != (numTrucks + numPickup)){
                int temp = (int) Math.floor(Math.random() * (max - min + 1) + min);
                set.add(temp);
            }
            //Convert set to List for easier manipulation
            //System.out.println("the size of the set is " + set.size());
            //System.out.println("the size of the set is supposed to be " + (numPickup+numTrucks));
            //System.out.println("This is the set prior to making graph:      " + set);
            //Randomizes set and casts to int array
            int[] temp = Arrays.stream(set.toArray(new Integer[0])).mapToInt(i->i).toArray();

            RandomizeArray(temp);
            //Iterates through converted set, populates matrix
            int tempTruck = 1;
            int tempPickup = 1;
            for (Integer integer : temp) {
                /*
                    Trucks have identifier from 0 to numTrucks-1 (inclusive)
                    Pickup locations have an identifier from numTrucks to  numTrucks+numPickup
                    Delivery locations have identifier from numTrucks+numPickup to numTrucks+numPickup+numDelivery
                 */
                //Trucks have identifier of String "T" in matrix
                if (numTrucks > 0) {
                    completedMap[integer % rows][integer / rows] = "T";
                    //Create Truck object, add to list of all available trucks
                    Truck truck = new Truck(50, 100, integer % rows, integer / rows, 60, 0, "Truck " + tempTruck, -1);  //Arbitrary values for now
                    tempTruck++;
                    listTruck.add(truck);
                    numTrucks--;
                }
                //Pickup has identifier of String "P" in matrix
                else {
                    completedMap[integer % rows][integer / rows] = "P";
                    PickUp pickup = new PickUp(integer % rows, integer / rows, 3, PickUp.packageArrayList, "Pick up point " + tempPickup);  //Arbitrary values for now
                    tempPickup++;
                    listPickup.add(pickup);
                    PickUp.generatePackages(pickup.locationX, pickup.locationY);  //Generate packages for pickup location
                    //System.out.println(listPickup.get(i).getName());
                }
            }
        } catch (Exception e) {
            //System.out.println("Something went wrong. \nCheck for invalid inputs.");
        }


        //System.out.println("There are supposed to be " + stupid);
        //System.out.println("There are actually " + listTruck.size());
        /*
        //Print for debugging
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                //System.out.print(completedMap[i][j] + " ");
            }
            //System.out.println();
        }
        */
        return completedMap;
    }
    public static int[] RandomizeArray(int[] array){
        Random rand = new Random();  // Random number generator

        for (int i=0; i<array.length; i++) {
            int randomPosition = rand.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }

        return array;
    }
/*
    public static String[][] updateMap(ArrayList<PickUp> listPickup) {

        for (int i = 0; i < listPickup.size(); i++){
            for (int j = 0; j < listPickup.get(i).packageArrayList.size(); j++){
                completedMap[listPickup.get(i).packageArrayList.get(j).destinationX][listPickup.get(i).packageArrayList.get(j).destinationY]
            }
        }








        for (int i = 0; i < completedMap.length; i++){
            for (int j = 0; i < completedMap[0].length; j++){

            }
        }
        return completedMap;
    }
*/

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
                String deliveryName = "Delivery " + i;
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
