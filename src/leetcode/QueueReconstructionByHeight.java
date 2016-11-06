package leetcode;

import java.util.*;

/**
 * Created by jiaqichen on 11/3/16.
 */
public class QueueReconstructionByHeight {
    static class Person {
        int height;
        int peopleBeforeMe;
        Person(int h, int k){
            this.height = h;
            this.peopleBeforeMe = k;
        }
    }

    static class HeightComparator implements Comparator<Person> {

        @Override
        public int compare(Person p1, Person p2){
            if(p1.height > p2.height) return 1;
            else if(p1.height < p2.height) return -1;
            else return 0;
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        int m = people.length;
        int[][] res = new int[m][2];
        LinkedList<Person> queue = new LinkedList<Person>();
        for(int i = 0; i < m; i++){
            Person p = new Person(people[i][0], people[i][1]);
            queue.add(p);
        }

        Collections.sort(queue, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2){
                if(p1.height > p2.height) return 1;
                else if(p1.height < p2.height) return -1;
                else return 0;
            }
        }); // O(nlogn)

        int k = 0;
        Iterator<Person> iterator = queue.iterator();
        while(k < m){ //O(n^2)
            Person tmp = iterator.next();
            if(valid(tmp,res,k)){
                res[k][0] = tmp.height;
                res[k][1] = tmp.peopleBeforeMe;
                iterator.remove();
                k++;
            }
            if(k < m && !iterator.hasNext()){
                iterator = queue.iterator();
            }
        }
        return res;
    }

    public static boolean valid(Person p, int[][] res, int k){
        int count = 0;
        for(int i = 0; i < k; i++){
            if(res[i][0] >= p.height) count++;
        }
        return count == p.peopleBeforeMe;
    }


    public static void main(String[] args){
        int[][] persons = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(persons);
    }

}
