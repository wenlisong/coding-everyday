import java.util.HashMap;
import java.util.Map;

// 146. LRU Cache

// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
// it should invalidate the least recently used item before inserting a new item.

// The cache is initialized with a positive capacity.

// Follow up:
// Could you do both operations in O(1) time complexity?

// Example:
// LRUCache cache = new LRUCache( 2 /* capacity */ );

// cache.put(1, 1);
// cache.put(2, 2);
// cache.get(1);       // returns 1
// cache.put(3, 3);    // evicts key 2
// cache.get(2);       // returns -1 (not found)
// cache.put(4, 4);    // evicts key 1
// cache.get(1);       // returns -1 (not found)
// cache.get(3);       // returns 3
// cache.get(4);       // returns 4

class LRUCache {
    private class Node {
        Node pre;
        Node next;
        int key;
        int val;

        Node() {
            key = 0;
            val = 0;
        }

        Node(int x, int y) {
            key = x;
            val = y;
        }
    }

    private int numOfItems, capacity;
    private Node head, tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.numOfItems = 0;
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.pre = this.head;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        Node targetNode = this.map.get(key);
        if (targetNode == null) {
            return -1;
        } else {
            moveToHead(targetNode);
            return targetNode.val;
        }
    }

    public void put(int key, int value) {
        Node curNode = this.map.get(key);
        if (curNode == null) {
            addToHead(new Node(key, value));
            if (this.numOfItems > this.capacity) {
                deleteTail();
            }
        } else {
            curNode.val = value;
            moveToHead(curNode);
        }

    }

    private void moveToHead(Node curNode) {
        if (curNode != this.head.next) {
            curNode.pre.next = curNode.next;
            curNode.next.pre = curNode.pre;
            curNode.next = this.head.next;
            curNode.next.pre = curNode;
            this.head.next = curNode;
        }
    }

    private void deleteTail() {
        Node curNode = this.tail.pre;
        curNode.pre.next = this.tail;
        this.tail.pre = curNode.pre;
        this.map.remove(curNode.key);
        this.numOfItems--;
    }

    private void addToHead(Node curNode) {
        curNode.next = this.head.next;
        curNode.next.pre = curNode;
        this.head.next = curNode;
        this.map.put(curNode.key, curNode);
        this.numOfItems++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */