package dsa.tree;

public class TreeTraversals {


//    prints data before the recursion
    public void preOrder(Node node) {
        // base case
        if (node == null) return;

        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }


//    in order traversal
    public void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

//    prints data after recursion
    public void postOrder(Node node) {
        if (node == null) return;

        postOrder(node);
        postOrder(node);
        System.out.println(node.data);
    }
}
