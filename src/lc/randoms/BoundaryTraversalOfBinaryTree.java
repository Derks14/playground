package lc.randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }
}
public class BoundaryTraversalOfBinaryTree {

    public static boolean isLeaf(Node node) {
        return node.left == null & node.right == null;
    }

    public static void collectLeft(Node node, List<Integer> bag) {
        // base case
        if (node == null || isLeaf(node)) return;

        // actual function
        bag.add(node.data);

        if (Objects.nonNull(node.left)) collectLeft(node.left, bag);
        else if (Objects.nonNull(node.right)) collectLeft(node.right, bag);

    }

    public static void collectLeaves(Node node, List<Integer> bag) {
        if (node == null) return;

        if (isLeaf(node)) bag.add(node.data);

        collectLeaves(node.left, bag);
        collectLeaves(node.right, bag);
    }

    public static void collectRight(Node node, List<Integer> bag) {
        if (node == null || isLeaf(node)) return;

        if (Objects.nonNull(node.right)) collectRight(node.right, bag);
        else if (Objects.nonNull(node.left)) collectRight(node.left, bag);
        bag.add(node.data);
    }


    public static List<Integer> runJob(Node tree) {
        List<Integer> bag = new ArrayList<>();

        if (tree == null) return bag;


        if (!isLeaf(tree)) {
            bag.add(tree.data);
        }

        collectLeft(tree.left, bag);
        collectLeaves(tree, bag);
        collectRight(tree.right, bag);

        return bag;


    }



    public static void main(String[] args) {
        // Input Binary tree
        //             1
        //         /       \
        //       2          3
        //     /   \       /   \
        //    4     5     6     7
        //         /  \
        //        8   9


        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        List<Integer> bag = runJob(root);

        System.out.println(bag.toString());
    }
}
