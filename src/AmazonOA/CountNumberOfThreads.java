package AmazonOA;

import com.sun.javafx.runtime.SystemProperties;
import com.sun.javafx.tk.Toolkit;

import java.util.*;

/**
 * Created by z001ktb on 1/22/17.
 */
public class CountNumberOfThreads {
    static class Task {
        int start;
        int end;
        public Task(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    public static int countThreads(List<Task> tasks) {
        Collections.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t1.start - t2.start;
            }
        });

        PriorityQueue<Task> threadQueue = new PriorityQueue<Task>(new Comparator<Task>(){
            @Override
            public int compare(Task t1, Task t2) {
                return t1.end - t2.end;
            }
        });

        int count = 0;
        if(tasks.size() > 0) {
            count++;
            threadQueue.add(tasks.get(0));

            for(int i = 1; i < tasks.size(); i++){
                Task curTask = tasks.get(i);
                if(threadQueue.peek().end > curTask.start){ //overlap here
                    count++;
                    threadQueue.add(curTask);
                }else{ // no overlap, can reuse a thread
                    threadQueue.poll();
                    threadQueue.add(curTask);
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<Task>();
        tasks.add(new Task(1,3));
//        tasks.add(new Task(2,4));
//        tasks.add(new Task(3,5));
        tasks.add(new Task(4,6));
        System.out.println(countThreads(tasks));
    }
}
