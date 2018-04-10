package enhon.stringmatch;

import java.util.Arrays;

public class StringMatch {


    public static void main(String[] args) {
        System.out.println(bruteForce("hjhrehreidffdd","adff"));
        System.out.println(kmp2("hjhrehreidffdd","adff"));
    }



    public static int[]  getNextArray(String str){
        char[] charArray = str.toCharArray();
        int temp[]=new int[str.length()];
        String tempStr=null;
        int tempIndex=0;
        for(int i=0;i<str.length();++i){
            if(i==0){
                temp[0]=-1;
            }else if(i==1){
                temp[1]=0;
            }else{
                tempStr=str.substring(0,i);
                tempIndex=1;
                while((!tempStr.substring(0,tempStr.length()-tempIndex).equals(tempStr.substring(tempIndex,tempStr.length())))){
                    tempIndex++;
                    if((tempStr.length()-tempIndex)<1){
                        break;
                    }
                }
                if((tempStr.length()-tempIndex)<1){
                    temp[i]=0;
                }else{
                    temp[i]=tempStr.substring(0,tempStr.length()-tempIndex).length();
                }
            }

        }
        return temp;
    }

    /**
     * 求next数组更优的解法
     * @param str
     * @return
     */
    public static int[]  getNextArray2(String str){
        char[] charArray = str.toCharArray();
        int temp[]=new int[str.length()];
        temp[0]=-1;
        int k=-1,j=0;
        while (j<str.length()-1){
            if(k==-1||charArray[j]==charArray[k]){
                k++;
                j++;
                temp[j]=k;
            }else{
                k=temp[k];
            }
        }
        return temp;
    }


    /**
     * 模式字符串匹配的BruteForce算法
     * 时间复杂度是TEXT.LENGTH*PATTERN.LENGTH  空间负载度是O(1)
     * @return
     */
    public static int bruteForce(String text,String pattern)
    {
        int i=0;
        int j=0;
        int size=pattern.length();
        int last=text.length()-size;
        while ((i<=last)&&(j<size)){
            if(text.charAt(i+j)==pattern.charAt(j)){
                j++;
            }else{
                i++;
                j=0;
            }
        }
        if(j>=size){
            return i;
        }
        return -1;
    }


    /**
     *
     * 时间复杂度是TEXT.LENGTH
     * 所以，如果文本串的长度为n，模式串的长度为m，那么匹配过程的时间复杂度为O(n)，算上计算next的O(m)时间，KMP的整体时间复杂度为O(m + n)。
     * @return
     */
    public static int kmp(String text,String pattern)
    {
        int ans=-1;
        int i=0;
        int j=0;
        int size=pattern.length();
        int last=text.length()-size;
        int[] next=getNextArray2(pattern);
        while (i<text.length()){
            if(j==-1||text.charAt(i)==pattern.charAt(j)){
                ++i;
                ++j;
            }else{
                j=next[j];
            }
            if(j==size){
                ans=i-size;
                break;
            }
        }
        return ans;
    }


    /**
     *
     * 时间复杂度是TEXT.LENGTH 空间负载度是O(PATTERN.LENGTH)
     * 所以，如果文本串的长度为n，模式串的长度为m，那么匹配过程的时间复杂度为O(n)，算上计算next的O(m)时间，KMP的整体时间复杂度为O(m + n)。
     * 这个算法比较好理解
     * @return
     */
    public static int kmp2(String text,String pattern)
    {
        int[] next=getNextArray2(pattern);
        int i=0;
        int j=0;
        int size=pattern.length();
        int last=text.length()-size;
        while ((i<=last)&&(j<size)){
            if(text.charAt(i+j)==pattern.charAt(j)){
                j++;
            }else{
                i=i+j-next[j];
                j=next[j]+1;
            }
        }
        if(j>=size){
            return i;
        }
        return -1;
    }
}
