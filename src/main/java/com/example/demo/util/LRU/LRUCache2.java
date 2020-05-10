package com.example.demo.util.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    private Node head;
    private Node tail;
    private int size;
    private int capicity;

    private Map<Integer, Node> cache = new HashMap<>();

    public LRUCache2() {
        this.capicity = 16;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;

    }

    public class Node {
        private int key;
        private int value;
        private Node prev;
        private Node next;

    }

    public void addHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node = next = next;
        next.prev = node;
        size++;
    }

    public void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

    }

    public void moveTohead(Node node) {
        removeNode(node);
        addHead(node);
    }

    public Node popTail() {
        Node prev = tail.prev;
        removeNode(prev);
        size--;
        return prev;
    }


    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            moveTohead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node node1 = new Node();
            node1.key = key;
            node1.value = value;
            addHead(node1);
            cache.put(key, node1);
            size++;
            if (size > capicity) {
                popTail();
                cache.remove(key);
                size--;
            }
        } else {
            node.value = value;
            moveTohead(node);
        }

    }
}
