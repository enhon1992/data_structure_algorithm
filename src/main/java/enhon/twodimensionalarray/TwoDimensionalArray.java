package enhon.twodimensionalarray;

/**
 * @author yinhao02
 * @ClassName TwoDimensionalArray.java
 * @Description TwoDimensionalArray
 * @createTime 2022年04月15日 10:02:00
 */
public class TwoDimensionalArray {
    /**
     * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
     * Consider the following matrix:
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     * Given target = 5, return true.
     * Given target = 20, return false.
     *
     * @param arr
     * @return 要求时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
     */

    public boolean isExist(int[][] arr, int key) {
        int rowNum = arr.length, colNum = arr[0].length;
        if (arr == null || rowNum == 0 || colNum == 0)
            return false;
        int x = 0, y = colNum - 1;
        while (x < rowNum && y >= 0) {
            int target = arr[x][y];
            if (target == key) {
                return true;
            } else if (target > key) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
