/**
  OrderedList_inArraySlots, holding Integers

  A list with the invariant the elements are in order by
  increasing value, implemented using a
  ArrayList<Integer>
 */

public class OrderedList_inArraySlots
    implements OrderedList {

    private java.util.ArrayList<Integer> list_iAS;


    /**
      @return the index any occurrence of 
              \findMe in this list, or -1 if
              \findMe is absent from this list.
     */
    public int indexOf( Integer findMe) {
        for (int low = 0, high = size() - 1; low <= high;) {
          int elementToCheck = (low + high) / 2;
          if (get(elementToCheck).compareTo(findMe) == 0) {
            return elementToCheck;
          } else if (get(elementToCheck).compareTo(findMe) < 0) {
            low = elementToCheck + 1;
          } else {
            high = elementToCheck - 1;
          }
        }
        return -1; //None found.
    }
    
    public int indexOf_recursive( Integer findMe, int low, int high) {
      if (low > high) {
        return -1;
      }
      int elementToCheck = (low + high) / 2;
      if (get(elementToCheck).compareTo(findMe) == 0) return elementToCheck;
      else if (get(elementToCheck).compareTo(findMe) < 0) return indexOf_recursiveStyle(findMe, low+1, high);
      else return indexOf_recursiveStyle(findMe, low, high - 1);
    }

    // ------ code from previous assignments below here ----

    public OrderedList_inArraySlots() {
        list_iAS = new java.util.ArrayList<Integer>();
    }

    /**
      @return the number of elements in this list
     */
    public int size(){
        return list_iAS.size();
    }

    /**
      @return a string representation of this Orderedlist_iAS
     */
    public String toString() {
        return list_iAS.toString();
    }


    /**
      Put @value where it belongs in the list.
      @pre: the list is in increasing order
     */
     public boolean add( Integer value) {
         int dest = 0;
         for( ; dest < list_iAS.size() && list_iAS.get( dest) < value
              ; dest++) ;
         // System.out.println( "OL adding " + value
         //                   + " at index " + dest);
         list_iAS.add( dest, value);
         return true;
     }


     /**
      @return element @index from this list
      precondition: @index is within the bounds of the array.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether the condition was violated.)
     */
    public Integer get( int index ) {
        return list_iAS.get( index);
    }


    /**
      Remove the element at position @index in this list.

      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).

      @return the value that was removed from the list
     */
    public Integer remove( int index) {
        return list_iAS.remove( index);
    }
}
