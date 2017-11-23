package FancyDataStructrue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by z001ktb on 5/1/17.
 */
public class MyTrie {
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
    static class Trie {
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

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("test");
        trie.insert("text");
        System.out.println(trie.startsWith("te"));
        System.out.println(trie.search("test"));
        System.out.println(trie.search("text"));
        trie.deleteWord("test");
        System.out.println(trie.search("test"));
        System.out.println(trie.startsWith("te"));
    }
}
