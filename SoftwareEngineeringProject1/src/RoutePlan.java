import java.util.*;
public class RoutePlan {
	static String routeCalculation(int truckx, int trucky, int x, int y) {
		int distx = truckx - x;
		int disty = trucky - y;
		double distance = Math.sqrt(distx^2+disty^2);
		String routeDirections = "Please head";
		if (y < 0) {
			routeDirections += " South ";
		}
		else {
			routeDirections += " North ";
		}
		if (x < 0) {
			routeDirections += "West.";
		}
		else {
			routeDirections += "East.";
		}
		return routeDirections;
	}
	public static void main(String[] args) {
		System.out.println(routeCalculation(0, 0, 1, 1));
	}
}
