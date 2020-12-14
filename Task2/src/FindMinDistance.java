/**
 * now Dijkstra's algorithm is used to find a short path between graphs
 */

public class FindMinDistance {
    /**
     * the algorithm calculates the minimum cost and writes it to an array
     * @param costOfRoads two-dimensional array in which the cost of travel between cities will be written in the form of a matrix
     * @param indexFromCity city index from where we are looking for a path
     * @return an array that contains all the cost of the path from this city
     */
    static int[] algorithm(int costOfRoads[][], int indexFromCity) {
        int dist[] = new int[costOfRoads.length];
        Boolean sptSet[] = new Boolean[costOfRoads.length];
        for (int i = 0; i < costOfRoads.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[indexFromCity] = 0;
        for (int count = 0; count < costOfRoads.length - 1; count++) {
            int u = minDistance(dist, sptSet, costOfRoads.length);
            sptSet[u] = true;
            for (int v = 0; v < costOfRoads.length; v++)
                if (!sptSet[v] && costOfRoads[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + costOfRoads[u][v] < dist[v])
                    dist[v] = dist[u] + costOfRoads[u][v];
        }
        return dist;
    }

    /**
     * the method finds the cheapest way from the first to the next city
     * @return minimum cost from the first city to the next
     */
    static int minDistance(int dist[], Boolean sptSet[], int length) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < length; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }
}
