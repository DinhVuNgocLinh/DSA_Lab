package problem7_8;

import java.io.*;
import java.util.*; // for Stack class

class TreeApp {
   public static void main(String[] args) throws IOException {
      int value;
      Tree theTree = new Tree();

      theTree.insert(50, 1.5);
      theTree.insert(25, 1.2);
      theTree.insert(75, 1.7);
      theTree.insert(12, 1.5);
      theTree.insert(37, 1.2);
      theTree.insert(43, 1.7);
      theTree.insert(30, 1.5);
      theTree.insert(33, 1.2);
      theTree.insert(87, 1.7);
      theTree.insert(93, 1.5);
      theTree.insert(97, 1.5);

      while (true) {
         System.out.print("\nEnter first letter of show, ");
         System.out.print("insert, find, delete, traverse, or quit clear(c); find max(x); find min(n): ");
         int choice = getChar();
         switch (choice) {
            // case clear
            case 'c':
               theTree.clear();
               System.out.println("Tree has been cleared");
               break;
            // case find max
            case 'x':
               Node maxNode = theTree.findMax();
               if (maxNode != null) {
                  System.out.println("Max element is: " + maxNode.iData);
               } else {
                  System.out.println("Tree is empty");
               }
               break;
            // case find min
            case 'n':
               Node minNode = theTree.findMin();
               if (minNode != null) {
                  System.out.println("Min element is: " + minNode.iData);
               } else {
                  System.out.println("Tree is empty");
               }
               break;
            case 's':
               System.out.print("horizontal or vertical (1 or 2)? ");
               value = getInt();
               if (value == 1) {
                  System.out.println();
                  showTree(0, theTree.root);
               } else
                  theTree.displayTree();
               break;
            case 'i':
               System.out.print("Enter value to insert: ");
               value = getInt();
               theTree.insert(value, value + 0.9);
               System.out.println("Comparisons = " + theTree.comps);
               break;
            case 'f':
               System.out.print("Enter value to find: ");
               value = getInt();
               Node found = theTree.find(value);
               if (found != null) {
                  System.out.print("Found: ");
                  found.displayNode();
                  System.out.print("\n");
               } else {
                  System.out.print("Could not find ");
                  System.out.println(value);
               }
               System.out.println("Comparisons = " + theTree.comps);
               break;
            case 'd':
               System.out.print("Enter value to delete: ");
               value = getInt();
               boolean didDelete = theTree.delete(value);
               if (didDelete)
                  System.out.print("Deleted " + value + '\n');
               else {
                  System.out.print("Could not delete ");
                  System.out.println(value);
               }
               System.out.println("Comparisons = " + theTree.comps);
               break;
            case 't':
               System.out.print("Enter type 1, 2 or 3: ");
               value = getInt();
               theTree.traverse(value);
               break;
            case 'q':
               return;
            default:
               System.out.print("Invalid entry\n");
         } // end switch
      } // end while
   } // end main()

   public static String getString() throws IOException {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
   }

   public static char getChar() throws IOException {
      String s = getString();
      return s.charAt(0);
   }

   public static int getInt() throws IOException {
      String s = getString();
      return Integer.parseInt(s);
   }

   public static Node node(int data, Node l, Node r) {
      Node a = new Node();
      a.iData = data;
      a.leftChild = l;
      a.rightChild = r;
      return a;
   }

   public static void showTree(int n, Node t) {
      tab(n);
      if (t == null)
         System.out.println("*");
      else {
         n = n + 3;
         System.out.println(t.iData);
         if (t.leftChild == null && t.rightChild == null)
            return;
         showTree(n, t.leftChild);
         showTree(n, t.rightChild);
      }
   }

   public static void tab(int n) {
      for (int i = 0; i < n; i++)
         System.out.print(" ");
   }

} // end class TreeApp

class Node {
   public int iData; // data item (key)
   public double dData; // data item
   public Node leftChild; // this node's left child
   public Node rightChild; // this node's right child

   public void displayNode() // display ourself
   {
      System.out.print('{');
      System.out.print(iData);
      System.out.print(", ");
      System.out.print(dData);
      System.out.print("} ");
   }
} // end class Node

class Tree {
   int comps = 0;
   Node root; // first node of tree

   public Tree() // constructor
   {
      root = null;
   } // no nodes in tree yet
     // clear method

   public void clear() {
      root = null;
   }

   // find max and min method
   public Node findMax() {
      Node current = root;
      if (current == null) {
         return null; // Tree is empty
      }
      while (current.rightChild != null) {
         current = current.rightChild;
      }
      return current; // This is the max node
   }

   public Node findMin() {
      Node current = root;
      if (current == null) {
         return null; // Tree is empty
      }
      while (current.leftChild != null) {
         current = current.leftChild;
      }
      return current; // This is the min node
   }

   public Node find(int key) // find node with given key
   {
      comps = 0; // (assumes non-empty tree)
      Node current = root; // start at root
      while (current.iData != key) // while no match,
      {
         comps++;
         if (key < current.iData) // go left?
            current = current.leftChild;
         else // or go right?
            current = current.rightChild;
         if (current == null) // if no child,
            return null; // didn't find it
      }
      return current; // found it
   } // end find()

