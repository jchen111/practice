package leetcode;

public class AddBinary {
    public static String addBinary(String a, String b) {
        int lenA = a.length(),lenB = b.length();
        StringBuilder res = new StringBuilder();
        int i=lenA-1,j=lenB-1,add=0;
        while(i>=0 && j>=0){
        	int currentA = Character.getNumericValue(a.charAt(i));
        	int currentB = Character.getNumericValue(b.charAt(j));
        	int currentRes = 0;
        	if(add!=0){
        		currentRes+=1;
        		add-=1;
        	}
        	currentRes += (currentA+currentB);
        	if(currentRes>1){
        		currentRes %= 2;
        		add+=1;
        	}
        	res.append(Integer.toString(currentRes).charAt(0));
        	i--;
        	j--;
        }
        while(i>=0){
        	int currentA = Character.getNumericValue(a.charAt(i));
        	int currentRes = 0;
        	if(add!=0){
        		currentRes+=1;
        		add-=1;
        	}
        	currentRes += currentA;
        	if(currentRes>1){
        		add+=1;
        		currentRes %= 2;
        	}
        	res.append(Integer.toString(currentRes).charAt(0));
        	i--;
        }
        while(j>=0){
        	int currentB = Character.getNumericValue(b.charAt(j));
        	int currentRes = 0;
        	if(add!=0){
        		currentRes+=1;
        		add-=1;
        	}
        	currentRes += currentB;
        	if(currentRes>1){
        		add+=1;
        		currentRes %= 2;
        	}
        	res.append(Integer.toString(currentRes).charAt(0));
        	j--;
        }
        while(add!=0){
        	add -= 1;
        	res.append(Integer.toString(1).charAt(0));
        }
        res.reverse();
        return res.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String res = addBinary("111","1");
		System.out.print(res);
	}

}
