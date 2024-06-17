package problem4;

public class Node {
    int value;
    Node left;
    Node right;

    protected Node(int value) {
        this.value = value;
        left = right = null;
    }
}