   public void insert(int id, double dd) {
      comps = 0;
      Node newNode = new Node(); // make new node
      newNode.iData = id; // insert data
      newNode.dData = dd;
      if (root == null) // no node in root
         root = newNode;
      else // root occupied
      {
         Node current = root; // start at root
         Node parent;
         while (true) // (exits internally)
         {
            parent = current;
            comps++;
            if (id < current.iData) // go left?
            {
               current = current.leftChild;
               if (current == null) // if end of the line,
               { // insert on left
                  parent.leftChild = newNode;
                  return;
               }
            } // end if go left
            else // or go right?
            {
               current = current.rightChild;
               if (current == null) // if end of the line
               { // insert on right
                  parent.rightChild = newNode;
                  return;
               }
            } // end else go right
         } // end while
      } // end else not root
   } // end insert()

   public boolean delete(int key) // delete node with given key
   {
      comps = 0; // (assumes non-empty list)
      Node current = root;
      Node parent = root;
      boolean isLeftChild = true;

      while (current.iData != key) // search for node
      {
         comps++;
         parent = current;
         if (key < current.iData) // go left?
         {
            isLeftChild = true;
            current = current.leftChild;
         } else // or go right?
         {
            isLeftChild = false;
            current = current.rightChild;
         }
         if (current == null) // end of the line,
            return false; // didn't find it
      } // end while
        // found node to delete

      // if no children, simply delete it
      if (current.leftChild == null &&
            current.rightChild == null) {
         if (current == root) // if root,
            root = null; // tree is empty
         else if (isLeftChild)
            parent.leftChild = null; // disconnect
         else // from parent
            parent.rightChild = null;
      }

      // if no right child, replace with left subtree
      else if (current.rightChild == null)
         if (current == root)
            root = current.leftChild;
         else if (isLeftChild)
            parent.leftChild = current.leftChild;
         else
            parent.rightChild = current.leftChild;

      // if no left child, replace with right subtree
      else if (current.leftChild == null)
         if (current == root)
            root = current.rightChild;
         else if (isLeftChild)
            parent.leftChild = current.rightChild;
         else
            parent.rightChild = current.rightChild;

      else // two children, so replace with inorder successor
      {
         // get successor of node to delete (current)
         Node successor = getSuccessor(current);

         // connect parent of current to successor instead
         if (current == root)
            root = successor;
         else if (isLeftChild)
            parent.leftChild = successor;
         else
            parent.rightChild = successor;

         // connect successor to current's left child
         successor.leftChild = current.leftChild;
      } // end else two children
        // (successor cannot have a left child)
      return true; // success
   } // end delete()

   private Node getSuccessor(Node delNode) {
      Node successorParent = delNode;
      Node successor = delNode;
      Node current = delNode.rightChild; // go to right child
      while (current != null) // until no more
      { // left children,
         successorParent = successor;
         successor = current;
         current = current.leftChild; // go to left child
      }
      // if successor not
      if (successor != delNode.rightChild) // right child,
      { // make connections
         successorParent.leftChild = successor.rightChild;
         successor.rightChild = delNode.rightChild;
      }
      return successor;
   }

   public void traverse(int traverseType) {
      switch (traverseType) {
         case 1:
            System.out.print("\nPreorder traversal: ");
            preOrder(root);
            break;
         case 2:
            System.out.print("\nInorder traversal:  ");
            inOrder(root);
            break;
         case 3:
            System.out.print("\nPostorder traversal: ");
            postOrder(root);
            break;
      }
      System.out.println();
   }

   private void preOrder(Node localRoot) {
      if (localRoot != null) {
         System.out.print(localRoot.iData + " ");
         preOrder(localRoot.leftChild);
         preOrder(localRoot.rightChild);
      }
   }

   private void inOrder(Node localRoot) {
      if (localRoot != null) {
         inOrder(localRoot.leftChild);
         System.out.print(localRoot.iData + " ");
         inOrder(localRoot.rightChild);
      }
   }

   private void postOrder(Node localRoot) {
      if (localRoot != null) {
         postOrder(localRoot.leftChild);
         postOrder(localRoot.rightChild);
         System.out.print(localRoot.iData + " ");
      }
   }

   public void displayTree() {
      Stack globalStack = new Stack();
      globalStack.push(root);
      int nBlanks = 32;
      boolean isRowEmpty = false;
      System.out.println("......................................................");
      while (isRowEmpty == false) {
         Stack localStack = new Stack();
         isRowEmpty = true;

         for (int j = 0; j < nBlanks; j++)
            System.out.print(' ');

         while (globalStack.isEmpty() == false) {
            Node temp = (Node) globalStack.pop();
            if (temp != null) {
               System.out.print(temp.iData);
               localStack.push(temp.leftChild);
               localStack.push(temp.rightChild);

               if (temp.leftChild != null ||
                     temp.rightChild != null)
                  isRowEmpty = false;
            } else {
               System.out.print("--");
               localStack.push(null);
               localStack.push(null);
            }
            for (int j = 0; j < nBlanks * 2 - 2; j++)
               System.out.print(' ');
         }
         System.out.println();
         nBlanks /= 2;
         while (localStack.isEmpty() == false)
            globalStack.push(localStack.pop());
      }
      System.out.println("......................................................");
   }
}