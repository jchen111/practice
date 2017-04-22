package leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * Created by z001ktb on 1/8/17.
 */
public class LFUCache {
    class Node {
        int count = 0;
        LinkedHashSet<Integer> keys = null;
        Node pre;
        Node next;

        public Node(int count) {
            this.count = count;
            keys = new LinkedHashSet<Integer>();
            pre = null;
            next = null;
        }
    }

    Node head;
    Node tail;
    int capacity;
    Map<Integer,Integer> valueHash;
    Map<Integer,Node> nodeHash;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        valueHash = new HashMap<Integer,Integer>();
        nodeHash = new HashMap<Integer,Node>();
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
    }

    private void addFirst(Node node) {
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private Node removeFirst() {
        Node res = head.next;
        removeNode(head.next);
        return res;
    }

    private void increaseCount(int key) {
        Node node = nodeHash.get(key);
        node.keys.remove(key);

        if(node.next == tail){
            node.next = new Node(node.count + 1);
            node.next.pre = node;
            node.next.next = tail;
            tail.pre = node.next;
            node.next.keys.add(key);
        }else if(node.next.count == node.count + 1) {
            node.next.keys.add(key);
        }else{
            Node tmp = new Node(node.count + 1);
            tmp.keys.add(key);
            tmp.pre = node;
            tmp.next = node.next;
            node.next.pre = tmp;
            node.next = tmp;
        }

        nodeHash.put(key,node.next);
        if(node.keys.size() == 0) removeNode(node);
    }

    public int get(int key) {
        if(valueHash.containsKey(key)){
            increaseCount(key);
            return valueHash.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(valueHash.containsKey(key)){
            valueHash.put(key,value);
        }else{
            if(valueHash.size() >= capacity){
                Node tmp = removeFirst();
                int old = 0;
                for(int k : tmp.keys){
                    old = k;
                    break;
                }
                tmp.keys.remove(old);
                if(tmp.keys.size() != 0) addFirst(tmp);
                nodeHash.remove(old);
                valueHash.remove(old);
            }
            valueHash.put(key, value);
            Node newnode = new Node(0);
            addFirst(newnode);
            nodeHash.put(key, newnode);
        }
        increaseCount(key);
    }

    public static void main(String[] args) {
        LFUCache obj = new LFUCache(2);
        obj.put(1,1);
        obj.put(2,2);
        obj.get(1);
        obj.put(3,3);
        obj.get(2);
        obj.get(3);
        obj.put(4,4);
        obj.get(1);
        obj.get(3);
        obj.get(4);
    }
}
