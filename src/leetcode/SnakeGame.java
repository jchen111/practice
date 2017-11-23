package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by z001ktb
 */
public class SnakeGame {
    static class MySnakeGame {
        private int[][] food;
        private int width, height;
        private int score;
        private int foodIndex;
        private LinkedList<Integer> body;
        private Set<Integer> currentBody;
        /** Initialize your data structure here.
         @param width - screen width
         @param height - screen height
         @param food - A list of food positions
         E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
        public MySnakeGame(int width, int height, int[][] food) {
            this.score = 0;
            this.width = width;
            this.height = height;
            this.food = food;
            this.foodIndex = 0;
            this.body = new LinkedList<Integer>();
            this.currentBody = new HashSet<Integer>();

            body.addFirst(0);
            currentBody.add(0);
        }

        /** Moves the snake.
         @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
         @return The game's score after the move. Return -1 if game over.
         Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {

            int r = body.getFirst() / width;
            int c = body.getFirst() % width;

            switch(direction) {
                case "U":
                    r -= 1;
                    break;
                case "D":
                    r += 1;
                    break;
                case "L":
                    c -= 1;
                    break;
                case "R":
                    c += 1;
                    break;
                default:
                    break;
            }

            int head = r * width + c;
            int tail = body.getLast();

            body.removeLast();
            currentBody.remove(tail);

            if(r < 0 || r >= height || c < 0 || c >= width || currentBody.contains(head)) {
                return -1;
            }

            body.addFirst(head);
            currentBody.add(head);

            if (foodIndex < food.length && r == food[foodIndex][0] && c == food[foodIndex][1]) {
                body.addLast(tail);
                currentBody.add(tail);
                score++;
                foodIndex++;
                return score;
            }

            return score;
        }
    }

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */

    public static void main(String[] args) {
        int[][] food = {{2,0},{0,0},{0,2},{2,2}};
        MySnakeGame game = new MySnakeGame(3,3,food);
        System.out.println(game.move("D"));
        System.out.println(game.move("D"));
        System.out.println(game.move("R"));
        System.out.println(game.move("U"));
        System.out.println(game.move("U"));
        System.out.println(game.move("L"));
        System.out.println(game.move("D"));
        System.out.println(game.move("R"));
        System.out.println(game.move("R"));
        System.out.println(game.move("U"));
        System.out.println(game.move("L"));
        System.out.println(game.move("D"));

//        System.out.println(game.move("R"));
//        System.out.println(game.move("D"));
//        System.out.println(game.move("L"));
//        System.out.println(game.move("U"));
//        System.out.println(game.move("R"));

    }
}
