package problem4;

public class BinaryTree {
    Node root;

    public boolean isIdentical(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null) {
            return (node1.value == node2.value
                    && isIdentical(node1.left, node2.left)
                    && isIdentical(node1.right, node2.right));
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree();
        BinaryTree tree2 = new BinaryTree();
        // Insert values into tree1
        tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        tree1.root.left.left = new Node(4);
        tree1.root.left.right = new Node(5);
        // Insert values into tree2
        tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(3);
        tree2.root.left.left = new Node(9);
        tree2.root.left.right = new Node(5);
        // Check if trees are identical
        if (tree1.isIdentical(tree1.root, tree2.root)) {
            System.out.println("Both trees are identical");
        } else {
            System.out.println("Trees are not identical");
        }
    }
}
