package AmazonOA;

public class JudgeGrayCode {
	public static int grayCode(byte element1, byte element2) {
        byte res = (byte) (element1 ^ element2);
        for (int i = 0; i <= 7; i++) {
                byte temp = (byte)(1 << i);
                if (temp == res) {
                        return 1;
                }
        }
        return -1;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        System.out.println(grayCode(,0x00));
	}

}
