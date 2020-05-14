package com.wyl.research.algrorithm.LRU;

import java.util.HashMap;
import java.util.Map;

/**
 * 0.定义节点存储数据;
 * 1.添加节点到头部之后;
 * 2.删除节点;
 * 3.移动节点到头部;
 * 4.弹出尾部数据;
 * 5.定义LRU自带属性:head,tail,cache,size,capicity
 * 6.构造方法初始化;
 * 7.get方法
 * 8.put方法
 */
public class LRUCache1 {

    //头结点和尾节点是两个哨兵节点,方便null指针的处理
    private Node head;
    private Node tail;
    private int size = 0;
    private int capicity = 16;

    private Map<Integer, Node> cache = new HashMap<>();

    public LRUCache1() {

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

        public Node() {

        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }


    public void addNode(Node node) {
        Node next = head.next;

        head.next = node;
        node.prev = head;

        node.next = next;
        next.prev = node;

    }

    public int removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        return node.value;
    }

    public void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }


    public Node popTail() {
        Node prev = tail.prev;
        removeNode(prev);
        size--;
        return prev;

    }

    public void put(int key, int value) {
        //不存在添加,存在移动到头部
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(node);
            size++;
            //判读当前大小和容量来移除尾部,包括cache里面的数据
            if (size > capicity) {
                Node pop = popTail();
                cache.remove(pop.key);
                size--;
            }

        } else {
            //存在更新值并移动到头部
            node.value = value;
            moveToHead(node);
        }


    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        return node.value;
    }


}
