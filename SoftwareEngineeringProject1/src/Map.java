
import java.util.*;
import java.util.Arrays;


public class Map {
    //Global variables
    public static String[][] completedMap;
//    public static Map[][] ;
    public static ArrayList<Truck> listTruck;
    public static ArrayList<Integer> listPickup;
    public static ArrayList<Integer> deliveryLocation;


    //Creates randomized map
    public static String[][] generate (int rows, int columns, int numTrucks, int numPickup, int numDelivery){
        completedMap = new String[rows][columns];
        listTruck = new ArrayList<Truck>();
        listPickup = new ArrayList<Integer>();
        deliveryLocation = new ArrayList<Integer>();
        for (String[] row: completedMap) {
            Arrays.fill(row, "*");
        }
        try {
            //Hashset for uniquely generated ints
            //Will be used to indicate locations in matrix of notable objects
            //Set will be unsorted
            Set<Integer> set = new HashSet<>();
            //Generates random number within range, typecasts to int
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
                    Truck truck = new Truck(50, 100, temp[i]%rows, temp[i] / rows,  60);  //Arbitrary values for now
                    listTruck.add(truck);
                }
                //Pickup has identifier of String "P" in matrix
                else if (i < numPickup + numTrucks) {
                    completedMap[temp[i] % rows][temp[i] / rows] = "P";
                    listPickup.add(temp[i]);
                }
                //Delivery has identifier of String "D" in matrix
                else {
                    completedMap[temp[i] % rows][temp[i] / rows] = "D";
                    deliveryLocation.add(temp[i]);
                }
            }
        }
        catch(Exception e){
            System.out.println("Something went wrong. \nCheck for invalid inputs.");
        }

        //Print for debugging
        for (int i = 0; i < rows; i ++){
            System.out.println();
            for (int j = 0; j < columns; j ++) {
                System.out.print(completedMap[i][j] + " ");
            }
        }
        return completedMap;
    }




    public String CustomException(String message) {
        return message;
        //handle the exception here.
    }
    /*
    //Spits out info for truck location
    public static int findTrucks (String[][] map){

    }
    */
}
