package com;

public class Node {
    Node next;
    Node prev;
    int value;
    String key;

    Node(int value, String key){
        this.next = null;
        this.prev = null;
        this.value = value;
        this.key = key;
    }
}
