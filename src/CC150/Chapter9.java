package CC150;
import java.util.Arrays;
import java.util.LinkedList;


public class Chapter9 {
	/* Bubble sort*/
	public static boolean inOrder(int[] array){
		for(int i=0;i<array.length-1;i++){
			if(array[i]>array[i+1]){
				return false;
			}
		}
		return true;
	}
	public static int[] bubbleSort(int[] array){
		int i=0;
		while(!inOrder(array)){
			if(array[i]>array[i+1]){
				int temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
				}
			i++;
			if(i+1 > array.length-1)
				i=0;
		}
		return array;
	}
	/* Selection sort*/
	public static int minIndexOfList(LinkedList<Integer> list, int start){
		int min = list.get(start);
		int index = start;
		for(int i=start;i<list.size();i++){
			if(list.get(i)<min) {
				min = list.get(i);
				index = i;
			}
		}
		return index;
	}
	public static LinkedList<Integer> selectionSort(LinkedList<Integer> list){
		int length = list.size();
//		LinkedList<Integer> newlist = new LinkedList<Integer>();
		int index=0;
		while(index<length){
			int minIndex = minIndexOfList(list,index);
			int min = list.get(minIndex);
			list.remove(minIndex);
			list.add(index, min);
			index++;
		}
		return list;
	}
	/* merge sort*/
	public static int[] merge(int[] a, int[] b){
		int[] c = new int[a.length+b.length];
		int i=0, j=0, k=0;
		while(k<c.length){
			if(i==a.length || j==b.length){
				if(i==a.length && j!=b.length){
					c[k] = b[j];
					j++;
				}
				if(i!=a.length && j==b.length){
					c[k] = a[i];
					i++;
				}
			}else{
				c[k] = Math.min(a[i], b[j]);
				if(Math.min(a[i], b[j]) == a[i])
					i++;
				else
					j++;
			}
			k++;
		}
		return c;
	}
	/* merge prople*/
	public static int[][] mergePeople(int[][] a,int[][] b){
		int[][] c = new int[a.length+b.length][2];
		int i=0,k=0,j=0;
		while(i<a.length && j<b.length){
				if(a[i][0]<b[j][0]){
					c[k] = a[i];
					i++;
					k++;
				}else{
					c[k] = b[j];
					j++;
					k++;
				}
		}
		while(j<b.length){
			c[k] = b[j];
			j++;
			k++;
		}
		while(i<a.length){
			c[k] = a[i];
			i++;
			k++;
		}
		for(i=0;i<k-1;i++){
			if(c[i][1]>c[i+1][1] && c[i][0]==c[i+1][0]){
				int tmp = c[i][1];
				c[i][1] = c[i+1][1];
				c[i+1][1] = tmp;
			}
		}
		return c;
	}
	public static int[][] mergeSortPeople(int[][] array){
		int length = array.length;
		int n = length/2;
		if(length==1){
			return array;
		}else{
		int[][] a = Arrays.copyOfRange(array, 0, n);
		int[][] b = Arrays.copyOfRange(array, n, length);
		return mergePeople(mergeSortPeople(a),mergeSortPeople(b));
		}
	}
	public static int[] mergeSort(int[] array){
		int length = array.length;
		int n = length/2;
		if(length==1){
			return array;
		}else{
			int[] a = Arrays.copyOfRange(array, 0, n);
			int[] b = Arrays.copyOfRange(array, n, array.length);
			return merge(mergeSort(a),mergeSort(b));
		}
	}
	/* solution for 9.1 given two sorted arrays A and B, write a method to merge B into A
	 * in sorted order*/
	public static int[] mergeBInToA(int[] a, int[] b){
		int lengthA = a.length;
		int lengthB = b.length;
		int trueLength = 0;
		int i = lengthA-1;
		while(i>=0){
			if(a[i]!=0) {
				trueLength = i+1;
				break;
			}
			i--;
		}
		int k = lengthB+trueLength;
		while(k>0){
				if(lengthB<=0){
					break;
				}
				else if(trueLength<=0){
					a[k-1] = b[lengthB-1];
					lengthB--;
				}
			    else{
			    	if(a[trueLength-1]>b[lengthB-1]){
			    		a[k-1] = a[trueLength-1];
			    		a[trueLength-1] = 0;
			    		trueLength--;
			    	}
			    	else{
			    		a[k-1] = b[lengthB-1];
			    		lengthB--;
			    	}
			    }
			k--;
		}
		return a;
	}
	/* solution for 9.3 Given a sorted array of n integers that has been rotated an unknown number of times
	 * , give a O(log n) algorithms that finds an element in the array*/
	public static int findIndex(int[] array, int index,int target){
		int length = array.length;
		int n = length/2;
		if(length==1){
			if(array[0]==target){
				return index;
			}else{
				return -1;
			}
		}
		int[] a = Arrays.copyOfRange(array, 0, n);
		int[] b = Arrays.copyOfRange(array, n, length);
		if(target>=array[n] && target<=array[length-1]){
			return findIndex(b,n+index,target);
		}else{
			return findIndex(a,index,target);
		}
	}
	/* solution for 9.5 given a sorted array of strings which is interspersed with empty strings,
	 * write a method to find the location of a given string*/
	public static int locationOfAString(String[] s, int index, String target){
		int length = s.length;
		int n = length/2;
		int left_index = n;
		int right_index = n;
		String left = "";
		String right = "";
		if(s[n]==""){
			if(length==1){
				return -1;
			}
			int i = n-1;
			while(s[i]=="" && i>0){
				i--;
			}
			left =s[i];
			left_index = i;
			i = n+1;
			while(s[i]=="" && i<length-1){
				i++;
			}
			right = s[i];
			right_index = i;
			String[] a = Arrays.copyOfRange(s, 0, left_index+1);
			String[] b = Arrays.copyOfRange(s, right_index, length);
			if(target.compareTo(left)>0){
				return locationOfAString(b,index+right_index,target);
			}else{
				return locationOfAString(a,index,target);
			}
		}
		else{
			if(length==1){
				if(s[n].equals(target)){
					return index;
				}else{
					return -1;
				}
			}
			String[] a = Arrays.copyOfRange(s, 0, left_index);
			String[] b = Arrays.copyOfRange(s, right_index, length);
			if(target.compareTo(s[n])>=0){
				return locationOfAString(b,index+right_index,target);
			}else{
				return locationOfAString(a,index,target);
			}
		}
	}
	/* solution for 9.6 given a matrix in which ecach row and column issorted, write a method 
	 * to find an element of it*/
	public static int[] findElementInMatrix(int[][] m, int[] index,int target){
		int rows = m.length;
		int columns = m[0].length;
		int r_n = rows/2;
		int c_n = columns/2;
		if(rows==1){
			if(columns==1){
				if(m[0][0]==target){
					return index;
				}
				else{
					return new int[]{-1,-1};
				}
			}
			int[] a_c = Arrays.copyOfRange(m[0], 0, c_n);
			int[] b_c = Arrays.copyOfRange(m[0], c_n, columns);
			if(target>=m[0][c_n]){
				index[1]+=c_n;
				return findElementInMatrix(new int[][]{b_c},index,target);
			}else{
				return findElementInMatrix(new int[][]{a_c},index,target);
			}
		}
		int[][] a = Arrays.copyOfRange(m, 0, r_n);
		int[][] b = Arrays.copyOfRange(m, r_n, rows);
		if(target>=m[r_n][0]){
			index[0] +=r_n;
			return findElementInMatrix(b,index,target);
		}else{
			return findElementInMatrix(a,index,target);
		}
		 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] peoples = {{50,100},{60,120},{30,40},{70,90}};
//		
//		int[][] r = mergeSortPeople(peoples);
//		int max = 1,count=1;
//		for(int i=0;i<r.length-1;i++){
//			if(r[i][0]<r[i+1][0] && r[i][1]<r[i+1][1]){
//				count+=1;
//				if(count>max) max=count;
//			}else{
//				if(count>max) max = count;
//				else count = 1;
//			}
//		}
//		System.out.println(max);
		int[] array = {10,9,8,7,6,5};
//		int[][] m = {{1,2,3,4,5},
//				     {6,7,8,9,10},
//				     {11,12,13,14,15}};
//		String[] s = {"","at","","","","ball","car","","","dad","",""};
//		int[] index = {0,0};
//		index = findElementInMatrix(m,index,3);
//		System.out.println(index[0]+" "+index[1]);
//		System.out.println(locationOfAString(s,0,"at"));
//		System.out.print(findIndex(array,0,2));
//		int[] A = new int[10];
//		A[0] = 6; A[1]=7;
//		int[] B = {2,3,4,5};
//		int[] C = mergeBInToA(A,B);
//		int[] e = mergeSort(array);
//		for(int i=0;i<C.length;i++){
//			System.out.print(C[i]+" ");
//		}
//		String[] a ={"apple","elppa","car","rac","hope","opeh"};
//		Arrays.sort(a, new AnagramComparator());/* solution for 9.2 write a method to sort an array of strings that all the anagrams are next to each 
//		 * other*/
//		for(int i=0;i<a.length;i++){
//			System.out.print(a[i]+" ");
//		}
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0;i<array.length;i++){
			list.add(array[i]);
		}
//		int[] array2 = bubbleSort(array);
		list = selectionSort(list);
		for(int i=0;i<list.size();i++){
			System.out.print(list.get(i)+" ");
		}
//		for(int i=0; i< array2.length;i++){
//			System.out.print(array2[i]+" ");
//		}
	}
}
