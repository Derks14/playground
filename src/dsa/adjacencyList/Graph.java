package dsa.adjacencyList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Graph {
//    An Adjacency List
//    an array of linkedlists
//    each linkedlist or array element as a unique node at the head
//    all adjacent neighbors to that node are added to that nodes linkedlist

//    runtime complexity to check an: O(v)
//    space complexity: O(v+e)



//    the heart of the graph lies here
    List<LinkedList<Node>> listOfLinkedList;

    Graph() {
        this.listOfLinkedList = new ArrayList<>();
    }

    protected void addNode(Node node) {
        LinkedList<Node> bucket = new LinkedList<>();
        bucket.add(node);
        this.listOfLinkedList.add(bucket);
    }

    protected void addEdge(int src, int dst) {
        LinkedList<Node> currentList = this.listOfLinkedList.get(src);
        LinkedList<Node> destinationList = this.listOfLinkedList.get(dst);

        Node dstNode = destinationList.get(0);

        currentList.add(dstNode);
    }

    protected boolean checkEdge (int src, int dst) {
        LinkedList<Node> path = this.listOfLinkedList.get(src);
        Node dstNode = this.listOfLinkedList.get(dst).getFirst();

        for (Node node: path) {
            if (node == dstNode) return true;
        }

        return false;
    }

    protected void showGraph() {
        for (LinkedList<Node> list: this.listOfLinkedList) {
            System.out.println();
            for (Node node: list) {
                System.out.print(node.data + " -> ");
            }
        }

    }


    public static void main(String[] args) {


        Graph graph = new Graph();

        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));
        graph.addNode(new Node('F'));


        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(4, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 0);


        graph.showGraph();

    }
}
