package problem3;

// Queue.java
// demonstrates queue
// to run this program: C>java QueueApp
////////////////////////////////////////////////////////////////
class Queue {
   private int maxSize;
   private long[] queArray;
   private int front;
   private int rear;
   private int nItems;
   private int callCount; // count for remove after N calls
   private long processingTime; // processing time

   // --------------------------------------------------------------
   public Queue(int s) // constructor
   {
      maxSize = s;
      queArray = new long[maxSize];
      front = 0;
      rear = -1;
      nItems = 0;
      processingTime = 0; // initialize processing time = 0
      callCount = 0; // initialize callCount = 0
   }

   // --------------------------------------------------------------
   public void insert(long j, long time) // put item at rear of queue
   {
      if (nItems == maxSize) { // extend the insert methods when it full
         System.out.println("Error! The queue is full, cannot insert more item");
         return; // if queue full return the old queue
      }
      if (rear == maxSize - 1) // deal with wraparound
         rear = -1;
      queArray[++rear] = j; // increment rear and insert
      nItems++; // one more item
      processingTime += time; // processing time
   }

   public long getProcessingTime() { // to get processing time
      return processingTime;
   }

   public long removeAfterNCalls(int n) { // remove item after N calls
      callCount++;
      if (callCount < n) {
         System.out.println("This method hasd been call" + callCount + " times. Remove an item after " + n + "calls");
         return -1;
      } else {
         callCount = 0; // reset
         return remove(); // remove item
      }
   }

   // --------------------------------------------------------------
   public long remove() // take item from front of queue
   {
      if (nItems == 0) { // extend the remoove methods when it empty
         System.out.println("Error!!! The qurue is empty, nothing to remove");
         return -1;
      }
      long temp = queArray[front++]; // get value and incr front
      if (front == maxSize) // deal with wraparound
         front = 0;
      nItems--; // one less item
      return temp;
   }

   // --------------------------------------------------------------
   public long peekFront() // peek at front of queue
   {
      return queArray[front];
   }

   // --------------------------------------------------------------
   public boolean isEmpty() // true if queue is empty
   {
      return (nItems == 0);
   }

   // --------------------------------------------------------------
   public boolean isFull() // true if queue is full
   {
      return (nItems == maxSize);
   }

   // --------------------------------------------------------------
   public int size() // number of items in queue
   {
      return nItems;
   }

   public void displayQueueArray() {
      for (int i = 0; i < maxSize; i++) {
         if (i < nItems) {
            System.out.print(queArray[i] + " ");
         } else {
            System.out.print("_"); // print a underscore for empty spaces
         }
      }
   }

   public void displayFront() {// method to display the front
      System.out.print(queArray[front]);
   }

   public void displayRear() {// method to display th rear
      System.out.print(queArray[rear]);
   }

   public void displayQueue() { // method to display the queue use a temporary front
      int tempFront = front;
      for (int i = 0; i < nItems; i++) {
         System.out.print(queArray[tempFront] + " ");
         tempFront++;
         if (tempFront == maxSize) {
            tempFront = 0;
         }
      }
   }

   public void displayQ() { // method to display the queue
      if (rear >= front) { // no wraparound
         for (int i = front; i <= rear; i++) {
            System.out.print(queArray[i] + " ");
         }
      } else { // wraparound
         for (int i = front; i < maxSize; i++) {
            System.out.print(queArray[i] + " ");
         }
         for (int i = 0; i <= rear; i++) {
            System.out.print(queArray[i] + " ");
         }
      }
   }
   // --------------------------------------------------------------
} // end class Queue
  ////////////////////////////////////////////////////////////////

class QueueApp {
   public static void main(String[] args) {
      Queue theQueue = new Queue(5); // queue holds 5 items

      theQueue.insert(10, 5); // insert 4 items
      theQueue.insert(20, 3);
      theQueue.insert(30, 7);
      theQueue.insert(40, 9);

      theQueue.displayQueue(); // display th queue
      System.out.println();

      theQueue.displayQueueArray(); // display the quaue array

      theQueue.remove(); // remove 3 items
      theQueue.remove(); // (10, 20, 30)
      theQueue.remove();

      theQueue.insert(50, 10); // insert 4 more items
      theQueue.insert(60, 4); // (wraps around)
      theQueue.insert(70, 20);
      theQueue.insert(80, 15);

      theQueue.displayQ(); // this also display th queue
      System.out.println();

      theQueue.displayFront(); // this is display front of queue
      System.out.println();

      theQueue.displayRear(); // display rear of queue
      System.out.println();

      System.out.println("The queue is full? " + theQueue.isFull());
      // insert more items
      theQueue.insert(90, 18);
      theQueue.displayQueue();
      System.out.println();
      // we can see that even the queue is full queue still insert to it and display
      // it, same with remove items

      theQueue.remove();
      theQueue.remove();
      theQueue.remove();
      theQueue.remove();
      theQueue.remove();
      System.out.println("The queue is empty? " + theQueue.isEmpty());
      // remove when queue is empty
      theQueue.remove();
      theQueue.displayQueue();
      // processing time
      System.out.println("Total processing time: " + theQueue.getProcessingTime());
      // remove after n calls
      for (int i = 0; i < 5; i++) {
         long removedItem = theQueue.removeAfterNCalls(3);
         if (removedItem != -1) {
            System.out.println("Removed item: " + removedItem);
         }
      }

      // while (!theQueue.isEmpty()) // remove and display
      // { // all items
      // long n = theQueue.remove(); // (40, 50, 60, 70, 80)
      // System.out.print(n);
      // System.out.print(" ");
      // }
      // System.out.println("");
   } // end main()
} // end class QueueApp
  ////////////////////////////////////////////////////////////////
