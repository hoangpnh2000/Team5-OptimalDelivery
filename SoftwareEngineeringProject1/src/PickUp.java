import java.util.*;
public class PickUp {

    private int locationX;
    private int locationY;
    private int numPackages;
    private String pickUpPoint = "P";
    private String name;
    public static ArrayList<Package> packageArrayList;


    public PickUp(int locationX, int locationY, int numPackages, ArrayList<Package> packageArrayList, String name) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.numPackages = numPackages;
        this.packageArrayList = packageArrayList;
        this.name = name;
    }


    //Set methods
    public void setLocation(int x, int y) {
        this.locationX = x;
        this.locationY = y;
    }

    public static void generatePackages(int pickupX, int pickupY){
        int max = Map.mapX * Map.mapY - 1;
        int min = 0;
        int temp1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
        int temp2 = (int) Math.floor(Math.random() * (max - min + 1) + min);

        //Makes sure package does not get assigned delivery location that is already occupied
        //Awful way to do this :(
        for (int i = 0; i < Map.listTruck.size(); i++){
            if (Map.listTruck.get(i).getLocationX() == temp1 || Map.listDelivery.get(i).getLocationX() == temp1 || Map.listPickup.get(i).getLocationX() == temp1){
                temp1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
            }
            if (Map.listTruck.get(i).getLocationY() == temp2 || Map.listDelivery.get(i).getLocationY() == temp2 || Map.listPickup.get(i).getLocationY() == temp2){
                temp2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
            }
            i = 0;
        }
        Package pack = new Package(false, false, pickupX,pickupY, temp1, temp2);
        packageArrayList.add(pack);
    }

    //Get methods
    public int getLocationX() {
        return this.locationX;
    }

    public int getLocationY() {
        return this.locationY;
    }
    public String getName() {
    	return this.name;
    }
    
    public ArrayList<Package> getPackageArrayList(){
        return packageArrayList;
    }
    public void printPackages(){
        for (int i = 0; i < numPackages; i++){
            System.out.print(packageArrayList.get(i).toString());
        }
    }


/*
    public static void main(String[] args) {
        PickUp pick1 = new PickUp(69, 96, 5);
        pick1.generatePackages(5,23,42);
        for (int i =0; i< pick1.packageArrayList.size(); i++){

        }
        pick1.printPackages();
    }
*/
    public String toString(){
        return("Pick up point at " + this.locationX + this.locationY);
    }



}