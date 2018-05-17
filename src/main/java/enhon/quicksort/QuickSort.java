package enhon.quicksort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {


    public void quickSort(List<Integer> list,int i,int j){
//        if(j<0){
//            return;
//        }
        if(j-i<=1){
            return;
        }else  if(j-i==2){
            if(list.get(i)>list.get(--j))
                swap(list, i, --j);
            return;
        }
        int start=i;
        int val=list.get(start);
        int end=j;
        while (true){
            if(list.get(--j)<val){
                if(j<=i){
                    break;
                }
                while (true){
                    if(list.get(++i)>=val){
                        if(j<=i){
                            break;
                        }
                        if(i==j){//找到基准点的位置
                            swap(list,start,i);
                            //递归并且判断条件
                            quickSort(list,start,i);
                            quickSort(list,i+1,end);
                        }else{
                            swap(list,i,j);//指正指定的两个元素相互交换
                        }

                    }
                }
            }
        }

    }


    public void swap(List<Integer> list,int i,int j){
        int tem=list.get(i);
        list.set(j,list.get(i));
        list.set(i,tem);
    }


    public static void main(String[] a){
        List<Integer> list=new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(3);
//        list.add(8);
//        list.add(7);
//        list.add(5);
//        list.add(10);
//        list.add(4);
//        list.add(6);
//        list.add(9);
        QuickSort quickSort=new QuickSort();
        quickSort.quickSort(list,0,3);
        System.out.println(list);
    }
}
class QuicklySort2
{


    public static void main(String[] args)
    {

//        quicksort qs = new quicksor();
//        int data[] = {44,22,2,32,54,22,88,77,99,11}; //需要排序的数组
//        qs.data = data;   //将该数组赋值给快速排序的数组
//        qs.sort(0, qs.data.length-1);  //调用排序方法
//        qs.display();                  //显示排序后的记录
        int data[] = {44,22,2,32,54,22,88,77,99,11}; //需要排序的数组
        Quicksort2.quickSort(data,0, data.length-1);
        System.out.println(Arrays.toString(data));

    }

}


class Quicksort2
{

    public static   void quickSort(int[] a, int low, int high) {
        //1,找到递归算法的出口
        if( low > high) {
            return;
        }
        //2, 存
        int i = low;
        int j = high;
        //3,key
        int key = a[ low ];
        //4，完成一趟排序
        while( i< j) {
            //4.1 ，从右往左找到第一个小于key的数
            while(i<j && a[j] > key){
                j--;
            }
            // 4.2 从左往右找到第一个大于key的数
            while( i<j && a[i] <= key) {
                i++;
            }
            //4.3 交换
            if(i<j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }else {//到这里必须相等
                System.out.println("调整位置开始:"+(i==j));
                // 4.4，调整key的位置
                int p = a[i];
                a[i] = a[low];
                a[low] = p;
                //5, 对key左边的数快排
                quickSort(a, low, i-1 );
                //6, 对key右边的数快排
                quickSort(a, i+1, high);
            }
        }



    }
}