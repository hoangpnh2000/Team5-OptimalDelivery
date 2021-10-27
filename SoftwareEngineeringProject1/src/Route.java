import java.util.ArrayList;

public class Route {

    public static ArrayList<ArrayList<String>> routes;//string of names based on the delivery, pickup and truck number
    //private ArrayList<ArrayList<WeightedGraph> > partitions; //arraylist of graphs using partitions
    //private WeightedGraph pickGraph;//graph for pickup points and trucks
    public ArrayList<ArrayList<DeliveryPoint>> partitions; //arraylist of graphs using partitions

    public Route() {
        routes = new ArrayList<ArrayList<String>>();
        this.partitions = new ArrayList<ArrayList<DeliveryPoint>>();

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
        /*
        ArrayList<Package> packageList;
        ArrayList<String> Directions = new ArrayList<>();
        for (int i = 0; i < Map.listPickup.size(); i++) {
            packageList = Map.listPickup.get(i).getPackageArrayList();
            for (Package aPackage : packageList) {
                Directions.add(makeDirections(Map.listTruck.get(i).getLocationX(), Map.listTruck.get(i).getLocationY(), Map.listPickup.get(i).getLocationX(), Map.listPickup.get(i).getLocationY()));
                Directions.add(makeDirections(Map.listTruck.get(i).getLocationX(), Map.listTruck.get(i).getLocationY(), aPackage.getDestinationX(), aPackage.getDestinationY()));
            }
        }
*/

        //Route jokerdotmp4= new Route();
        //jokerdotmp4.initialBestRoute();
    /*    Map.listTruck = new ArrayList<>();
        Map.listPickup = new ArrayList<>();
        Map.listDelivery = new ArrayList<>();


        Truck temp1 = new Truck(0,5,20,10,0,0,"Truck1",-1);
        DeliveryPoint temp2 = new DeliveryPoint(false,6,5,"Delivery Point 1");
        PickUp temp3 = new PickUp(10, 11, 0, "Pickup Point 1");
        Map.listTruck.add(temp1);
        Map.listPickup.add(temp3);
        Map.listDelivery.add(temp2);

        temp1 = new Truck(0,5,59,60,0,0,"Truck2",-1);
        temp2 = new DeliveryPoint(false,69,69,"Delivery Point 2");
        temp3 = new PickUp(10, 99, 0, "Pickup Point 2");
        Map.listTruck.add(temp1);
        Map.listPickup.add(temp3);
        Map.listDelivery.add(temp2);

        temp1 = new Truck(0,5,59,10,0,0,"Truck3",-1);
        temp2 = new DeliveryPoint(false,69,30,"Delivery Point 3");
        temp3 = new PickUp(54, 99, 0, "Pickup Point 3");
        Map.listTruck.add(temp1);
        Map.listPickup.add(temp3);
        Map.listDelivery.add(temp2);

        temp1 = new Truck(0,5,77,20,0,0,"Truck4",-1);
        temp2 = new DeliveryPoint(false,20,20,"Delivery Point 4");
        temp3 = new PickUp(95, 4, 20, "Pickup Point 4");
        Map.listTruck.add(temp1);
        Map.listPickup.add(temp3);
        Map.listDelivery.add(temp2);

        temp1 = new Truck(0,5,17,60,0,0,"Truck5",-1);
        temp2 = new DeliveryPoint(false,13,40,"Delivery Point 5");
        temp3 = new PickUp(95, 3, 0, "Pickup Point 5");
        Map.listTruck.add(temp1);
        Map.listPickup.add(temp3);
        Map.listDelivery.add(temp2);

        temp1 = new Truck(0,5,18,25,0,0,"Truck6",-1);
        temp2 = new DeliveryPoint(false,19,36,"Delivery Point 6");
        temp3 = new PickUp(95, 6, 9, "Pickup Point 6");
        Map.listTruck.add(temp1);
        Map.listPickup.add(temp3);
        Map.listDelivery.add(temp2);

        temp1 = new Truck(0,5,77,20,0,0,"Truck7",-1);
        temp2 = new DeliveryPoint(false,20,20,"Delivery Point 7");
        temp3 = new PickUp(95, 81, 75, "Pickup Point 7");
        Map.listTruck.add(temp1);
        Map.listPickup.add(temp3);
        Map.listDelivery.add(temp2);

        Route temp = new Route();
        temp.initialBestRoute();
*/
    }

    public static double distancebtwn(double x1, double y1, double x2, double y2) {
        return (Math.pow((Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)),0.5));
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

        routes = new ArrayList<ArrayList<String>>();
        partitions = new ArrayList<ArrayList<DeliveryPoint>>();

