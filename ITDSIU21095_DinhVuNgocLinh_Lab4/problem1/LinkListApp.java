// linkList.java
// demonstrates linked list
// to run this program: C>java LinkListApp

class Link {
   public int iData; // data item
   public double dData; // data item
   public Link next; // next link in list

   public Link(int id, double dd) // constructor
   {
      iData = id; // initialize data
      dData = dd; // ('next' is automatically
   } // set to null)

   public void displayLink() // display ourself
   {
      System.out.print(this.toString());
   }

   @Override
   public String toString() {
      return "{" + iData + ", " + dData + "} ";
   }
} // end class Link

class LinkList {
   private Link first; // ref to first link on list

   public LinkList() // constructor
   {
      first = null; // no links on list yet
   }

   public boolean isEmpty() // true if list is empty
   {
      return (first == null);
   }

   // insert at start of list
   public void insertFirst(int id, double dd) { // make new link
      Link newLink = new Link(id, dd);
      newLink.next = first; // newLink --> old first
      first = newLink; // first --> newLink
   }

   public Link deleteFirst() // delete first item
   { // (assumes list not empty)
      Link temp = first; // save reference to link
      first = first.next; // delete it: first-->old next
      return temp; // return deleted link
   }

   public void displayList() {
      System.out.println(this.toString());
   }

   @Override
   public String toString() {
      String result = "List (first-->last): ";
      Link current = first; // start at beginning of list
      while (current != null) // until end of list,
      {
         current.displayLink(); // print data
         current = current.next; // move to next link
      }
      return result;
   }

   public Link getFirst() {
      return this.first;
   }

   public Link getLast() {
      if (this.isEmpty()) {
         return null;
      }
      Link current = this.first;
      while (current.next != null) {
         current = current.next;
      }
      return current;
   }

} // end class LinkList

class LinkListApp {
   public static void main(String[] args) {
      LinkList theList = new LinkList(); // make new list

      theList.insertFirst(22, 2.99); // insert four items
      theList.insertFirst(44, 4.99);
      theList.insertFirst(66, 6.99);
      theList.insertFirst(88, 8.99);

      theList.displayList(); // display list

      Link first = theList.getFirst();
      System.out.println(first.toString());

      Link last = theList.getLast();
      System.out.println(last.toString());

      // while( !theList.isEmpty() ) // until it's empty,
      // {
      // Link aLink = theList.deleteFirst(); // delete link
      // System.out.print("Deleted "); // display it
      // aLink.displayLink();
      // System.out.println("");
      // }
      // theList.displayList(); // display list
   } // end main()
} // end class LinkListApp
