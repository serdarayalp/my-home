import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
        if (!hasEdge(v, w)) {
            M.addEdge(v, w);
        }
    }

    /**
     * Returns true if there is an edge between 'v' and 'w'
     *
     * @param v one vertex
     * @param w another vertex
     * @return true or false
     */
    public boolean hasEdge(int v, int w) {
        if (v != w) {
            LinkedList<Integer> adjV = M.adj(v);
            LinkedList<Integer> adjW = M.adj(w);

            return adjV.contains(w) || adjW.contains(v);
        }
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

    private void printVertexAdjList(LinkedList<Integer> adjList) {
        System.out.println("**********************");
        for (Integer item : adjList) {
            System.out.println(item);
        }
        System.out.println("**********************");
    }

    public static void main(String[] args) {
        Maze maze = new Maze(4, 0);
        Graph mazeGridGraph = maze.mazegrid();

        List<Integer> path = Arrays.asList(0, 1, 5, 9, 13);

        GridGraph gridGraph = new GridGraph(mazeGridGraph, path);
        gridGraph.plot();

        /*maze.printVertexAdjList(maze.M.adj(0));*/

        maze.printVertexAdjList(maze.M.adj(1));

        /*maze.printVertexAdjList(maze.M.adj(2));
        maze.printVertexAdjList(maze.M.adj(3));

        maze.printVertexAdjList(maze.M.adj(12));
        maze.printVertexAdjList(maze.M.adj(13));
        maze.printVertexAdjList(maze.M.adj(14));
        maze.printVertexAdjList(maze.M.adj(15));*/

    }


}

