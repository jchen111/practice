package AmazonOA;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by z001ktb on 6/25/17.
 */
public class Robot {
    int x;
    int p1;
    int p2;
    int other;
    Robot(int x, int p2) {
        this.x = x;
        this.p1 = x;
        this.p2 = p2;
    }

    public void moveLeft() {
        this.x--;
    }

    public void moveRight() {
        this.x++;
    }

    public void noOperation() {}

    public boolean onTopOfParachute() {
        return x == p1 || x == p2;
    }

    public boolean didWeMeet() {
        return x == other;
    }

    /**
     * http://ms-amazon.blogspot.com/2013/05/robot-meet-problem.html
     *
     * In each iteration, the robot will go over it's own parachute one time.
     *  But after certain time, one robot will go over its parachute and also the other robots parachute.
     *  At this point, I stop this robot and continue with the other robot.
     *  Finally when this robot go over it's own parachute, it meets the other robot
     * */
    public boolean robotMeet() {
        int k = 0;
        boolean reachedParachute = false;
        while(!didWeMeet()) {
            if (reachedParachute) {
                noOperation();
            }else {
                int i = 0;
                while (i < k) {
                    moveLeft();
                    i++;
                }
                i = 0;
                while (i < k + 1) {
                    moveRight();
                    if (i == k && onTopOfParachute()) {
                        reachedParachute = true;
                        break;
                    }
                    i++;
                }
                k = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(3, 2, 3);
//        list.sort((e1, e2) -> e1 - e2);
//        list.forEach(e -> System.out.println(e));
        Map<String, String> map = new HashMap<>();
        map.put("key","value");
        map.forEach( (k,v) -> System.out.println(k + ":" + v));
    }

}
