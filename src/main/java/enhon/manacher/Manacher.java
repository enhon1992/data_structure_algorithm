package enhon.manacher;

import java.util.Arrays;

public class Manacher {


    public static void main(String[] args) {
        longestPalindrome("abaabafdfdhfffffdfdghgjhgj");
    }
    private static String preProcess(String s){
        int n = s.length();
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("#" + s.charAt(i));
        }
        sb.append("#") ;
        return  sb.toString();
    }
    public static  String longestPalindrome(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int id = 0, Max = 1;
        P[0]=1;
        for (int i = 1; i < n; i++){
            if(Max>i){
                P[i]=Math.min(P[2*id-i],Max-i);
            }else{
                P[i]=1;
            }
            // Attempt to expand palindrome centered at i
            while((i+P[i])<n&&(i-P[i]>=0)&&T.charAt(i+P[i])==T.charAt(i-P[i]))
                P[i]++;
            // if palindrome centered at i expand past R
            // adjust center based on expanded palindrome
            if ( i + P[i] > Max) {
                id = i;
                Max = i + P[i];
            }
        }
        int maxIndex=0,maxValue=P[0];
        for (int i = 0; i < n ; i++) {
            if (P[i] >  maxValue) {
                maxValue=P[i];
                maxIndex=i;
            }
        }
        String result=T.substring(maxIndex-maxValue+1,maxIndex+maxValue).replaceAll("#","");
        System.out.println(result);
        System.out.println(Arrays.toString(T.toCharArray()));
        System.out.println(Arrays.toString(P));
        return result;
    }
}
