package enhon.huffman2;

public class Data implements Comparable<Data>{
    private Byte c;
    // 字符出现的次数
    private int frequency;

    public Byte getC() {
        return c;
    }
    public void setC(Byte c) {
        this.c = c;
    }
    public int getFrequency() {
        return frequency;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Data [c=" + c + ", frequency=" + frequency + "]";
    }
    @Override
    public int compareTo(Data o) {
        if (this.frequency < o.getFrequency()) {
            return -1;
        } else if (this.frequency > o.getFrequency()) {
            return 1;
        } else {
            return 0;
        }
    }
}
