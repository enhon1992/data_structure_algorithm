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

    }


    public  static  void test(List<? extends Person> list){

    }
}
class Person{
}
class X extends Person {
}
class Y extends Person {
}
