import acm.program.ConsoleProgram;
import acm.util.ErrorException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FlightPlanner extends ConsoleProgram {

    private static final String FLIGHT_DATA_FILE = "flights.txt";

    private final Map<String, List<String>> flights =
            new LinkedHashMap<String, List<String>>();
    private final List<String> cities = new ArrayList<String>();

    public void run() {
        readFlightData(FLIGHT_DATA_FILE);

        println("Welcome to Flight Planner!");
        println("Here's a list of all the cities in our database:");
        printCityList(cities);
        println("Let's plan a round-trip route!");

        String startCity = readStartingCity();
        List<String> route = buildRoute(startCity);
        printRoute(route);
    }

    private String readStartingCity() {
        while (true) {
            String city = readLine("Enter the starting city: ");
            if (flights.containsKey(city)) {
                return city;
            }
            println("That city is not in the database.");
        }
    }

    private List<String> buildRoute(String startCity) {
        List<String> route = new ArrayList<String>();
        route.add(startCity);

        String currentCity = startCity;
        while (true) {
            String nextCity = readNextCity(currentCity);
            route.add(nextCity);
            if (nextCity.equals(startCity)) {
                return route;
            }
            currentCity = nextCity;
        }
    }

    private String readNextCity(String city) {
        List<String> destinations = flights.get(city);

        while (true) {
            println("From " + city + " you can fly directly to:");
            printCityList(destinations);
            String nextCity = readLine("Where do you want to go from "
                    + city + "? ");

            if (destinations.contains(nextCity)) {
                return nextCity;
            }
            println("You can't get to that city by a direct flight.");
        }
    }

    private void printCityList(List<String> cityList) {
        for (String city : cityList) {
            println(" " + city);
        }
    }

    private void printRoute(List<String> route) {
        println("The route you've chosen is:");
        for (int i = 0; i < route.size(); i++) {
            if (i > 0) {
                print(" -> ");
            }
            print(route.get(i));
        }
        println();
    }

    private void readFlightData(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                if (line.trim().length() > 0) {
                    readFlightEntry(line);
                }
            }
            reader.close();
        } catch (IOException exception) {
            throw new ErrorException(exception);
        }
    }

    private void readFlightEntry(String line) {
        int arrow = line.indexOf("->");
        if (arrow == -1) {
            throw new ErrorException("Illegal flight entry: " + line);
        }

        String fromCity = line.substring(0, arrow).trim();
        String toCity = line.substring(arrow + 2).trim();
        if (fromCity.length() == 0 || toCity.length() == 0) {
            throw new ErrorException("Illegal flight entry: " + line);
        }

        defineCity(fromCity);
        defineCity(toCity);
        flights.get(fromCity).add(toCity);
    }

    private void defineCity(String city) {
        if (!flights.containsKey(city)) {
            cities.add(city);
            flights.put(city, new ArrayList<String>());
        }
    }
}
