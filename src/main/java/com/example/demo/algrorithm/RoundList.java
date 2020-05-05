package com.example.demo.algrorithm;

public class RoundList {
    private Node head;
    private Node tail;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (isEmpty()) {
            throw new CalException("链表长度为空...");
        }
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return temp.data;
            } else {
                temp = temp.next;
            }
        }
        return -1;
    }


    public void addToTail(Object data) {
        if (head == null & tail == null) {
            Node newNode = new Node(data);
            head = tail = newNode;
        } else {
            Node newNode = new Node(data);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }


    public void removeFromHead() {
        Node next = head.next;
        next.prev = null;
        head = null;
        head = next;
        size--;
    }


    public void removeFromTail() {
        Node prev = tail.prev;
        prev.next = null;
        tail = null;
        tail = prev;
        size--;
    }


    public void remove(Object data) {
        Node temp = head;
        Node temp1 = tail;
        if (temp.data.equals(data)) {
            removeFromHead();
        } else if (temp1.data.equals(data)) {
            removeFromTail();
        } else {
            for (int i = 0; i < size; i++) {
                if (temp.data.equals(data)) {
                    Node prev = temp.prev;
                    Node next = temp.next;
                    prev.next = next;
                    next.prev = prev;
                    temp = null;
                    temp = next;
                    size--;
                } else {
                    temp = temp.next;
                }
            }
        }

    }


    public class Node {

        private Object data;
        private Node prev;
        private Node next;

        public Node(Object data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }


        public Node(Object data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;

        }


    }


}
