import java.util.*;
import java.util.Arrays;


public class Map {
    //Creates randomized map
    public static String[][] generate (int rows, int columns, int numTrucks, int numPickup, int numDelivery){
        String[][] completedMap = new String[rows][columns];
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

                //Trucks have identifier of int 1
                if (i < numTrucks) {
                    completedMap[temp[i] % rows][temp[i] / rows] = "T";
                }
                //Pickup has identifier of int 1
                else if (i < numPickup + numTrucks) {
                    completedMap[temp[i] % rows][temp[i] / rows] = "P";
                }
                //Delivery has identifier of int 3
                else {
                    completedMap[temp[i] % rows][temp[i] / rows] = "D";
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

}
