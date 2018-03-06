package enhon.instackandoutstack;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;

public class InStackAndOutStack {

    public static void main(String[] args) {
        String inStr="ABCDE";
        String outStr="EDCBA";
        System.out.println(isCorrect(inStr,outStr));

    }


    public static  boolean isCorrect(String inStr,String outStr){
        if(inStr==null||outStr==null||inStr.length()==0||outStr.length()==0||outStr.length()!=inStr.length()){
            return false;
        }
        MyStack<Character> stack=new MyStack<Character>();
        char temp='\u0000';
        int inStrIndex=0;
        for(int i=0;i<outStr.length();){//注意++i是在弹栈的后面进行
            temp=outStr.charAt(i);
            if(!stack.isEmpty()&&stack.get().equals(temp)){
                stack.poll();
                ++i;//注意是这里进行的i++的
            }else{
                if(inStrIndex==inStr.length()){
                    return false;
                }
                stack.add(inStr.charAt(inStrIndex));
                inStrIndex++;
            }
        }
        return true;
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
