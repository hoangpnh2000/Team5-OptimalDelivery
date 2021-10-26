import java.util.ArrayList;

public class Route {

    private final ArrayList<ArrayList<String>> routes;//string of names based on the delivery, pickup and truck number
    //private ArrayList<ArrayList<WeightedGraph> > partitions; //arraylist of graphs using partitions
    //private WeightedGraph pickGraph;//graph for pickup points and trucks
    private final ArrayList<ArrayList<String>> partitions; //arraylist of graphs using partitions

    public Route() {
        this.routes = new ArrayList<ArrayList<String>>();
        this.partitions = new ArrayList<>();

    }

    public static String makeDirections(int truckX, int truckY, int x, int y) {
        String routeDirections = "";
        for (int i = 0; i < Map.listDelivery.size() - 1; i++) {
            int distX = x - truckX;
            int distY = y - truckY;
            if (distY != 0) {
                if (distY < 0) {
                    routeDirections += "HEAD SOUTH " + distY + " UNITS. ";
                } else {
                    routeDirections += "HEAD NORTH " + distY + " UNITS. ";
                }
            }

            if (distX != 0) {
                if (distY != 0) {
                    routeDirections += "THEN, ";
                }
                if (distX < 0) {
                    routeDirections += "HEAD WEST " + distX + " UNITS";
                } else {
                    routeDirections += "HEAD EAST " + distX + " UNITS";
                }
            }
            truckX = x;
            truckY = y;
            x = Map.listDelivery.get(i + 1).getLocationX();
            y = Map.listDelivery.get(i + 1).getLocationY();
        }
        return routeDirections;
    }

    //Returns the index of the shortest distance
    public static int findShortest(double[] distanceArray) {
        double temp = distanceArray[0];
        try {
            for (double i : distanceArray) {
                if (distanceArray[(int) i] < temp) {
                    temp = i;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index OOB");
        }
        return (int) temp;
    }


    //Obsolete due to createGraph in Graph class

    public static void main(String[] args) {
        ArrayList<Package> packageList = new ArrayList<Package>();
        ArrayList<String> Directions = new ArrayList<String>();
        for (int i = 0; i < Map.listPickup.size(); i++) {
            packageList = Map.listPickup.get(i).getPackageArrayList();
            for (int j = 0; j < packageList.size(); j++) {
                Directions.add(makeDirections(Map.listTruck.get(i).getLocationX(), Map.listTruck.get(i).getLocationY(), Map.listPickup.get(i).getLocationX(), Map.listPickup.get(i).getLocationY()));
                Directions.add(makeDirections(Map.listTruck.get(i).getLocationX(), Map.listTruck.get(i).getLocationY(), packageList.get(j).getDestinationX(), packageList.get(j).getDestinationY()));
            }
        }
    }

    //create weighted graph of whole graph with pick up points and trucks being the nodes(use maps createGraph function)
    //use dijkstras to find the best pickup point route for trucks as whole
    //assign quadrants based on where the truck last went to
    //we first go to each pickup point for each truck
    //access variables using the global variables
    //Then we want to split up the graph into partitions
    //generate a new graph for each partition
    //use dijkstras to find best route for delivery points
	/*
	public void createFirstGraph() {
		int numVertices = Map.listTruck.size() + Map.listPickup.size();
		//this.pickGraph = new WeightedGraph( , numVertices);
		for (int i = 0; i < Map.listTruck.size(); i++) {
			for (int j = 0; j < Map.listPickup.size(); j++) {
				int distX = Map.listPickup.get(j).getLocationX();
				int distY = Map.listPickup.get(j).getLocationY();
				double dist = Math.sqrt(Math.pow(distX - Map.listTruck.get(i).getLocationX(), 2) + Math.pow(distY - Map.listTruck.get(i).getLocationY(), 2));
				//this.pickGraph.addEdgeHelper(i, Map.listTruck.size() + j,(int) dist);
			}
		}
	}*/
    public void initialBestRoute() {//finding best route for pick up and trucks
        //initializing first pickup point for each truck (closest one to go to)
        String temp;//temporary variable to store pick up name location
        double small;//shortest distance temp variable
        int ind;//index to remove
        ArrayList<PickUp> tempPick = Map.listPickup;
        for (int i = 0; i < Map.listTruck.size(); i++) {
            while (tempPick.size() > 0) {
                this.routes.get(i).add(Map.listTruck.get(i).getName());
                small = Math.sqrt(Math.pow(Map.listTruck.get(i).getLocationX() - tempPick.get(1).getLocationX(), 2) + Math.pow(Map.listTruck.get(i).getLocationY() - tempPick.get(1).getLocationY(), 2));
                temp = tempPick.get(1).getName();
                ind = 1;
                for (int j = 0; j < tempPick.size(); j++) {
                    if (small > Math.sqrt(Math.pow(Map.listTruck.get(i).getLocationX() - tempPick.get(j).getLocationX(), 2) + Math.pow(Map.listTruck.get(i).getLocationY() - tempPick.get(j).getLocationY(), 2))) {
                        small = Math.sqrt(Math.pow(Map.listTruck.get(i).getLocationX() - tempPick.get(j).getLocationX(), 2) + Math.pow(Map.listTruck.get(i).getLocationY() - tempPick.get(j).getLocationY(), 2));
                        temp = tempPick.get(j).getName();
                        ind = j;
                    }
                }
                this.routes.get(i).add(temp);
                tempPick.remove(ind);
            }
            tempPick = Map.listPickup;
        }
    }

    //create partitions and assign trucks
    //traverse through deliveries
    public void createPartitions() {
        double temp = Map.listTruck.size();
        double highestFactor = temp;
        int numHorizontalPartition;
        int numVerticalPartition;

        double sqRoot = Math.pow(Map.listTruck.size(), 0.5);
        for (int i = 0; i < sqRoot; i++) {
            if (Map.listTruck.size() % i == 0) {
                if (i - sqRoot < (double) Map.listTruck.size()) {
                    highestFactor = i;
                }
            }
        }
        numHorizontalPartition = (int) highestFactor;
        numVerticalPartition = Map.listTruck.size() / numHorizontalPartition;
        double previ = 0, prevj = 0;


        for (double i = 100 / numHorizontalPartition; i < 100; i = i + 100 / numHorizontalPartition) {
            for (double j = 100 / numVerticalPartition; j < 100; j = j + 100 / numVerticalPartition) {
                for (int k = 0; k < Map.listDelivery.size(); k++) {
                    if (Map.listDelivery.get(k).getLocationX() > prevj && Map.listDelivery.get(k).getLocationX() < j
					&& Map.listDelivery.get(k).getLocationY() > previ && Map.listDelivery.get(k).getLocationY() < i) {
						
                    }
                }
            }
        }


    }

    //System.out.println(distance(0, 0, 1, 1));
    public String toString() {
        for (int i = 0; i < this.routes.size(); i++) {
            System.out.println("Route " + i);
            for (int j = 0; j < this.routes.get(i).size(); j++) {
                if (j != 0) {
                    System.out.print(",");
                }
                System.out.print(this.routes.get(i).get(j));
            }
            System.out.println();
        }
        return ("");
    }
}

//double distance = Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));


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
    Find average distance each truck is from all the pickup locations
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
            //Pick up location will be designated "numTrucks/numPickUp + 1" trucks
        }






length of route/num pakcages to find the most efficient route
 */

