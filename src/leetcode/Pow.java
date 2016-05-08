package leetcode;

import java.math.BigDecimal;

public class Pow {
	public  static double pow(double x, int n) {
        double res=1;
        if(x==1 || x==0 || x==-1){
        	if(x==1) return 1;
        	else if(x==0) return 0;
        	else{
        	    if(n%2==0) return 1;
        	    else return -1;
        	}
        }
    	if(n==1){
        	return x;
        }
        else if(n>=0){
            if(n==0){
                return 1.0;
            }
    		else if(n%2==0){
    			res = pow(x,n/2);
    			return res*res;
    		}
    		else{
    			res = x;
    			return res*pow(x,n-1);
    		}
    	}else{
    		return 1.0/pow(x,n*(-1));
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pow(5,0));
	}

}
