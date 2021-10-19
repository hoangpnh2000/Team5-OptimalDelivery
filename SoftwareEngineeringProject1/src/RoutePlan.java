import java.util.*;
public class RoutePlan {
	static String routeCalculation(int truckx, int trucky, int x, int y) {
		int distx = x - truckx;
		int disty = y - trucky;
		double distance = Math.sqrt(distx^2+disty^2);
		String routeDirections = "Please head";
		if (disty < 0) {
			routeDirections += " South ";
		}
		else {
			routeDirections += " North ";
		}
		if (distx < 0) {
			routeDirections += "West.";
		}
		else {
			routeDirections += "East.";
		}
		return routeDirections;
	}
	public static void main(String[] args) {
		System.out.println(routeCalculation(2, 2, 1, 1));
	}
}
