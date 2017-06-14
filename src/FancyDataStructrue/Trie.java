package FancyDataStructrue;

import java.util.Map;

/**
 * Created by z001ktb on 5/1/17.
 */
public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void add(String str) {
        Map<Character, TrieNode> children = root.children;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            TrieNode t;
            if(children.containsKey(c)){
                t = children.get(c);
            }else{
                t = new TrieNode(c);
                children.put(c,t);
            }

            if(i == str.length() - 1) t.isLeaf = true;

            children = t.children;
        }
    }

    public TrieNode find(String target) {
        Map<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i = 0; i < target.length(); i++){
            char c = target.charAt(i);
            if(children.containsKey(c)){
                t = children.get(c);
                children = t.children;
            }else{
                return null;
            }
        }
        return t;
    }

    public boolean startsWith(String prefix) {
        TrieNode result = find(prefix);
        return result != null;
    }

    public boolean contains(String target) {
        TrieNode result = find(target);
        if(result != null && result.isLeaf) return true;
        else return false;
    }
}
