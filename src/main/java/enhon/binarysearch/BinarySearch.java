package enhon.binarysearch;

/**
 * @author yinhao02
 * @ClassName BinarySearch.java
 * @Description BinarySearch
 * @createTime 2022年04月13日 20:25:00
 */
public class BinarySearch {
    private static int binarySearch0(long[] arr, int fromIndex, int toIndex,
                                     long key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = arr[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
}
