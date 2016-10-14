package hackerrank;

/**
 * Created by jacky on 9/8/16.
 */
class FullCountingSort {
//    static int[] map = new int[100];
//    static HashMap<Integer, LinkedList<String>> strsMap = new HashMap<Integer, LinkedList<String>>();
//
//    public static void counting(int[] arr) {
//        for(int i = 0; i < arr.length; i++) {
//            map[arr[i]]++;
//
//        }
//    }
//
//    public static void sort(int[] arr, HashMap<Integer, LinkedList<String>> strsMap) {
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < map.length; i++) { //n
//            if(map[i] > 0){
//                for(int k = 0; k < map[i]; k++){ //n
//                    if(!strsMap.get(i).isEmpty()) {
//                        sb.append(strsMap.get(i).poll() + " ");
//                    }
//                }
//            }
//        }
//        System.out.print(sb.toString());
//    }
//
//    public static void main(String[] args) {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//            String str = sc.next();
//            if(i < n/2){
//                str = "-";
//            }
//            LinkedList<String> array = new LinkedList<String>();
//            //n
//            if(strsMap.containsKey(arr[i])){
//                strsMap.get(arr[i]).add(str);
//            }else {
//                array.add(str);
//                strsMap.put(arr[i],array);
//            }
//        }
//        counting(arr); //n
//        sort(arr,strsMap); //n^2
//    }
}
