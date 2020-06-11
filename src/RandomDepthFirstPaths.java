import java.util.*;

public class RandomDepthFirstPaths {
    private final boolean[] marked;    // marked[v] = is there an s-v path?
    private final int[] edgeTo;        // edgeTo[v] = last edge on s-v path
    private final int s;         // source vertex

    /**
     * Computes a path between {@code s} and every other vertex in graph {@code G}.
     *
     * @param G the graph
     * @param s the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     */
    public RandomDepthFirstPaths(Graph G, int s) {
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        validateVertex(s);
    }

    public void randomDFS(Graph G) {
        randomDFS(G, s);
    }

    // depth first search from v
    private void randomDFS(Graph G, int v) {
        marked[v] = true;

        Collections.shuffle(G.adj(v));
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                randomDFS(G, w);
            }
        }

    }

    public void randomNonrecursiveDFS(Graph G) {
        // TODO
    }

    /**
     * Is there a path between the source vertex {@code s} and vertex {@code v}?
     *
     * @param v the vertex
     * @return {@code true} if there is a path, {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
    }

    /**
     * Returns a path between the source vertex {@code s} and vertex {@code v}, or
     * {@code null} if no such path.
     *
     * @param v the vertex
     * @return the sequence of vertices on a path between the source vertex
     * {@code s} and vertex {@code v}, as an Iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     *                                  <p>
     *                                  This method is different compared to the original one.
     */
    public List<Integer> pathTo(int v) {
        if (hasPathTo(v)) {
            List<Integer> path = new ArrayList<>();

            path.add(v);
            int counter = v;
            while (edgeTo[counter] > s) {
                path.add(edgeTo[counter]);
                counter = edgeTo[counter];
            }
            path.add(s);
            return path;
        }
        return null;
    }

    public int[] edge() {
        return edgeTo;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    }

    public static void main(String[] args) {

        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);

        g.addEdge(1, 4);

        g.addEdge(4, 3);
        g.addEdge(4, 5);

        g.addEdge(3, 2);
        g.addEdge(3, 5);

        RandomDepthFirstPaths rdfp = new RandomDepthFirstPaths(g, 0);

        rdfp.randomDFS(g);
        // rdfp.randomNonrecursiveDFS(g);


        System.out.println();
        System.out.println();

        for (int i = 0; i < rdfp.edgeTo.length; i++) {
            System.out.println("[" + i + "] -> " + rdfp.edgeTo[i] + " ");
        }

        List<Integer> path = rdfp.pathTo(3);
        for (Integer integer : path) {
            System.out.print(integer + " ");
        }

    }
}

