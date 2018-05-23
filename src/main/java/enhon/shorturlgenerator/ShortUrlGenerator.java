package enhon.shorturlgenerator;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShortUrlGenerator {
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {

        String sLongUrl = "https://www.baidu.com/s?wd=java%20%E5%A4%84%E7%90%8616%E8%BF%9B%E5%88%B6&rsv_spt=1&rsv_iqid=0xb296e6280001a35c&issp=1&f=8&rsv_bp=0&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=62&rsv_sug1=8&rsv_sug7=100&rsv_t=3e95VN3Ab5eyTO%2By5fcZr2MbfazuAJ1sk12OR2WkCVC9BXve3p9Fu9%2BcwqLLkexq5wuN&rsv_sug2=0&inputT=14280&rsv_sug4=14280" ; //长链接
        String[] aResult = shortUrl (sLongUrl);
        // 打印出结果
        for ( int i = 0; i < aResult. length ; i++) {
            System. out .println( "[" + i + "]:::" + aResult[i]);
        }
    }

    public static String[] shortUrl(String url) throws Exception {
        // 可以自定义生成 MD5 加密字符传前的混合 KEY
        String key = "mengdelong" ;
        // 要使用生成 URL 的字符
        String[] chars = new String[] { "a" , "b" , "c" , "d" , "e" , "f" , "g" , "h" ,
                "i" , "j" , "k" , "l" , "m" , "n" , "o" , "p" , "q" , "r" , "s" , "t" ,
                "u" , "v" , "w" , "x" , "y" , "z" , "0" , "1" , "2" , "3" , "4" , "5" ,
                "6" , "7" , "8" , "9" , "A" , "B" , "C" , "D" , "E" , "F" , "G" , "H" ,
                "I" , "J" , "K" , "L" , "M" , "N" , "O" , "P" , "Q" , "R" , "S" , "T" ,
                "U" , "V" , "W" , "X" , "Y" , "Z"

        };
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 对传入网址进行 MD5 加密
        String sMD5EncryptResult =bytesToHex(md.digest((key + url).getBytes("utf-8")));
        String hex = sMD5EncryptResult;

        String[] resUrl = new String[4];
        for ( int i = 0; i < 4; i++) {

            // 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
            String sTempSubString = hex.substring(i * 8, i * 8 + 8);

            // 这里需要使用 long 型来转换，因为 Inteper .parseInt() 只能处理 31 位 , 首位为符号位 , 如果不用 long ，则会越界
            long lHexLong = 0x3FFFFFFF & Long.parseLong (sTempSubString, 16);
            String outChars = "" ;
            for ( int j = 0; j < 6; j++) {
                // 把得到的值与 0x0000003D 进行位与运算，取得字符数组 chars 索引
                long index = 0x0000003D & lHexLong;
                // 把取得的字符相加
                outChars += chars[( int ) index];
                // 每次循环按位右移 5 位
                lHexLong = lHexLong >> 5;
            }
            // 把字符串存入对应索引的输出数组
            resUrl[i] = outChars;
        }
        return resUrl;
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuffer hexStr = new StringBuffer();
        int num;
        for (int i = 0; i < bytes.length; i++) {
            num = bytes[i];
            if(num < 0) {
                num += 256;
            }
            if(num < 16){
                hexStr.append("0");
            }
            hexStr.append(Integer.toHexString(num));
        }
        return hexStr.toString().toUpperCase();
    }
}
