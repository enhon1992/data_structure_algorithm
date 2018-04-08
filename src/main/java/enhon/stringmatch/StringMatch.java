package enhon.stringmatch;

public class StringMatch {


    public static void main(String[] args) {

    }


    /**
     * 模式字符串匹配的BruteForce算法
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
}
