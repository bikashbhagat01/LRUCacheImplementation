package com;

import java.util.HashMap;
import java.util.HashSet;

public class LRUCacheImpl {
    LinkedListImpl linkedList;
    int usedCapacity = 0;
    int maxCapacity;
    HashMap<String, Node> hashMap;

    LRUCacheImpl(int capacity) {
        this.maxCapacity = capacity;
        linkedList = new LinkedListImpl(null);
        hashMap = new HashMap<>();
    }

    void deleteAlreadyPresentKeyAndReduceCapacity(String key) {
        Node n = this.hashMap.get(key);
        this.linkedList.deleteNode(n);
        this.hashMap.remove(key);
        this.usedCapacity--;
    }

    void evictElementAndReduceCapacity(){
        Node n = linkedList.popFromHead();
        String toDeleteKey = n.key;
        this.hashMap.remove(toDeleteKey);
        this.usedCapacity--;
    }

    void setData(String key, int value) {

        if(this.hashMap.containsKey(key)){
            this.deleteAlreadyPresentKeyAndReduceCapacity(key);
        }

        if(this.usedCapacity == this.maxCapacity){
           this.evictElementAndReduceCapacity();
        }

        Node n = linkedList.pushNode(value, key);
        this.usedCapacity++;
        hashMap.put(key, n);
    }

    int get(String key) throws Exception {
        if(this.hashMap.containsKey(key)) {
            System.out.println("Hit cache");
            Node n = this.hashMap.get(key);
            this.linkedList.prioritiseNode(n);
            return n.value;
        } else {
            throw new Exception("No such key: Miss");
        }
    }



}
