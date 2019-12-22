package com;

public class LinkedListImpl {
    Node head;
    Node tail;

    LinkedListImpl(Node head) {
        this.head = head;
        this.tail = head;
    }

    Node pushNode(int val, String key) {
        Node n = new Node(val, key);
        if(this.head == null) {
            this.head = n;
            this.tail = n;
        } else {
            this.tail.next = n;
            n.prev = this.tail;
            this.tail = n;
        }
        return n;
    }

    void prioritiseNode(Node n) {
        Node prev = n.prev;
        Node next = n.next;

        this.tail.next = n;
        n.prev = this.tail;
        this.tail = n;

        if(prev != null) prev.next = next;
        if(next != null) next.prev = prev;
    }

    Node popFromHead(){
        if(this.head != null) {
            Node n = this.head;
            this.head = this.head.next;
            this.head.prev = null;
            return n;
        }
        return null;
    }

    void deleteNode(Node n) {
        if(n.prev != null) n.prev.next = n.next;
        if(n.next != null) n.next.prev = n.prev;
    }
}
