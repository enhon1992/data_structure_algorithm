package enhon;
import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.io.*;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        FileReader fr= new FileReader("C:\\Users\\Enhon\\Desktop\\ecs_log");
        BufferedReader br = new BufferedReader(fr);
        HashMap<String,Integer> map=new HashMap<String, Integer>();
        String line = null;
        while ((line=br.readLine())!=null){
            if(line.contains("POST /appapi_getvcode HTTP/1.1")){
                if(map.get(line.split("\\ +")[0])==null){
                    map.put(line.split("\\ +")[0],1);
                }else{
                    map.put(line.split("\\ +")[0],map.get(line.split("\\ +")[0])+1);
                }
            }
        }
        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String,Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        };
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list,valueComparator);
        BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\Enhon\\Desktop\\ecs_ip_log"));
        for (Map.Entry<String, Integer> entry : list) {
            if(entry.getValue()>=30){
                System.out.println(entry.getKey() + ":" + entry.getValue());
                writer.write("-A INPUT -s "+entry.getKey()+"/32 -j DROP");
                writer.newLine();
            }
        }
        System.out.println("总的ip数"+list.size());
        br.close();
        writer.close();

        System.out.println("xxx");

    }


}
class OuterClass
{
//    static{
//        System.out.println("OuterClass static load.");
//    }

//    public OuterClass()
//    {
//        System.out.println("flag");
//    }
//    public OuterClass(String flag)
//    {
//        System.out.println("flag:"+flag);
//    }
    static class InnerStaticClass
    {
        //private static OuterClass out = new OuterClass("innerStatic");

        static{
            System.out.println("InnerStaticClass static load.");
            System.out.println(InnerStaticClass.a);
        }
        public static Integer a = 2;
//        private static void load()
//        {
//            System.out.println("InnerStaticClass func load().");
//        }
    }
//    public static  OuterClass getInstatnce()
//    {
//        return OuterClass.InnerStaticClass.out;
//    }
    public static void main(String[] args)
    {

        while (true){

        }
//        OuterClass out = OuterClass.InnerStaticClass.out;
//        OuterClass.InnerClass innerClass = out.new InnerClass() ;
        //OuterClass.InnerStaticClass.out.
    }

}


//class Appa
//{
//    public static void main(String[] args)  {
//        System.out.println(Outer.i);
//    }
//}
//
//class Outer
//{
//    static {
//        System.out.println("Class is load");
//        System.out.println(Outer.i);
//    }
//
//    public static  Integer i=2;
//
//}


class Appa
{
    public static void main(String[] args)  {
        HotSpotStackOverflowError a=new HotSpotStackOverflowError();
        a.run();
    }
}

class Outer
{

    static class  Inner{
        static {
            System.out.println("Class is load");
            System.out.println(Inner.i);
        }

        public static  Integer i=2;
    }
}


class HotSpotStackOverflowError{


    private void dontstop(){
        while (true){

        }
    }

    public  void run(){
        while (true){
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    dontstop();
                }
            });
            t.start();
        }
    }
}