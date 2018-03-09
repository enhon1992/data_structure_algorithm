package enhon.lcs;

import java.util.Arrays;

public class Lcs {


    public static void main(String[] args) {
      printLcs("ABCBDAB","BDCABA");

    }

    public static void  printLcs(String strA,String strB){
        if(strA==null ||strB==null){
            throw new NullPointerException();
        }
        int array[][]=new int[strA.length()+1][strB.length()+1];//注意二维数组的长度是strA+1或者 strB+1   一维数组长度是strB+1或者 strA+1
        for(int i=1;i<array.length;++i){//因为array[0][?]=0   array[?][0]=0
            for(int j=1;j<array[i].length;++j){
                if(strA.charAt(i-1)==strB.charAt(j-1)){
                    array[i][j]=array[i-1][j-1]+1;
                }else{
                    array[i][j]=array[i][j-1]>array[i-1][j]?array[i][j-1]:array[i-1][j];
                }
            }

        }
        int i=strA.length(),j=strB.length();
        String[] lcsArray=new String[array[strA.length()][strB.length()]];
        int index=lcsArray.length-1;
        while (i!=0&&j!=0){
            if(strA.charAt(i-1)==strB.charAt(j-1)){
                lcsArray[index--]=strA.charAt(i-1)+"";
                i--;
                j--;
            }else{
                if(array[i][j-1]>array[i-1][j]){
                    --j;
                }else if(array[i][j-1]==array[i-1][j]){
                    --j;
                }else{
                    --i;
                }
            }
        }

        System.out.println(Arrays.toString(lcsArray));
    }

}
