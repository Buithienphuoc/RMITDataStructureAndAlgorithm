import myalgorithm.Greedy;
import myalgorithm.Greedy.MST;
import myalgorithm.Greedy.ShortestPath;
import mylib.MyArrayList;
import mylib.MyGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnitTest {
    @Test
    public void testPrimMST(){
        MST t = new MST();
        int[][] graph = new int[][] {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        MyArrayList<String> result = t.primMST(graph);
        System.out.println(result.toString());
        Assertions.assertNotNull(result);
    }

    @Test
    public void testDijkstra(){
        int[][] graph2
                = new int[][] {
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        Assertions.assertNotNull(ShortestPath.findShortestPath(graph2,0));
    }

    @Test
    public void testTopologicalShort(){
        MyGraph g = new MyGraph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological "
                + "sort of the given graph");
        // Function Call
        System.out.println(g.topologicalSort());
        Assertions.assertNotNull(g);
    }
}
