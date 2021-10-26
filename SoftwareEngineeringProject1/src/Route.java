import org.w3c.dom.Node;

import java.util.ArrayList;

public class Route {

    private ArrayList<ArrayList<String> > routes;//string of names based on the delivery, pickup and truck number
    private ArrayList<ArrayList<WeightedGraph.Graph> > partitions; //arraylist of graphs using partitions
    private WeightedGraph.Graph pickGraph;//graph for pickup points and trucks

    public Route()
    {
        this.routes =  new ArrayList<ArrayList<String> >();
        this.partitions = new ArrayList<>();

    }
    //create weighted graph of whole graph with pick up points and trucks being the nodes(use maps createGraph function)
    //use dikjstras to find the best pickup point route for trucks as whole
    //assign quadrants based on where the truck last went to
    //we first go to each pickup point for each truck
    //access variables using the global variables
    //Then we want to split up the graph into partitions
    //generate a new graph for each partition
    //use dikjstras to find best route for delivery points




    //Obsolete due to createGraph in Graph class


    public static double distance(int truckX, int truckY, int x, int y) {
        for (int i = 0; i < Map.listDelivery.size(); i++) {
            int distX = x - truckX;
            int distY = y - truckY;
            double distance = Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));
            String routeDirections = "";

            if (distY != 0) {
                if (distY < 0) {
                    routeDirections += "HEAD SOUTH " + distY * (-1) + " UNITS. ";
                } else {
                    routeDirections += "HEAD NORTH " + distY + " UNITS. ";
                }
            }

            if (distX != 0) {
                if (distY != 0) {
                    routeDirections += "THEN, ";
                }
                if (distX < 0) {
                    routeDirections += "HEAD WEST " + distX * (-1) + " UNITS";
                } else {
                    routeDirections += "HEAD EAST " + distX + " UNITS";
                }
            }
            truckX = x;
            truckY = y;
            return distance;
        }

    //Returns the index of the shortest distance
    public static int findShortest (double [] distanceArray){
        double temp = distanceArray[0];
        try{
            for (double i : distanceArray){
                if (distanceArray[(int)i] < temp){
                    temp = i;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Index OOB");
        }
        return (int)temp;
    }

    public static void main(String[] args) {
            ArrayList<String> Directions = new List<String>();
            for (int i = 0; i < map.listDelivery.size()+1; i++){
                Directions.add(distance(Map.listTruck(i).getLocationX, Map.listTruck(i).getLocationY), Map.listPickup(i).PickUp.getLocationX, Map.listPickup(i)PickUp.getLocationY);
                Directions.add(distance(Map.listTruck(i).getLocationX, Map.listTruck(i).getLocationY), Map.listPickup(i).PickUp.getLocationX, Map.listPickup(i)PickUp.getLocationY);
            }

        }
        //System.out.println(distance(0, 0, 1, 1));
    }
    public String toString(){
        for(int i=0 ; i < )
    }
}




/*


How do I determine which truck goes to which pickup location
How do i determine what packages each truck picks up at each pickup location
How do I determine whether or not a truck visits another pickup location?




Num trucks < num pickup locations
    Each truck goes to nearest unoccupied pickup location and picks up all packages
    Uses dijkstra algorithm to find the shortest route to deliver all packages for each truck
    If the truck is within n tiles of another unclaimed pickup station OR if truck is done with all packages, reroutes to the unclaimed pickup station
        Reuses dijkstra algorithm to find the new shortest path
    Day ends when all packages have been delivered

Num trucks == num pickup locations
    Find average distance each truch is from all the pickup locations
        Truck with highest average gets to choose the closest pickup location
        Truck with next highest average then chooses its closest pickup location that is available
        etc...
    Uses dijkstra algorithm to find the shortest route to deliver all packages for each truck

Num Trucks > num pickup locations
    Find average distance each PICKUP LOCATION is from all the trucks
        Pickup location that has the highest average distance gets assigned Trucks/pickup.floor() + 1
        Pickup location with second highest average distance gets assigned Trucks/pickup.floor() + 1 if Trucks%pickup > 1
    Uses dijkstra algorithm to find the shortest route to deliver all packages for each truck


    Formula to check if truck will be designated an extra truck
        for (int i = numTrucks%numPickUp; i != 0; i--){
            //Pickuplocation will be designated "numTrucks/numPickUp + 1" trucks
        }






lengthofroute/numpakcages to find the most efficient route
 */

