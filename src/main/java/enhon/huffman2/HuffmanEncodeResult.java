package enhon.huffman2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * 对字符串编码后的结果：包括编码后的字符串和字符/编码对
 */
public class HuffmanEncodeResult {
    // 字符串编码后的结果的二进制结果
    private String encode;
    // 字符编码对
    private Map<Byte, String> letterCode;
    public HuffmanEncodeResult(String encode, Map<Byte, String> letterCode) {
        super();
        this.encode = encode;
        this.letterCode = letterCode;
    }
    public String getEncode() {
        return encode;
    }
    public Map<Byte, String> getLetterCode() {
        return letterCode;
    }
    /**
     *获取编码后的文本字符串
     * @return
     */
    public String geteEncodedStr(){
        int len=encode.length();
        int byteLen=len%8==0?len/8:(len/8)+1;
        int count=0;
        int remainder=len%8;
        StringBuilder sb=new StringBuilder(encode);
        ByteArrayOutputStream outputStream=null;
        try {
            outputStream=new ByteArrayOutputStream();
            if(remainder!=0){
                for (int i=0;i<8-remainder;++i){
                    sb.append("0");
                    count++;
                }
            }
            for(int i=0;i<byteLen;i++){
                String temp=sb.substring(i*8,8*(1+i));
                outputStream.write(Integer.parseInt(temp,2));
            }
            outputStream.write(count);
            byte[] bytes = outputStream.toByteArray();
            String resStr=new String(bytes,"ISO-8859-1");
            return resStr;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
