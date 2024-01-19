package myalgorithm;

import mylib.MyArrayList;

import java.util.Arrays;

public class Greedy {
    /**
     * Prim 's algorithm
     */
    public static class MST {
        // Number of vertices in the graph
        private static int numberOfVertices;

        // A utility function to find the vertex with minimum
        // key value, from the set of vertices not yet included
        // in MST
        int minKey(int[] key, Boolean[] mstSet) {
            // Initialize min value
            int min = Integer.MAX_VALUE, min_index = -1;

            for (int vertex = 0; vertex < numberOfVertices; vertex++)
                if (!mstSet[vertex] && key[vertex] < min) {
                    min = key[vertex];
                    min_index = vertex;
                }

            return min_index;
        }

        // A utility function to print the constructed MST
        // stored in parent[]
        void printMST(int[] parent, int[][] distanceGraph) {
            System.out.println("Edge \tWeight");
            for (int vertex = 1; vertex < numberOfVertices; vertex++)
                System.out.println(parent[vertex] + " - " + vertex + "\t"
                        + distanceGraph[vertex][parent[vertex]]);
        }

        MyArrayList<String> getResultList(int[] parent, int[][] distanceGraph) {
            MyArrayList<String> resultList = new MyArrayList<>();
            System.out.println("Edge \tWeight");
            for (int vertex = 1; vertex < numberOfVertices; vertex++) {
                resultList.add(parent[vertex] + " - " + vertex + " ==> weight:"
                        + distanceGraph[vertex][parent[vertex]]);
            }
            return resultList;
        }

        // Function to construct and print MST for a distanceGraph
        // represented using adjacency matrix representation
        public MyArrayList<String> primMST(int[][] distanceGraph) {
            numberOfVertices = distanceGraph.length;
            // Array to store constructed MST
            int[] parent = new int[numberOfVertices];

            // Key values used to pick minimum weight edge in
            // cut
            int[] key = new int[numberOfVertices];

            // To represent set of vertices included in MST
            Boolean[] mstSet = new Boolean[numberOfVertices];

            // Initialize all keys as INFINITE
            for (int i = 0; i < numberOfVertices; i++) {
                key[i] = Integer.MAX_VALUE;
                mstSet[i] = false;
            }

            // Always include first 1st vertex in MST.
            // Make key 0 so that this vertex is
            // picked as first vertex
            key[0] = 0;

            // First node is always root of MST
            parent[0] = -1;

            // The MST will have V vertices
            for (int count = 0; count < numberOfVertices - 1; count++) {

                // Pick the minimum key vertex from the set of
                // vertices not yet included in MST
                int minKeyVertex = minKey(key, mstSet);

                // Add the picked vertex to the MST Set
                mstSet[minKeyVertex] = true;

                // Update key value and parent index of the
                // adjacent vertices of the picked vertex.
                // Consider only those vertices which are not
                // yet included in MST
                for (int vertex = 0; vertex < numberOfVertices; vertex++) {
                    // distanceGraph[minKeyVertex][vertex] is non-zero only for adjacent
                    // vertices of m mstSet[vertex] is false for
                    // vertices not yet included in MST Update
                    // the key only if distanceGraph[minKeyVertex][vertex] is smaller
                    // than key[vertex]
                    if (distanceGraph[minKeyVertex][vertex] != 0 && !mstSet[vertex]
                            && distanceGraph[minKeyVertex][vertex] < key[vertex]) {
                        parent[vertex] = minKeyVertex;
                        key[vertex] = distanceGraph[minKeyVertex][vertex];
                    }
                }
            }

            // Results are stored into an arraylist for other usages
            return getResultList(parent, distanceGraph);
        }
    }

    /**
     * Dijkstra’s Algorithm
     */
    public static class ShortestPath {
        // A utility function to find the vertex with minimum
        // distance value, from the set of vertices not yet
        // included in the shortest path tree
        static int numberOfVertices;

        static int minDistance(int[] dist, Boolean[] sptSet) {
            // Initialize min value
            int min = Integer.MAX_VALUE, min_index = -1;

            for (int v = 0; v < numberOfVertices; v++)
                if (!sptSet[v] && dist[v] <= min) {
                    min = dist[v];
                    min_index = v;
                }

            return min_index;
        }

        // A utility function to print the constructed distance
        // array
        static void printSolution(int[] dist) {
            System.out.println(
                    "Vertex \t\t Distance from Source");
            for (int vertex = 0; vertex < numberOfVertices; vertex++) {
                System.out.println(vertex + " \t\t " + dist[vertex]);
            }
        }

        static void printPath(Boolean[] isVertexPassedArray) {
            for (int i = 0; i <isVertexPassedArray.length ; i++) {
                if(isVertexPassedArray[i]){
                    System.out.print(i+"->");
                }
            }
                System.out.println(Arrays.toString(isVertexPassedArray));

        }

        // Function that implements Dijkstra's single source
        // the shortest path algorithm for a graph represented using
        // adjacency matrix representation
        public static int[] findShortestPath(int[][] graph, int src) {
            numberOfVertices = graph.length;
            int[] dist = new int[numberOfVertices]; // The output array.
            // dist[i] will hold
            // the shortest distance from src to i

            // isVertexPassedArray[i] will true if vertex i is included in
            // the shortest path tree or shortest distance from src
            // to i is finalized
            Boolean[] isVertexPassedArray = new Boolean[numberOfVertices];
            // Initialize all distances as INFINITE and stpSet[]
            // as false
            for (int vertex = 0; vertex < numberOfVertices; vertex++) {
                dist[vertex] = Integer.MAX_VALUE;
                isVertexPassedArray[vertex] = false;
            }

            // Distance of source vertex from itself is always 0
            dist[src] = 0;

            // Find the shortest path for all vertices
            for (int count = 0; count < numberOfVertices - 1; count++) {
                // Pick the minimum distance vertex from the set
                // of vertices not yet processed. u is always
                // equal to src in first iteration.
                int u = minDistance(dist, isVertexPassedArray);
                printPath(isVertexPassedArray);
                // Mark the picked vertex as processed
                isVertexPassedArray[u] = true;

                // Update dist value of the adjacent vertices of
                // the picked vertex.
                for (int vertex = 0; vertex < numberOfVertices; vertex++)

                    // Update dist[vertex] only if is not in isVertexPassedArray,
                    // there is an edge from u to vertex, and total
                    // weight of path from src to vertex through u is
                    // smaller than current value of dist[vertex]
                    if (!isVertexPassedArray[vertex] && graph[u][vertex] != 0
                            && dist[u] != Integer.MAX_VALUE
                            && dist[u] + graph[u][vertex] < dist[vertex])
                        dist[vertex] = dist[u] + graph[u][vertex];
            }

            // print the constructed distance array
            printSolution(dist);
            return dist;
        }
    }
}
