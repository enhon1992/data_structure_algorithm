package enhon.stringquanpailie;

import java.util.Arrays;

public class StringQuanPaiLie {


    public static void main(String[] args) {
        String[] str={"A","B","C","D"};
        printQuanPaiLie(str,0);
    }

    public static void printQuanPaiLie(String[] strAray,int index){
        if(index==strAray.length-1) {
            System.out.println(Arrays.toString(strAray));
        }else{
            for(int i=index;i<strAray.length;++i){
                swap(strAray, i, index);
                printQuanPaiLie(strAray,index+1);
                swap(strAray, i, index);
            }
        }
    }

    public static  void swap(String[] strAray,int i,int j){
        String temp=strAray[i];
        strAray[i]=strAray[j];
        strAray[j]=temp;
    }
}
