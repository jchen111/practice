package CC150;
import java.io.Console;
import java.lang.Object;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * implementation code for Cracking the Coding Interview 
 */
public class Chapter1 {
	/* solution for 1.1 determine if s string has all unique characters*/
	public static boolean isUniqueChars2(String str){
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);//transform to ASCII code
			if (char_set[val]) return false;
			char_set[val] = true;
		}
		return true;
	}
	/* solution for 1.2 reverse a C-Style String*/
	public static char[] reverse(char[] str){
		char[] reversed_str = new char[100];
		for(int i=0, j=str.length-1; i < str.length; i++,j--){
			reversed_str[j] = str[i];
		}
		return reversed_str;
	}
	/* solution for 1.3 remove duplicate characters*/
	public static String removeDuplicate(String str){
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		
		for(int i=0; i<sb.length(); i++){
			//System.out.println(i);
			for(int j=sb.length()-1; j>=0; j--){
				//System.out.println(j);
				if(sb.charAt(i)==sb.charAt(j)){
					if(i!=j){
						sb.deleteCharAt(j);
					}
				}
			}
		}
		return sb.toString();
	}
	/* solution for 1.4 anagrams*/
	public static boolean isAnagrams(String str1, String str2){
		boolean isTrue = true;
		if(str1.length() == str2.length()){
			int [] letters = new int[256];
			for(int i=0; i<256;i++){
				letters[i]=0;
			}//256
			for(int i=0; i<str1.length(); i++){
				letters[str1.charAt(i)]++;
			}//n
			
			for(int i=0; i<str2.length(); i++){
				letters[str2.charAt(i)]--;
			}//n
			for(int i=0; i<256;i++){
				if(letters[i] != 0){
					isTrue = false;
				}
			}//n
			
		}else{
			isTrue = false;
		}
		return isTrue;
	}
	/* solution for 1.5 replace all spaces with %20 */
	public static String replaceSpace(String str){
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		sb1.append(str);
		int i=0;
		while(i<sb1.length()){
			if(sb1.charAt(i)==' '){
				sb2.append("%20");
			}
			else{
				sb2.append(sb1.charAt(i));
			}
			i++;
		}//n
		return sb2.toString();
	}
	/* solution for 1.6 rotate a matrix*/
	public static void rotateMatrix(char [][] image){
		int height = image.length;
		int width = image[1].length;
		char [][] image2 = new char [width][height];
		for(int i=0;i<image2.length;i++){
			for(int j=0; j<image2[i].length;j++){
//				image2[i][j] = image[j][width-i-1]; //counter-clock-wise
				image2[i][j] = image[height-j-1][i];// clock-wise
			}
		}
		System.out.println("after rotation:");
		for(int i=0; i < image2.length; i++){
			for(int j=0; j < image2[i].length;j++){
				System.out.print(image2[i][j]+" ");
			}
			System.out.print('\n');
		}
	}
	/* solution for 1.7 write an algorithm such that if an element in an MxM matrix is 0, its entire row and column is set to 0 */
	public static void matrixZero(int [][] matrix){
		ArrayList<Integer> rowsTozero = new ArrayList<Integer>();
		ArrayList<Integer> columnsTozero = new ArrayList<Integer>();
		for(int i=0; i<matrix.length;i++){
			for(int j=0; j<matrix[i].length;j++){
				if(matrix[i][j]==0){
					if(!rowsTozero.contains(i)){
						rowsTozero.add(i);
					}
					if(!columnsTozero.contains(j)){
						columnsTozero.add(j);
					}
				}
			}
		}//n2
		for(int row:rowsTozero){
			matrix[row] = new int[matrix[row].length];
		}//set row to zero
		 //n
		for(int i =0; i< matrix.length;i++){
			for(int column:columnsTozero){
				matrix[i][column] = 0;
			}
		}// set column to zero
		 //n
		System.out.println("after reset:");
		for(int i=0; i<matrix.length;i++){
			for(int j=0; j<matrix[i].length;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.print('\n');
		}
	}
	/* solution 1.8 check rotation substring*/
	public static boolean isSubstring(String s1,String s2){
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		sb1.append(s1);
		sb2.append(s2);
		String rest = "";
		String head = "";
		if(sb1.length()!=sb2.length())
			return false;
		for(int i=0; i<sb2.length();i++){
			for(int j=0; j<sb1.length();j++){
				if(sb2.charAt(i)==sb1.charAt(j)){
					rest = s2.substring(j, sb2.length());
					head = s2.substring(0, j);
					if((rest+head).equals(s1)){
						return true;
					}
				}
			}
		}
		//waterbottle
		//erbottlewat
		return false;
	}
	/*main function*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][] image = {
				{'q','q','q','q','q'},
				{'q','q','q','q','q'},
				{'s','s','q','q','q'},
				{'s','s','s','s','s'}
				};
		int [][] matrix ={
				{0,2,3,4,5},
				{1,3,4,5,0},
				{1,1,0,9,8},
				{3,0,4,5,9},
		};
		Scanner in = new Scanner(System.in);
		String input;
		String input2;
		System.out.println("Enter a string:");
		input = in.nextLine();
		System.out.println("Enter a string:");
		input2 = in.nextLine();
//		input = input.replaceAll("[^a-zA-Z0-9]+", "");
//		input = input.replaceAll("\\s", "");
//		input = input.toLowerCase();
//		System.out.println(input);
//		System.out.println("Enter another string:");
//		input2 = in.nextLine();
//		input2 = input2.replaceAll("[^a-zA-Z0-9]+", "");
//		input2 = input2.replaceAll("\\s", "");
//		input2 = input2.toLowerCase();
//		System.out.println(input2);
//		System.out.println(removeDuplicate(input));
//		System.out.println(isAnagrams(input,input2));
//		System.out.println(replaceSpace(input));
//		rotateMatrix(image);
//		matrixZero(matrix);
		System.out.print(isSubstring(input,input2));
	}

}
