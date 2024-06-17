public class LinkQueue {
    private FirstLastList theList;
    private int callCount;

    public LinkQueue() // constructor
    {
        theList = new FirstLastList();
        callCount = 0;
    } // make a 2-ended list

    public boolean isEmpty() // true if queue is empty
    {
        return theList.isEmpty();
    }

    public void insert(long j) // insert, rear of queue
    {
        theList.insertLast(j);
    }

    public long remove() // remove, front of queue
    {
        return theList.deleteFirst();
    }

    public int size() {
        return theList.size();
    }

    public void removeN(int n) {
        callCount++;
        if (callCount == 0) {
            Link current = theList.getFirst();
            Link previous = null;
            for (int i = 1; i < n; i++) {
                if (current.next != null) {
                    previous = current;
                    current = current.next;
                } else {
                    System.out.println("The list has fewer than " + n + " items.");
                    return;
                }
            }
            if (previous != null) {
                previous.next = current.next;
            } else {
                theList.deleteFirst();
            }
            callCount = 0;
        }
    }

    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }
}
