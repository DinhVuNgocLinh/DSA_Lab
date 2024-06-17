package problem5;

// priorityQ.java
// demonstrates priority queue
// to run this program: C>java PriorityQApp
////////////////////////////////////////////////////////////////
class PriorityQ {
   // array in sorted order, from max at 0 to min at size-1
   private int maxSize;
   private long[] queArray;
   private int nItems;

   // -------------------------------------------------------------
   public PriorityQ(int s) // constructor
   {
      maxSize = s;
      queArray = new long[maxSize];
      nItems = 0;
   }

   // -------------------------------------------------------------
   public void insert(long item) // insert item
   {
      if (nItems == maxSize) {
         System.out.println("The queue is full, cannot insert more item");
         return;
      } else {
         int j;

         if (nItems == 0) // if no items,
            queArray[nItems++] = item; // insert at 0
         else // if items,
         {
            for (j = nItems - 1; j >= 0; j--) // start at end,
            {
               if (item > queArray[j]) // if new item larger,
                  queArray[j + 1] = queArray[j]; // shift upward
               else // if smaller,
                  break; // done shifting
            } // end for
            queArray[j + 1] = item; // insert it
            nItems++;
         } // end else (nItems > 0)
      }
   } // end insert()
     // -------------------------------------------------------------

   public long remove() // remove minimum item
   {
      return queArray[--nItems];
   }

   // -------------------------------------------------------------
   public long peekMin() // peek at minimum item
   {
      return queArray[nItems - 1];
   }

   // -------------------------------------------------------------
   public boolean isEmpty() // true if queue is empty
   {
      return (nItems == 0);
   }

   // -------------------------------------------------------------
   public boolean isFull() // true if queue is full
   {
      return (nItems == maxSize);
   }

   // -------------------------------------------------------------
   public void displayPriorityQ() {
      for (int i = nItems - 1; i >= 0; i--) {
         System.out.print(queArray[i] + " ");
      }
   }

} // end class PriorityQ
  ////////////////////////////////////////////////////////////////

class PriorityQApp {
   public static void main(String[] args) {
      PriorityQ thePQ = new PriorityQ(5);
      thePQ.insert(30);
      thePQ.insert(50);
      thePQ.insert(10);
      thePQ.insert(40);
      thePQ.insert(20);
      thePQ.displayPriorityQ();
      System.out.println();
      // now queue full
      thePQ.insert(60);

      // the QueueApp.java just follow the FIFO so this more efficent when maintain a
      // list items in order they were added. Like who line up first will be served
      // first. moreover insertion of Queue time complexity is O(1) while PriorityQ is
      // O(n) so that insert of Queue is more efficent.
      // the Priority.java the insertion is less efficient than QueueApp.java because
      // every time insert this have to sort the queue, but more efficient when we
      // need to frequently access the highest (or lowest) priority item

      // while (!thePQ.isEmpty()) {
      // long item = thePQ.remove();
      // System.out.print(item + " "); // 10, 20, 30, 40, 50
      // } // end while
      // System.out.println("");
   } // end main()
     // -------------------------------------------------------------
} // end class PriorityQApp
  ////////////////////////////////////////////////////////////////
