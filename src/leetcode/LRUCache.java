package leetcode;

import java.util.HashMap;

public class LRUCache {
    private class DoubleLinkedNode{
    	DoubleLinkedNode pre;
    	DoubleLinkedNode next;
    	int val;
    	int key;
    	DoubleLinkedNode(int key, int val){
    		this.val = val;
    		this.key = key;
    		pre = null;
    		next = null;
    	}
    }
    	
    HashMap<Integer,DoubleLinkedNode> map;
    DoubleLinkedNode head;//stay in the air
    DoubleLinkedNode tail;//stay in the air
    int cap;
    
    public void removeFirst(){
    	removeNode(head.next);
    }
    
    public void removeNode(DoubleLinkedNode node){
    		node.pre.next = node.next;
    		node.next.pre = node.pre;
    }

    public void add(DoubleLinkedNode node){
    		tail.pre.next = node;
    		node.pre = tail.pre;
    		node.next = tail;
    		tail.pre = node;
    }
	public LRUCache(int capacity){
		this.cap = capacity;
		head = new DoubleLinkedNode(-1,-1);//stay in the air
		tail = new DoubleLinkedNode(-1,-1);//stay in the air
		head.next = tail;
		tail.pre = head;
		map = new HashMap<Integer,DoubleLinkedNode>();
	}
	
	public int get(int key){
		if(map.get(key) == null){
			return -1;
		}
		
		DoubleLinkedNode node = map.get(key);
		removeNode(node);
		add(node);
		
		return node.val;
	}
	
	public void set(int key, int value){
		DoubleLinkedNode node = map.get(key);
		if(node==null){
			node = new DoubleLinkedNode(key,value);
			map.put(key, node);
		}else{
			node.val = value;
			removeNode(node);
		}
		
		add(node);
		
		if(map.size()>cap){
			map.remove(head.next.val);
			removeFirst();
		}
	}	
}
