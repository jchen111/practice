package FancyDataStructrue;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by z001ktb on 5/1/17.
 */
public class TrieNode {
    char ch;
    boolean isLeaf;
    Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();

    public TrieNode(char c) {
        this.ch = c;
    }

    public TrieNode() {

    }

}
