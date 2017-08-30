package facebook;

public class CountandSay {

    public static String countAndSay(int n) {
        if(n < 1) return "";
        String solution = "1";
        String tmp = "";
        int start = 0;
        int i = 1;
        while(n > 1) {
            char num = solution.charAt(start);

            while(i < solution.length() && solution.charAt(i) == num) {
                i++;
            }

            tmp += ((i - start) + "" + num );
            if(i < solution.length()) {
                start = i;
                i++;
            } else {
                start = 0;
                i = 1;
                n--;
                solution = tmp;
                tmp = "";
            }
        }
        return solution;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(5));
	}

}
