package CC150;
import java.util.Arrays;
import java.util.Comparator;


public class AnagramComparator implements Comparator<String>{
	public String sortChars(String string){
		char[] c = string.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	public int compare(String s1,String s2){
		return sortChars(s1).compareTo(sortChars(s2));
	}
}
