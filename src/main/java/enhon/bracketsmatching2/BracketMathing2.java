package enhon.bracketsmatching2;

import java.util.ArrayList;

public class BracketMathing2 {

    public static void main(String[] args) {
        String str="";
        System.out.println("".length());
    }


    private static boolean isLeftBracket(char c){
        if(c=='('){
            return  true;
        }
        return  false;
    }


    private static boolean isRightBracket(char c){
        if(c==')'){
            return  true;
        }
        return  false;
    }
    private  static  int getMathingSubStr(String str){
        MyStack<Integer> stack=new MyStack<Integer>();
        if(str==null||str.length()==0){
            return  0;
        }
        int startIndex=-1;
        int maxLength=0;
        char tempChar='\u0000';
        for(int i=0;i<str.length();++i){
            tempChar=str.charAt(i);
            if(isLeftBracket(tempChar)) {
                stack.add(i);//因为stack中只有"("  这事就直接压栈下标
            }else{//右括号
                 stack.poll();
                if(stack.isEmpty()){
                    startIndex=i;
                }else{//不为空肯定就先弹出 栈顶元素
                    stack.poll();
                    if(stack.isEmpty()){
                        maxLength=maxLength>(i-startIndex)?maxLength:i-startIndex;
                    }else{
                        maxLength=maxLength>(i-stack.get())?maxLength:i-stack.get();
                    }
                }
            }

        }
        return  maxLength;
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