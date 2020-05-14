package com.wyl.research.algrorithm;

public class LinkedListTest {
    public static void main(String[] args) {
        RoundList roundList = new RoundList();
        roundList.addToTail("1111");
        roundList.addToTail("2222");
        roundList.addToTail("3333");
        roundList.addToTail("4444");
        roundList.addToTail("5555");

        printList(roundList);

        roundList.remove("3333");
        System.out.println("=====remove 3333========");
        printList(roundList);

        System.out.println("=====remove head========");
        roundList.removeFromHead();
        printList(roundList);

        System.out.println("=====remove tail========");
        roundList.removeFromTail();
        printList(roundList);
    }

    public static void printList(RoundList list) {
        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                System.out.println();
            }
        }
    }
}
