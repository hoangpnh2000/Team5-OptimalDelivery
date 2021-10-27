import java.util.*;
public class PickUp {

    public int locationX;
    public int locationY;
    private int numPackages;
    private String pickUpPoint = "P";
    private String name;
    public static ArrayList<Package> packageArrayList = new ArrayList<Package>();



    public PickUp(int locationX, int locationY, int numPackages,ArrayList<Package> packageArrayList, String name) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.numPackages = numPackages;
        this.packageArrayList = packageArrayList;
        this.name = name;
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

    public PickUp(){

    }
=======
>>>>>>> parent of 1d9b08c (Update Route)
=======
=======
>>>>>>> parent of 1d9b08c (Update Route)
=======
>>>>>>> parent of 1d9b08c (Update Route)

>>>>>>> parent of 1d9b08c (Update Route)

    //Set methods
    public void setLocation(int x, int y) {
        this.locationX = x;
        this.locationY = y;
    }

    public static void generatePackages(int pickupX, int pickupY){
        int max = 3;
        int min = 1;
        int temp1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
        int temp2 = (int) Math.floor(Math.random() * (max - min + 1) + min);

        while (Map.completedMap[temp1][temp2] != "*"){
            temp1 = (int) Math.floor(Math.random() * (max - min + 1) + min);
            temp2 = (int) Math.floor(Math.random() * (max - min + 1) + min);
        }

        packageArrayList.add(new Package(false, false, pickupX,pickupY, temp1, temp2));
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
        return("Pick up point at: " +"X= "+ this.locationX +"Y= "+ this.locationY);
    }



}