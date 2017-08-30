package leetcode;

import java.util.*;

/**
 * Created by jiaqichen on 12/25/16.
 */
public class LFU {
    public static class LFUCache {

        int capacity;

        class Node {
            int count;
            LinkedHashSet<Integer> keys;
            Node pre;
            Node next;
            Node (int n){
                count = n;
                keys = new LinkedHashSet<Integer>();
            }
        }

        Map<Integer,Integer> valueMap;
        Map<Integer,Node> nodeMap;
        Node head;
        Node tail;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.pre = head;
            valueMap = new HashMap<Integer,Integer>();
            nodeMap = new HashMap<Integer,Node>();
        }

        private void addNode(Node node){
            tail.pre.next = node;
            node.pre = tail.pre;
            node.next = tail;
            tail.pre = node;
        }

        private void removeNode(Node node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private Node poll(){
            Node res = head.next;
            if(head.next != null) removeNode(head.next);
            return res;
        }

        private void addFirst(Node node){
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }

        private void increaseCount(int key) {
            Node tmp = nodeMap.get(key);
            tmp.keys.remove(key);
            int count = tmp.count;


            if(count + 1 == tmp.next.count){
                tmp.next.keys.add(key);
            }else{
                Node newnode = new Node(count + 1);
                newnode.keys.add(key);
                newnode.pre = tmp;
                newnode.next = tmp.next;
                tmp.next = newnode;
                tmp.next.pre = newnode;
            }


            nodeMap.put(key,tmp.next);
            if(tmp.keys.isEmpty()) removeNode(tmp);
        }

        public int get(int key) {
            int res = -1;
            if(valueMap.containsKey(key)){
                res = valueMap.get(key);
                increaseCount(key);
            }
            return res;
        }

        public void put(int key, int value) {
            if(valueMap.containsKey(key)){
                valueMap.put(key,value);
            }else{
                if(valueMap.size() + 1 > capacity){
                    Node pop = poll();
                    int old = 0;
                    for(Integer k : pop.keys){
                        old = k;
                        break;
                    }
                    pop.keys.remove(old);
                    valueMap.remove(old);
                    nodeMap.remove(key);
                    if(!pop.keys.isEmpty()) {
                        nodeMap.put(key,pop);
                        addFirst(pop);
                    }
                }
                valueMap.put(key,value);
                Node newnode = new Node(0);
                addFirst(newnode);
                nodeMap.put(key,newnode);
            }
            increaseCount(key);
        }
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(2,1);
        lfu.put(2,2);
        lfu.get(2);
        lfu.put(1,1);
//        lfu.get(2);
//        lfu.get(3);
        lfu.put(4,1);
        lfu.get(2);
//        lfu.get(3);
//        lfu.get(4);
    }
}
