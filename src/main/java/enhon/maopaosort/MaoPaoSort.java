package enhon.maopaosort;

/**
 * @author yinhao02
 * @ClassName MaoPaoSort.java
 * @Description MaoPaoSort
 * @createTime 2022年04月14日 10:44:00
 */
public class MaoPaoSort {

    public static void main(String[] args) {

    }


    public static void choiceSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int y = i + 1; y < arr.length; ++y) {
                if (arr[i] < arr[y]) {
                    swap(arr, i, y);
                }
            }
        }
    }


    public static void swap(int[] arr, int i, int y) {
        int tem = arr[i];
        arr[i] = arr[y];
        arr[y] = tem;
    }

    public static void maopaoSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int y = 0; y < arr.length - 1 - i; ++y) {
                if (arr[y] < arr[y + 1]) {
                    swap(arr, y + 1, y);
                }
            }
        }
    }
}
