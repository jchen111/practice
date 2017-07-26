package facebook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by z001ktb on 6/13/17.
 */
public class KNearestPoints {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static List<Point> findKNearestPoints(List<Point> points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return (p2.x * p2.x + p2.y * p2.y) - (p1.x * p1.x + p1.y * p1.y);
            }
        });

        for (Point point : points) {
            maxHeap.add(point);
            while (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Point> result = new ArrayList<Point>();
        while (!maxHeap.isEmpty()) {
            result.add(maxHeap.poll());
        }

        return result;
    }
}
