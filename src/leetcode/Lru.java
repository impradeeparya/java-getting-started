package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Pradeep Arya
 */

class LinkedHashMapLru {

    private Map<Integer, Integer> cache;
    private int capacity;

    public LinkedHashMapLru(int capacity) {
        this.cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;

    }

    public int get(int key) {
        int output = cache.getOrDefault(key, -1);

        if (output != -1) {
            cache.remove(key);
            cache.put(key, output);
        }

        return output;
    }

    public void put(int key, int value) {

        if (cache.size() == capacity && cache.getOrDefault(key, -1) == -1) {
            int lruKey = cache.keySet().iterator().next();
            cache.remove(lruKey);
            cache.put(key, value);
        } else {
            cache.remove(key);
            cache.put(key, value);
        }
    }
}

class Node {
    private int key;
    private int value;
    private Node next;
    private Node prev;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}

class LinkedListLru {

    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;
    private int capacity;

    public LinkedListLru(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.capacity = capacity;

    }

    private void remove() {
        if (head != null) {
            Node nextHead = head.getNext();

            if (nextHead != null) {
                nextHead.setPrev(null);
                head.setNext(null);
                head = nextHead;
            } else {
                head = null;
                tail = null;
            }
        }
    }

    private void remove(Node node) {

        if (node.getPrev() == null) {

            Node nextNode = node.getNext();
            if (nextNode != null) {
                node.setNext(null);
                nextNode.setPrev(null);
                head = nextNode;
            } else {
                head = null;
                tail = null;
            }

        } else if (node.getNext() == null) {
            Node prevNode = node.getPrev();
            node.setPrev(null);
            prevNode.setNext(null);
            tail = prevNode;
        } else {
            Node prevNode = node.getPrev();
            Node nextNode = node.getNext();

            node.setNext(null);
            node.setPrev(null);

            prevNode.setNext(nextNode);
            nextNode.setPrev(prevNode);
        }

    }

    private void add(Node node) {

        if (cache.size() == capacity) {
            remove();
        }
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
        cache.put(node.getKey(), node);

    }

    private void update(Node node) {
        remove(node);
        add(node);
    }

    public int get(int key) {
        Node output = cache.get(key);

        if (output != null) {
            update(output);
        }

        return output != null ? output.getValue() : -1;
    }

    public void put(int key, int value) {

        Node node = new Node();
        node.setKey(key);
        node.setValue(value);

        if (cache.get(key) != null) {
            update(node);
        } else {
            add(node);
        }

    }
}

