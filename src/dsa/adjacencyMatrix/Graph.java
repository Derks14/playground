package dsa.adjacencyMatrix;

import javax.naming.directory.SearchControls;
import java.util.*;

public class Graph {
//    A graph is a non-linear aggregation of nodes and edges

//    Adjacency Matrix
//    a 2d array to store 1's or 0's to represent edges
//    # of rows = # of unique nodes
//    # of columns = # of unique nodes


//    runtime complexity to check an edge: O(1)
//    space complexity: O(v^2)


    List<Node> nodes;
    int[][] matrix;

    Graph(int size) {
        this.matrix = new int[size][size];
        this.nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        this.nodes.add(node);
    }

    public void addEdge(int src, int dst) {
        this.matrix[src][dst] = 1;
    }

    public boolean checkEdge(int src, int dst) {
        return this.matrix[src][dst] == 1;
    }

    public void showGraph() {
        System.out.print("\t");
        for (Node node: this.nodes) {
            System.out.print( node.data + " ");
        }
        System.out.println();

        for (int i = 0; i < this.matrix.length - 1; i++) {
            System.out.print(nodes.get(i).data+  "\t");
            for (int j = 0; j < this.matrix.length - 1; j++) {

                System.out.print(this.matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

//    Depth-First Search
//    Traverse a graph branch by branch
//    Utilizes a stack
//    better if destination is far from the start
//    children are visited before siblings
//    more popular for games/puzzles

    public void depthFirstSearch(int src) {
        System.out.println("------------------- ");
        Set<Integer> visited = new HashSet<>();
        traverserDFS(src, visited);
    }
    public void traverserDFS(int src, Set<Integer> visited) {
        if (visited.contains(src)) return;
        else {
            visited.add(src);
            System.out.println("visiting - "+ nodes.get(src).data);
        }
        for (int i = 0; i < matrix[src].length; i++) {
            if (matrix[src][i] == 1) {
                traverserDFS(i, visited);
            }
        }
    }

//    Breath-First Search
//    Traverse a graph level by level
//    Utilizes a queue
//    Better if destination is on average close to start
//    siblings are visited before children

    public void breathFirstSearch(int src) {
//      so the whole idea is to put valid edges into the queue and mark it as visited once we poll
        System.out.println("\nBeginning BFS\n");

//      we take note of queue for and set for track keeping
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        // we register our first node and mark as visited
        queue.offer(src);
        visited.add(src);

        while (!queue.isEmpty()) {
            // poll means we have visited that nodes
            src = queue.poll();
            System.out.println(nodes.get(src).data + " has been visited ");

            for (int i = 0; i < matrix[src].length; i++) {
                if (matrix[src][i] == 1 && !visited.contains(i)){
                    queue.offer(i);
                    visited.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {

//        this is the graph
        Graph graph = new Graph(6);

//        this is our nodes
//        think of the nodes as indexes so - 0, 1, 2, 3, 4, 5, 6

        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));


        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);

        graph.showGraph();

        graph.breathFirstSearch(0);


    }

}
