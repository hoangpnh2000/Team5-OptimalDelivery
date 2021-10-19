import java.util.*;

public class RoutePlan {
<<<<<<< Updated upstream
    static String routeCalculation(int truckx, int trucky, int x, int y) {
        int distx = x - truckx;
        int disty = y - trucky;
        double distance = Math.sqrt(Math.pow(distx, 2) + Math.pow(disty, 2));
        String routeDirections = "Please head";
        if (disty < 0) {
            routeDirections += " South ";
        } else {
            routeDirections += " North ";
        }
        if (distx < 0) {
            routeDirections += "West ";
        } else {
            routeDirections += "East ";
        }
        routeDirections += distance + " spaces.";
        return routeDirections;
    }

    public static void main(String[] args) {
        System.out.println(routeCalculation(0, 0, 1, 1));
    }
=======
	static String routeCalculation(int truckx, int trucky, int x, int y) {
		int distx = x - truckx;
		int disty = y - trucky;
		double distance = Math.sqrt(Math.pow(distx, 2)+Math.pow(disty,2));
		String routeDirections = "Please head ";
		if (disty < 0) {
			routeDirections += "South ";
		}
		else {
			routeDirections += "North ";
		}
		if (distx < 0) {
			routeDirections += "West ";
		}
		else {
			routeDirections += "East ";
		}
		routeDirections += distance + " spaces.";
		return routeDirections;
	}
	public static void main(String[] args) {
		System.out.println(routeCalculation(0, 0, 1, 1));
	}
>>>>>>> Stashed changes
}
