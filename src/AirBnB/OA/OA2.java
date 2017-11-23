package AirBnB.OA;

import java.util.*;

/**
 * Created by z001ktb
 */
public class OA2 {
    /**
     *
     5
     13
     1,28,310.6,SF
     4,5,204.1,SF
     20,7,203.2,Oakland
     6,8,202.2,SF
     6,10,199.1,SF
     1,16,190.4,SF
     6,29,185.2,SF
     7,20,180.1,SF
     6,21,162.1,SF
     2,18,161.2,SF
     2,30,149.1,SF
     3,76,146.2,SF
     2,14,141.1,San Jose

     time O(numOfPages * sizeOfPage * n * n) = O(n^3)
     space O(2*n)
     * **/
    static String[] paginate(int num, String[] results) {
        if(num == 0 || results == null || results.length == 0) {
            return new String[]{};
        }
        int total = results.length;
        int numOfPages = total / num + (total % num == 0 ? 0 : 1);

        String[] solution = new String[total + numOfPages - 1];
        ArrayList<String> dataStream = new ArrayList<String>(Arrays.asList(results));
        Set<String> set = new HashSet<String>();
        Iterator<String> iterator;
        int index = 0;

        while(!dataStream.isEmpty()) {
            iterator = dataStream.iterator();
            set.clear();
            int i = 0;
            while(i < num && iterator.hasNext()) {//load page
                String dataEntry = iterator.next();
                String hostId = dataEntry.split(",")[0];
                if(!set.contains(hostId)) {//for current page, read distinct host as much as possible
                    set.add(hostId);
                    iterator.remove(); // ArrayList remove can take up to O(n)
                    solution[index++] = dataEntry;
                    i++;
                }
                if(i < num && !iterator.hasNext()) {//if running out of distinct hosts, read skipped hosts in order of when they are skipped
                    iterator = dataStream.iterator();
                    while(iterator.hasNext() && i < num) {
                        solution[index++] = iterator.next();
                        iterator.remove();
                        i++;
                    }
                }
            }
            if(index < solution.length) solution[index++] = "";
        }
        return solution;
    }

    /**
     * follow up
     * time O(n)
     * space O(n)
     * */
    static String[] paginateFollowup(int num, String[] results) {
        if(num == 0 || results == null || results.length == 0) {
            return new String[]{};
        }
        int total = results.length;
        int numOfPages = total / num + (total % num == 0 ? 0 : 1);

        String[] solution = new String[total + numOfPages - 1];
        Queue<String> queue;

        LinkedHashMap<String, Queue<String>> linkedHashMap = new LinkedHashMap<String, Queue<String>>();
        for(int i = 0; i < results.length; i++) { // n build linkedHashMap
            String hostId = results[i].split(",")[0];
            if(linkedHashMap.containsKey(hostId)) {
                queue = linkedHashMap.get(hostId);
            } else {
                queue = new LinkedList<String>();
            }
            queue.offer(results[i]);
            linkedHashMap.put(hostId, queue);
        }

        Iterator<Map.Entry<String, Queue<String>>> iterator;
        int index = 0;
        while(!linkedHashMap.isEmpty()) { // n
            iterator = linkedHashMap.entrySet().iterator();
            int i = 0;
            while (i < num || iterator.hasNext()) {
                while(i < num && iterator.hasNext()) {
                    Map.Entry<String, Queue<String>> entry = iterator.next();
                    Queue<String> q = entry.getValue();
                    solution[index++] = q.poll();
                    if (!q.isEmpty()) {
                        entry.setValue(q);
                    } else {
                        iterator.remove();
                    }
                    i++;
                }
                if(i < num) {
                    iterator = linkedHashMap.entrySet().iterator();
                    if(!iterator.hasNext()) return solution;
                } else {
                    break;
                }
            }
            if(index < solution.length) solution[index++] = "";
        }
        return solution;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pageSize = sc.nextInt();
        int inputSize = sc.nextInt();
        String[] input = new String[inputSize];
        for(int i = 0; i < inputSize; i++) {
            input[i] = sc.next();
        }
        String[] output = paginate(pageSize,input);
        System.out.println();
        for(int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
    }
}
