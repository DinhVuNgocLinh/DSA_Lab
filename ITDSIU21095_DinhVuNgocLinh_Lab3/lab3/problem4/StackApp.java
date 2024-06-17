package problem4;

// stack.java
// demonstrates stacks
// to run this program: C>java StackApp
////////////////////////////////////////////////////////////////
class StackX {
   private int maxSize; // size of stack array
   private long[] stackArray;
   private int top; // top of stack
   // --------------------------------------------------------------

   public StackX(int s) // constructor
   {
      maxSize = s; // set array size
      stackArray = new long[maxSize]; // create array
      top = -1; // no items yet
   }

   // --------------------------------------------------------------
   public void push(long j) // put item on top of stack
   {
      if (top == maxSize - 1) {
         System.out.println("The stack is full, cannot push more item");
         return;
      } else {
         stackArray[++top] = j; // increment top, insert item
      }
   }

   // --------------------------------------------------------------
   public long pop() // take item from top of stack
   {
      if (top == -1) {
         System.out.println("The stack is empty, nothing for u to delete");
         return -1;
      } else {
         return stackArray[top--]; // access item, decrement top
      }
   }

   // --------------------------------------------------------------
   public long peek() // peek at top of stack
   {
      return stackArray[top];
   }

   // --------------------------------------------------------------
   public boolean isEmpty() // true if stack is empty
   {
      return (top == -1);
   }

   // --------------------------------------------------------------
   public boolean isFull() // true if stack is full
   {
      return (top == maxSize - 1);
   }

   // --------------------------------------------------------------
   public void displayStack() {
      for (int i = 0; i <= top; i++) {
         System.out.print(stackArray[i] + " ");
      }
   }

   public void displayStackArray() {
      for (int i = 0; i <= maxSize - 1; i++) {
         System.out.print(stackArray[i] + " ");
      }
   }

} // end class StackX
  ////////////////////////////////////////////////////////////////

class StackApp {
   public static void main(String[] args) {
      StackX theStack = new StackX(10); // make new stack
      theStack.push(20); // push items onto stack
      theStack.push(40);
      theStack.push(60);
      theStack.push(80);
      theStack.displayStack(); // display stack
      System.out.println();

      theStack.pop();
      theStack.pop();
      theStack.displayStack(); // display stack
      System.out.println();

      theStack.push(90);
      theStack.push(100);
      theStack.displayStack(); // display stack
      System.out.println();
      theStack.displayStackArray(); // display stack array
      System.out.println();
      // push full to check
      theStack.push(930);
      theStack.push(1300);
      theStack.push(190);
      theStack.push(3100);
      theStack.push(970);
      theStack.push(1040);
      // now stack is full
      theStack.push(234);

      theStack.pop();
      theStack.pop();
      theStack.pop();
      theStack.pop();
      theStack.pop();
      theStack.pop();
      theStack.pop();
      theStack.pop();
      theStack.pop();
      theStack.pop();
      // stack now is empty
      theStack.pop();

      // while (!theStack.isEmpty()) // until it's empty,
      // { // delete item from stack
      // long value = theStack.pop();
      // System.out.print(value); // display it
      // System.out.print(" ");
      // } // end while
      // System.out.println("");
   } // end main()
} // end class StackApp
  ////////////////////////////////////////////////////////////////
