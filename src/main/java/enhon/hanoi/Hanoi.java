package enhon.hanoi;

public class Hanoi {


    public static void main(String[] args) {
        System.out.println(calc("BBAAAAAAAAAAAAAAA",'A','C','B'));
    }

    public static  void move(int n,char from,char to,char aux){
        if(n==1){
            moveOne(from,to);
            return;
        }
        move(n-1,from,aux,to);
        moveOne(from,to);
        move(n-1,aux,to,from);
    }
    public static  void moveOne(char from,char to){
        //......
    }


    /**
     * 这个方法是计算 str所对应的状态需要的步数
     * @param str
     * @param from
     * @param to
     * @param aux
     * @return
     */
    public static  int calc(String str,char  from,char to,char aux){
        if(str==null||str.length()==0){
            return 0;
        }
        int size=str.length();
        if(str.charAt(size-1)==aux){
            return -1;
        }

        if(str.charAt(size-1)==to){
            int n=calc(str.substring(0,size-1),aux,to,from);
            if(n==-1){
                return -1;
            }
            return 1<< (size-1)+n;
        }
        return calc(str.substring(0,size-1),from,aux,to);//str.charAt(size-1)==from
    }
}