        String temp;//temporary variable to store pick up name location
        double small;//shortest distance temp variable
        int ind;//index to remove
        ArrayList<PickUp> tempPick = new ArrayList<PickUp>();
        System.out.println("Truck size:"+ Map.listTruck.size());
        for (int w = 0; w < Map.listPickup.size(); w++) {
            tempPick.add(Map.listPickup.get(w));
        }
        for (int i = 0; i < Map.listTruck.size(); i++) {
            routes.add(new ArrayList<String>());
            routes.get(i).add(Map.listTruck.get(i).getName());
            while (tempPick.size() > 0) {
                small = Math.sqrt(Math.pow(Map.listTruck.get(i).getLocationX() - tempPick.get(0).getLocationX(), 2) + Math.pow(Map.listTruck.get(i).getLocationY() - tempPick.get(0).getLocationY(), 2));
                temp = tempPick.get(0).getName();
                ind = 0;
                for (int j = 0; j < tempPick.size(); j++) {
                    if (small > Math.sqrt(Math.pow(Map.listTruck.get(i).getLocationX() - tempPick.get(j).getLocationX(), 2) +
                            Math.pow(Map.listTruck.get(i).getLocationY() - tempPick.get(j).getLocationY(), 2))) {
                        small = Math.sqrt(Math.pow(Map.listTruck.get(i).getLocationX() - tempPick.get(j).getLocationX(), 2) +
                                Math.pow(Map.listTruck.get(i).getLocationY() - tempPick.get(j).getLocationY(), 2));
                        temp = tempPick.get(j).getName();
                        ind = j;
                    }
                }
                routes.get(i).add(temp);
                tempPick.remove(ind);
            }
            for (int w = 0; w < Map.listPickup.size(); w++) {
                tempPick.add(Map.listPickup.get(w));
            }
        }
        System.out.println("Hello: " + routes.toString() + Map.listDelivery.size()+ "Truck size:"+ Map.listTruck.size());
        createPartitions();
    }

    public void updateRoute() {
        for (int i = 0; i < Map.listTruck.size(); i++) {
            routes.add(new ArrayList<String>());
            routes.get(i).add(Map.listTruck.get(i).getName());
        }
    }
    //create partitions and assign trucks
    //traverse through deliveries
    public void createPartitions() {
        double highestFactor = Map.listTruck.size();
        int numHorizontalPartition;
        int numVerticalPartition;
        //Finds factor thats closest to the square root of the number of trucks (numTrucks^.5)
        double sqRoot = Math.pow(Map.listTruck.size(), 0.5);
        for (int i = 1; i < sqRoot+1; i++) {
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
        //this.partitions.add(new ArrayList<DeliveryPoint>());
        int xx =  10/ numHorizontalPartition;
        int yy =  10 / numVerticalPartition;
        for (int i = 10 / numHorizontalPartition; i <= 10; i = i + 10 / numHorizontalPartition) {
            for (int j = 10 / numVerticalPartition; j <= 10; j = j + 10 / numVerticalPartition) {
                this.partitions.add(new ArrayList<DeliveryPoint>());
                for (int k = 0; k < Map.listDelivery.size(); k++) {
                    if (Map.listDelivery.get(k).locationX > prevj && Map.listDelivery.get(k).locationX < yy
                            && Map.listDelivery.get(k).locationY > previ && Map.listDelivery.get(k).locationY < xx) {
                        this.partitions.get(increment).add(Map.listDelivery.get(k));
                    }
                }

                increment++;
                prevj = yy;
                yy = yy + 10 / numVerticalPartition;
                //this.partitions.add(new ArrayList<DeliveryPoint>());
            }

            previ = xx;
            prevj =  0;
            xx =  xx + 10/ numHorizontalPartition;

        }
//print partitions
        for (int i = 0; i < partitions.size(); i++) {
            System.out.println("Partition " + i);
            for (int j = 0; j < partitions.get(i).size(); j++) {
                if (j != 0) {
                    System.out.print(",");
                }
                System.out.print(partitions.get(i).get(j).getName());
            }
            System.out.println();
        }
        //print partitions
        //assign trucks to partitions
        /*
        for (int y = 0; y < Map.listTruck.size(); y++) {
            Map.listTruck.get(y).setPartition(y);
        }*/

        PickUp tempPoint = new PickUp();

        double small = 0;//shortest distance temp variable
        int ind = 0;//index of shortest pickup to partition
        int tind = 0;//index of truck to partition
        int counter = 0;
        previ = 0;
        prevj = 0;
        ArrayList<ArrayList<String>> troutes = new ArrayList<ArrayList<String>>();
        ArrayList<Truck> fakep = new ArrayList<Truck>();;
        //creating arraylist for checker
        //for (int c=0; c<Map.listTruck.size();c++)
        // {
        //fakep.add(Map.listTruck.get(c));
        // }
        //creating arraylist for checker
        //copying routes to troutes
        for(int o = 0;o<routes.size();o++)
        {
            troutes.add(new ArrayList<String>());
            for(int u=0; u<routes.get(o).size();u++){
                troutes.get(o).add(routes.get(o).get(u));
            }
        }
        System.out.println(troutes);
        double i = (double) 10 / numHorizontalPartition;
        double j = (double) 10 / numVerticalPartition;
        //copying routes to troutes
        for (int x = (Integer) 10 / numHorizontalPartition; x <= (Integer) 10; x = x + (Integer)10 / numHorizontalPartition) {
            for (int y = (Integer) 10 / numVerticalPartition; y <= (Integer) 10; y = y + (Integer) 10 / numVerticalPartition) {
                for (int k = 0; k < troutes.size(); k++) {

                    for (int h = 0; h < Map.listPickup.size(); h++) {//finds the cooresponding pick up truck last seen at
                        if (troutes.get(k).get(troutes.get(k).size() - 1).equals(Map.listPickup.get(h).getName())) {
                            tempPoint = Map.listPickup.get(h);
                        }
                    }
                    //System.out.println(tempPoint.getName());
                    if (k == 0 && fakep.indexOf(Map.listTruck.get(k)) == -1) {
                        small = distancebtwn(tempPoint.getLocationX(), tempPoint.getLocationY(), (i - previ) / 2, (j - prevj) / 2);
                        //ind = Map.listPickup.indexOf(tempPoint);
                        tind=0;
                    }
                    else if (small > distancebtwn(tempPoint.getLocationX(), tempPoint.getLocationY(), (i - previ) / 2, (j - prevj) / 2) &&
                            Map.listTruck.get(k).getPartition() < 0 && fakep.indexOf(Map.listTruck.get(k)) == -1) {
                        //ind = Map.listPickup.indexOf(tempPoint);//finds index of pickup point
                        small = distancebtwn(tempPoint.getLocationX(), tempPoint.getLocationY(), (i - previ) / 2, (j - prevj) / 2);
                        tind=k;
                    }
                    //System.out.println("small:"+ small);
                    //System.out.println("distancebtwen:"+ distancebtwn(tempPoint.getLocationX(), tempPoint.getLocationY(), (i - previ) / 2, (j - prevj) / 2));
                }
                //System.out.println(tind);
                //System.out.println(ind);
                Map.listTruck.get(tind).setPartition(counter);
                counter++;
                //troutes.remove(tind);//remove the truck that was assigned a partition
                //fakep.remove(counter);
                fakep.add(Map.listTruck.get(tind));
                prevj = j;
                small=20000;

                j = j + (double) 10 / numVerticalPartition;
            }
            prevj = 0;
            previ = i;
            i = i + (double) 10 / numHorizontalPartition;
        }
        //print out all trucks with cooresponding partitions
        System.out.println();
        for(int f = 0; f<Map.listTruck.size();f++)
        {
            System.out.println(Map.listTruck.get(f).getName()+" has partitions "+Map.listTruck.get(f).getPartition());
        }
        //print out all trucks with cooresponding partitions
        goToDeliveries();
    }

    //private final ArrayList<ArrayList<String>> routes;//string of names based on the delivery, pickup and truck number
    //private final ArrayList<ArrayList<DeliveryPoint>> partitions; //arraylist of partitions using strings to represent
    //know that route corresponds to truck and truck has the partition values assigned to it
    //grab partition values and work with deliveries in that partition.
    public void goToDeliveries() {
        //initializing first pickup point for each truck (the closest one to go to)
        ArrayList<DeliveryPoint> tempDel = new ArrayList<DeliveryPoint>();
        PickUp tempPoint = new PickUp();
        String temp;    //temporary variable to store pick up name location
        double small;//shortest distance temp variable
        int ind;//index to remove
        for (int p = 0; p < Map.listTruck.size(); p++) {
            tempDel = this.partitions.get(Map.listTruck.get(p).getPartition());  //tempDel is the arraylist of delivery points
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
                routes.get(p).add(temp);
                tempDel.remove(ind);

            }
        }
        System.out.println(routes);
    }

    //System.out.println(distance(0, 0, 1, 1));
    public String toString() {
        for (int i = 0; i < routes.size(); i++) {
            System.out.println("Route " + i);
            for (int j = 0; j < routes.get(i).size(); j++) {
                if (j != 0) {
                    System.out.print(",");
                }
                System.out.print(routes.get(i).get(j));
            }
            System.out.println();
        }
        return ("");
    }
}