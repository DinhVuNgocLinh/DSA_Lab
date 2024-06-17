import java.util.*;
import java.io.*;

public class MyList {
    Node head, tail;
    int size;

    // Default constructor
    MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.getInfo() + " "); // write data in the node p to the file f
            p = p.next;
        }

        f.writeBytes("\r\n");
    }

    /**
     * Do NOT modify this method
     * Load 3 lines of data from file:
     * line k (for name),
     * line k+1 (for price), and
     * line k+2 (for amount)
     * 
     * @param k the k-th line where data is started to be loaded
     */
    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;

        for (int i = 0; i < n; i++)
            addLast(a[i], b[i], c[i]);// insert the new Node(a[i], b[i], c[i]) into the list
    }

    /**
     * Luy y: 1. SV KHONG su dung tieng Viet co dau trong bai lam de tranh Error khi
     * run chuong trinh.
     * 2. Neu khong tuan thu se nhan diem 0 (khong).
     * 
     * Question 1.1: implement the 'addLast' method that inserts
     * a new Node into the list's tail if the attribute 'Name'of a Animal does NOT
     * start with 'B'.
     * The output of this method will be written into the file 'f1.txt'.
     * Therefore you should open this file to see/test your code output.
     * Example: with the content given in the file 'data.txt', the content of
     * 'f1.txt' after insertion
     * should be (A,9,8) (C,6,5) (M,1,1) (E,7,9) (F,4,-7) (G,-3,2)
     * 
     * @param xName   the Name of the input Animal
     * @param xPrice  the price of the input Animal
     * @param xAmount the amount of the input Animal
     */
    void addLast(String xName, int xPrice, int xAmount) {
        // ------------------------------------------------------------------------------------
        // ------ Start your code
        // here---------------------------------------------------------
        Animal newAnimal = new Animal(xName, xPrice, xAmount);
        if (!xName.startsWith("B")) {
            Node node = new Node(newAnimal);
            if (isEmpty()) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            size++;
        }
        // ------ End your code
        // here-----------------------------------------------------------
        // ------------------------------------------------------------------------------------
    }

    /**
     * Do NOT modify this method
     * This is a helper method for writing data (node's info) stored in the linked
     * list to file
     * 
     * @throws Exception
     */
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

    // This method is used for Question 1.2
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        // Declare two Animal Objects which will be used for the Question 1.2
        Animal p;
        Animal q;
        p = new Animal("P", 6, 8);
        q = new Animal("Q", 8, 6);

        /**
         * Question 1.2: use Animal p and Animal p declared above, write your code to:
         * (1) insert the node with info = p into the second position of the list, and
         * (2) insert the node with info = q into the third position of the list
         * The output of this method will be written into the file 'f2.txt'.
         * Therefore you should open this file to see/test your code output.
         * Example: if the linked list before insertion is (X,9,8) (D,6,3) (E,8,5)
         * (F,5,4) (I,4,9)
         * then the content of 'f2.txt' after insertion is (X,9,8) (P,6,8) (Q,8,6)
         * (D,6,3) (E,8,5) (F,5,4) (I,4,9)
         */
        // ------------------------------------------------------------------------------------
        // ------ Start your code
        // here---------------------------------------------------------
        Node current = head;
        Node newP = new Node(p);
        Node newQ = new Node(q);

        if (current != null) {
            Node temp = current.next;
            current.next = newP;
            newP.next = newQ;
            newQ.next = temp;
            size = size + 2;
        }
        // ------ End your code
        // here-----------------------------------------------------------
        // ------------------------------------------------------------------------------------

        ftraverse(f); // write list's data to file
        f.close();
    }

    // This method is used for Question 1.3
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");

        /**
         * Question 1.3: Find all nodes in the linked list with Animal's price less than
         * 6,
         * if such a node is found, then set the amount of Animal in this node to 0.
         * The output of this method will be written into the file 'f3.txt'.
         * Therefore you should open this file to see/test your code output.
         * Example: if the linked list before change is (C,8,6) (N,3,5) (E,9,2) (F,5,8)
         * (G,9,7) (H,6,8) (I,7,3)
         * then the content of 'f3.txt' after change is (C,8,6) (N,3,0) (E,9,2) (F,5,0)
         * (G,9,7) (H,6,8) (I,7,3)
         * the changed nodes are: N, F
         */
        // ------------------------------------------------------------------------------------
        // ------ Start your code
        // here---------------------------------------------------------
        Node current = head;
        while (current != null) {
            if (current.getInfo().getPrice() < 6) {
                current.getInfo().setAmount(0);
            }
            current = current.next;
        }
        // ------ End your code
        // here-----------------------------------------------------------
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    // This method is used for Question 1.4
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists())
            g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        /**
         * Question 1.4: Sort the linked list in an descending order according to
         * Animal's value.
         * The value in this case is defined by: value = price * amount.
         * For example, the value of (X, 4, 6) is 24.
         * The output of this method will be written into the file 'f4.txt'.
         * Therefore you should open this file to see/test your code output.
         * Example: if the linked list before sorting is (C,1,2) (H,7,33) (E,2,15)
         * (F,13,6) (I,6,1) (J,11,15) (K,7,9)
         * then the content of 'f4.txt' after sorting is (H,7,33) (J,11,15) (F,13,6)
         * (K,7,9) (E,2,15) (I,6,1) (C,1,2)
         */
        // ------------------------------------------------------------------------------------
        // ------ Start your code
        // here---------------------------------------------------------
        sortDescendingByValue();
        // ------ End your code
        // here-----------------------------------------------------------
        // ------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

    private void sortDescendingByValue() {
        Animal[] apartmentArray = convertLinkedListToArray();
        Arrays.sort(apartmentArray,
                Comparator.comparingInt(a -> ((Animal) a).getPrice() * ((Animal) a).getAmount()).reversed());
        convertArrayToLinkedList(apartmentArray);
    }

    private Animal[] convertLinkedListToArray() {
        List<Animal> apartmentList = new ArrayList<>();
        Node current = head;

        while (current != null) {
            apartmentList.add(current.getInfo());
            current = current.next;
        }

        return apartmentList.toArray(new Animal[0]);
    }

    private void convertArrayToLinkedList(Animal[] apartmentArray) {
        clear();

        for (Animal apartment : apartmentArray) {
            addLast(apartment.getName(), apartment.getPrice(), apartment.getAmount());
        }
    }
}
