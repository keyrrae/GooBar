package structures;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuanwang on 12/30/16.
 */
public class LRUCache {

    private class Node{
        Node left;
        Node right;
        int val;
        int key;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.right = tail;
        tail.left = head;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node cur = map.get(key);
        cur.left.right = cur.right;
        cur.right.left = cur.left;
        moveToTail(cur);

        return cur.val;
    }

    public void set(int key, int value) {
        if(get(key) != -1){
            map.get(key).val = value;
            return;
        }

        if(map.size() == capacity){
            map.remove(head.right.key);
            head.right = head.right.right;
            head.right.left = head;
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        moveToTail(newNode);
    }

    private void moveToTail(Node n){
        tail.left.right = n;
        n.left = tail.left;

        tail.left = n;
        n.right = tail;
    }

}
