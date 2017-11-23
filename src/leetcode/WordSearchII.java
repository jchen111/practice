package leetcode;

import java.util.*;

/**
 * Created by jiaqichen on 12/17/16.
 */
public class WordSearchII {
//    class TrieNode {
//        char c;
//        boolean isLeaf;
//        HashMap<Character, TrieNode> children = new HashMap<Character,TrieNode>();
//        // Initialize your data structure here.
//        public TrieNode() {}
//
//        public TrieNode(Character c) {
//            this.c = c;
//        }
//    }
//
//    public class Trie {
//        private TrieNode root;
//
//        public Trie() {
//            root = new TrieNode();
//        }
//
//        // Inserts a word into the trie.
//        public void insert(String word) {
//            HashMap<Character, TrieNode> children = root.children;
//
//            for(int i = 0; i < word.length(); i++){
//                char c = word.charAt(i);
//
//                TrieNode t;
//                if(children.containsKey(c)){
//                    t = children.get(c);
//                }else{
//                    t = new TrieNode(c);
//                    children.put(c,t);
//                }
//
//                children = t.children;
//
//                if(i == word.length() - 1) t.isLeaf = true;
//            }
//        }
//
//        private TrieNode searchNode(String word) {
//            HashMap<Character, TrieNode> children = root.children;
//
//            TrieNode t = null;
//            for(int i = 0; i < word.length(); i++){
//                char c = word.charAt(i);
//
//                if(children.containsKey(c)){
//                    t = children.get(c);
//                    children = t.children;
//                }else{
//                    return null;
//                }
//            }
//            return t;
//        }
//
//        // Returns if the word is in the trie.
//        public boolean search(String word) {
//            TrieNode t = searchNode(word);
//            if(t != null && t.isLeaf) return true;
//            return false;
//        }
//
//        // Returns if there is any word in the trie
//        // that starts with the given prefix.
//        public boolean startsWith(String prefix) {
//            if(searchNode(prefix) != null) return true;
//            return false;
//        }
//    }
//
//    List<String> result;
//    Set<String> resultSet;
//    int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
//    public  List<String> findWords(char[][] board, String[] words) {
//        result = new ArrayList<String>();
//        if(board.length == 0 || words.length == 0) return result;
//        Trie trie = new Trie();
//        resultSet = new HashSet<String>();
//        int m = board.length;
//        int n = board[0].length;
//        for(String s : words){
//            trie.insert(s);
//        }
//
//        for(int i = 0; i < m; i++) {
//            for(int j = 0; j < n; j++) {
//                dfs(board, new StringBuilder(), trie, i, j, m, n);
//            }
//        }
//
//        return result;
//    }

//    public  void dfs(char[][] board, StringBuilder sb, Trie trie, int r, int c, int m, int n) {
//        char ch = board[r][c];
//        sb.append(ch);
//        String s = sb.toString();
//        if(!trie.startsWith(s)){
//            return;
//        }
//        if(trie.search(s)){
//            if(!resultSet.contains(s)) {
//                resultSet.add(s);
//                result.add(s);
//            }
//        }
//
//        board[r][c] = '#';
//        for(int[] dir : dirs){
//            int i = r + dir[0];
//            int j = c + dir[1];
//            if(i >= 0 && i < m && j >= 0 && j < n && board[i][j] != '#'){
//                dfs(board, sb, trie, i, j, m, n);
//                sb.deleteCharAt(sb.length()-1);
//            }
//        }
//        board[r][c] = ch;
//    }

    static class Trie {

        static class TrieNode {
            char c;
            boolean isLeaf;
            TrieNode parent;
            Map<Character, TrieNode> children;
            TrieNode(char c) {
                this.c = c;
                children = new HashMap<Character, TrieNode>();
            }

            TrieNode() {
                children = new HashMap<Character, TrieNode>();
            }
        }

        TrieNode root;
        Map<Character, TrieNode> children;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            children = root.children;
            TrieNode parent = root;
            for(int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                TrieNode node;
                if(children.containsKey(cur)) {
                    node = children.get(cur);
                } else {
                    node = new TrieNode(cur);
                    children.put(cur, node);
                }
                if(i == word.length() - 1) {
                    node.isLeaf = true;
                }
                node.parent = parent;
                parent = node;
                children = node.children;
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = searchTrieNode(word);
            if(node != null && node.isLeaf) {
                return true;
            }
            return false;
        }

        private void deleteWord(String word) {
            TrieNode target = searchTrieNode(word);
            if(target != null) {
                target.isLeaf = false;
                for(int i = word.length() - 1; i >= 0; i--) {
                    char cur = word.charAt(i);
                    if(target.children.isEmpty()) {
                        target.parent.children.remove(cur);
                        target = target.parent;
                    }
                }
            }
        }

        private TrieNode searchTrieNode(String prefix) {
            children = root.children;
            TrieNode node = null;
            for(int i = 0; i < prefix.length(); i++) {
                char cur = prefix.charAt(i);
                if(children.containsKey(cur)) {
                    node = children.get(cur);
                    children = node.children;
                } else {
                    return null;
                }
            }
            return node;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            if(searchTrieNode(prefix) != null) {
                return true;
            }
            return false;
        }
    }

    static Set<String> resultSet;
    static List<String> result;
    static int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
    public static List<String> findWords(char[][] board, String[] words) {
        result = new ArrayList<String>();
        if(board == null || board.length == 0) return result;
        int m = board.length;
        int n = board[0].length;
        resultSet = new HashSet<String>();
        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(board, m, n, new StringBuilder(), trie, i, j);
            }
        }
        return result;
    }

    private static void dfs(char[][] board, int m, int n, StringBuilder sb, Trie trie, int i, int j) {
        char ch = board[i][j];
        sb.append(ch);
        String s = sb.toString();
        if(!trie.startsWith(s)) {
            return;
        }
        if(trie.search(s)) {
            if(!resultSet.contains(s)) {
                resultSet.add(s);
                result.add(s);
            }
        }
        board[i][j] = '#';
        for(int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if(r >= 0 && r < m && c >= 0 && c < n && board[r][c] != '#') {
                dfs(board, m, n, sb, trie, r, c);
                sb.setLength(sb.length() - 1);
            }
        }
        board[i][j] = ch;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] board = new char[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = sc.next().charAt(0);
            }
        }
//        String[] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        String[] words = {"oath","pea","eat","rain"};
        findWords(board,words);
    }
}
