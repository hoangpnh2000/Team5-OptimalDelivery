public class Route {

    public static double distance(int truckX, int truckY, int x, int y) {
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
        System.out.println(distance(0, 0, 1, 1));
    }
}




/*

Num trucks < num pickup locations
    Each truck goes to nearest unoccupied pickup location and picks up all packages
    Uses dijkstra algorithm to find the shortest route to deliver all packages for each truck
    If the truck is within n tiles of another unclaimed pickup station OR if truck is done with all packages, reroutes to the unclaimed pickup station
        Reuses dijkstra algorithm to find shortest path
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


 */

