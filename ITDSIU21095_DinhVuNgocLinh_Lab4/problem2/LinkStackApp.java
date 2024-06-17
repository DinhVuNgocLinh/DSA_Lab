// linkStack.java
// demonstrates a stack implemented as a list
// to run this program: C>java LinkStackApp
class Link {
   public long dData; // data item
   public Link next; // next link in list

   public Link(long dd) // constructor
   {
      dData = dd;
   }

   public void displayLink() // display ourself
   {
      System.out.print(dData + " ");
   }
} // end class Link

class LinkList {
   private Link first; // ref to first item on list

   public LinkList() // constructor
   {
      first = null;
   } // no items on list yet

   public boolean isEmpty() // true if list is empty
   {
      return (first == null);
   }

   public void insertFirst(long dd) // insert at start of list
   { // make new link
      Link newLink = new Link(dd);
      newLink.next = first; // newLink --> old first
      first = newLink; // first --> newLink
   }

   public long deleteFirst() // delete first item
   { // (assumes list not empty)
      Link temp = first; // save reference to link
      first = first.next; // delete it: first-->old next
      return temp.dData; // return deleted link
   }

   // insertLast method
   public void insertLast(long dd) {
      Link newLink = new Link(dd);
      if (isEmpty()) {
         first = newLink;
      } else {
         Link current = first;
         while (current.next != null) {
            current = current.next;
         }
         current.next = newLink;
      }
   }

   public void displayList() {
      Link current = first; // start at beginning of list
      while (current != null) // until end of list,
      {
         current.displayLink(); // print data
         current = current.next; // move to next link
      }
      System.out.println("");
   }
} // end class LinkList

class LinkStack {
   private LinkList theList;

   public LinkStack() // constructor
   {
      theList = new LinkList();
   }

   public void push(long j) // put item on top of stack
   {
      theList.insertFirst(j);
   }

   public long pop() // take item from top of stack
   {
      return theList.deleteFirst();
   }

   public boolean isEmpty() // true if stack is empty
   {
      return (theList.isEmpty());
   }

   public void displayStack() {
      System.out.print("Stack (top-->bottom): ");
      theList.displayList();
   }
} // end class LinkStack

class LinkStackApp {
   public static void main(String[] args) {
      LinkList theList = new LinkList(); // make stack

      theList.insertFirst(20); // push items
      theList.insertFirst(40);
      theList.insertFirst(60); // push items
      theList.insertFirst(80);

      theList.displayList(); // display stack

      // idea : delete from list and push to the stack
      // then 'insertLast' to the list that pop from the stack
      // to do this i've created insertLast method
      LinkStack theNewStack = new LinkStack();
      while (!theList.isEmpty()) {
         theNewStack.push(theList.deleteFirst());
      }
      while (!theNewStack.isEmpty()) {
         theList.insertLast(theNewStack.pop());
      }
      theList.displayList();

   } // end main()
} // end class LinkStackApp
  ////////////////////////////////////////////////////////////////
