package com;

/*LRU Cache Implementation
* Each request value is added one by one at the one end, until capacity is reached
* if the request value is already present in list, the node is placed at the top and removed from previous location
* When Capacity n is reached, the new request value can be handled in 2 scenarios
*  1. if the request value is present, the node is placed at the top [as usual]
*  2. if the request value is not present, the least recently used element is removed
*
* */

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    LinkedList<Integer> cacheList; // For maintaining priority order
    HashMap<Integer, Integer> cacheMap; // For optimized searching
    int capacity;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheList = new LinkedList<Integer>();
        this.cacheMap = new HashMap<>();
    }

    public void add(int value) {
        if (cacheHas(value)) {
            System.out.println("Element Present | Cache Hit | Priority Changed");
            removeEntryFromList(value);
            pushEntryToList(value);
        }

        if (!(cacheHas(value) && cacheIsFull())){
            System.out.println("Element Not Present | Cache Miss | Value Added");
            pushEntryToList(value);
            addEntryToMap(value);
        }

        if (!(cacheHas(value)) && cacheIsFull()) {
            System.out.println("Element Not Present | Cache Miss | Cache Full | LRU Replaced");
            removeOldestEntryFromMap();
            popOldestEntryFromList();
            pushEntryToList(value);
            addEntryToMap(value);
        }
    }

    public void displayCache(){
        System.out.print("Current list : [ " );
        if(this.cacheList.size() != 0) {
            for (int a : cacheList)
                System.out.println(a + "");
            System.out.println("]");
        }
        if(this.cacheList.size() == 0)
            System.out.println("Empty Cache!!!");
    }

    private void removeOldestEntryFromMap() {
        int oldestItem = this.cacheList.getFirst();
        System.out.println("Removed Oldest Entry : " + oldestItem);
        this.cacheMap.remove(oldestItem);
    }

    private boolean cacheIsFull() {
        return this.capacity == this.cacheList.size();
    }

    private boolean cacheHas(int value) {
        return this.cacheMap.containsKey(value);
    }

    private void popOldestEntryFromList() {
        this.cacheList.removeLast();
    }

    private void pushEntryToList(int value) {
        this.cacheList.push(value);
    }

    private void removeEntryFromList(int value) {
        this.cacheList.remove(new Integer(value));
    }

    private void removeEntryFromMap(int value) {
        this.cacheMap.remove(value);
    }

    private void addEntryToMap(int value) {
        this.cacheMap.put(value, value);
    }
}

