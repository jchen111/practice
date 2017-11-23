package AirBnB.phone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by z001ktb
 */
public class BoggleGame {

    private static int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
    // 从每个点开始，找从这个点出发的所有单词组合
    /**
     * loop through the board, find all possible words where the first word's starting index is i , j
     * **/
    public static void getAllWords(char[][] board, String[] words) {
        // 构建字典树加速查找
        // build the trie to accelerate the searching process
        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        List<String> result = new ArrayList<>();
        // 每个点作为起点，可能会有不一样的结果
        // result might be different if starting word is different
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n]; // reset visited
                List<String> path = new ArrayList<>();
                findWords(result, board, visited, path, i, j, trie.root);
            }
        }

        System.out.println(result);
    }

    // 从i,j开始递归找到所有单词组合

    public static void findWords(List<String> result, char[][] board, boolean[][] visited, List<String> words, int x, int y, TrieNode root) {

        int m = board.length;
        int n = board[0].length;
        for (int i = x; i < m; i++) {
            for (int j = y; j < n; j++) {
                List<List<Integer>> nextWordIndexes = new ArrayList<>();
                List<Integer> path = new ArrayList<>();
                // 获得从当前点开始的所有可能单词的indexes
                // find all possible words whose starting char is current char
                if(root.children.containsKey(board[i][j])) getNextWords(nextWordIndexes, board, visited, path, i, j, root);
                for (List<Integer> indexes : nextWordIndexes) {
                    // 设置visited为当前使用单词
                    // the chars used by current word are all used
                    String word = "";
                    for (int index : indexes) {
                        int row = index / n;
                        int col = index % n;
                        visited[row][col] = true;
                        word += board[row][col];
                    }

                    words.add(word); // add found word to current solution
                    // 只要更新了words，就保存一次words
                    if (words.size() > result.size()) { // if size of current solution is the biggest, update result
                        result.clear();
                        result.addAll(words);
                    }
                    findWords(result, board, visited, words, i, j, root);

                    // 恢复visited
                    for (int index : indexes) { // restore visited
                        int row = index / n;
                        int col = index % n;
                        visited[row][col] = false;
                    }
                    words.remove(words.size() - 1);
                }
            }
            // 只有第x行是从y开始，后面都从0开始
            // only at line x, col iterator starts from y, rest of lines y starts from 0
            y = 0;
        }
    }

    private static void getNextWords(List<List<Integer>> words, char[][] board, boolean[][] visited, List<Integer> path, int i, int j, TrieNode root) {
        if(i < 0 | i >= board.length || j < 0 || j >= board[0].length
                || visited[i][j]|| !root.children.containsKey(board[i][j])) {
            return;
        }

        root = root.children.get(board[i][j]);
        if(root.isLeaf) {
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(i * board[0].length + j);
            words.add(newPath);
            return;
        }

        visited[i][j] = true;
        path.add(i * board[0].length + j);
        for(int[] dir : dirs) {
            int nexti = i + dir[0];
            int nextj = j + dir[1];
            getNextWords(words, board, visited, path, nexti, nextj, root);

        }
        path.remove(path.size() - 1);
        visited[i][j] = false;
    }


    static class TrieNode {
        char ch;
        boolean isLeaf;
        Map<Character, TrieNode> children;
        TrieNode(char c) {
            ch = c;
            children = new HashMap<>();
        }

        TrieNode() {
            children = new HashMap<>();
        }
    }

    static class Trie {
        TrieNode root;
        Map<Character, TrieNode> children;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            children = root.children;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TrieNode node;
                if(children.containsKey(c)) {
                    node = children.get(c);
                }else {
                    node = new TrieNode(c);
                }
                if(i == word.length() - 1) node.isLeaf = true;
                children.put(c, node);
                children = node.children;
            }
        }

    }


    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
        };
        String[] words = new String[] {
                "abc", "cfi", "beh", "defi", "gh"
        };

        getAllWords(board, words);
    }
}
