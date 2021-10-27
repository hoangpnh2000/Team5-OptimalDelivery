import java.util.ArrayList;

public class Route {

    public static ArrayList<ArrayList<String>> routes;//string of names based on the delivery, pickup and truck number
    //private ArrayList<ArrayList<WeightedGraph> > partitions; //arraylist of graphs using partitions
    //private WeightedGraph pickGraph;//graph for pickup points and trucks
    public ArrayList<ArrayList<DeliveryPoint>> partitions; //arraylist of graphs using partitions

    public Route() {
        this.routes = new ArrayList<>();
        this.partitions = new ArrayList<>();

    }

    public static String makeDirections(int truckX, int truckY, int x, int y) {
        StringBuilder routeDirections = new StringBuilder();
        for (int i = 0; i < Map.listDelivery.size() - 1; i++) {
            int distX = x - truckX;
            int distY = y - truckY;
            if (distY != 0) {
                if (distY < 0) {
                    routeDirections.append("HEAD SOUTH ").append(distY).append(" UNITS. ");
                } else {
                    routeDirections.append("HEAD NORTH ").append(distY).append(" UNITS. ");
                }
            }

            if (distX != 0) {
                if (distY != 0) {
                    routeDirections.append("THEN, ");
                }
                if (distX < 0) {
                    routeDirections.append("HEAD WEST ").append(distX).append(" UNITS");
                } else {
                    routeDirections.append("HEAD EAST ").append(distX).append(" UNITS");
                }
            }
            truckX = x;
            truckY = y;
            x = Map.listDelivery.get(i + 1).getLocationX();
            y = Map.listDelivery.get(i + 1).getLocationY();
        }
        return routeDirections.toString();
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
        ArrayList<Package> packageList;
        ArrayList<String> Directions = new ArrayList<>();
        for (int i = 0; i < Map.listPickup.size(); i++) {
            packageList = Map.listPickup.get(i).getPackageArrayList();
            for (Package aPackage : packageList) {
                Directions.add(makeDirections(Map.listTruck.get(i).getLocationX(), Map.listTruck.get(i).getLocationY(), Map.listPickup.get(i).getLocationX(), Map.listPickup.get(i).getLocationY()));
                Directions.add(makeDirections(Map.listTruck.get(i).getLocationX(), Map.listTruck.get(i).getLocationY(), aPackage.getDestinationX(), aPackage.getDestinationY()));
            }
        }


        //Route jokerdotmp4= new Route();
        //jokerdotmp4.initialBestRoute();


    }

