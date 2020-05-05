package com.example.demo.util.LRU;

import java.util.Hashtable;

/**
 * 1.添加节点到头部之后;
 * 2.删除节点;
 * 3.移动节点到头部;
 * 4.弹出尾部数据;
 * 5.定义LRU自带属性:head,tail,cache,size,capicity
 * 6.构造方法初始化;
 * 7.get方法
 * 8.put方法
 */
public class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        long expireTime;
        long createTime;
    }


    //添加一个节点在头结点之后
    private void addNode(DLinkedNode node) {
        /**
         * Always add the new node right after head.
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    //删除一个已经存在的节点
    private void removeNode(DLinkedNode node) {
        /**
         * Remove an existing node from the linked list.
         */
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    //移动一个节点到头部
    private void moveToHead(DLinkedNode node) {
        /**
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node);
    }

    //弹出尾部
    private DLinkedNode popTail() {
        /**
         * Pop the current tail.
         */
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private Hashtable<Integer, DLinkedNode> cache =
            new Hashtable<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;


    //构造方法
    public LRUCache(int capacity) {
        //初始化大小
        this.size = 0;
        //初始化容量
        this.capacity = capacity;

        //定义头结点
        head = new DLinkedNode();
        // head.prev = null;

        //定义尾结点
        tail = new DLinkedNode();
        // tail.next = null;

        //当为空的时候头指向尾,尾指向头
        head.next = tail;
        tail.prev = head;

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (head != null) {
                    DLinkedNode temp = head;
                    while (temp != null) {
                        if (System.currentTimeMillis() - temp.createTime > temp.expireTime) {
                            removeNode(temp);
                            cache.remove(temp.key);
                        }
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();


    }

    //get方法
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }


    //put方法
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            if (size > capacity) {
                // pop the tail
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // update the value.
            node.value = value;
            moveToHead(node);
        }
    }
}

/**
 * LRUCache 对象会以如下语句构造和调用:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
