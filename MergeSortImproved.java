
/**
 * Improved MergeSort class.
 */

public class MergeSortImproved {

  /**
   * Merge sort the provided array using an improved merge operation.
   */
  public static <T extends Comparable<T>> void mergeSortHalfSpace(T[] items) {
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Comparable[items.length / 2 + 1];
    mergeSortHalfSpace(items, temp, 0, items.length - 1);
  }

  private static <T extends Comparable<T>> void mergeSortHalfSpace(T[] items, T[] temp, int left,
      int right) {

    if (left >= right) { // List has one record
      return;
    }

    int mid = (left + right) / 2; // Select midpoint

    mergeSortHalfSpace(items, temp, left, mid); // Mergesort first half
    mergeSortHalfSpace(items, temp, mid + 1, right); // Mergesort second half

    mergeHalfSpace(items, temp, left, mid, right);

  }

  /**
   * Merge two sorted sub-arrays.
   */
  private static <T extends Comparable<T>> void mergeHalfSpace(T[] items, T[] temp, 
      int left, int mid,
      int right) {

    for (int i = left; i <= mid; i++) {
      temp[i - left] = items[i];
    }

    int i1 = 0;
    int i2 = mid + 1;
   
    for (int curr = left; curr <= right; curr++) {
      if (i1 >= mid - left + 1) { 
        items[curr] = items[i2++];
      } else if (i2 > right) { // Right subarray exhausted
        items[curr] = temp[i1++];
      } else if (temp[i1].compareTo(items[i2]) <= 0) { // Get smaller value
        items[curr] = temp[i1++];
      } else {
        items[curr] = items[i2++];
      }
    }
  }
  
  /**
   * Merge sort the provided array by using an improved merge operation and
   * switching to insertion sort for small sub-arrays.
   */
  public static <T extends Comparable<T>> void mergeSortAdaptive(T[] items) {
    int threshhold = 190;
    if (items.length < threshhold) {
      BasicSorts.insertionSort(items);
    } else {
      mergeSortHalfSpace(items);
    }
  }

  /**
   * Merge sort the provided sub-array using our improved merge sort. This is the
   * fallback method used by introspective sort.
   */
  public static <T extends Comparable<T>> void mergeSubsortAdaptive(T[] items, int start, int end) {
    // TODO
    // You will need to call the insertion sort method from BasicSorts.java:
    //   insertionSort(T[] items, int start, int end)
    int threshhold = 190;
    if ((end - start) < threshhold) {
      BasicSorts.insertionSubsort(items, start, end);  
    } else {
      @SuppressWarnings("unchecked")
      T[] temp = (T[]) new Comparable[((start + end) / 2) - start + 1];
      mergeSortHalfSpace(items, temp, start, end);
    }
  }

}
