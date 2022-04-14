package enhon.duplicatenum;

/**
 * @author yinhao02
 * @ClassName DuplicatedNum.java
 * @Description DuplicatedNum
 * @createTime 2022年04月14日 10:46:00
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * Input:
 * {2, 3, 1, 0, 2, 5}
 * <p>
 * Output:
 * 2
 * <p>
 * 要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
 */
public class DuplicatedNum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 0, 2, 5};
        System.out.println(findDuplicatedNum(arr));
    }


    public static int findDuplicatedNum(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                }
                swap(arr, i, arr[i]);
            }
        }
        return -1;
    }

    public static void swap(int[] arr, int i, int y) {
        int tem = arr[i];
        arr[i] = arr[y];
        arr[y] = tem;
    }
}
