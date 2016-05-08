package leetcode;

public class ZigZagConversion {
    public static String convert(String s, int nRows) {
    	int length = s.length();
    	if(length==0) return "";
    	if(nRows==1 || s.length()==nRows) return s;
        StringBuilder[] sb = new StringBuilder[nRows];
        for( int i=0; i<nRows; i++ )
            sb[i] = new StringBuilder();
        boolean flag = true;
        generateMatrix(sb,s,0,0,nRows,flag);
        String res = "";
        for(int i=0;i<sb.length;i++){
        	res+=sb[i];
		}
        return res;
    }
    public static void generateMatrix(StringBuilder[] sb, String s, int index, int r, int row,boolean flag){
    	if(index==s.length()-1) {
    		sb[r].append(s.charAt(index));
    		return;
    	}
    	else{
    		sb[r].append(s.charAt(index));
    		if(r==0){
    			flag = true;
    			generateMatrix(sb,s,index+1,r+1,row,flag);
    		}else{
    			if(r<row-1 && flag){
    				generateMatrix(sb,s,index+1,r+1,row,flag);
    			}else if(r==row-1){
    				flag = false;
    				generateMatrix(sb,s,index+1,r-1,row,flag);
    			}else if(r>0 && !flag){
    				generateMatrix(sb,s,index+1,r-1,row,flag);
    			}
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String res = convert("PAYPALISHIRING",3);
		String res = convert("ABCDE",3);
		System.out.print(res);
	}

}