    public static double distancebtwn(double x1, double y1, double x2, double y2) {
        return (Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    //create weighted graph of whole graph with pick up points and trucks being the nodes(use maps createGraph function)
    //use Dijkstra's to find the best pickup point route for trucks as whole
    //assign quadrants based on where the truck last went to
    //we first go to each pickup point for each truck
    //access variables using the global variables
    //Then we want to split up the graph into partitions
    //generate a new graph for each partition
    //use Dijkstra's to find best route for delivery points
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
    public void initialBestRoute() {//finding best route for pickup and trucks
        //initializing first pickup point for each truck (the closest one to go to)
        String temp;//temporary variable to store pick up name location
        double small;//shortest distance temp variable
        int ind;//index to remove
        ArrayList<PickUp> tempPick = Map.listPickup;
        for (int i = 0; i < Map.listTruck.size(); i++) {
            while (tempPick.size() > 0) {
            	this.routes.add(new ArrayList<String>());
                this.routes.add(new ArrayList<String>());
                this.routes.get(i).add(Map.listTruck.get(i).getName());
                small = Math.sqrt(Math.pow(Map.listTruck.get(i).getLocationX() - tempPick.get(0).getLocationX(), 2) + Math.pow(Map.listTruck.get(i).getLocationY() - tempPick.get(0).getLocationY(), 2));
                temp = tempPick.get(0).getName();
                ind = 0;
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
        createPartitions();
    }

    //create partitions and assign trucks
    //traverse through deliveries
    public void createPartitions() {
        double highestFactor = Map.listTruck.size();
        int numHorizontalPartition;
        int numVerticalPartition;
        //Finds factor thats closest to the square root of the number of trucks (numTrucks^.5)
        double sqRoot = Math.pow(Map.listTruck.size(), 0.5);
        for (int i = 1; i < sqRoot; i++) {
            if (Map.listTruck.size() % i == 0) {
                if (i - sqRoot < (double) Map.listTruck.size()) {
                    highestFactor = i;
                }
            }
        }
        //Determines the distance between each vertical and horizontal partition
        numHorizontalPartition = (int) highestFactor;
        numVerticalPartition = Map.listTruck.size() / numHorizontalPartition;


        double previ = 0, prevj = 0;
        int increment = 0;
        //Adds each delivery location to partition arraylist
        for (double i = (double) 100 / numHorizontalPartition; i < (double) 100; i = i + (double) 100 / numHorizontalPartition) {
            for (double j = (double) 100 / numVerticalPartition; j < (double) 100; j = j + (double) 100 / numVerticalPartition) {
                this.partitions.add(new ArrayList<>());
                for (int k = 0; k < Map.listDelivery.size(); k++) {
                    if (Map.listDelivery.get(k).locationX > prevj && Map.listDelivery.get(k).locationX < j
                            && Map.listDelivery.get(k).locationY > previ && Map.listDelivery.get(k).locationY < i) {
                        this.partitions.get(increment).add(Map.listDelivery.get(k));
                    }
                }
                increment++;
                prevj = j;
            }
            previ = i;
            prevj = 0;
        }

        //assign trucks to partitions
        PickUp tempPoint = new PickUp();
        double small = 0;//shortest distance temp variable
        int ind = 0;//index of shortest path to partition
        int counter = 0;
        previ = 0;
        prevj = 0;
        ArrayList<ArrayList<String>> troutes = this.routes;
        for (double i = (double) 100 / numHorizontalPartition; i < (double) 100; i = i + (double) 100 / numHorizontalPartition) {
            for (double j = (double) 100 / numVerticalPartition; j < (double) 100; j = j + (double) 100 / numVerticalPartition) {
                for (int k = 0; k < troutes.size(); k++) {
                    for (int h = 0; h < Map.listPickup.size(); h++) {
                        if (troutes.get(k).get(troutes.get(k).size() - 1).equals(Map.listPickup.get(h).getName())) {
                            tempPoint = Map.listPickup.get(h);
                        }
                    }
                    if (k == 0) {
                        small = distancebtwn(tempPoint.getLocationX(), tempPoint.getLocationY(), (i - previ) / 2, (j - prevj) / 2);
                    }
                    if (small > distancebtwn(tempPoint.getLocationX(), tempPoint.getLocationY(), (i - previ) / 2, (j - prevj) / 2)) {
                        ind = k;
                    }

                }
                Map.listTruck.get(ind).setPartition(counter);
                counter++;
                troutes.remove(ind);
                prevj = j;
            }
        }
        goToDeliveries();
    }

    //private final ArrayList<ArrayList<String>> routes;//string of names based on the delivery, pickup and truck number
    //private final ArrayList<ArrayList<DeliveryPoint>> partitions; //arraylist of partitions using strings to represent
    //know that route corresponds to truck and truck has the partition values assigned to it
    //grab partition values and work with deliveries in that partition.
    public void goToDeliveries() {
        //initializing first pickup point for each truck (the closest one to go to)
        ArrayList<DeliveryPoint> tempDel;
        PickUp tempPoint = new PickUp();
        String temp;//temporary variable to store pick up name location
        double small;//shortest distance temp variable
        int ind;//index to remove
        for (int p = 0; p < Map.listTruck.size(); p++) {
            tempDel = partitions.get(Map.listTruck.get(p).getPartition());//tempDel is the arraylist of delivery points
            while (tempDel.size() > 0) {
                //now find the shortest path for a certain delivery point
                for (int h = 0; h < Map.listPickup.size(); h++) {
                    if (routes.get(p).get(routes.get(p).size() - 1).equals(Map.listPickup.get(h).getName())) {
                        tempPoint = Map.listPickup.get(h);
                    }
                }
                small = Math.sqrt(Math.pow(tempPoint.getLocationX() - tempDel.get(0).getLocationX(), 2) + Math.pow(tempPoint.getLocationY() - tempDel.get(0).getLocationY(), 2));
                temp = tempDel.get(0).getName();
                ind = 0;
                for (int j = 0; j < tempDel.size(); j++) {
                    if (small > Math.sqrt(Math.pow(tempPoint.getLocationX() - tempDel.get(j).getLocationX(), 2) + Math.pow(tempPoint.getLocationY() - tempDel.get(j).getLocationY(), 2))) {
                        small = Math.sqrt(Math.pow(tempPoint.getLocationX() - tempDel.get(j).getLocationX(), 2) + Math.pow(tempPoint.getLocationY() - tempDel.get(j).getLocationY(), 2));
                        temp = tempDel.get(j).getName();
                        ind = j;
                    }
                }
                this.routes.get(p).add(temp);
                tempDel.remove(ind);

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