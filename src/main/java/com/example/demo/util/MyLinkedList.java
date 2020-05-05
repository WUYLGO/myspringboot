package com.example.demo.util;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> last;
    private int size;

    public int size() {
        return this.size;
    }


    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    //插入到最后(需要考虑的是head节点和last节点的变化,往后面插入数据唯一不变的是last=newNode)
    public void add(T item) {
        //将传入的值存入新的node
        Node newNode = new Node(item);

        //将last暂存
        Node<T> ls = last;
        last = newNode;
        if (ls == null) {
            head = newNode;
        } else {
            //如果last不为空,则需要将last指向新的节点,暂存的节点指向新的节点
            ls.next = last;
            last.prev = ls;
        }
        size++;

    }


    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return head.data;
        } else if (index == size) {
            return last.data;
        } else {
            //不是首尾查中间数据需要根据索引查找到对应的节点,
            // 查找的时候可以根据索引位置选择从前往后查还是从后往前查
            if (index < (size % 2 == 0 ? size / 2 : (size / 2 + 1))) {
                //从前往后查
                Node<T> temp = head;
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
                return temp.data;
            } else {
                //从后往前查
                Node<T> temp = last;
                for (int i = size - 1; i > index; i--) {
                    temp = temp.prev;
                }
                return temp.data;
            }
        }

    }

    public void remove(T item) {
        //先找到该节点再移除
        Node<T> temp = head;
        Node<T> target = null;
        if (item.equals(temp.data)) {
            target = temp;
        } else {
            for (int i = 0; i < size; i++) {
                temp = temp.next;
                if (item.equals(temp.data)) {
                    target = temp;
                    break;
                }
            }
        }

        Node<T> prev = target.prev;
        Node<T> next = target.next;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }
        size--;
    }


}
