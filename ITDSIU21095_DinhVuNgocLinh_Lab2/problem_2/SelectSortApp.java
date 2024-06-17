// selectSort.java
// demonstrates selection sort
// to run this program: C>java SelectSortApp
////////////////////////////////////////////////////////////////
class ArraySel
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArraySel(int max)          // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
//--------------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
//--------------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
//--------------------------------------------------------------
   public void selectionSort()
      {
      int out, in, min;
      int comparisonCounter = 0;

      for(out=0; out<nElems-1; out++)   // outer loop
         {
         min = out;                     // minimum
         for(in=out+1; in<nElems; in++) // inner loop
         {
            if (a[in] < a[min]) {         // if min greater,
               comparisonCounter++;
               System.out.println("\nThe comparison: "+a[in]+" < "+a[min]+"(True)");
               System.out.println("The number of comparison after inner loop = " + comparisonCounter);
               min = in;
               // we have a new min
            }
         }swap(out, min);// swap them
         }  // end for(out)
         System.out.println("\nThe total number of comparison = " + comparisonCounter);
      }  // end selectionSort()
//--------------------------------------------------------------
   private void swap(int one, int two)
      {
         System.out.println("\nIntem that are swapped is "+a[one]+" and "+a[two]);
         long temp = a[one];
         a[one] = a[two];
         a[two] = temp;
         display();
      }
//--------------------------------------------------------------
   }  // end class ArraySel
////////////////////////////////////////////////////////////////
class SelectSortApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      ArraySel arr;                 // reference to array
      arr = new ArraySel(maxSize);  // create the array

      arr.insert(77);               // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);
      System.out.println("Array before swap");
      arr.display();                // display items

      arr.selectionSort();          // selection-sort them

      arr.display();                // display them again
         System.out.println("\nBest-case, average-case, and worst-case scenario: O(n^2)");
      }  // end main()
   }  // end class SelectSortApp
////////////////////////////////////////////////////////////////
