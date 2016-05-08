package leetcode;

public class ValidNumber {
    public static boolean isNumber(String s) {
        int length = s.length();
        if(length==0) return false;
        if(length==1){
        	if((int)s.charAt(0)<48 || (int)s.charAt(0)>57) return false;
        	else return true;
        }
        else{
        	s = s.trim();
        	length = s.length();
        	if(length==0 || s.charAt(length-1)!='.' && ( (int)s.charAt(length-1)>57 || (int)s.charAt(length-1)<48)){
        		return false;
        	}
        	try{
        		double d = Double.parseDouble(s);
        		return true;
        	}catch(Exception e){
        		return false;
        	}
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] test_case = {
//				"0e",
//				"1e.",
//				"1 ",
//				".1",
//				" 0",
//				"3.",
//				"1e6",
//				"2e0",
//				"1 4",
//				".0e",
//				"3. " ,//true
//				"1 .",
//				" 9e",
//				" 0",
//				"89.900f",
				"11"
				
		};
		for(int i=0;i<test_case.length;i++){
			System.out.println(test_case[i]+" "+isNumber(test_case[i]));
		}
//		System.out.println(Double.parseDouble("89.8989f"));
	}

}
