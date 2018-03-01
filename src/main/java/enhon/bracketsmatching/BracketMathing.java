package enhon.bracketsmatching;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BracketMathing {

    public static void main(String[] args) {
        String str="([]{{}}()){}";
        System.out.println("".length());
    }


    private static boolean isLeftBracket(char c){
        if(c=='('||c=='{'||c=='['){
            return  true;
        }
        return  false;
    }


    private static boolean isRightBracket(char c){
        if(c==')'||c=='}'||c==']'){
            return  true;
        }
        return  false;
    }

    private static  boolean isMathingBracket(char s,char t){
        if((s=='('&&t==')')||(s=='['&&t==']')||(s=='{'&&t=='}')){
            return true;
        }
        return  false;
    }


    private  static  boolean isMathing(String str){
        MyStack<String> stack=new MyStack<String>();
        if(str==null||str.length()==0){
            return  false;
        }
        char tempChar='\u0000';
        for(int i=0;i<str.length();++i){
            tempChar=str.charAt(i);
            if(isLeftBracket(tempChar)) {
                stack.add(tempChar + "");
            }else{//右括号 因为字符串中只有左括号  右括号
                if(stack.isEmpty()||!isMathingBracket(stack.get().charAt(0),tempChar)){
                    return false;
                }else if(isMathingBracket(stack.get().charAt(0),tempChar)){
                    stack.poll();
                }
            }

        }
        return  stack.isEmpty();
    }
}
class  MyStack<E>{
    ArrayList<E> list=null;
    public MyStack(){
        list=new ArrayList<E>();
    }
    public E get(){
        if(list.isEmpty()){
            return null;
        }
        return list.get(list.size()-1);
    }

    public void add(E e){
        list.add(e);
    }


    public E poll(){
        if(list.isEmpty()){
            return null;
        }
        E re=list.get(list.size()-1);
        list.remove(list.size()-1);
        return re;
    }

    public  boolean isEmpty(){
        return  list.isEmpty();
    }
}