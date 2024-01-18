package mylib;

public class MyGraph {
    // No. of vertices
    private final int numberOfVertices;

    // Adjacency List as ArrayList of ArrayList's
    private final MyArrayList<MyArrayList<Integer>> adjacencyList;

    // Constructor
    public MyGraph(int numberOfVertices)
    {
        this.numberOfVertices = numberOfVertices;
        adjacencyList = new MyArrayList<>(numberOfVertices);
        for (int i = 0; i < numberOfVertices; i++)
            adjacencyList.add(new MyArrayList<>(numberOfVertices));
    }

    // Function to add an edge into the graph
    public void addEdge(int v, int w) { adjacencyList.get(v).add(w); }

    // A recursive function used by topologicalSort
    void topologicalSortUtil(int v, boolean[] visited,
                             MyStack<Integer> stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        for (int i = 0; i < adjacencyList.size(); i++){
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }
        // Push current vertex to stack
        // which stores result
        stack.push(v);
    }

    // The function to do Topological Sort.
    // It uses recursive topologicalSortUtil()
    public MyStack<Integer> topologicalSort()
    {
        MyStack<Integer> stack = new MyStack<>();

        // Mark all the vertices as not visited
        boolean[] visited = new boolean[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++)
            visited[i] = false;

        // Call the recursive helper
        // function to store
        // Topological Sort starting
        // from all vertices one by one
        for (int i = 0; i < numberOfVertices; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        // Print contents of stack
        //System.out.println(stack);
        return stack;
    }

}
