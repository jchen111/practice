package FancyDataStructrue;

/**
 * Created by z001ktb on 5/27/17.
 */
public class main {
    public static void main(String[] args) {
        MyHashTable<String, String> map = new MyHashTable<String,String>(50);
        map.put("test key","test value");
        map.remove("test key");
        System.out.print(map.get("test key"));
    }
}
