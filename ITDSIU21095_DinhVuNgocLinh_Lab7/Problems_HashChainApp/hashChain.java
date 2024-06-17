package Problems_HashChainApp;

// hashChain.java
// demonstrates hash table with separate chaining
// to run this program: C:>java HashChainApp
import java.io.*;

////////////////////////////////////////////////////////////////
class Link { // (could be other items)
    private int iData; // data item
    public Link next; // next link in list
    // -------------------------------------------------------------

    public Link(int it) // constructor
    {
        iData = it;
    }

    // -------------------------------------------------------------
    public int getKey() {
        return iData;
    }

    // -------------------------------------------------------------
    public void displayLink() // display this link
    {
        System.out.print(iData + " ");
    }
} // end class Link
  ////////////////////////////////////////////////////////////////

class SortedList {
    private Link first; // ref to first list item
    // -------------------------------------------------------------

    public void SortedList() // constructor
    {
        first = null;
    }

    // -------------------------------------------------------------
    public int insert(Link theLink) // insert link, in order
    {
        int probeLength = 1;
        int key = theLink.getKey();
        Link previous = null; // start at first
        Link current = first;
        // until end of list,
        while (current != null && key > current.getKey()) { // or current > key,
            previous = current;
            current = current.next; // go to next item
            probeLength++;
        }
        if (previous == null) // if beginning of list,
            first = theLink; // first --> new link
        else // not at beginning,
            previous.next = theLink; // prev --> new link
        theLink.next = current; // new link --> current
        return probeLength;
    } // end insert()
      // -------------------------------------------------------------

    public void delete(int key) // delete link
    { // (assumes non-empty list)
        Link previous = null; // start at first
        Link current = first;
        // until end of list,
        while (current != null && key != current.getKey()) { // or key == current,
            previous = current;
            current = current.next; // go to next link
        }
        // disconnect link
        if (previous == null) // if beginning of list
            first = first.next; // delete first link
        else // not at beginning
            previous.next = current.next; // delete current link
    } // end delete()
      // -------------------------------------------------------------

    public LinkAndProbeLength find(int key) // find link
    {
        int probeLength = 1;
        Link current = first; // start at first
        // until end of list,
        while (current != null && current.getKey() <= key) { // or key too small,
            if (current.getKey() == key) // is this the link?
                return new LinkAndProbeLength(current, probeLength); // found it, return link
            current = current.next; // go to next item
            probeLength++;
        }
        return new LinkAndProbeLength(null, probeLength);
    } // end find()
      // -------------------------------------------------------------

    public void displayList() {
        System.out.print("List (first-->last): ");
        Link current = first; // start at beginning of list
        while (current != null) // until end of list,
        {
            current.displayLink(); // print data
            current = current.next; // move to next link
        }
        System.out.println("");
    }
} // end class SortedList
  ////////////////////////////////////////////////////////////////

class LinkAndProbeLength {
    public Link link;
    public int probeLength;

    public LinkAndProbeLength(Link link, int probeLength) {
        this.link = link;
        this.probeLength = probeLength;
    }
}

class HashTable {
    private SortedList[] hashArray; // array of lists
    private int arraySize;
    private int totalProbeLength;
    private int numInsertions;

    // -------------------------------------------------------------
    public HashTable(int size) // constructor
    {
        arraySize = size;
        hashArray = new SortedList[arraySize]; // create array
        for (int j = 0; j < arraySize; j++) // fill array
            hashArray[j] = new SortedList(); // with lists
        totalProbeLength = 0;
        numInsertions = 0;
    }

    // -------------------------------------------------------------
    public void displayTable() {
        for (int j = 0; j < arraySize; j++) // for each cell,
        {
            System.out.print(j + ". "); // display cell number
            hashArray[j].displayList(); // display list
        }
    }

    // -------------------------------------------------------------
    public int hashFunc(int key) // hash function
    {
        return key % arraySize;
    }

    // -------------------------------------------------------------
    public void insert(Link theLink) // insert a link
    {
        int key = theLink.getKey();
        int hashVal = hashFunc(key); // hash the key
        int probeLength = hashArray[hashVal].insert(theLink);
        totalProbeLength += probeLength;
        numInsertions++;
        displayLoadFactorAndAverageProbeLength(); // insert at hashVal
        System.out.println("Probe length for insert: " + probeLength);
    } // end insert()

    private void displayLoadFactorAndAverageProbeLength() {
        double loadFactor = (double) numInsertions / arraySize;
        double averageProbeLength = (double) totalProbeLength / numInsertions;
        System.out.println("Load factor: " + loadFactor + ", Average probe length: " + averageProbeLength);
    }
    // -------------------------------------------------------------

    public void delete(int key) // delete a link
    {
        int hashVal = hashFunc(key); // hash the key
        hashArray[hashVal].delete(key); // delete link
    } // end delete()
      // -------------------------------------------------------------

    public Link find(int key) // find link
    {
        int hashVal = hashFunc(key); // hash the key
        LinkAndProbeLength result = hashArray[hashVal].find(key);
        System.out.println("Probe length for find: " + result.probeLength);
        return result.link;
    }
    // -------------------------------------------------------------
} // end class HashTable
  ////////////////////////////////////////////////////////////////

class HashChainApp {
    public static void main(String[] args) throws IOException {
        int aKey;
        Link aDataItem;
        int size, n, keysPerCell = 100;
        // get sizes
        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        // make table
        HashTable theHashTable = new HashTable(size);
        for (int j = 0; j < n; j++) // insert data
        {
            aKey = (int) (java.lang.Math.random() *
                    keysPerCell * size);
            System.out.println("Generated key: " + aKey);
            aDataItem = new Link(aKey);
            theHashTable.insert(aDataItem);
        }
        while (true) // interact with user
        {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, or find: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new Link(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if (aDataItem != null)
                        System.out.println("Found " + aKey);
                    else
                        System.out.println("Could not find " + aKey);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            } // end switch
        } // end while
    } // end main()
      // --------------------------------------------------------------

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    // -------------------------------------------------------------
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    // -------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
    // --------------------------------------------------------------
} // end class HashChainApp
  ////////////////////////////////////////////////////////////////