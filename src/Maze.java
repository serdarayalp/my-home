import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a maze with N*N junctions.
 *
 * @author Vera Röhr
 */
public class Maze {

    private final int N;
    private final Graph M; // Maze
    public int startnode;
    private int nVertex;

    public Maze(int N, int startnode) {
        if (N < 0) throw new IllegalArgumentException("Number of vertices in a row must be nonnegative");
        this.N = N;
        this.M = new Graph(N * N);
        nVertex = N * N;
        this.startnode = startnode;
        buildMaze();
    }

    public Maze(In in) {
        this.M = new Graph(in);
        this.N = (int) Math.sqrt(M.V());
        this.startnode = 0;
    }


    /**
     * Adds the undirected edge v-w to the graph M.
     *
     * @param v one vertex in the edge
     * @param w the other vertex in the edge
     * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    public void addEdge(int v, int w) {
        M.addEdge(v, w);
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= (nVertex - 1))
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (nVertex - 1));
    }

    /**
     * Returns true if there is an edge between 'v' and 'w'
     *
     * @param v one vertex
     * @param w another vertex
     * @return true or false
     */
    public boolean hasEdge(int v, int w) {
        // TODO
        return true;
    }

    /**
     * Builds a grid as a graph.
     *
     * @return Graph G -- Basic grid on which the Maze is built
     */
    public Graph mazegrid() {

        for (int i = 0; i < nVertex; i++) {
            if ((i - 1) >= 0 && (i % N != 0)) {
                addEdge(i, i - 1);
            }
            if ((i - N) > 0) {
                addEdge(i, i - N);
            }
            if ((i + 1) % N != 0) {
                addEdge(i, i + 1);
            }
            if ((i + N) < nVertex) {
                addEdge(i, i + N);
            }
        }

        return M;
    }

    /**
     * Builds a random maze as a graph.
     * The maze is build with a randomized DFS as the Graph M.
     */
    private void buildMaze() {
        // TODO
    }

    /**
     * Find a path from node v to w
     *
     * @param v start node
     * @param w end node
     * @return List<Integer> -- a list of nodes on the path from v to w (both included) in the right order.
     */
    public List<Integer> findWay(int v, int w) {
        // TODO
        return new ArrayList<>();
    }

    /**
     * @return Graph M
     */
    public Graph M() {
        return M;
    }

    public static void main(String[] args) {
        Maze maze = new Maze(5, 0);
        Graph mazeGridGraph = maze.mazegrid();

        GridGraph gridGraph = new GridGraph(mazeGridGraph);
        gridGraph.plot();
    }


}

