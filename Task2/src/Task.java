import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * this class is looking for the minimum cost from one city to another
 */
class Task {
    /**
     * this is the maximum number of tests that can be performed at one time
     */
    private final int TEST_LIMIT = 10;
    /**
     * this is the maximum number of cities that the network can consist of
     */
    private final int CITY_LIMIT = 10000;
    /**
     *
     */
    private final int PAIRS_OF_CITIES_LIMIT = 100;
    /**
     *two-dimensional array in which the cost of travel between cities will be written in the form of a matrix
     */
    public int costOfRoads[][];
    /**
     *stores the name of the city and its postal code
     */
    private Map<String, Integer> cityNames = new HashMap<>();
    /**
     *city index from where to find the path
     */
    private List<Integer> fromCity = new ArrayList<>();
    /**
     *city index to which you want to know the cost of the trip
     */
    private List<Integer> toCity = new ArrayList<>();

    /**
     * This method prints the result
     * @param dist cost of the way to all cities
     * @param indexToCity city index to which you want to calculate the cost of the way
     */
    void printSolution(int[] dist, Integer indexToCity) {
        System.out.println(dist[toCity.get(indexToCity)]);

    }

    /**
     * This method writes data from the console
     * @param reader to read from console
     */
    private void readData(BufferedReader reader) throws IOException {
        int cityCount = Integer.parseInt(reader.readLine());
        if (cityCount > CITY_LIMIT) {
            System.out.println("city limit > 10000");
            return;
        }
        costOfRoads = new int[cityCount][cityCount];
        for (int cityIndex = 0; cityIndex < cityCount; cityIndex++) {
            String nameCity = reader.readLine();
            if (nameCity.length() > 10) {
                System.err.print("city name must not include 10 characters");
                return;
            }
            cityNames.put(nameCity, cityIndex);
            int neighborsNumb = Integer.parseInt(reader.readLine());
            for (int neighborIndex = 0; neighborIndex < neighborsNumb; neighborIndex++) {
                String nrAndCost = reader.readLine();
                String[] splitted = nrAndCost.split(" ");
                costOfRoads[cityIndex][Integer.parseInt(splitted[0]) - 1] = Integer.parseInt(splitted[1]);
            }
        }
        int pairsOfCities = Integer.parseInt(reader.readLine());
        if (pairsOfCities > PAIRS_OF_CITIES_LIMIT) {
            System.err.print("the number of search paths must be <= 100");
            return;
        }
        for (int i = 0; i < pairsOfCities; i++) {
            String fromCityToCity = reader.readLine();
            String[] splittedCity = fromCityToCity.split(" ");
            fromCity.add(cityNames.get(splittedCity[0].toLowerCase()));
            toCity.add(cityNames.get(splittedCity[1].toLowerCase()));
        }
    }

    /**
     * @throws IOException input / output exception
     */
    private void run(BufferedReader reader) throws IOException {
        int testCount = Integer.parseInt(reader.readLine());
        if (testCount > TEST_LIMIT) {
            System.err.print("test limit > 10");
            return;
        }
        for (int testNumber = 0; testNumber < testCount; testNumber++) {
            readData(reader);
        }
        for (int pairCount = 0; pairCount < fromCity.size(); pairCount++) {
            printSolution(FindMinDistance.algorithm(costOfRoads, fromCity.get(pairCount)), pairCount);
        }
    }

    /**
     * This is the main method that starts the execution of the program
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Task task = new Task();
            task.run(reader);
        }
    }
}